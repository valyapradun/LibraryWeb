package by.htp.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.web.dao.UserDao;
import by.htp.web.domain.User;


public class UserDaoImpl implements UserDao{
	@Override
	public User read(String login, String password) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/webdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
		//	con = DriverManager.getConnection("jdbc:mysql://mysql43217-env-7650425.mycloud.by/webdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "VSPmpa89797");
			st = con.prepareStatement("select * from webdb.user where user.LOGIN =? and user.PASSWORD =?");
			st.setString(1, login);
			st.setString(2, password);
			rs = st.executeQuery();

			while (rs.next()) {
				String lg = rs.getString("LOGIN");
				String pw = rs.getString("PASSWORD");
				boolean role = rs.getBoolean("ROLE");
				user = new User(lg, pw, role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
				}
			}
		}
		return user;
	}

}
