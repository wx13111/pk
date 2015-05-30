package bookmodel;

/**
 * Lend entity. @author MyEclipse Persistence Tools
 */

public class Lend implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer cusId;
	private Integer bookId;

	// Constructors

	/** default constructor */
	public Lend() {
	}

	/** full constructor */
	public Lend(Integer cusId, Integer bookId) {
		this.cusId = cusId;
		this.bookId = bookId;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCusId() {
		return this.cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}