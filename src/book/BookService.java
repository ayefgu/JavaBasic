package book;

import java.util.List;

public interface BookService {
	boolean registBook(BookVO book);
	List<BookVO> listBooks();
	BookVO detailBookInfo(int bookNo);
	boolean updateBookPrice(int bookNo, int price);
	boolean updateBookInstock(int bookNo, int price);
	boolean removeBook(int bookNo);

}
