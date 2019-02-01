package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command; 
/**
 *
 */
public class AutoEncTurnCommand extends Command {
	
	private boolean isFinished;
	private double leftTurnAngle;
	private double rightTurnAngle;
	private String direction;
	private double speed = .25;
	
    public AutoEncTurnCommand(double Rangle, double Langle, String D) {
    	
    	//90 degree turn - Alt -        enc - 
    	
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.kDriveTrainSubsystem);
    	leftTurnAngle = Langle;
    	rightTurnAngle = Rangle;
    	direction = D;
    	isFinished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.kDriveTrainSubsystem.gyro.reset();
    Robot.kDriveTrainSubsystem.enc.reset();
    Robot.kDriveTrainSubsystem.altEnc.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kDriveTrainSubsystem.altEnc.getDistance();
    	Robot.kDriveTrainSubsystem.enc.getDistance();
    	
    	if(direction.equals("right")){
    		Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput,speed);
    		Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, speed);
    		
    		Robot.kDriveTrainSubsystem.FrontRight.set( speed);
    		Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, speed);
    		if (Robot.kDriveTrainSubsystem.enc.getDistance() > leftTurnAngle && Robot.kDriveTrainSubsystem.altEnc.getDistance() < rightTurnAngle){
    			isFinished = true;
    		}
    	}
    	else if (direction.equals("left")){
    		Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput,-speed);
    		Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, -speed);
    		
    		Robot.kDriveTrainSubsystem.FrontRight.set(-speed);
    		Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, -speed);
    		if (Robot.kDriveTrainSubsystem.enc.getDistance() < leftTurnAngle && Robot.kDriveTrainSubsystem.altEnc.getDistance() > rightTurnAngle){
    			isFinished = true;
    		}
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveTrainSubsystem.stop();
    	Timer.delay(0.5);
		Robot.kDriveTrainSubsystem.gyro.reset();
		Robot.kDriveTrainSubsystem.enc.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("INTERRUPTED AUTOTURN");
    }
}
