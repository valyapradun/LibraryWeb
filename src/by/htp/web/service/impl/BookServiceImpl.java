package by.htp.web.service.impl;

import java.util.List;

import by.htp.web.dao.BookDao;
import by.htp.web.dao.impl.BookDaoImpl;
import by.htp.web.domain.Book;
import by.htp.web.service.BookService;


public class BookServiceImpl implements BookService {
private BookDao dao;
	
	{
		dao = new BookDaoImpl();
	}
	
	@Override
	public List<Book> listBooks() {
		List<Book> books = dao.read();
		return books;
	}

}
