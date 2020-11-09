package com.bksoftwarevn.itstudent.controller;

import com.bksoftwarevn.itstudent.model.JsonResult;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UploadFileController", value = "/api/v1/upload-file/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxRequestSize = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50)

/**
 * fileSizeThreshold: Nếu kích thước của một file nó dung lượng đã cấu hình
 * thì sẽ được lưu trực tiếp lên ổ đĩa mà không thông qua bộ đệm.
 *
 * maxRequestSize: dung lượng tối đa của 1 request (1 request có thể có
 * nhiều file)
 *
 * maxFileSize: dung lượng tối đa của 1 file
 */
public class UploadFileController extends HttpServlet {

    private Gson gson = new Gson();

    private JsonResult jsonResult = new JsonResult();

    public static final String SAVE_DIRECTORY = "file-upload";

    private String getFileName(Part part) {
        String fileNameRs = null;
        //thuộc tính header của đối tượng part tương ứng với key content-disposition
        // thì sẽ chưa một một chuỗi có định dạng tương tự
        // form-data; name="file"; filename="C:\a\file1.zip"
        //từ chuỗi này mình lấy ra tên file và phần mở rộng của file.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s: items) {
            if(s.trim().startsWith("filename")) {
                //filename="C:\file1.zip"
                fileNameRs = s.substring(s.indexOf("=") + 2, s.length() - 1);
                fileNameRs = fileNameRs.replace("\\", "/");
                int i = fileNameRs.lastIndexOf("/");
                fileNameRs = fileNameRs.substring(i + 1);
            }
        }
        return fileNameRs;
    }

    private File getFolderUpload() {
        //kiểm soát thư mục muốn file trên server
        String appPath = "D:\\";
        //thư muốn upload vào thì phaior tạo ra một biến static final

        //1 file sẽ nằm trong 1 thư mục giải quyết trùng tên file
        //chú ý kết quả trả về phải đúng đường dẫn

        //=> 1 request tạo ra 1 thư muc
        appPath += SAVE_DIRECTORY + File.separator + new Date().getTime();
        //xảy ra 2 trường hợp 1 là thư mục SAVE đã tồn tại, SAVE chưa tồn
        File folderUpload = new File(appPath);
        if(!folderUpload.exists()) {
            //tạo các thư mục
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rs = null;
        try {
            //lây ra được các file người dùng truyền lên
            Collection<Part> partCollection = request.getParts();
            if(partCollection != null) {
                //duyệt từng file và thực hiện lưu các file đấy
                List<String> listFileName = new ArrayList<>();
                for (Part part : partCollection) {
                    //thực hiện các bước lưu file
                    //tên file phải đưuọc giữ nguyên, ghi dữ liệu của file

                    //tên file của người dùng truyền lên sẽ nằm trong đối tượng Part
                    //tên file nó nằm trong một chuỗi phức tạp => tạo ra hàm tách tên file từ chuỗi phức tạp đấy.
                    String fileName = getFileName(part);
                    if(fileName != null) {
                        //lưu file thì lưu ở đâu (chỉ ra đường dẫn tuyệt đối
                        // địa điểm mà muốn lưu file)
                        //phải có hàm kiểm soát thư mục lưu trữ file getFolderUpload()
                        //.getAbsolutePath() lấy đường dẫn tuyệt đối của thư mục muốn upload vào
                        //D:\\file-upload
                        String filePath = getFolderUpload().getAbsolutePath() + File.separator + fileName;
                        System.out.println("Write File: " + filePath);
                        //thực hiện ghi file
                        part.write(filePath);
                        listFileName.add(SAVE_DIRECTORY + "/" + fileName);
                    }
                }
                rs = gson.toJson(jsonResult.jsonSuccess(listFileName));
            } else {
                rs = gson.toJson(jsonResult.jsonSuccess("file not found"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Tải file thất bại!"));
        }
        response.getWriter().println(rs);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
