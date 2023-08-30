package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Supplier;

public class SuppilerDAO implements DAOInterface<Supplier >{

	@Override
	public ArrayList<Supplier> selectAll() {
		ArrayList<Supplier> data = new ArrayList<Supplier>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM supplier";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: lấy thông tin
			while(rs.next()) {
				String idSupplier = rs.getString("idsupplier");
				String fullName = rs.getString("fullname");
				Date foundedYear = rs.getDate("foundedyear");
				String story = rs.getString("story");
				
				Supplier supplier = new Supplier(idSupplier, fullName, foundedYear, story);
				data.add(supplier);
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
	public Supplier selectById(Supplier t) {
		Supplier data = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM supplier WHERE idsupplier=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdSupplier());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: lấy thông tin
			while(rs.next()) {
				String idSupplier = rs.getString("idsupplier");
				String fullName = rs.getString("fullname");
				Date foundedYear = rs.getDate("foundedyear");
				String story = rs.getString("story");
				
				data = new Supplier(idSupplier, fullName, foundedYear, story);
				break;
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
	public int insert(Supplier t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO supplier (idsupplier, fullname, foundedyear, story) "+
					" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdSupplier());
			st.setString(2, t.getFullName());
			st.setDate(3, t.getFoundedYear());
			st.setString(4, t.getStory());
			
			// Bước 3: thực thi câu lệnh SQL
			ans = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ans + " dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public int insertAll(ArrayList<Supplier> arr) {
		int count = 0;
		for (Supplier tacGia : arr) {
			count+=this.insert(tacGia);
		}
		return count;
	}

	@Override
	public int delete(Supplier t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from supplier "+
					 " WHERE idsupplier=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdSupplier());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ans = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ans+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public int deleteAll(ArrayList<Supplier> arr) {
		int count = 0;
		for (Supplier supplier : arr) {
			count+=this.delete(supplier);
		}
		return count;
	}

	@Override
	public int update(Supplier t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE supplier "+
					 " SET " +
					 " fullname=?"+
					 ", foundedyear=?"+
					 ", story=?"+
					 " WHERE idsupplier=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullName());
			st.setDate(2, t.getFoundedYear());
			st.setString(3, t.getStory());
			st.setString(4, t.getIdSupplier());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ans = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ans+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		SuppilerDAO tgd = new SuppilerDAO();
		ArrayList<Supplier> kq = tgd.selectAll();
		for (Supplier supplier : kq) {
			System.out.println(supplier.toString());
		}
//		
//		TacGia tg = tgd.selectById(new TacGia("TG3","",null,""));
//		System.out.println(tg);
//		
//		TacGia th_new = new TacGia("TG06","Nguyen Van Quang",new Date(2003, 03, 10),null);
//		tgd.insert(th_new);
		
	}

}
