
package org.usfirst.frc.team4586.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4586.robot.commands.ArcadeDrive;
import org.usfirst.frc.team4586.robot.commands.AutoCommandGroupLeft;
import org.usfirst.frc.team4586.robot.commands.AutoCommandGroupMiddle;
import org.usfirst.frc.team4586.robot.commands.AutoCommandGroupRight;
import org.usfirst.frc.team4586.robot.commands.ExampleCommand;
import org.usfirst.frc.team4586.robot.commands.MiddleAutoPickCube;
import org.usfirst.frc.team4586.robot.subsystems.Driver;
import org.usfirst.frc.team4586.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static Driver driver;
	public static NetworkTable table;
	Command autonomousCommand;
	SendableChooser<Integer> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		driver = new Driver(RobotMap.fRMotor, RobotMap.fLMotor, RobotMap.bRMotor, RobotMap.bLMotor, RobotMap.encoder, RobotMap.gyro);
		driver.calibrateGyro();
		oi = new OI();
		chooser.addDefault("Auto Left Side", 0);
		//chooser.addObject("Auto Right Side", new AutoCommandGroupRight());
		//chooser.addObject("AutoMiddle", new AutoCommandGroupMiddle());
		chooser.addObject("Auto Middle Pickup", 1);
		SmartDashboard.putData("Auto mode", chooser);
		smartDashboardInit();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		System.out.println(chooser.getSelected());
		if (chooser.getSelected() == 0) {
			autonomousCommand = new AutoCommandGroupLeft();
		} 
		else if (chooser.getSelected() == 1) {
			autonomousCommand = new MiddleAutoPickCube();
		}
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		smartDashboardPeriodic();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Scheduler.getInstance().add(new ArcadeDrive());
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		smartDashboardPeriodic();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void smartDashboardPeriodic() {
		SmartDashboard.putNumber("Gyro Value", driver.getGyro());
		SmartDashboard.putNumber("Encoder Count", driver.getEncoderCount());
		SmartDashboard.putNumber("Encoder Rate", driver.getEncoderRate());
		SmartDashboard.putNumber("Encoder Distance", driver.getEncoderDistance());

	}

	public void smartDashboardInit() {
		SmartDashboard.putNumber("Max Speed", 0.7);
		SmartDashboard.putNumber("Gyro Value", 0);
		SmartDashboard.putNumber("Encoder Count", 0);
		SmartDashboard.putNumber("Encoder Rate", 0);
		SmartDashboard.putNumber("Encoder Distance", 0);
		SmartDashboard.putData("Encoder PID", driver.encoderController);
		SmartDashboard.putData("Gyro PID", driver.gyroController);
		SmartDashboard.putNumber("Encoder Setpoint", 0);
		SmartDashboard.putNumber("GYRO Setpoint", 0);	
		SmartDashboard.putNumber("Left Side Switch Or Scale", 0); //1 - scale, -1 switch
	}
}
