package swerveDrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SwerveUnit {
	// get user rotation input 
	public static String getInput() {
		 BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
     String input = null;
	try {
		input = reader.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Invalid entry, please try again.");
	}
   return input;
	}
	
	// get input of desired rotations for each motor
	public static ArrayList inputDesiredMovement() {
		ArrayList<Double>desiredMovement = new ArrayList<Double>();
		System.out.println("Please enter the desired rotations for stealth wheel:");
		Double stealthWheelTurn = Double.parseDouble(getInput());
		System.out.println("Please enter the desired angle for Swerve Assembly:");
		Double swerveAssemblyTurn = Double.parseDouble(getInput());
		
		desiredMovement.add(stealthWheelTurn);
		desiredMovement.add(swerveAssemblyTurn);
		return desiredMovement;
		}
	
	// given two values in a list, [# of input gear, # of output gear]
	public static double getRatio(ArrayList<Double> gearRatioList) {
		double gearRatio = gearRatioList.get(0)/gearRatioList.get(1);
		return gearRatio;
	}
	
	// store all the number of teeth per gear 
	// calculate conversions for gear ratios
	public static ArrayList<Double> getFinalGearRatio() {
	// initializing each gear ratio
		//double ratioMotorBevel1To
	return null
	
		
	}
	
	
	public static ArrayList getMotorMovement() {
		double motorA;
		double motorB;
		ArrayList<Double>inputMovement = inputDesiredMovement();
		
		// adding the values of the stealthWheelturn, motorA will be positive while motorB is negative
		motorA = inputMovement.get(0);
		motorB = inputMovement.get(0) * -1;
		
		// adding the values of the stealthWheelturn, both motors will be same sign (either neg or pos)
		motorA += inputMovement.get(1);
		motorB += inputMovement.get(1);
		
 		ArrayList<Double> motorMovement = new ArrayList<Double>();
 		motorMovement.add(motorA);
 		motorMovement.add(motorB);
		return motorMovement;
	}
	
	
}

