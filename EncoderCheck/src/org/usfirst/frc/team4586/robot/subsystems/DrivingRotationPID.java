package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 *
 */
public class DrivingRotationPID implements PIDOutput {
	private double rotation;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DrivingRotationPID() {
		rotation = 0;
		//this.driver = Robot.driver; 
	}

	public double getRotation() {
		return rotation;
	}

	public void updateRotation(double rotation) {
		this.rotation = rotation;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		rotation = output;
	}
}

