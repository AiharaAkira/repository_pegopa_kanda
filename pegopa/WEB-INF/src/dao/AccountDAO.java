package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import util.DBManager;

public class AccountDAO {

	public static boolean loginCheck(boolean result, HttpServletRequest request, HttpServletResponse res) {
		Account account = (Account) request.getSession().getAttribute("accountList");

		result = false;

		if (account == null) {

				result = true;
				return result;

		}

		return result;

	}

	public static boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		Account account = (Account) request.getSession().getAttribute("accountList");

		if (account == null) {

			return true;

		}

		return false;
	}

	public static void login(String name, String pw, HttpServletRequest request) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from account where email = '" + name + "'";
			System.out.println(sql);
			con = DBManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			Account a = new Account();

			if (rs.next()) {
				String dbPW = rs.getString("pw");

				if (pw.equals(dbPW)) {

					a.setId(Integer.parseInt(rs.getString("id")));
					a.setPw(rs.getString("pw"));
					a.setName(rs.getString("name"));
					a.setEmail(rs.getString("email"));
					a.setAddress(rs.getString("address"));
					a.setAuthority(Integer.parseInt(rs.getString("authority")));

					HttpSession hs = request.getSession();
					hs.setAttribute("accountList", a);
					hs.setMaxInactiveInterval(1800);

					System.out.println("login success");

				} else {
					System.out.println("pw worng!");
					a = null;

				}
			} else {

				System.out.println("no userdata");
				a = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}

	}

	public static void logout(HttpServletRequest request) {

		try {

			HttpSession hs = request.getSession();
			hs.setAttribute("accountList", null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void insert(Account a) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		try {
			String sql = "INSERT INTO account (pw,name,address,email,authority)" + "VALUES('" + a.getPw() + "','"
					+ a.getName() + "','" + a.getAddress() + "','" + a.getEmail() + "'," + a.getAuthority() + ")";
			;
			System.out.println(sql);
			con = DBManager.getConnection();
			smt = con.createStatement();
			if (smt.executeUpdate(sql) >= 1) {

				System.out.println("success");
			} else {
				System.out.println("fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}

	}

	public static void update(Account a) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		try {
			String sql = "update account set name = '" + a.getName() + "',pw='" + a.getPw() + "',address='"
					+ a.getAddress() + "',email='" + a.getEmail() + "' " + "where id = " + a.getId();
			System.out.println(sql);
			con = DBManager.getConnection();
			smt = con.createStatement();
			if (smt.executeUpdate(sql) >= 1) {

				System.out.println("success");
			} else {
				System.out.println("fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}

	}

	public static int delete(Account a) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;

		int result = 0;
		try {
			String sql = "delete from account where email ='" + a.getEmail() + "'and pw='" + a.getPw() + "'and name ='"
					+ a.getName() + "'";
			System.out.println(sql);
			con = DBManager.getConnection();
			smt = con.createStatement();
			if (smt.executeUpdate(sql) >= 1) {

				System.out.println("success");
				result = 1;
			} else {
				System.out.println("fail");
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}
		return result;

	}

	public static boolean loginCheck(String name) {

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {

			String sql = "select * from account where email = '" + name + "'";
			System.out.println(sql);

			con = DBManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			if (rs.next()) {

				System.out.println("login success");
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}
		return true;

	}

	public static boolean searchByEmailPw(String name, String pw) {
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {

			String sql = "select * from account where email = '" + name + "' and pw = '" + pw + "'";
			System.out.println(sql);

			con = DBManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			System.out.println("----------");

			if (rs.next()) {

				System.out.println("success");
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}
		return true;
	}

	public static boolean searchByEmailPw(String name, String pw, int id) {
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {

			String sql = "select * from account where email = '" + name + "'";
			System.out.println(sql);

			con = DBManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			if (rs.next()) {

				System.out.println("success");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			DBManager.close(con, smt, rs);
		}
		return true;
	}

}
