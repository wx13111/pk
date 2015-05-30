package bookmodel;

/**
 * Price entity. @author MyEclipse Persistence Tools
 */

public class Price implements java.io.Serializable {

	// Fields

	private Integer bname;
	private String bookName;
	private Integer price;

	// Constructors

	/** default constructor */
	public Price() {
	}

	/** full constructor */
	public Price(String bookName, Integer price) {
		this.bookName = bookName;
		this.price = price;
	}

	// Property accessors

	public Integer getBname() {
		return this.bname;
	}

	public void setBname(Integer bname) {
		this.bname = bname;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}