package bookmodel;

/**
 * Num entity. @author MyEclipse Persistence Tools
 */

public class Num implements java.io.Serializable {

	// Fields

	private Integer bid;
	private Integer bookId;
	private Integer surNum;
	private Integer lendNum;

	// Constructors

	/** default constructor */
	public Num() {
	}

	/** full constructor */
	public Num(Integer bookId, Integer surNum, Integer lendNum) {
		this.bookId = bookId;
		this.surNum = surNum;
		this.lendNum = lendNum;
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

	public Integer getSurNum() {
		return this.surNum;
	}

	public void setSurNum(Integer surNum) {
		this.surNum = surNum;
	}

	public Integer getLendNum() {
		return this.lendNum;
	}

	public void setLendNum(Integer lendNum) {
		this.lendNum = lendNum;
	}

}