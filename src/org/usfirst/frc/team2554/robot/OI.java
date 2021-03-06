package org.usfirst.frc.team2554.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.commands.Claw.Retrieve;

import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.Claw.WinchDown;
import org.usfirst.frc.team2554.robot.commands.Claw.WinchUp;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.ManualElevator;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;
import org.usfirst.frc.team2554.robot.subsystems.Elevator;
import org.usfirst.frc.team2554.robot.triggers.Intake;
import org.usfirst.frc.team2554.robot.triggers.ManualControl;
import org.usfirst.frc.team2554.robot.triggers.Outtake;
import org.usfirst.frc.team2554.robot.triggers.PovRotate;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	

     //0: HOME
	// 1: SWITCH 
	// 2: SCALE
	// 3: CLIMB
	public Joystick leftStick = new Joystick(0);
	public Joystick mechController = new Joystick(2);
	
	//BUTTONS 
	
	
	// Levels
	int buttonHome = 1;
	int buttonSwitch = 2;
	int buttonScale = 4;
	
	

	//Elevator
	
	
	//Winch
	int winchControlUp =  6;
	int winchControlDown = 5;
	//AXES 
	
	//Claw
	int intakeControl = 3;
	int outtakeControl = 2;

	
	//Elevator
	int elevatorControl = 1;
	
	//Elevator Buttons
	public Button home = new JoystickButton(mechController, buttonHome);
    public Button switche = new JoystickButton(mechController, buttonSwitch);
    public Button scale = new JoystickButton(mechController, buttonScale);
    
   //Climbing
    
    
    public Button winchUp = new JoystickButton(mechController, winchControlUp);
    public Button winchDown = new JoystickButton(mechController, winchControlDown);
    
    public Trigger manualControl = new ManualControl(mechController, elevatorControl);
    public Trigger intake = new Intake(mechController, intakeControl);
    public Trigger outtake = new Outtake(mechController, outtakeControl);
   
 
    public Trigger degree90 = new PovRotate(leftStick, 90);
    public Trigger degree0 = new PovRotate(leftStick, 0);
    public Trigger degreeminus90 = new PovRotate(leftStick, 270);
    public Trigger degree180 = new PovRotate (leftStick, 180);
    
    public double elevatorControl() //manual elevator
 	{
 		return -1*mechController.getRawAxis(elevatorControl);
 	}
    
    public double intakeSpeed() // claw
    {
    	return mechController.getRawAxis(intakeControl);
    }
    
    public double outtakeSpeed() // claw
    {
    	return mechController.getRawAxis(outtakeControl);
    }
 
    public double leftSide() //tank drive
    {
    	return -1*leftStick.getY();
    }
    
  
    

	
    public double verticalSpeed() //arcade drive
    {
    	return -1*leftStick.getY();
    }
    
    public double rotationSpeed() // arcade drive
    {
    	return leftStick.getZ();
    }
	public OI() {
		
		

		home.whenPressed(new MoveElevator(0));
		switche.whenPressed(new MoveElevator(1));
		scale.whenPressed(new MoveElevator(2));
		

		winchUp.whileHeld(new WinchUp());
		winchDown.whileHeld(new WinchDown());	
		
		manualControl.whileActive(new ManualElevator());
		intake.whileActive(new Retrieve());
		outtake.whileActive(new Shooter());
		
		degree90.whenActive(new RotateToAngle(90));
		degreeminus90.whenActive((new RotateToAngle(-90)));
		degree0.whenActive(new RotateToAngle(0));
		degree180.whenActive(new RotateToAngle(180));
	}

	
	
}
