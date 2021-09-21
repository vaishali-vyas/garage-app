package com.natwest.garage.persistence.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String make;

	private String model;

	private String colour;

	private String reg;

	public Cars() {
		super();
	}

	public Cars(String make, String model, String colour, String reg) {
		super();
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.reg = reg;
	}

	public Cars(Long id, String make, String model, String colour, String reg) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.reg = reg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", make=" + make + ", model=" + model + ", colour=" + colour + ", reg=" + reg + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, id, make, model, reg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cars other = (Cars) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(id, other.id) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && Objects.equals(reg, other.reg);
	}

}
