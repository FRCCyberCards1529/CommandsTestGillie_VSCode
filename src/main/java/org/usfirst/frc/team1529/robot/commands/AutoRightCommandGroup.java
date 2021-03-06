package org.usfirst.frc.team1529.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightCommandGroup extends CommandGroup {

    public AutoRightCommandGroup(String switchMode) {
    	addSequential(new ChangeNeturalMode(NeutralMode.Brake));
    	addSequential(new AutoPneumaticsCommand(true));
		switch (switchMode){
			case "LEFT":
				addSequential(new GyroStraight(0, .75,147 ,2));
				
				break;
			case "RIGHT":
				addSequential(new GyroStraight(0,.75,148,1.6));
				addSequential(new ArmRaiseCommand(1, 7, 3));
				addSequential(new AutoTurnCommand(-85, "left"));
				addSequential(new AutoDriveCommand(.5,10, 2));
				addSequential(new IntakeCommand(.5, 1));
				break;
			default:
				addSequential(new GyroStraight(0, .75,147 ,2));
//				addSequential(new AutoTurnCommand(-60, "left"));
//				addSequential(new AutoTurnCommand(90, "right"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
//				addSequential(new IntakeCommand(.5, 1));
				break;
			
		}
		
    	}
    }

