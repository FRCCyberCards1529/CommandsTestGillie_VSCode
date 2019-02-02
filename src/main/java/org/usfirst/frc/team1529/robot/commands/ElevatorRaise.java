package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorRaise extends Command {
	private Timer ourTimer = new Timer();
	private double speed;
	//private double time;
	//private int Auto_counter = 0;

	public ElevatorRaise(double s) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.kElevatorSubsystem);
		speed = s;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		ourTimer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		
		System.out.println("Elevator Raise Executed..");
		
		Robot.kElevatorSubsystem.gotoTopPos(1.0);
	}

	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.kElevatorSubsystem.Stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
