package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Driver extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Encoder encoder; // driving encoder
	public Jaguar fRMotor; // Front Right Motor
	public Jaguar fLMotor; // Front Left Motor
	public Jaguar bRMotor; // Back Right Motor
	public Jaguar bLMotor; // Back Left Motor
	public AnalogGyro gyro; // driving gyroscope
	public RobotDrive driver;
	
	public PIDController encoderController;
	public PIDController gyroController;
	public PIDController gyroControllerRotation;
	public DrivingEncoderPID encoderSource;
	public DrivingGyroPID gyroSource;
	public DrivingSpeedPID speed;
	//public DrivingRotationPID rotation;
	public DrivingRotationPID rotation;
	
	public Driver(Jaguar _fRMotor, Jaguar _fLMotor, Jaguar _bRMotor, Jaguar _bLMotor, Encoder _encoder, AnalogGyro _gyro)
	{
		this.fRMotor = _fRMotor;
		this.fLMotor = _fLMotor;
		this.bLMotor = _bLMotor;
		this.bRMotor = _bRMotor;
		this.encoder = _encoder;
		encoder.setDistancePerPulse(0.47877872);
		this.gyro = _gyro;
		driver = new RobotDrive(fLMotor, bLMotor, fRMotor, bRMotor);
		this.driver.setInvertedMotor(MotorType.kFrontLeft, true);
		this.driver.setInvertedMotor(MotorType.kRearLeft, true);
		
		this.driver.setSafetyEnabled(false);
		
		speed = new DrivingSpeedPID();
		//rotation = new DrivingRotationPID();
		rotation = new DrivingRotationPID();
		
		encoderSource = new DrivingEncoderPID(encoder);
		gyroSource = new DrivingGyroPID(gyro);

		
		encoderController = new PIDController(0.1, 0.0, 0.395, encoderSource, speed);
		encoderController.setAbsoluteTolerance(0.7);
		
		gyroController = new PIDController(0.13, 0.005, 0.023, gyroSource, rotation); //Driving forward PID 0.13, 0.005, 0.023
		gyroController.setAbsoluteTolerance(1);
		
		
		/*
		 PID ENCODER 3 METERS - 0.01, 0, 0.04
		 PID ENCODER 2 METERS - 0.017,0.0001,0.11
		 */

	}
	
	public double getBLSpeed()
	{
		return this.bLMotor.get();
	}
	
	public double getBRSpeed()
	{
		return this.bRMotor.get();
	}
	
	public double getFLSpeed()
	{
		return this.fLMotor.get();
	}
	
	public double getfRSpeed()
	{
		return this.fRMotor.get();
	}
	
	public void setLeft(double speed)
	{
		this.bLMotor.set(speed);
		this.fLMotor.set(speed);
	}
	
	public void setRight(double speed)
	{
		this.bRMotor.set(speed);
		this.fRMotor.set(speed);
	}
	
	public void arcadeDrive(double rotation, double speed)
	{
		driver.arcadeDrive(rotation, speed);
	}
	
	public double getGyro()
	{
		return gyro.getAngle() % 360;
	}
	
	public void resetGyro()
	{
		this.gyro.reset();
	}
	
	public void calibrateGyro()
	{
		this.gyro.calibrate();
	}
	
	public int getEncoderCount()
	{
		return -encoder.get();
	}
	
	public double getEncoderRate()
	{
		return -encoder.getRate();
	}
	
	public double getEncoderDistance()
	{
		return -encoder.getDistance();
	}
	
	public void resetEncoder()
	{
		this.encoder.reset();
	}
	
	public double getPIDspeed() {
		return speed.getSpeed();
	}

	/*public double getPIDRotation() {
		return rotation.getRotation();
	}*/
	
	public double getPIDRotationInPlace() {
		return rotation.getRotation();
	}
	
	public void setEncoderControllerSetPoint(double setPoint) {
		encoderController.setSetpoint(setPoint);
	}
	
	public void setGyroControllerSetPoint(double setPoint) {
		gyroController.setSetpoint(setPoint);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

