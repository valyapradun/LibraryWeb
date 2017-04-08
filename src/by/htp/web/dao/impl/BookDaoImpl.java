package by.htp.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.web.dao.BookDao;
import by.htp.web.domain.Book;
import by.htp.web.domain.User;

public class BookDaoImpl implements BookDao {
	@Override
	public List<Book> read() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/webdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
		//	con = DriverManager.getConnection("jdbc:mysql://mysql43217-env-7650425.mycloud.by/webdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "VSPmpa89797");
			st = con.createStatement();
			rs = st.executeQuery("select * from book");

			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				String src = rs.getString("src");
				Book book = new Book(title, author, price, src);
				books.add(book);
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
		return books;
	}

}
