package com.jacaranda.model;

import java.util.Objects;

public class Calculator {

	private Integer n1;
	private Integer n2;

	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculator(Integer n1, Integer n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	
	
	public Integer getN1() {
		return n1;
	}

	public void setN1(Integer n1) {
		this.n1 = n1;
	}

	public Integer getN2() {
		return n2;
	}

	public void setN2(Integer n2) {
		this.n2 = n2;
	}

	public Integer sumar() {
		return n1 + n2;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(n1, n2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Objects.equals(n1, other.n1) && Objects.equals(n2, other.n2);
	}

	@Override
	public String toString() {
		return "Calculator [n1=" + n1 + ", n2=" + n2 + "]";
	}

	
	
}
