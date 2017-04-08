package by.htp.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.web.dao.impl.BookDaoImpl;
import by.htp.web.domain.Book;

import static by.htp.web.util.Permanents.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AdminAddBook implements Command{
	BookDaoImpl impl = new BookDaoImpl();
	List<Book> books = new ArrayList<Book>();
		@Override
		public String AddBookCommand(HttpServletRequest request, HttpServletResponse response) {
			String page = PAGE_WELCOME_ADMIN;
			String bookTitle = "";
			Connection con;
			Statement st;
			ResultSet rs;
			PreparedStatement pstmt;
			bookTitle = request.getParameter("title");

				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/webdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
					pstmt = con.prepareStatement("UPDATE BOOK SET TITLE = ? WHERE ID = ?");
					int x = 0;
					books = impl.read();
					x = books.size()+1;
					

	pstmt.setInt(1, x);
	pstmt.setString(2, bookTitle);                      

					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				 catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
			
			return page;
		}
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			return AddBookCommand(request, response);
		}

		


}
