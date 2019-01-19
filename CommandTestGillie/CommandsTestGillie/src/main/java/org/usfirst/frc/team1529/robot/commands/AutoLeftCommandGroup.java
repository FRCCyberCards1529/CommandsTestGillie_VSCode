package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoLeftCommandGroup extends CommandGroup {

    public AutoLeftCommandGroup(String switchMode) {
     	addSequential(new ChangeNeturalMode(NeutralMode.Brake));
    	addSequential(new AutoPneumaticsCommand(true));
		switch (switchMode){
		
			case "LEFT":
				System.out.println("LEFT COMMAND GROUP");
				addSequential(new GyroStraight(0,.75,138,2));
				addSequential(new AutoTurnCommand(85, "right"));
//				addSequential(new GyroStraight(0,.75, 10, 2));
				addSequential(new ArmRaiseCommand(1, 7, 3));
				addSequential(new IntakeCommand(.5, 1));
//				
				break;
			case "RIGHT":
				addSequential(new GyroStraight(0,.75,136,2));
//				addSequential(new AutoDriveCommand(.5,185));
//				addSequential(new AutoTurnCommand(70, "right"));
//				addSequential(new AutoDriveCommand(.5,150));
//				addSequential(new AutoTurnCommand(70, "right"));
//				addSequential(new IntakeCommand(.5, 1));
				break;
			
			default:
				//addSequential(new AutoDriveCommand(.5,136));
//				addSequential(new AutoTurnCommand(60, "right"));
//				addSequential(new ArmRaiseCommand(.5,2));
				break;
			
			
		}
    }
}