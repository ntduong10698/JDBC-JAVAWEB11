package view;

import model.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        try {
            myConnection.connectDB();

            //demo với câu lệnh lấy ra tất cả các bản ghi trong category
            PreparedStatement prepare = myConnection.prepare("select * from category");
            //sau khi lấy ra được một đối tượng prepare thì thực hiện cấu lệnh
            //bằng cách gọi hàm executeQuery();
            ResultSet resultSet = prepare.executeQuery();
            //để đọc được tất cả bản ghi thì phải cho con trỏ resultSet chạy
            //từ trên xuống dưới và đọc từng bản ghi 1
            // về thực hiện cho con trỏ resultSet có thể chạy thì dùng hàm next()
            //hàm next trả về cho mình một giá trị là boolean
            while(resultSet.next()) {
                //resetSet là một bản ghi
                //Để lấy ra giá trị của 1 thuộc tính thì sử dụng
                //hàm get kiểu dữ liệu tương ứng và truyền vào tên cột
                //của thuộc tính đấy
                System.out.println(resultSet.getInt("id") +
                        " " + resultSet.getString("name") +
                        " " + resultSet.getBoolean("deleted"));
            }
            //bài tập in ra đầy đủ thuộc tính của 1 bản ghi category
            //vd: 1 Dây điện false;

            //demo câu lệnh thay đổi dữ liệu bằng thêm vào một bản ghi
            //category
            PreparedStatement prepareUpdate = myConnection.prepareUpdate("insert into category (name, deleted) values (?,?)");
            prepareUpdate.setString(1, "Bút thử điện");
            prepareUpdate.setBoolean(2, false);
            //trả về số nguyên các bản ghi thay đổi dữ liệu thành công
            int rs = prepareUpdate.executeUpdate();
            if(rs > 0) {
                System.out.println("insert successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
