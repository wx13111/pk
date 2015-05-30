package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.BooknameDAO;
import bookmodel.Bookname;
import hibernate.HibernateSessionFactory;


public class BooknameControl {

	/*	BooknameControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static BooknameControl control = null; 
	public static BooknameControl getBooknameControl(){
		if(null==control){
			control = new BooknameControl();
		}
		return control;
	}
	
	/* BooknameDAO
	 * BooknamelevelDAO
	 * HibernateSession
	 */
	private BooknameDAO umlbooknameDao = null;
	private Session session = null;
	private BooknameControl(){
		umlbooknameDao = new BooknameDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Bookname saveBookname( Integer bookId, String bookName){
		Bookname bookname = new Bookname(  bookId,  bookName);
		umlbooknameDao.save(bookname);
		session.flush();
		return bookname;
	}
	public Bookname deleteBookname(Integer booknameName){
		Bookname bookname = new Bookname();
		List list = umlbooknameDao.findByBookId(booknameName);
		umlbooknameDao.delete( ( (Bookname)list.get(0)));
		umlbooknameDao.delete(bookname);
		session.flush();
		return bookname;
	}
	public List findBookname(String BooknameName){
		List list = new BooknameDAO().findByBookName(BooknameName);
		session.flush();
		return list;
	}
}