package swerveDrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SwerveUnit {
	// get user rotation input 
	public static String getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid entry, please try again.");
		}
	   return input;
		}
	
	public static ArrayList inputDesiredMovement() {
		// get input of desired rotations for each motor
		System.out.println("Please enter the desired rotations for stealth wheel:");
		Double stealthWheelTurn = Double.parseDouble(getInput());
		System.out.println("Please enter the desired angle for Swerve Assembly:");
		Double swerveAssemblyTurn = Double.parseDouble(getInput());
		
		// do the conversions with gear ratios and degrees
		ArrayList<Double> desiredMovement = new ArrayList<Double>();
		ArrayList<Integer> gearsList = new gearRatios().initGears();
		double gearBoxRatio = gearRatios.getGearboxRatio(gearsList);
		System.out.println("the gear ratios in the gear box is " + gearBoxRatio);
		desiredMovement = gearRatios.getFinalGearRatio(gearBoxRatio, stealthWheelTurn, swerveAssemblyTurn);
		System.out.println("the desired Movement after gear ratio conversions are " + desiredMovement);
		return desiredMovement;
		}
	
	// initialize the gears and return them in a list to be used

	
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

