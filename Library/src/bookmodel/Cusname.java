package bookmodel;

/**
 * Cusname entity. @author MyEclipse Persistence Tools
 */

public class Cusname implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer cusId;
	private String cusName;

	// Constructors

	/** default constructor */
	public Cusname() {
	}

	/** full constructor */
	public Cusname(Integer cusId, String cusName) {
		this.cusId = cusId;
		this.cusName = cusName;
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

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

}