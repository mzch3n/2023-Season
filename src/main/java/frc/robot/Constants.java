package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
    public static final class DriveConstants {
        // motor ids
        public static final int RIGHT_FRONT_DRIVE_CAN_ID = 3;
        public static final int RIGHT_MIDDLE_DRIVE_CAN_ID = 4;
        public static final int RIGHT_BACK_DRIVE_CAN_ID = 5;
        public static final int LEFT_FRONT_DRIVE_CAN_ID = 6;
        public static final int LEFT_MIDDLE_DRIVE_CAN_ID = 7;
        public static final int LEFT_BACK_DRIVE_CAN_ID = 8;

        //solenoids
        public static final int SHIFT_HIGH_SPEED_SOLENOID_PCM_PORT = 2;
	    public static final int SHIFT_HIGH_TORQUE_SOLENOID_PCM_PORT = 3;
        public static final int PCM_ADDRESS = 0;
        public static final boolean IS_HIGH_SPEED = true;

        // encoder 
       public static final double HIGH_TORQUE_REVOLUTION_TO_INCH_CONVERSION = 2.317175948;
       public static final double HIGH_SPEED_REVOLUTION_TO_INCH_CONVERSION = 1.048247093;

        // No turning sensitivity
        public static final double MAX_TURN_SPEED = 1;

        public static final double TURN_SENSITIVITY = 0;

        public static final double SLOW_SPEED_FRACTION = 0.3;

    }

    public static final class JoystickConstants {
        // joystick ports
        public static final int JOYSTICK_PORT = 1;

    } 

    public static final class XboxConstants {
        public static final int XBOX_PORT = 0;

        public static final int FORWARD_JOYSTICK_INVERT = 1;
        public static final int TURN_JOYSTICK_INVERT = 1;

        public static final double FORWARD_DEADBAND = 0.05;
        public static final double TURN_DEADBAND = 0.1;

        public static final double DRIVE_SLEW_RATE = 5.0;
        public static final double TURN_SLEW_RATE = 5.0;

        public static final double JOYSTICK_SENSITIVITY = 0.5;
    }
}