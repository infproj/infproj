package rs.code9.videostore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "movie")
public class Movie extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5631695248497327122L;

	@NotEmpty(message = "This field is required!")
	private String name;
	
	@NotEmpty(message = "This field is required!")
	private String genre;
	
	@NotEmpty(message = "This field is required!")
	private String description;
	
	@NotNull(message = "This field is required!")
	private int year;
	
	@NotNull(message = "This field is required!")
	private int stock;
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "genre")
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Column(name = "year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
