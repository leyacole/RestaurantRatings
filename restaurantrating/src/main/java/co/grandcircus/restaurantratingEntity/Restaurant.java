package co.grandcircus.restaurantratingEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurants")

public class Restaurant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double rating;
	private String name;
	
	public Restaurant() {
		super();
	}

	public Restaurant(Long id, double rating, String name) {
		super();
		this.id = id;
		this.rating = rating;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", rating=" + rating + ", name=" + name + "]";
	}
	
	
	
	
	
	
	

}
