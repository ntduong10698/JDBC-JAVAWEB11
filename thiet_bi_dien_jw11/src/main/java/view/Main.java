package view;

import dao.CategoryDao;
import dao_impl.CategoryDaoImpl;
import model.Category;
import model.MyConnection;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        try {
            myConnection.connectDB();
            //ở đây chỉ là ví dụ để kiểm trả chức năng vừa viết
            CategoryDao categoryDao = new CategoryDaoImpl();
            List<Category> list = categoryDao.findAll();
            for (Category c: list) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
