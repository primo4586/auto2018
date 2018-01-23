package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static Encoder encoder; // driving encoder
	public static Jaguar fRMotor; // Front Right Motor
	public static Jaguar fLMotor; // Front Left Motor
	public static Jaguar bRMotor; // Back Right Motor
	public static Jaguar bLMotor; // Back Left Motor
	public static AnalogGyro gyro; // driving gyroscope
	
	public static void init()
	{
		fRMotor = new Jaguar(4);
		fLMotor = new Jaguar(3);
		bRMotor = new Jaguar(6);
		bLMotor = new Jaguar(7);
		gyro = new AnalogGyro(0);
		encoder = new Encoder(0,1);
	}
	
}
