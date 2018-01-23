package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommandGroupMiddle extends CommandGroup {

	public AutoCommandGroupMiddle() {
		boolean FMSSimScale = true;
		boolean FMSSimSwitch = true;
		if (FMSSimSwitch && !FMSSimScale) {
			addSequential(new AutoDrive(95));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoTurn(-48));
			addSequential(new AutoDrive(240));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoTurn(47));
			addSequential(new AutoDrive(100));
			// Remember: add elevator
		}
		else
		{
			addSequential(new AutoDrive(95));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoTurn(48));
			addSequential(new AutoDrive(240));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoTurn(-47));
			addSequential(new AutoDrive(100));
			// Remember: add elevator
		}
	}
}
