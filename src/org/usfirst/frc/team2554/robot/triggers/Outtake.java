package org.usfirst.frc.team2554.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class Outtake extends Trigger {

	Joystick joystick;
	int axis;
	public Outtake(Joystick jystk, int ax)
	{
		joystick = jystk;
		axis = ax;
	}
    public boolean get() {
        return (Math.abs(joystick.getRawAxis(axis)) > 0.1);
         
    }
}
