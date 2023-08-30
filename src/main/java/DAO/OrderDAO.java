package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;
import model.Order;

public class OrderDAO implements DAOInterface<Order>{

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> data = new ArrayList<Order>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM order";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String idorder = rs.getString(1);
				String idclient = rs.getString(2);
				String shoppingaddress = rs.getString(3);
				String deliveryaddress = rs.getString(4);
				String status = rs.getString(5);
				String payments = rs.getString(6);
				String paymentstatus = rs.getString(7);
				double amountpaid = rs.getDouble(8);
				double amountmiss = rs.getDouble(9);
				Date dateOrder = rs.getDate(10);
				Date dateDelivery = rs.getDate(11);

				Client client = new ClientDAO()
						.selectById(new Client(idclient, "", "", "", "", "", "", "", null, "", "", false));
				
				Order order = new Order(idorder, client, shoppingaddress, deliveryaddress, status, payments,
						paymentstatus, amountpaid, amountmiss, dateOrder, dateDelivery);

				data.add(order);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Order selectById(Order t) {
		Order order = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM order WHERE idorder = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdOrder());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String idorder = rs.getString(1);
				String idclient = rs.getString(2);
				String shoppingaddress = rs.getString(3);
				String deliveryaddress = rs.getString(4);
				String status = rs.getString(5);
				String payments = rs.getString(6);
				String paymentstatus = rs.getString(7);
				double amountpaid = rs.getDouble(8);
				double amountmiss = rs.getDouble(9);
				Date dateOrder = rs.getDate(10);
				Date dateDelivery = rs.getDate(11);

				Client client = new ClientDAO()
						.selectById(new Client(idclient, "", "", "", "", "", "", "", null, "", "", false));
				
				order = new Order(idorder, client, shoppingaddress, deliveryaddress, status, payments,
						paymentstatus, amountpaid, amountmiss, dateOrder, dateDelivery);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public int insert(Order t) {
		int ans = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO order(idorder, idclient, shoppingaddress, deliveryaddress, status,payments,amountpaid, amountmiss,dateOrder,dateDelivery)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdOrder());
			st.setString(2, t.getClient().getIdClient());
			st.setString(3, t.getShoppingAddress());
			st.setString(4, t.getDeliveryAddress());
			st.setString(5, t.getStatus());
			st.setString(6, t.getPayments());
			st.setDouble(7, t.getAmountPaid());
			st.setDouble(8, t.getAmountMiss());
			st.setDate(9, t.getDateOrder());
			st.setDate(10, t.getDateDelivery());

			ans = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int insertAll(ArrayList<Order> arr) {
		int ans = 0;
		for (Order order : arr) {
			ans += this.insert(order);
		}
		return ans;
	}

	@Override
	public int delete(Order t) {
		int ans = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM order WHERE idorder = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdOrder());
			ans = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int deleteAll(ArrayList<Order> arr) {
		int ans = 0;
		for (Order t : arr) {
			ans += this.delete(t);
		}
		return ans;
	}

	@Override
	public int update(Order t) {
		int ans = 0;
		Connection con = JDBCUtil.getConnection();

		String sql = "UPDATE order" + " SET " + "client=?" + ", shoppingaddress=?" + ",deliveryaddress=?"
				+ ",status=?" + ",payments=?" + ",amountpaid=?" + ",amountmiss=?" + ",dateOrder=?"
				+ ",dateDelivery=?" + " WHERE idorder=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getClient().getIdClient());
			st.setString(2, t.getShoppingAddress());
			st.setString(3, t.getDeliveryAddress());
			st.setString(4, t.getStatus());
			st.setString(5, t.getPayments());
			st.setDouble(6, t.getAmountPaid());
			st.setDouble(7, t.getAmountMiss());
			st.setDate(8, t.getDateOrder());
			st.setDate(9, t.getDateDelivery());
			st.setString(10, t.getIdOrder());

			ans = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

}
