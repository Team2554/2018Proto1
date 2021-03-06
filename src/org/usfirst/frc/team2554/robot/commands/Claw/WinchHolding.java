package org.usfirst.frc.team2554.robot.commands.Claw;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchHolding extends Command {

    public WinchHolding() {
    	
        requires(Robot.claw);

        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.claw.winchSpeed(0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.winchSpeed(0.095);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.winchSpeed(0.15);

    }
}
