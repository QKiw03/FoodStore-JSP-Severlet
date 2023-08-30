package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;

public class ClientDAO implements DAOInterface<Client>{

	@Override
	public ArrayList<Client> selectAll() {
		ArrayList<Client> data = new ArrayList<Client>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String idClient = rs.getString("idclient");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullname");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryaddress");
				String shoppingAdress = rs.getString("shoppingadress");
				Date dob = rs.getDate("dob");
				String phoneNumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean registerEmail = rs.getBoolean("registeremail");

				Client client = new Client(idClient, userName, password, fullName, sex, address,
						deliveryAddress, shoppingAdress, dob, phoneNumber, email, registerEmail);
				data.add(client);
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
	public Client selectById(Client t) {
		Client data = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String idClient = rs.getString("idclient");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullname");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryaddress");
				String shoppingAdress = rs.getString("shoppingadress");
				Date dob = rs.getDate("dob");
				String phoneNumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean registerEmail = rs.getBoolean("registeremail");

				data = new Client(idClient, userName, password, fullName, sex, address,
						deliveryAddress, shoppingAdress, dob, phoneNumber, email, registerEmail);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
	
	public Client selectByIdAndPassword(Client t) {
		Client data = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM client WHERE username=? and password=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserName());
			st.setString(2, t.getPassword());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String idClient = rs.getString("idclient");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("fullname");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryaddress");
				String shoppingAdress = rs.getString("shoppingadress");
				Date dob = rs.getDate("dob");
				String phoneNumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				boolean registerEmail = rs.getBoolean("registeremail");

				data = new Client(idClient, userName, password, fullName, sex, address,
						deliveryAddress, shoppingAdress, dob, phoneNumber, email, registerEmail);
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
	public int insert(Client t) {
		int check = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO client (idclient, username, password, fullname, sex, address, "
					+ "deliveryaddress, shoppingadress, dob, phonenumber, email, registeremail) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdClient());
			st.setString(2, t.getUserName());
			st.setString(3, t.getPassword());
			st.setString(4, t.getFullName());
			st.setString(5, t.getSex());
			st.setString(6, t.getAddress());
			st.setString(7, t.getDeliveryAddress());
			st.setString(8, t.getShoppingAdress());
			st.setDate(9, t.getDob());
			st.setString(10, t.getPhoneNumber());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.isRegisterEmail());

			// Bước 3: thực thi câu lệnh SQL
			check = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + check + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int insertAll(ArrayList<Client> arr) {
		int count = 0;
		for (Client client : arr) {
			count += this.insert(client);
		}
		return count;
	}

	@Override
	public int delete(Client t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from client " + " WHERE idclient=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdClient());

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
	public int deleteAll(ArrayList<Client> arr) {
		int count = 0;
		for (Client client : arr) {
			count += this.delete(client);
		}
		return count;
	}

	@Override
	public int update(Client t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE client " + " SET " + " username=?" + ", password=?" + ", fullname=?" + ", sex=?"
					+ ", address=?" + ", deliveryaddress=?" + ", shoppingadress=?" + ", dob=?" + ", phonenumber=?"
					+ ", email=?" + ", registeremail=?" + " WHERE idclient=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserName());
			st.setString(2, t.getPassword());
			st.setString(3, t.getFullName());
			st.setString(4, t.getSex());
			st.setString(5, t.getAddress());
			st.setString(6, t.getDeliveryAddress());
			st.setString(7, t.getShoppingAdress());
			st.setDate(8, t.getDob());
			st.setString(9, t.getPhoneNumber());
			st.setString(10, t.getEmail());
			st.setBoolean(11, t.isRegisterEmail());
			st.setString(12, t.getIdClient());
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
	
	
	public boolean updateInfomation(Client t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE client " + " SET " + " fullname=?" + ", sex=?"
					+ ", address=?" + ", deliveryaddress=?" + ", shoppingadress=?" + ", dob=?" + ", phonenumber=?"
					+ ", email=?" + " WHERE idclient=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullName());
			st.setString(2, t.getSex());
			st.setString(3, t.getAddress());
			st.setString(4, t.getDeliveryAddress());
			st.setString(5, t.getShoppingAdress());
			st.setDate(6, t.getDob());
			st.setString(7, t.getPhoneNumber());
			st.setString(8, t.getEmail());
			st.setString(9, t.getIdClient());
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

		return ans > 0;
	}
	
	public boolean changePassword(Client t) {
		int ans = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE client " + " SET " + " password=?" + " WHERE idclient=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getPassword());
			st.setString(2, t.getIdClient());
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

		return ans > 0;
	}
	
	public boolean checkUserName(String userName) {
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM client WHERE username=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				return true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
