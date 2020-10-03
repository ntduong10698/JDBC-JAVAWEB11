package dao_impl;

import dao.ProductDao;
import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product getObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getList(ResultSet resultSet) throws SQLException {
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
