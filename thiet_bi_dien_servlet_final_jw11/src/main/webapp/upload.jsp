<%--một file jsp là file chứa cấu trúc html và một số thẻ jsp để thực hiện các code java--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <H1>Demo upload file with servlet</H1>
<%--    sử dụng cấu trúc thẻ form để thực chức năng upload file--%>
<%--    thẻ form trong html có chức năng chứa các thông tin người dùng nhập--%>
<%--    vào và truyền các thông tin ấy lên server--%>
<%--    ngoài gọi method khác bằng postman thì có thể sủ dùng form trong html--%>
    <form action="api/v1/upload-file" method="post" enctype="multipart/form-data">
        <label>Chọn file upload:</label>
        <input type="file" name="file" multiple="multiple">
        <input type="submit" value="Tải lên">
    </form>
</body>
</html>
