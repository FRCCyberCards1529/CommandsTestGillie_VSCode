package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
        public PWMVictorSPX ElevatorMotor = new PWMVictorSPX(1);
        public DigitalInput topLimit = new DigitalInput(1);
        public DigitalInput bottomLimit = new DigitalInput(2);
        boolean isBottomLimitPressed = bottomLimit.get();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void gotoBottomPos(){
        while (isBottomLimitPressed == false) {
            ElevatorMotor.set(-1.0);    
        }
            return;
            //ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }

    public void gotoTopPos(){
        while (topLimit.get()) {
            ElevatorMotor.set(1.0);    
        }
            ElevatorMotor.set(0.0);
            return;
            //ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }
    
    public void Stop(){
    	ElevatorMotor.set(0);
    }
}

