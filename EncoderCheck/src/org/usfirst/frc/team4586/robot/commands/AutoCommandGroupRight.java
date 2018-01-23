package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommandGroupRight extends CommandGroup {

	public AutoCommandGroupRight() {
		boolean FMSSimScale = false;
		boolean FMSSimSwitch = true;
		if (FMSSimSwitch && !FMSSimScale) {
			addSequential(new AutoDrive(450));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoTurn(-90));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoDrive(175));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			// Remember: add elevator
		}
		else if (FMSSimScale && !FMSSimSwitch)
		{
			addSequential(new AutoDrive(820));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoTurn(-90));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value"));
			addSequential(new AutoDrive(76));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value"));
			// Remember: add elevator
		}
		else
		{
			if (SmartDashboard.getNumber("Left Side Switch Or Scale") == 1)
			{
				addSequential(new AutoDrive(420));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value"));
				addSequential(new AutoTurn(-90));
				System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value"));
				addSequential(new AutoDrive(170));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value"));
				// Remember: add elevator
			}
			else
			{
				addSequential(new AutoDrive(820));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value"));
				addSequential(new AutoTurn(-90));
				System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value"));
				addSequential(new AutoDrive(76));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance") + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value"));
				// Remember: add elevator

			}
		}
	}
}
