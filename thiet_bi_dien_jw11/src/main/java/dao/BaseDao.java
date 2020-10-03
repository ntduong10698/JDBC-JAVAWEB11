package dao;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Các hàm thao tác với database mà đối tượng
 * nào cũng phải có
 *
 * findAll(): lấy ra tất cả cá bản ghi
 * findById(): lấy ra bản ghi có id tương ứng
 * insert(): thêm một bản ghi
 * update(): sửa một bản ghi
 * delete(): xóa một bản ghi
 *
 * ngọi trừ 5 hàm thao tác với db cần có cần thêm 2 hàm
 * getObject và getList
 * sẽ chuyển đối tượng resultSet về đối tượng của mìnhd
 *
 * Để không phải viết lại code nhiều
 * sử dụng kĩ thuật lập trình tổng quát
 */

//T đại diện class muốn truyền vào
public interface BaseDao<T> {

    T getObject(ResultSet resultSet) throws SQLException;

    List<T> getList(ResultSet resultSet) throws SQLException;

    List<T> findAll() throws SQLException;

    T findById(int id) throws SQLException;

    T insert(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean deleted(int id) throws SQLException;
}
