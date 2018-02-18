package org.usfirst.frc.team2554.robot.triggers;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ManualControl extends Trigger {

	
	Joystick joystick;
	int axis;
	public ManualControl(Joystick jystk, int ax)
	{
		joystick = jystk;
		axis = ax;
	}
    public boolean get() {
        return (Math.abs(joystick.getRawAxis(axis)) > 0.1);
         
    }
}
