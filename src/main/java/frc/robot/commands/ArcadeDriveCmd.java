package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrain;
import java.util.function.Supplier;

public class ArcadeDriveCmd extends CommandBase {

    private final DriveTrain driveSubsystem;
    private final Supplier<Double> speedFunction, turnFunction;
    public static boolean isSlow = false;

    /* This command does this (fill in)... */
    public ArcadeDriveCmd(DriveTrain driveSubsystem, //
            Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("ArcadeDriveCmd started!");
        isSlow = true;
    }

    @Override
    public void execute() {
        double realTimeSpeed;
        double realTimeTurn;

        // // have deadband to prevent joystick drifting
        // if (Math.abs(speedFunction.get()) <= XboxConstants.FORWARD_DEADBAND) {
        //     realTimeSpeed = 0;
        // } 
        // else {
        //     realTimeSpeed = speedFunction.get() * JoystickConstants.FORWARD_JOYSTICK_INVERT;
        // }

        // // have deadband to prevent joystick drifting
        // if (Math.abs(turnFunction.get()) <= XboxConstants.TURN_DEADBAND) {
        //     realTimeTurn = 0;
        // } 
        // else {
        //     realTimeTurn = turnFunction.get() * JoystickConstants.TURN_JOYSTICK_INVERT;
        // }


        // double a = RobotContainer.a_value.getDouble(0.0);

        // // altering driving joystick sensitivity
        // realTimeSpeed = ((1 - a) * realTimeSpeed) + (a * Math.pow(realTimeSpeed, 3));

        realTimeSpeed = speedFunction.get();
        realTimeTurn = turnFunction.get();

        double left = realTimeSpeed + realTimeTurn;
        double right = realTimeSpeed - realTimeTurn;
        if (isSlow)
        {        
            this.driveSubsystem.setMotors(left * DriveConstants.SLOW_SPEED_FRACTION, right * DriveConstants.SLOW_SPEED_FRACTION);
        }
        else
        {
            this.driveSubsystem.setMotors(left, right);
        }
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("ArcadeDriveCmd ended!");
        isSlow = false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
