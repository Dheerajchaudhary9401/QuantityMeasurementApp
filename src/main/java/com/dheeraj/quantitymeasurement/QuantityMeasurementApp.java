package com.dheeraj.quantitymeasurement;

public class QuantityMeasurementApp {
	

	public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
		if(q1.equals(q2)) return true;
		return false;
	}
	
	public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> q, U targetUnit){
		return new Quantity<>(q.convertTo(targetUnit), targetUnit);
	}
	
	public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2){
			return q1.add(q2);
	}
	
	public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit){
		return q1.add(q2, targetUnit);
	}
	
	public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2, U targetUnit){
		return q1.subtract(q2, targetUnit);
	}
	
	public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> q1, Quantity<U> q2){
		return q1.subtract(q2);
	}
	
	public static <U extends IMeasurable> double demonstrateDivision(Quantity<U> q1, Quantity<U> q2) {
		return q1.divide(q2);
	}

	public static void main(String[] args) {
		
		//weight
		//Demonstrate equality bw to two quantities
		Quantity<WeightUnit> weightInGrams=new Quantity<>(1000.0,WeightUnit.GRAM);
		Quantity<WeightUnit> weightInKilograms=new Quantity<>(1.0,WeightUnit.KILOGRAM);
		boolean areEqual=demonstrateEquality(weightInGrams,weightInKilograms);
		System.out.println("Are weights equal: "+areEqual);
		
		//Demonstrate conversion bw two quantities
		Quantity<WeightUnit> convertedWeight=demonstrateConversion(weightInGrams, WeightUnit.KILOGRAM);
		System.out.println("Converted weight"+convertedWeight);
		
		
		//Demonstration addition of two quantities and return the result in the unit of first quantity
		System.out.println("Addition (result in first unit): "+demonstrateAddition(weightInGrams, weightInKilograms));
		
		//Demonstration addition of two quantities and return the result in the target unit
		System.out.println("Addition (result in MILLIGRAM): "+demonstrateAddition(weightInGrams,weightInKilograms,WeightUnit.MILLIGRAM));
		
		System.out.println("Subtraction (result in first unit): " + demonstrateSubtraction(weightInGrams, weightInKilograms));
	    System.out.println("Subtraction (result in MILLIGRAM): " + demonstrateSubtraction(weightInGrams, weightInKilograms, WeightUnit.MILLIGRAM));

	    System.out.println("Division: " + demonstrateDivision(weightInGrams, weightInKilograms));

		
		//length
		Quantity<LengthUnit> lengthInFeet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(12.0, LengthUnit.INCHES);

        boolean lengthsEqual = demonstrateEquality(lengthInFeet, lengthInInches);
        System.out.println("Are lengths equal: " + lengthsEqual);
        //Demonstrate conversion bw two quantities
        Quantity<LengthUnit> convertedLength = demonstrateConversion(lengthInFeet, LengthUnit.INCHES);
        System.out.println("Converted length: " + convertedLength);
		//Demonstration addition of two quantities and return the result in the unit of first quantity
        System.out.println("Addition (result in first unit): " + demonstrateAddition(lengthInFeet, lengthInInches));
        //Demonstration addition of two quantities and return the result in the target unit
		System.out.println("Addition (result in YARDS): " + demonstrateAddition(lengthInFeet, lengthInInches, LengthUnit.YARDS));

		System.out.println("Subtraction (result in first unit): " + demonstrateSubtraction(lengthInFeet, lengthInInches));
	    System.out.println("Subtraction (result in YARDS): " + demonstrateSubtraction(lengthInFeet, lengthInInches, LengthUnit.YARDS));

	    System.out.println("Division: " + demonstrateDivision(lengthInFeet, lengthInInches));

	    
		//volume
		Quantity<VolumeUnit> volumeInML=new Quantity<>(1000.0,VolumeUnit.MILLILITRE);
		Quantity<VolumeUnit> volumeInL=new Quantity<>(1.0,VolumeUnit.LITRE);
		boolean areVolumeEqual=demonstrateEquality(volumeInML, volumeInL);
		System.out.println("Are volumes equal: "+areVolumeEqual);
		
		Quantity<VolumeUnit> convertedVolume=demonstrateConversion(volumeInML,VolumeUnit.LITRE);
		System.out.println("Converted volume: "+convertedVolume);
		System.out.println("Addition (result in first unit): "+demonstrateAddition(volumeInML, volumeInL));
		System.out.println("Addition (result in gallons): " + demonstrateAddition(volumeInML,volumeInL,VolumeUnit.GALLON));
		
		System.out.println("Subtraction (result in first unit): " + demonstrateSubtraction(volumeInML, volumeInL));
	    System.out.println("Subtraction (result in GALLON): " + demonstrateSubtraction(volumeInML, volumeInL, VolumeUnit.GALLON));

	    System.out.println("Division: " + demonstrateDivision(volumeInML, volumeInL));
	
	  //Temperature 
  		Quantity<TemperatureUnit> q1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
  		Quantity<TemperatureUnit> q2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
  		System.out.println("0 C equals 32 F: "+q1.equals(q2));
  		
  		Quantity<TemperatureUnit> celsius= new Quantity<>(100.0, TemperatureUnit.CELSIUS);
  		Quantity<TemperatureUnit> fahrenheit= demonstrateConversion(celsius,TemperatureUnit.FAHRENHEIT);
  		System.out.println("Coverted 100 C to fahrenheit = "+fahrenheit);

  		try {
  			demonstrateAddition(celsius,new Quantity<>(50.0, TemperatureUnit.CELSIUS));
		}catch(UnsupportedOperationException e) {
	  		System.out.println(e.getMessage());
	  	}
	}
}
