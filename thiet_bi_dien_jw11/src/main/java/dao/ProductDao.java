package dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends BaseDao<Product> {
    //Ngoài các phương thức chung khi mà một đối tượng thao tác với
    // database cần phải có đã được định nghĩa ở BaseDao
    //Thì đối với mỗi đối tượng sẽ có một số hàm riêng biệt phải được
    // chỉ ra tại Interface dao của chỉnh nó

    /**
     * Product có thêm một hàm riêng biệt để thao tác với database như sau
     * - Sắp xếp sản phẩm theo trường mà người dùng yêu cầu, thứ tự sắp xếp
     * có thể là tăng dân hoặc giảm dần
     * - Lấy ra danh sách sản phẩm cùng category
     * - tìm kiếm sản phẩm
     */

    /**
     * Hướng dẫn phân tích đọc yêu cầu để định nghĩa được một hàm
     * phục vụ yêu cầu (đầu ra của hàm, đầu vào của hàm, hàm sẽ xử lý
     * các vấn để gì)
     */

    /**
     * Sắp xếp theo các trường:
     *      - sắp xếp theo thời gian tạo sản phẩm
     *      - sắp xếp theo giá tiền
     *      - sắp xếp theo tên
     *      - sắp xếp theo số lượt mua (bán chạy)
     *      - sắp xếp theo khuyến mãi
     * => Mỗi trường sắp xếp thì sẽ có 2 kiểu sắp xếp là tằng dân hoặc giảm
     * dần. Nếu mỗi kiểu sắp xếp tạo ra 1 hàm thì sẽ có trường x 2 hàm
     * Thì cần sinh ra một hàm mà có thể thay thế được cho 10 hàm
     *
     * => tạo ra một hàm có đầu vào là 2 trường:
     *      - String field: Sắp xếp theo trường nào
     *      - boolean isASC:
     *          + isASC: true => Tần dần (ASC)
     *          + isASC: false => Giảm dần (DESC)
     * => Đầu ra là một danh sách product đã được sắp xếp theo yêu cầu
     * (List<Product>)
     */

    List<Product> sortBy(String field, boolean isASC) throws SQLException;

    //Chức năng lấy ra danh sách sản phẩm cùng category
    /**
     * Hàm trả về một danh sách sản phẩm cùng category tương ứng
     * với categoryId mà người dùng truyền vào
     */

    List<Product> findByCategory(int idCategory) throws SQLException;

    /**
     * => Hàm trả về cho mình một danh sách sản phẩm theo điều kiện lọc
     * người dùng yêu cầu
     * + Điều kiện lọc ở đây có thể là điều kiện lọc đơn: lọc theo tên,
     * lock theo ngày tạo, lọc theo giá hoặc cũng có thể là điều kiện lọc
     * hỗ hợp: lọc theo ngày và tên, lọc theo ngày và giá hoặc lọc theo
     * tên, ngày, giá
     * => Phải tạo ra một hàm search cho tất cả các trường khi không muốn
     * lọc theo một trường nào đấy thì sẽ truyền giá trị đặc biệt cho trường đấy
     * để hàm search hiểu là sẽ lọc theo điều kiện này
     * - Giá trị đặc biệt ở đây là gì:
     *      - Giá trị null
     *      - Hoặc 1 giá trị khác biệt tuopwng ứng với kiểu dữ liệu của trường
     */
     List<Product> search(String name, String startDate, String endDate,
                          Boolean soldOut, int guarantee, int categoryId,
                          int bought, int promotion) throws SQLException;
}
