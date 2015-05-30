package bookmodel;

/**
 * Money entity. @author MyEclipse Persistence Tools
 */

public class Money implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer cusId;
	private Integer money;

	// Constructors

	/** default constructor */
	public Money() {
	}

	/** full constructor */
	public Money(Integer cusId, Integer money) {
		this.cusId = cusId;
		this.money = money;
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

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}