package bookmodel;

/**
 * Press entity. @author MyEclipse Persistence Tools
 */

public class Press implements java.io.Serializable {

	// Fields

	private Integer bname;
	private String bookName;
	private String press;

	// Constructors

	/** default constructor */
	public Press() {
	}

	/** full constructor */
	public Press(String bookName, String press) {
		this.bookName = bookName;
		this.press = press;
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

	public String getPress() {
		return this.press;
	}

	public void setPress(String press) {
		this.press = press;
	}

}