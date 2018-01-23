package org.usfirst.frc.team4586.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 *
 */
public class DrivingGyroPID implements PIDSource {
	
	public AnalogGyro gyro;

	public DrivingGyroPID(AnalogGyro gyro) {
		// TODO Auto-generated constructor stub
		this.gyro = gyro;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return gyro.getAngle() % 360;
	}
}

