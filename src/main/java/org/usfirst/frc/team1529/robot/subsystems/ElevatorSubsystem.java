package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
        public WPI_VictorSPX ElevatorMotor = new WPI_VictorSPX(RobotMap.ElevatorMotorPort);
        topLimit = new DigitalInput(1);
        bottomLimit = new DigitalInput(2);
        boolean isBottomLimitPressed = bottomLimit.get();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void gotoBottomPos(){
        while (isBottomLimitPressed == false) {
            ElevatorMotor.set(ControlMode.PercentOutput, -1.0);    
        }
            return;
            //ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }

    public void gotoTopPos(){
        while (topLimit.get() = false {
            ElevatorMotor.set(ControlMode.PercentOutput, 1.0);    
        }
            ElevatorMotor.set(ControlMode.PercentOutput, 0);
            return;
            //ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }
    
    public void Stop(){
    	Climb.set(ControlMode.PercentOutput, 0);
    }
}

