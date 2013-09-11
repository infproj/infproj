package rs.code9.videostore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserved extends Event{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7819737041808034467L;
	
	private Date expireTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expire_time")
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	

}
