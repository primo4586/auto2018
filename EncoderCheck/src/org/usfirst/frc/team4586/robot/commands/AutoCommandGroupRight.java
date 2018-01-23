package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommandGroupRight extends CommandGroup {

	public AutoCommandGroupRight() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.charAt(0) == 'R' && gameData.charAt(1) != 'R') {
			addSequential(new AutoDrive(450));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(-90));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoDrive(175));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			// Remember: add elevator
		}
		else if (gameData.charAt(0) != 'R' && gameData.charAt(1) == 'R')
		{
			addSequential(new AutoDrive(820));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(-90));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoDrive(76));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			// Remember: add elevator
		}
		else
		{
			if (SmartDashboard.getNumber("Left Side Switch Or Scale",0) == 1)
			{
				addSequential(new AutoDrive(420));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoTurn(-90));
				System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoDrive(170));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				// Remember: add elevator
			}
			else
			{
				addSequential(new AutoDrive(820));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoTurn(-90));
				System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoDrive(76));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				// Remember: add elevator

			}
		}
	}
}
