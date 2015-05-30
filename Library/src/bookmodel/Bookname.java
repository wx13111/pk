package bookmodel;

/**
 * Bookname entity. @author MyEclipse Persistence Tools
 */

public class Bookname implements java.io.Serializable {

	// Fields

	private Integer bid;
	private Integer bookId;
	private String bookName;

	// Constructors

	/** default constructor */
	public Bookname() {
	}

	/** full constructor */
	public Bookname(Integer bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}