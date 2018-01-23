package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommandGroupMiddle extends CommandGroup {

	public AutoCommandGroupMiddle() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.charAt(0) == 'L') {
			addSequential(new AutoDrive(95));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(-48));
			addSequential(new AutoDrive(240));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(47));
			addSequential(new AutoDrive(100));
			// Remember: add elevator
		}
		else
		{
			addSequential(new AutoDrive(95));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			System.out.println("Turned: " + SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(48));
			addSequential(new AutoDrive(240));
			System.out.println("Drive: " + SmartDashboard.getNumber("Encoder Distance",0) + ", Stiya: "
					+ SmartDashboard.getNumber("Gyro Value",0));
			addSequential(new AutoTurn(-47));
			addSequential(new AutoDrive(100));
			// Remember: add elevator
		}
	}
}
