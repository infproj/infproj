package rs.code9.videostore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Taken extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6933611749048655897L;
	
	private Date returnTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_time")
	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	
	

}
