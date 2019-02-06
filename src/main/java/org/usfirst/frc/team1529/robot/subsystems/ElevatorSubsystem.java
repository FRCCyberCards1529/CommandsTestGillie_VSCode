package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.hal.DIOJNI;
/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
        // DigitalInput topLimit;
        // DigitalInput bottomLimit;
        // DigitalInput MidProxy;
        DigitalInput topLimit = new DigitalInput(1);
        DigitalInput bottomLimit = new DigitalInput(2);
        DigitalInput MidProxy = new DigitalInput(3);

        public TalonSRX ElevatorMotor = new TalonSRX(3);

       // boolean isBottomLimitPressed = bottomLimit.get();

    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //     //setDefaultCommand(new MySpecialCommand());
     }

    public void gotoBottomPos(double speed){
        while (!bottomLimit.get()) {
            ElevatorMotor.set(ControlMode.PercentOutput,-speed);    
        }
            return;
            //ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }

    public void gotoTopPos(double speed){
        while (!topLimit.get()) {
            ElevatorMotor.set(ControlMode.PercentOutput,speed);    
        }
            ElevatorMotor.set(ControlMode.PercentOutput,0.0);
            return;
            //ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }
    public void gotoMidPos(double speed){
        while (!MidProxy.get()){
            if (!topLimit.get())
            {
                ElevatorMotor.set(ControlMode.PercentOutput,speed);
            }
           else
           {
                ElevatorMotor.set(ControlMode.PercentOutput,-speed);
           }
            ElevatorMotor.set(ControlMode.PercentOutput,0.0);
            return;

        }
    }
    
    public void Stop(){
    	ElevatorMotor.set(ControlMode.PercentOutput,0);
    }
}