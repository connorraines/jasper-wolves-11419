package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.JavaUtil;

@TeleOp(name = "TeleOP")
public class TeleOP extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    double frontLeftPower;
    double backLeftPower;
    double frontRightPower;
    double backRightPower;

    /**
     * This OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
     * This code will work with either a Mecanum-Drive or an X-Drive train.
     * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
     *
     * Also note that it is critical to set the correct rotation direction for each motor. See details below.
     *
     * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
     * Each motion axis is controlled by one Joystick axis.
     *
     * 1) Axial -- Driving forward and backward -- Left-joystick Forward/Backward
     * 2) Lateral -- Strafing right and left -- Left-joystick Right and Left
     * 3) Yaw -- Rotating Clockwise and counter clockwise -- Right-joystick Right and Left
     *
     * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
     * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
     * the direction of all 4 motors (see code below).
     */
    @Override
    public void runOpMode() {
        ElapsedTime runtime;
        float axial;
        float lateral;
        float yaw;
        double max;

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        DcMotor spinA = hardwareMap.get(DcMotor.class, "spinA");
        spinA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        DcMotor spinB = hardwareMap.get(DcMotor.class, "spinB");
        spinB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        DcMotor entrance = hardwareMap.get(DcMotor.class, "entrance");
        entrance.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        CRServo intakeServo1 = hardwareMap.get(CRServo.class, "intakeServo1");
        CRServo intakeServo2 = hardwareMap.get(CRServo.class, "intakeServo2");
        CRServo outtakeServo1 = hardwareMap.get(CRServo.class, "outtakeServo1");
        CRServo outtakeServo2 = hardwareMap.get(CRServo.class, "outtakeServo2");


        runtime = new ElapsedTime();
        // ########################################################################################
        // !!! IMPORTANT Drive Information. Test your motor directions. !!!!!
        // ########################################################################################
        //
        // Most robots need the motors on one side to be reversed to drive forward.
        // The motor reversals shown here are for a "direct drive" robot
        // (the wheels turn the same direction as the motor shaft).
        //
        // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
        // that your motors are turning in the correct direction. So, start out with the reversals here, BUT
        // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
        //
        // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward.
        // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.
        // <--- Click blue icon to see important note re. testing motor directions.
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        spinA.setDirection(DcMotor.Direction.FORWARD);
        spinB.setDirection(DcMotor.Direction.REVERSE);
        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();
        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            spinA.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            spinB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            entrance.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            // Note: pushing stick forward gives negative value
            axial = -gamepad1.left_stick_y;
            lateral = gamepad1.left_stick_x;
            yaw = gamepad1.right_stick_x;
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            frontLeftPower = axial + lateral + yaw;
            frontRightPower = (axial - lateral) - yaw;
            backLeftPower = (axial - lateral) + yaw;
            backRightPower = (axial + lateral) - yaw;
            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = JavaUtil.maxOfList(JavaUtil.createListWith(Math.abs(frontLeftPower), Math.abs(frontRightPower), Math.abs(backLeftPower), Math.abs(backRightPower)));
            if (max > 1) {
                frontLeftPower = frontLeftPower / max;
                frontRightPower = frontRightPower / max;
                backLeftPower = backLeftPower / max;
                backRightPower = backRightPower / max;
            }
            // Send calculated power to wheels.
            leftFront.setPower(frontLeftPower);
            rightFront.setPower(frontRightPower);
            leftBack.setPower(backLeftPower);
            rightBack.setPower(backRightPower);
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.addData("Front left/Right", JavaUtil.formatNumber(frontLeftPower, 4, 2) + ", " + JavaUtil.formatNumber(frontRightPower, 4, 2));
            telemetry.addData("Back  left/Right", JavaUtil.formatNumber(backLeftPower, 4, 2) + ", " + JavaUtil.formatNumber(backRightPower, 4, 2));
            telemetry.update();
            if (gamepad1.left_bumper){
                entrance.setPower(1); // Turn the motor on
            } else {
                entrance.setPower(0); // Turn the motor off
            }
            if (gamepad1.left_trigger > 0.5) {
                spinA.setPower(1); // Turn the motor on
                spinB.setPower(-1);
           } else {
                spinA.setPower(0); // Turn the motor off
                spinB.setPower(0);
            }
            if (gamepad1.right_bumper){
                //make intake speed servos spin
                intakeServo1.setPower(1);
                intakeServo2.setPower(-1);
            } else {
                intakeServo1.setPower(0);
                intakeServo2.setPower(0);

            }
            if (gamepad1.right_trigger > 0.5){
                //make outtake speed servos spin
                outtakeServo1.setPower(-1);
                outtakeServo2.setPower(1);
            } else {
                outtakeServo1.setPower(0);
                outtakeServo2.setPower(0);
            }
        }

    }

}
