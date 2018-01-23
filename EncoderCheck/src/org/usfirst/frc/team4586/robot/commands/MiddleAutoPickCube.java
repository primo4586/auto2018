package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MiddleAutoPickCube extends CommandGroup {

	public MiddleAutoPickCube() {
		boolean FMSSimScale = true;
		boolean FMSSimSwitch = true;
		if (FMSSimSwitch && FMSSimScale) {
			addSequential(new AutoDrive(75));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(-48));
			addSequential(new AutoDrive(200));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(47));
			addSequential(new AutoDrive(50));
			addSequential(new AutoTurn(90));
			addSequential(new AutoDrive(100));
			addSequential(new Wait(1));
			addSequential(new AutoDrive(-100));
			// Remember: add elevator
		}
	}
}
