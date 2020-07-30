package com.cts.inventorypurchase.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "product")
public class Purchase  implements Serializable{
	
	/* private static final long serialVersionUID = 1307525040224585678L; */
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6400766232351837502L;
	@Id	
	@ApiModelProperty(notes="Product id")
	@Column(name = "product_id")
	private int id;
	@ApiModelProperty(notes="Product name")
	@Column(name = "product_name")
	private String name;
	@ApiModelProperty(notes="Product Count")
	@Column(name = "product_count")
	private int count;
	@ApiModelProperty(notes="Finished Product Count")
	@Column(name = "finished_product_count")
	private int finishedCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getFinishedCount() {
		return finishedCount;
	}
	public void setFinishedCount(int finishedCount) {
		this.finishedCount = finishedCount;
	}	
	
}
