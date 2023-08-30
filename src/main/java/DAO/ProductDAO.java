package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Product;
import model.Supplier;
import model.TypeOfFood;

public class ProductDAO implements DAOInterface<Product>{

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> data = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: lấy thông tin
			while(rs.next()) {
				String idProduct = rs.getString("idproduct");
				String nameProduct = rs.getString("nameproduct");
				String idSupplier = rs.getString("idsupplier");
				int date = rs.getInt("date");
				double importPrice = rs.getDouble("importPrice");
				double cost = rs.getDouble("cost");
				double price = rs.getDouble("price");
				int count = (int) rs.getDouble("count");
				String idTypeoffood = rs.getString("idtypeoffood");
				String story = rs.getString("story");

				Supplier supplier = (new SuppilerDAO().selectById(new Supplier(idSupplier, "", null, "")));
				TypeOfFood typeOfFood = (new TypeOfFoodDAO().selectById(new TypeOfFood(idTypeoffood, "")));

				Product product = new Product(idProduct, nameProduct, supplier, 
						date, importPrice, cost, price, count,typeOfFood, story);
				data.add(product);
			}
			
			// Bước 5: Dong CSDL
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public Product selectById(Product t) {
		Product data = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE idproduct=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdProduct());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: lấy thông tin
			while(rs.next()) {
				String idProduct = rs.getString("idproduct");
				String nameProduct = rs.getString("nameproduct");
				String idSupplier = rs.getString("idsupplier");
				int date = rs.getInt("date");
				double importPrice = rs.getDouble("importPrice");
				double cost = rs.getDouble("cost");
				double price = rs.getDouble("price");
				int count = (int) rs.getDouble("count");
				String idTypeoffood = rs.getString("idtypeoffood");
				String story = rs.getString("story");

				Supplier supplier = (new SuppilerDAO().selectById(new Supplier(idSupplier, "", null, "")));
				TypeOfFood typeOfFood = (new TypeOfFoodDAO().selectById(new TypeOfFood(idTypeoffood, "")));

				data = new Product(idProduct, nameProduct, supplier, 
						date, importPrice, cost, price, count,typeOfFood, story);
			}
			// Bước 5: Dong CSDL
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public int insert(Product t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO product (idproduct, nameproduct, idsupplier, date, "
					+ "importPrice, cost, price, count, idtypeoffood,story) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdProduct());
			st.setString(2, t.getNameProduct());
			st.setString(3, t.getSupplier().getIdSupplier());
			st.setInt(4, t.getDate());
			st.setDouble(5, t.getImportPrice());
			st.setDouble(6, t.getCost());
			st.setDouble(7, t.getPrice());
			st.setInt(8, t.getCount());
			st.setString(9, t.getTypeOfFood().getIdToF());
			st.setString(10, t.getStory());

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
	public int insertAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product product : arr) {
			count+=this.insert(product);
		}
		return count;
	}

	@Override
	public int delete(Product t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from product " + " WHERE idproduct=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdProduct());

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
	public int deleteAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product product : arr) {
			count+=this.delete(product);
		}
		return count;
	}

	@Override
	public int update(Product t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE product " + " SET " + "nameproduct=?, idsupplier=?, date=?, importPrice=?, cost=?, "
					+ "price=?, count=?, idtypeoffood=?, story=?" + " WHERE idproduct=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameProduct());
			st.setString(2, t.getSupplier().getIdSupplier());
			st.setInt(3, t.getDate());
			st.setDouble(4, t.getImportPrice());
			st.setDouble(5, t.getCost());
			st.setDouble(6, t.getPrice());
			st.setInt(7, t.getCount());
			st.setString(8, t.getTypeOfFood().getIdToF());
			st.setString(9 , t.getStory());
			st.setString(10, t.getIdProduct());
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

}
