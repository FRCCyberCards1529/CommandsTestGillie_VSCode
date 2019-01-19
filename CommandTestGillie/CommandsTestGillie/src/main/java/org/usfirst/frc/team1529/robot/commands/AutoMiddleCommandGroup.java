package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */	
public class AutoMiddleCommandGroup extends CommandGroup {
	
    public AutoMiddleCommandGroup(String switchMode) {
    	addSequential(new AutoPneumaticsCommand(true));
		switch (switchMode){
			case "LEFT":
				//Put left auto code here
				addSequential(new AutoPneumaticsCommand(true));
				
				addSequential(new AutoDriveCommand(.5, 14, 1.5));
				
				addSequential(new ArmRaiseCommand(1, 55, 3));
				
				addSequential(new AutoTurnCommand(-35,"left"));
				
				addSequential(new AutoDriveCommand(.5, 72, 4));	
								
				addSequential(new AutoTurnCommand(50,"right"));

				
				addSequential(new AutoDriveCommand(.5, 45, 2));
				
				addSequential(new IntakeCommand(.3,1));
				
				
				//addSequential(new AutoPneumaticsCommand(false));
				break;
			case "RIGHT":
				//Put right auto code here
				addSequential(new AutoPneumaticsCommand(true));
				
				addSequential(new GyroStraight(0, .5, 17, 1));
				
				addSequential(new ArmRaiseCommand(1, 55, 3));
				
				addSequential(new AutoTurnCommand(48,"right"));
				
				addSequential(new GyroStraight(0, .5, 17, 2));	
				
				addSequential(new AutoTurnCommand(-60,"left"));
				
				addSequential(new GyroStraight(0, .5, 17, 1));
				
				addSequential(new IntakeCommand(.5,1));
				
				//addSequential(new AutoPneumaticsCommand(false));
				break;
			//add arm raise
			default:
				System.out.println("PARKER");
				addSequential(new AutoDriveCommand(.5, 12));
				
				addSequential(new AutoTurnCommand(10,"right"));
				
				addSequential(new AutoDriveCommand(.5, 56, 5));
				
				//addSequential(new ArmRaiseCommand(.5,67));
				
				//addSequential(new IntakeCommand(1,1));
				
				break;
    	}
		
    }
}
