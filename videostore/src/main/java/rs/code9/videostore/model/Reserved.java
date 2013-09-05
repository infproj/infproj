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

	@Column(name = "expire_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	

}
