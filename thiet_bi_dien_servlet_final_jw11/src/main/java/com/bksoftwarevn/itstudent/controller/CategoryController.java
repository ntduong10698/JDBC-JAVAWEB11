package com.bksoftwarevn.itstudent.controller;

import com.bksoftwarevn.itstudent.model.Category;
import com.bksoftwarevn.itstudent.model.JsonResult;
import com.bksoftwarevn.itstudent.service.CategoryService;
import com.bksoftwarevn.itstudent.service_impl.CategoryServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/api/v1/category/*")
public class CategoryController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    private Gson gson = new Gson();

    private JsonResult jsonResult = new JsonResult();

    //sẽ cung cấp chức năng thêm bản ghi
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rs = null;
        //đàu vào insert là một đối tượng
        //đối tượng là client truyền lên
        /**
         * Các cách truyền thông tin từ client đến server:
         *      - Truyền bằng query string: truyền được các kiểu dữ liệu nguyên thủy
         *          key=value (value: int, boolean, string, ...) value sẽ không chấp nhận object
         *      - Truyền thông tin bằng body: (có chấp nhận đối tượng)
         *          - Khi sử dụng truyền thông tin bằng body thì chỉ chấp
         *              nhận các phương thức sau:  POST, PUT, DELETE
         *      => Query String:GET,PUT,POST,DELETE
         *      => Body: POST, PUT, DELETE
         *
         *      Do đang làm việc với json thì object truyền nó dạng là một
         *      chuỗi json, chuyển json này thành một đối tượng java
         */
        //getReader bộ đọc body (body ở đây chính là đối tuownjg được
        // client truyền lên)
        Category category = gson.fromJson(request.getReader(), Category.class);
        try {
            Category newCategory = categoryService.insert(category);
            rs = gson.toJson(jsonResult.jsonSuccess(newCategory));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Thêm category thất bại!"));
        }
        response.getWriter().println(rs);
    }

    //sẽ cung cấp các chức năng tìm kiếm bản ghi
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //đã kết nối đến database rồi
        //chỉ thao tác để lấy dữ liệu
        //đối với tìm kiếm tầng service của cateory: CategoryService cung cấp 2 phương thức
        // + findAll
        // + findById
        //nếu /find-all, /find-by-id

        // viết chương trình nếu người dùng
        //nhập vào /api/v1/category/find-all, api/v1/category/find-by-id
        String rs = null;
        String pathInfo = request.getPathInfo();
        if(pathInfo != null){
            //find-all
            //find-by-id
            if(pathInfo.equals("/find-all")) {
                try {
                    List<Category> list = categoryService.findAll();
                    //đã lấy ra được thông tin trong db
                    //chuyển một đối tượng java thành chuỗi json
                    //thư viện gson
                    rs = gson.toJson(jsonResult.jsonSuccess(list));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    rs = gson.toJson(jsonResult.jsonFail("find all error"));
                }
            } else if (pathInfo.equals("/find-by-id")) {
                try {
                    //truyền thông tin từ client lên server truyền bằng queryString, param
                    int id = Integer.parseInt(request.getParameter("id"));
                    Category category = categoryService.findById(id);
                    rs = gson.toJson(jsonResult.jsonSuccess(category));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    rs = gson.toJson(jsonResult.jsonFail("find by id error"));
                }
            } else {
                response.sendError(404, "Api Not Found");
            }
        } else {
            //nếu pathInfo không tồn tịa hoặc khác  /find-all, /find-by-id
            // trả về 1 trang 404
            //sendError tham số int là Http Status Code
            response.sendError(404, "Api Not Found");
        }
        response.getWriter().println(rs);
    }

    //sẽ cung cấp chức năng sửa bản ghi
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rs = null;
        try {
            Category category = gson.fromJson(request.getReader(), Category.class);
            rs = gson.toJson(jsonResult.jsonSuccess(categoryService.update(category)));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Sửa category lỗi"));
        }
        response.getWriter().println(rs);
    }
    //sẽ cung cấp chức năng xóa bản ghi
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rs = null;
        try {
            rs = gson.toJson(jsonResult.jsonSuccess(categoryService.deleted(Integer.parseInt(request.getParameter("id")))));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Xóa category lỗi"));
        }
        response.getWriter().println(rs);
    }

    //BTVN: làm doPUT gọi update trong service, doDELETE gọi delete trong serivce
}
