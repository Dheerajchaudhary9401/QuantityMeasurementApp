package com.dheeraj.quantitymeasurement;

public class QuantityMeasurementApp {
	
	//UC1
	public static class Feet{
		private final double value;
		public Feet(double value) {
			this.value=value;
		}
		public double getValue() {
			return value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj == null) {
				return false;
			}
			if(getClass() != obj.getClass()) {
				return false;
			}
			Feet other= (Feet) obj;
			return Double.compare(this.value, other.value)==0;
		}
		
		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}

	//UC2
	public static class Inches{
		private final double value;
		public Inches(double value) {
			this.value=value;
		}
		public double getValue() {
			return value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj== null) {
				return false;
			}if(getClass() != obj.getClass()) {
				return false;
			}
			Inches other = (Inches)obj;
			return Double.compare(this.value,other.value)==0;
		}
		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}
	public static void demonstrateFeetEquality() {
		Feet feet1 = new Feet(12.01);
		Feet feet2 = new Feet(12.01);
		System.out.print("Feet: ");
		if(feet1.equals(feet2)) {
			System.out.println("equal");
		}else {
			System.out.println("not equal");
		}
	}
	
	public static void demonstrateInchesEquality() {
		Inches i1 = new Inches(12.01);
		Inches i2 = new Inches(12.01);
		System.out.print("Inches: ");
		if(i1.equals(i2)) {
			System.out.println("equal");
		}else {
			System.out.println("not equal");
		}
	}
	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();

	}

}
