package service_impl;

import dao.ProductDao;
import dao_impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    //sortBy cần truyền vào 2 trường là String là chứa chuỗi là tên của trường
    //muốn sắp xếp, isASC tăng hay giảm (isASC không cần kiểm soát)
    //Cần kiểm soát String field
    //Nếu người dùng truyển đúng các chuỗi sau thì mới gọi đến tầng dao

    /**
     * create_time
     * price
     * guarantee
     * bouth
     * promotion
     * name
     */
    @Override
    public List<Product> sortBy(String field, boolean isASC) throws SQLException {
        String listField[] = {"create_time", "price", "guarantee", "bouth", "promotion", "name"};
        boolean check = false;
        for (String s: listField) {
            if(s.equals(field)) {
                check = true;
                break;
            }
        }
        return check ? productDao.sortBy(field, isASC): null;
    }

    @Override
    public List<Product> findByCategory(int idCategory) throws SQLException {
        return null;
    }

    @Override
    public List<Product> search(String name, String startDate, String endDate, Boolean soldOut, int guarantee, int categoryId, int bought, int promotion) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        return null;
    }

    @Override
    public Product findById(int id) throws SQLException {
        return null;
    }

    @Override
    public Product insert(Product product) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean deleted(int id) throws SQLException {
        return false;
    }
}
