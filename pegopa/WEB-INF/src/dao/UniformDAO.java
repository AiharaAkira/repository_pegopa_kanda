package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Order;
import bean.Uniform;

public class UniformDAO {


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


	public static ArrayList<Uniform> selectAll() {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		ArrayList<Uniform> uniformList = new ArrayList<Uniform>();

		try {

			String sql = "select * from uniform";

			con = getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			while (rs.next()) {
				Uniform uniform = new Uniform();

				uniform.setId(rs.getInt("id"));
				uniform.setName(rs.getString("name"));
				uniform.setPrice(rs.getInt("price"));
				uniform.setStock(rs.getInt("stock"));
				uniform.setImg(rs.getString("img"));

				uniformList.add(uniform);
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
		return uniformList;
	}


	//書籍情報を登録するメソッド
	public void insert(Uniform uniform) {

		Connection con = null;
		Statement smt = null;

		try {

			//SQL文
			String sql = "insert INTO uniform(name, price, stock, img) values('"+uniform.getName()+"', "+uniform.getPrice()+", "+uniform.getStock()+", '"+uniform.getImg()+"')";

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


	public Uniform selectById(int uniformid) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		Uniform uniform = new Uniform();

		try {

			String sql = "select name, price, stock, img FROM uniform where id="+uniformid;

			con = getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			while (rs.next()) {
				uniform.setId(uniformid);
				uniform.setName(rs.getString("name"));
				uniform.setPrice(rs.getInt("price"));
				uniform.setStock(rs.getInt("stock"));
				uniform.setImg(rs.getString("img"));
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

		return uniform;
	}


	public void update(Uniform uniform) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		Order order = new Order();

		try {

			String sql = "UPDATE uniform SET name='"+uniform.getName()+"', price="+uniform.getPrice()+", stock="+uniform.getStock()+", img='"+uniform.getImg()+"' WHERE id="+uniform.getId();

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


	public void delete(int uniformid) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		Order order = new Order();

		try {

			String sql = "delete FROM uniform where id="+uniformid;

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

}
