package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveMap extends Command {
	private Driver driver;
	private double setPoint;
	
    public AutoDriveMap(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	driver = Robot.driver;
    	this.setPoint = setPoint;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driver.resetEncoder();
    	driver.resetGyro();
    	//setPoint = SmartDashboard.getNumber("Encoder Setpoint",0);
    	setTimeout(1.5);
    	driver.setEncoderControllerSetPoint(setPoint);
    	driver.encoderController.enable();
    	driver.setGyroControllerSetPoint(0);
    	driver.gyroController.enable();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		//System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
				//+ SmartDashboard.getNumber("Gyro Value",0));
		driver.gyroController.setPID(0.08, 0, 0.295);
        driver.arcadeDrive(-driver.getPIDRotationInPlace(), map(this.setPoint - driver.getEncoderDistance(), 0, this.setPoint, 0, 0.8));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || driver.encoderController.onTarget(); //&& driver.getBLSpeed() == 0 && driver.getBRSpeed() == 0;
	}

    // Called once after isFinished returns true
    protected void end() {
    	driver.gyroController.disable();
    	driver.encoderController.disable();
    	driver.setLeft(0);
    	driver.setRight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driver.gyroController.disable();
    	driver.encoderController.disable();
    	driver.setLeft(0);
    	driver.setRight(0);
    }
    
    protected double map(double toMap, double disMin, double disMax, double speedMin, double speedMax)
    {
    	if(toMap > disMax)
    		return speedMax;
    	return speedMin + toMap*(speedMax - speedMin)/(disMax - disMin);
    }
}
