
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class Shifter extends SubsystemBase {

	private DoubleSolenoid shifter;

	/* Subsystem for controlling the shifter. */
	public Shifter() {
		/**
		 * Assigns Solenoids to correct PCM address and port
		 */
		System.out.println("Shifter subsystem starting");	
		shifter = new DoubleSolenoid(DriveConstants.PCM_ADDRESS, PneumaticsModuleType.CTREPCM, DriveConstants.SHIFT_HIGH_SPEED_SOLENOID_PCM_PORT, 
																							   DriveConstants.SHIFT_HIGH_TORQUE_SOLENOID_PCM_PORT);

	}

	/**
	 * Method accepts a value of a boolean, the Solenoid object is then set to that value
	 * @param setShifter
	 */
	public void setShifterHighSpeed() {
		shifter.set(Value.kReverse);

		DriveTrain.leftEncoder.setPositionConversionFactor(Constants.DriveConstants.HIGH_SPEED_REVOLUTION_TO_INCH_CONVERSION);
        DriveTrain.rightEncoder.setPositionConversionFactor(Constants.DriveConstants.HIGH_SPEED_REVOLUTION_TO_INCH_CONVERSION);
	}
	
	public void setShifterHighTorque() {
		shifter.set(Value.kForward);

		DriveTrain.leftEncoder.setPositionConversionFactor(Constants.DriveConstants.HIGH_TORQUE_REVOLUTION_TO_INCH_CONVERSION);
        DriveTrain.rightEncoder.setPositionConversionFactor(Constants.DriveConstants.HIGH_TORQUE_REVOLUTION_TO_INCH_CONVERSION);
	}

	/**
	 * Gets value of Solenoid for testing purposes
	 * @return
	 */
	public boolean isHighSpeed() {
		return shifter.get() == Value.kForward;
	}
} 
