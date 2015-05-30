package bookmodel;

/**
 * Time entity. @author MyEclipse Persistence Tools
 */

public class Time implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer cusId;
	private Integer lendTime;
	private Integer retTime;

	// Constructors

	/** default constructor */
	public Time() {
	}

	/** full constructor */
	public Time(Integer cusId, Integer lendTime, Integer retTime) {
		this.cusId = cusId;
		this.lendTime = lendTime;
		this.retTime = retTime;
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

	public Integer getLendTime() {
		return this.lendTime;
	}

	public void setLendTime(Integer lendTime) {
		this.lendTime = lendTime;
	}

	public Integer getRetTime() {
		return this.retTime;
	}

	public void setRetTime(Integer retTime) {
		this.retTime = retTime;
	}

}