package swerveDrive;

import java.util.ArrayList;

public class gearRatios {
	// in a perfect world, motor rotation of 1 would mean wheel rotation of one
	// however since we use gears and degrees (not rotations) for assembly turns, we need conversions
	// in total there are 2 conversions desired, motor turns to assembly degree turns and motor turns to wheel turns

	public static ArrayList<Integer> initGears() {
		int motorBevel1 = 15;
		int motorBevel2withMotor = 18; 
		int motorBevel2withSpur = 13;
		int gearBoxSpur = 32;
		int gearBoxSpur2 = 32;
		int rackBevelOutside = 116;
		
		// place all variables into a list
		ArrayList<Integer> gearList = new ArrayList<Integer>();
		gearList.add(motorBevel1);
		gearList.add(motorBevel2withMotor);
		gearList.add(motorBevel2withSpur);
		gearList.add(gearBoxSpur);
		gearList.add(gearBoxSpur2);
		gearList.add(rackBevelOutside);
		return gearList;
	}
	
	// given two values in a list, [# of input gear, # of output gear]
	public static double getRatio(int inputGearTeeth, int outputGearTeeth) {
		double gearRatio = outputGearTeeth/(1.0 * inputGearTeeth);
		return gearRatio;
	}
	
	public static double getGearboxRatio(ArrayList<Integer> gearsList) {
		// converting the gear ratios that spin assembly in rotations but not stealth wheel
		// each of the gears that mesh with each other are adjacent indexes in the list
		double gearBoxRatio = 1;
		double tempGearRatio = 1;
		for (int i = 0; i < gearsList.size(); i++) {
			if (i % 2 == 0) {				
				tempGearRatio = getRatio(gearsList.get(i), gearsList.get(i + 1));
			} else if (i % 2 != 0){
				gearBoxRatio = tempGearRatio * gearBoxRatio;
			}	 
		}
		// Gear Ratios only give the outPutGearRotations using inputGearRotations as 1
		// Instead, use the reciprocal of gearBoxRatio to find inputGearRotations based off of outputGearRotations being 1
		return gearBoxRatio;
	}
	
	// calculate conversions for gear ratios
	public static ArrayList<Double> getFinalGearRatio(double gearBoxRatio, double stealthWheelRotations, double assemblyDegrees) {
		// so now that we have the gearbox ratio, we have to use it to get assembly turn in degrees and stealth wheel turns in rotations

		// assembly turn in degrees
		double finalAssemblyDegrees = (assemblyDegrees/360) * gearBoxRatio;
		
		// stealth wheel degrees(taking into account involuteBevel1)
		int rackBevelInside = 63; 
		int involuteBevel1 = 18;
		double finalStealthWheelRotations = (getRatio(rackBevelInside, involuteBevel1) * gearBoxRatio) * stealthWheelRotations;
		
		ArrayList<Double> convertedDesiredMovement = new ArrayList<Double>();
		convertedDesiredMovement.add(finalStealthWheelRotations);
		convertedDesiredMovement.add(finalAssemblyDegrees);
		return convertedDesiredMovement;			
	}
}
