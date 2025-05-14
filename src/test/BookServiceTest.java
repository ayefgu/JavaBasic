package test;

import book.BookDAO;
import book.BookVO;
import book.ListBookDAO;

public class BookServiceTest {
	
	public static void main(String[] args) {
		
		BookDAO bookDAO = new ListBookDAO();
		
		bookDAO.insertBook(new BookVO ("test", "hyejeong", "kopo", 10000, 10));
		bookDAO.insertBook(new BookVO("test2", "curi", "home", 1000, 5));
		bookDAO.insertBook(new BookVO("test3", "hey", "home", 3000, 15));
		
		System.out.println(bookDAO.selectAllBooks());
		System.out.println(bookDAO.selectBook(112));
		
		BookVO book = bookDAO.selectBook(111);
		book.setPrice(15);
		bookDAO.updateBook(book);
		
		book = bookDAO.selectBook(112);
		book.setPrice(30000);
		bookDAO.updateBook(book);
		
		
		System.out.println(bookDAO.selectAllBooks());
		
		bookDAO.deleteBook(113);
		System.out.println(bookDAO.selectAllBooks());
	}

}
