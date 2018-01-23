	package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4586.robot.commands.AutoDrive;
import org.usfirst.frc.team4586.robot.commands.AutoTurn;
import org.usfirst.frc.team4586.robot.commands.Calibrate;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {	
	public static Joystick driverJoystick;
	public static JoystickButton autoDrive;
	public static JoystickButton autoTurn;
	public static JoystickButton calibrateGyro;
	
	public OI()
	{
		driverJoystick = new Joystick(0);
		autoDrive = new JoystickButton(driverJoystick, 1);
		autoTurn = new JoystickButton(driverJoystick, 2);
		calibrateGyro = new JoystickButton(driverJoystick, 3);
		
		autoDrive.whenPressed(new AutoDrive (250));
		autoTurn.whenPressed(new AutoTurn(45));
		calibrateGyro.whenPressed(new Calibrate());
	}
}
