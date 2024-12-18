package com.jacaranda.model;

import java.util.Objects;

public class IMCCalculator {

	private float weight;
	private float height;

	public IMCCalculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IMCCalculator(float weight, float height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IMCCalculator other = (IMCCalculator) obj;
		return Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}
	
	public float calculateIMC() {
		
		return (float) (weight / Math.pow((height), 2));
		
	}

}
