package com.bksoftwarevn.itstudent.model;

import com.bksoftwarevn.itstudent.common.AppConfig;

import java.sql.*;

//để cop code thì các cop đúng thứ tự mà tạo ra
//model, dao, service
public class MyConnection {

    //1 project chỉ kết nối đến một db nên chỉ tạo biến connection 1 lần
    public static Connection connection = null;

    /**
     * Các bước thao tác với database:
     * B1: Đầu tiền để kết nối với database cần kiểm tra đã có thư viện
     *      kết nối hay chưa => cần định nghĩa 1 hàm driverTest();
     * B2: Sau khi đã tồn tại thư viện thì thực hiện kết nối đên database
     *      bằng hàm connectDB()
     * B3: Khi connect với db thành công thao tác lệnh với database:
     *      Chia ra 2 loại lệnh khi thao tác với db:
     *          prepare(): Loại 1 là câu lệnh lấy ra bản ghi: select
     *          prepareUpdate():Loại 2 là các câu lệnh thay đổi dữ
     *          liệu: insert, update, delete
     *       Đinh nghĩa 2 hàm prepare() và prepareUpdate()
     *       để thực hiện các câu lênh trong db
     * B4: sau khi thao tác chán chê mê mỏi thì đóng kết nối
     *      bằng hàm closeConnection();
     */

    //kiểm tra đã tồn tại thư viện hay chưa
    public void driverTest() throws ClassNotFoundException {
        try {
            Class.forName(AppConfig.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("JDBC Driver not found" + e.getMessage());
        }
    }

    public Connection connectDB() throws ClassNotFoundException, SQLException {
        if(connection == null) {
            driverTest();
            try {
                // sử dụng DriverManager.getConnection để tạo liên liên kết đến
                //database hàm yêu cầu 3 tham số đường dẫn database, tài khoản, mất khẩu
                //database
                connection = DriverManager.getConnection(AppConfig.URL_DATABASE,
                        AppConfig.USERNAME, AppConfig.PASSWORD);
                System.out.println("Connect DB successfully");
            } catch (SQLException throwables) {
                throw new SQLException("Connect DB fail " + throwables.getMessage());
            }
        }
        return connection;
    }

    //sau khi connect thành công thì lấy đối tượng vừa connect để thực
    //hiện các câu lệnh

    //hàm prepare nhận vào một câu lệnh tìm kiếm cần thực hiện
    //và trả về một đối tượng PreparedStatment dùng để thực hiện câu lệnh đấy.
    public PreparedStatement prepare(String sql) {
        System.out.println(">> " + sql);
        try {
            //đối với các câu lệnh tìm kiếm thì hàm prepareStatement
            //cần truyền thêm một tham số như sau ResultSet.TYPE_SCROLL_INSENSITIVE
            //ResultSet.TYPE_SCROLL_INSENSITIVE cho phép con trỏ ResultSet chạy từ
            //bản ghi đầu tiền xuống bản ghi cuối cùng.
            return connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public PreparedStatement prepareUpdate(String sql) {
        System.out.println(">> " + sql);
        try {
            //đối với các câu lệnh thay đổi dữ liệu thì cần truyền
            //thêm một tham số là Statement.RETURN_GENERATED_KEYS
            //Statement.RETURN_GENERATED_KEYS có tác dụng giải sử
            //khi thêm một bản ghi category thì chỉ truyền 2 thuộc tính là
            //name và deleted vì id tự động tăng, nhưng sau khi thêm thành công
            //bản ghi thì mình biết id vừa thêm vào là bn?, thì tham số này
            //trả về cho các bạn cái id tương ứng với bản ghi vừa thêm vào;
            return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //sau khi thao tác với database xong thì thực hiện giải phóng tài nguyên
    public void closeConnection() throws SQLException {
        if(connection != null) {
            connection.close();
            System.out.println("Connection is closed");
        }
    }
}
