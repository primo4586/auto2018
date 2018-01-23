package org.usfirst.frc.team4586.robot.commands;

import java.sql.Driver;

import org.usfirst.frc.team4586.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommandGroupLeft extends CommandGroup {
	public AutoCommandGroupLeft() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.charAt(0) == 'L' && gameData.charAt(1) != 'L') {
			addSequential(new AutoDrive(300));
			addSequential(new AutoTurn(88));
			addSequential(new AutoDrive(88));
			// Remember: add elevator
		}
		else if (gameData.charAt(0) != 'L' && gameData.charAt(1) == 'L')
		{
			addSequential(new AutoDrive(820));
			addSequential(new AutoTurn(90));
			addSequential(new AutoDrive(76));
			// Remember: add elevator
		}
		else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
		{
			addSequential(new AutoDrive(300));
		}
		else
		{
			if (SmartDashboard.getNumber("Left Side Switch Or Scale",0) == 1)
			{
				System.out.println("Loy");
				/*addSequential(new AutoDrive(420));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoTurn(90));
				System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoDrive(175));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				// Remember: add elevator */
			}
			else
			{
				System.out.println("Loy");
				/*
				addSequential(new AutoDrive(820));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoTurn(90));
				System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
				addSequential(new AutoDrive(76));
				System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
						+ SmartDashboard.getNumber("Gyro Value",0));
				// Remember: add elevator */

			}
		}
	}
}
