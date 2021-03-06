package org.usfirst.frc.team2554.robot.commands.Elevator;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

         //0: HOME
	// 1: SWITCH
	// 2: SCALE
	// 3: CLIMB
public class MoveElevator extends Command {

	private int goal;
	private int currentLocation;
	private double speedUp = 0.45;
	private double speedDown = -0.2;
	private double speed= 0;
    public MoveElevator(int goal) {
        requires(Robot.elevator);
       this.goal = goal;
       
    }

    protected void initialize() {

    	currentLocation = Robot.elevator.currentLocation;
    	 
    	
    	if(goal > currentLocation)
    		speed = speedUp;
    	
    	 if(goal < currentLocation)
    		speed = speedDown;
 

    	 
    }

    protected void execute() {
    	
		Robot.elevator.move(speed);
	
		int position = Robot.elevator.getCurrentLocation();
    	
    	if(position>=0)
    		Robot.elevator.currentLocation = position;
    }

    protected boolean isFinished() {
    	return Robot.elevator.getLimit(goal);
    	
    }

    protected void end() {
    	Robot.elevator.stall();
    	Robot.elevator.currentLocation = Robot.elevator.getCurrentLocation();
    }

    protected void interrupted() {
    	Robot.elevator.stall();
    }
}
