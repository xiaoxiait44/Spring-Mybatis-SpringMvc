package com.xxa.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxa.dao.BookDao;
import com.xxa.entity.Book;

public class BookDaoTest extends BookTest {
	@Autowired
	private BookDao bookDao;
	@Test
	public void testqueryById() throws Exception {
		long bookid=1000;
		Book book = bookDao.queryById(bookid);
		System.out.println(book.getName());
		
	}
	@Test
	public void testqueryAll() {
		List<Book> book = bookDao.queryAll(0, 4);
		for(Book b:book) {
		 System.out.println(b.getName());
		}
		
	}
	@Test
	public void testreduceNumber() {
		long number = 1000;
		int number1 = bookDao.reduceNumber(number);
        System.out.println(number1);		
	}
	

}
