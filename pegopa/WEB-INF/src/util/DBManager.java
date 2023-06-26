package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

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

		public static void close(Connection con, Statement smt, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
			}
			try {
				if (smt != null) {
					smt.close();
				}
			} catch (Exception e) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
			}
		}

}
