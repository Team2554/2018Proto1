package org.usfirst.frc.team2554.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int[] driveTrain = {3,0,1,2};
	public static int[] claw = {5, 6};
	public static int winch = 7;

	public static int[] elevator = {4,8};
	
	
	public static int[] limitSwitches = {4,5,6};
	public static int winchLimit = 9;
	public static int[] encoderLeft = {0,1};
	public static int[] encoderRight = {2,3};
	public static int[] encoderWinch = {7, 8};

}
