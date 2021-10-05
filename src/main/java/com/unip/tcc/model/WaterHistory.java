package com.unip.tcc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="water_history")
@Table(name="water_history")
public class WaterHistory {
	
	@Id
	@GeneratedValue(generator= "increment")
	@GenericGenerator(name="increment", strategy ="increment")
	@Column(name="id")
	private Integer id;
	
	@Column(name="date_att")
	private Date dateAtt;
	
	@Column(name="quantity")
	private String quantity;
	
	public WaterHistory() {}

	public WaterHistory(String quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateAtt() {
		return dateAtt;
	}

	public void setDateAtt(Date dateAtt) {
		this.dateAtt = dateAtt;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
