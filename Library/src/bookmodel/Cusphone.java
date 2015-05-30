package bookmodel;

/**
 * Cusphone entity. @author MyEclipse Persistence Tools
 */

public class Cusphone implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer cusId;
	private String cusPhone;

	// Constructors

	/** default constructor */
	public Cusphone() {
	}

	/** full constructor */
	public Cusphone(Integer cusId, String cusPhone) {
		this.cusId = cusId;
		this.cusPhone = cusPhone;
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

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

}