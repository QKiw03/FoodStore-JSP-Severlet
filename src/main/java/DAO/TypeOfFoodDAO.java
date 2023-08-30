package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TypeOfFood;

public class TypeOfFoodDAO implements DAOInterface<TypeOfFood>{

	@Override
	public ArrayList<TypeOfFood> selectAll() {
		ArrayList<TypeOfFood> data = new ArrayList<TypeOfFood>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM typeoffood";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: lấy thông tin
			while(rs.next()) {
				String idTypeOfFood = rs.getString("idtypeoffood");
				String nameTypeOfFood = rs.getString("nametypeoffood");
				
				TypeOfFood typeOfFood = new TypeOfFood(idTypeOfFood, nameTypeOfFood);
				data.add(typeOfFood);
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
	public TypeOfFood selectById(TypeOfFood t) {
		TypeOfFood data = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM typeoffood WHERE idtypeoffood=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdToF());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4: lấy thông tin
			while(rs.next()) {
				String idTypeOfFood = rs.getString("idtypeoffood");
				String nameTypeOfFood = rs.getString("nametypeoffood");
				
				data = new TypeOfFood(idTypeOfFood, nameTypeOfFood);
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
	public int insert(TypeOfFood t) {
		int check = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO typeoffood (idtypeoffood, nametypeoffood)"+
					" VALUES (?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdToF());
			st.setString(2, t.getNameToF());
			
			// Bước 3: thực thi câu lệnh SQL
			check = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ check + " dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public int insertAll(ArrayList<TypeOfFood> arr) {
		int count = 0;
		for (TypeOfFood typeOfFood : arr) {
			count+=this.insert(typeOfFood);
		}
		return count;
	}

	@Override
	public int delete(TypeOfFood t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from typeoffood "+
					 " WHERE idtypeoffood=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdToF());
			
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
	public int deleteAll(ArrayList<TypeOfFood> arr) {
		int count = 0;
		for (TypeOfFood typeOfFood : arr) {
			count+=this.delete(typeOfFood);
		}
		return count;
	}

	@Override
	public int update(TypeOfFood t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE typeoffood "+
					 " SET " +
					 " nametypeoffood=?"+
					 " WHERE idtypeoffood=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameToF());

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
		TypeOfFoodDAO tld = new TypeOfFoodDAO();
		ArrayList<TypeOfFood> kq = tld.selectAll();
		for (TypeOfFood typeOfFood : kq) {
			System.out.println(typeOfFood);
		}
	}

}
