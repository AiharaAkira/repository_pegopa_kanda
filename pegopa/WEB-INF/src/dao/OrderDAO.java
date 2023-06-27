package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Order;

public class OrderDAO {


	// データベース接続情報
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniformdb";
	private static String USER = "root";
	private static String PASS = "root123";

	// データベース接続を行うメソッド
	// データベース接続用定義を基にデータベースへ接続し、戻り値としてコネクション情報を返す
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}


	public static ArrayList<Order> selectAll() {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		ArrayList<Order> orderList = new ArrayList<Order>();

		try {
			String sql = "select * from orderitem order by id desc";
			con = getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);


			while (rs.next()) {
				Order order = new Order();

				order.setId(rs.getInt("id"));
				order.setEmail(rs.getString("email"));
				order.setUser_name(rs.getString("user_name"));
				order.setAddress(rs.getString("address"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderdate(rs.getTimestamp("orderdate"));
				order.setContent(rs.getString("content"));
				order.setDeposit(rs.getString("deposit"));
				order.setShipping(rs.getString("shipping"));
				order.setAccount_id(rs.getInt("account_id"));
				order.setUniform_id(rs.getInt("uniform_id"));
				order.setUniform_name(rs.getString("uniform_name"));
				order.setPrice(rs.getInt("price"));

				orderList.add(order);

			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return orderList;
	}


	public Order selectByOrderID(int orderid) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		Order order = new Order();

		try {
			String sql = "select * from orderitem where id="+orderid;

			con = getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);


			while (rs.next()) {

				order.setId(rs.getInt("id"));
				order.setEmail(rs.getString("email"));
				order.setUser_name(rs.getString("user_name"));
				order.setAddress(rs.getString("address"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderdate(rs.getTimestamp("orderdate"));
				order.setContent(rs.getString("content"));
				order.setDeposit(rs.getString("deposit"));
				order.setShipping(rs.getString("shipping"));
				order.setAccount_id(rs.getInt("account_id"));
				order.setUniform_id(rs.getInt("uniform_id"));
				order.setUniform_name(rs.getString("uniform_name"));
				order.setPrice(rs.getInt("price"));

			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}


		return order;
	}


	public void updateOrder(int orderid, String deposit, String shipping) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		Order order = new Order();

		try {
			String sql = "UPDATE orderitem SET deposit='"+deposit+"', shipping='"+shipping+"' WHERE id="+orderid;

			con = getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}

	}


	public void insertOrder(Order order) {

		Connection con = null;
		Statement smt = null;

		try {
			//SQL文
			String sql ="insert INTO orderitem(email, user_name, address, quantity, content, account_id, uniform_id, uniform_name, price) values('"+order.getEmail()+"', '"+order.getUser_name()+"', '"+order.getAddress()+"', "+order.getQuantity()+", '"+order.getContent()+"', "+order.getAccount_id()+", "+order.getUniform_id()+", '"+order.getUniform_name()+"', "+order.getPrice()+")";
			con = getConnection();
			smt = con.createStatement();

			smt.executeUpdate(sql);

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}






	}


	public ArrayList<Order> selectByUserId(int id) {
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		ArrayList<Order> orderList = new ArrayList<Order>();

		try {

			String sql = "select * from orderitem where account_id="+id+" order by id desc";
			con = getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);


			while (rs.next()) {
				Order order = new Order();

				order.setId(rs.getInt("id"));
				order.setEmail(rs.getString("email"));
				order.setUser_name(rs.getString("user_name"));
				order.setAddress(rs.getString("address"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderdate(rs.getTimestamp("orderdate"));
				order.setContent(rs.getString("content"));
				order.setDeposit(rs.getString("deposit"));
				order.setShipping(rs.getString("shipping"));
				order.setAccount_id(rs.getInt("account_id"));
				order.setUniform_id(rs.getInt("uniform_id"));
				order.setUniform_name(rs.getString("uniform_name"));
				order.setPrice(rs.getInt("price"));

				orderList.add(order);

			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return orderList;
	}


}
