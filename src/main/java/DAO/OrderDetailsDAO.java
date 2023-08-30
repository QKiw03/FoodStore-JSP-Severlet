package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Order;
import model.OrderDetails;
import model.Product;



public class OrderDetailsDAO implements DAOInterface<OrderDetails>{

	@Override
	public ArrayList<OrderDetails> selectAll() {
		ArrayList<OrderDetails> data = new ArrayList<OrderDetails>();

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM orderdetails";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:

			while (rs.next()) {
				String idorderdetails = rs.getString("idorderdetails");
				String idorder = rs.getString("idorder");
				String idproduct = rs.getString("idproduct");
				double count = rs.getDouble("count");
				double cost = rs.getDouble("cost");
				double discount = rs.getDouble("discount");
				double price = rs.getDouble("price");
				double taxvat = rs.getDouble("taxvat");
				double totalmoney = rs.getDouble("totalmoney");

				Order order = new OrderDAO().selectById(new Order(idorder, null, "", "", "", "", "",0, 0, null, null));
				Product product = new ProductDAO().selectById(new Product(idproduct, "", null, 0, 0, 0, 0, 0, null, ""));

				OrderDetails orderDetails = new OrderDetails(idorderdetails, order, product, count, cost, discount, price,
						taxvat, totalmoney);
				data.add(orderDetails);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public OrderDetails selectById(OrderDetails t) {
		OrderDetails ans = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM orderdetails WHERE idorderdetails=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdOrderDetails());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String idorderdetails = rs.getString("idorderdetails");
				String idorder = rs.getString("idorder");
				String idproduct = rs.getString("idproduct");
				double count = rs.getDouble("count");
				double cost = rs.getDouble("cost");
				double discount = rs.getDouble("discount");
				double price = rs.getDouble("price");
				double taxvat = rs.getDouble("taxvat");
				double totalmoney = rs.getDouble("totalmoney");

				Order order = new OrderDAO().selectById(new Order(idorder, null, "", "", "", "", "",0, 0, null, null));
				Product product = new ProductDAO().selectById(new Product(idproduct, "", null, 0, 0, 0, 0, 0, null, ""));

				ans  = new OrderDetails(idorderdetails, order, product, count, cost, discount, price,
						taxvat, totalmoney);
				break;
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ans;
	}

	@Override
	public int insert(OrderDetails t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO orderdetails (idorderdetails, idorder,idproduct, count, cost,discount,price,taxvat,totalmoney) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdOrderDetails());
			st.setString(2, t.getOrder().getIdOrder());
			st.setString(3, t.getProduct().getIdProduct());
			st.setDouble(4, t.getCount());
			st.setDouble(5, t.getCost());
			st.setDouble(7, t.getDiscount());
			st.setDouble(6, t.getPrice());
			st.setDouble(8, t.getTaxVAT());
			st.setDouble(9, t.getTotalMoney());
			// Bước 3: thực thi câu lệnh SQL
			ans = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ans + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ans;
	}

	@Override
	public int insertAll(ArrayList<OrderDetails> arr) {
		int count = 0;
		for (OrderDetails orderDetails : arr) {
			count += this.insert(orderDetails);
		}
		return count;
	}

	@Override
	public int delete(OrderDetails t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from orderdetails " + " WHERE idorderdetails=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdOrderDetails());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ans = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ans + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ans;
	}

	@Override
	public int deleteAll(ArrayList<OrderDetails> arr) {
		int count = 0;
		for (OrderDetails orderDetails : arr) {
			count += this.delete(orderDetails);
		}
		return count;
	}

	@Override
	public int update(OrderDetails t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE orderdetails SET idorder=?, idproduct=?, count=?, cost=?, discount=?, price=?, taxvat=?, totalmoney=?"
					+ " WHERE idorderdetails=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getOrder().getIdOrder());
			st.setString(2, t.getProduct().getIdProduct());
			st.setDouble(3, t.getCount());
			st.setDouble(4, t.getCost());
			st.setDouble(5, t.getDiscount());
			st.setDouble(6, t.getPrice());
			st.setDouble(7, t.getTaxVAT());
			st.setDouble(8, t.getTotalMoney());
			st.setString(9, t.getIdOrderDetails());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ans = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ans;
	}

}
