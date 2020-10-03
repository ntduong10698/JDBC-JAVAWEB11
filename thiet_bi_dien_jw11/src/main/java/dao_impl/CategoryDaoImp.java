package dao_impl;

import dao.CategoryDao;
import model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public Category getObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Category> getList(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<Category> findAll() throws SQLException {
        return null;
    }

    @Override
    public Category findById(int id) throws SQLException {
        return null;
    }

    @Override
    public Category insert(Category category) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }

    @Override
    public boolean deleted(int id) throws SQLException {
        return false;
    }
}
