package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.tools.javac.Main;

@Autonomous(name = "Red Back Auto", group = "Auto")
public class RedBackAuto extends LinearOpMode {
    //add MainAuto's methods

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;
    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors and servos
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");


        // Set zero power behavior
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        MainAuto.strafeTo(-12,38,0.5, -60,12, leftFront, leftBack, rightFront, rightBack);
        MainAuto.loadBall(leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(1.6,0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.strafeTo(-30,10,0.5, -12, 38, leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(-2.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.launchBall();
    }


}
@Autonomous(name = "Blue Back Auto", group = "Auto")
public class BlueBackAuto extends LinearOpMode {
    //add MainAuto's methods

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors and servos
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");


        // Set zero power behavior
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        MainAuto.strafeTo(-12, -38, 0.5, -60, -12, leftFront, leftBack, rightFront, rightBack);
        MainAuto.loadBall(leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(-1.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.strafeTo(-30, -10, 0.5, -12, -38, leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(2.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.launchBall();
    }
}
@Autonomous(name = "Red Front Auto", group = "Auto")
public class RedFrontAuto extends LinearOpMode {
    //add MainAuto's methods

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors and servos
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");


        // Set zero power behavior
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        MainAuto.strafeTo(-12, 38, 0.5, 50, 12, leftFront, leftBack, rightFront, rightBack);
        MainAuto.loadBall(leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(1.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.strafeTo(-30, 10, 0.5, -12, 38, leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(-2.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.launchBall();
    }
}
@Autonomous(name = "Blue Front Auto", group = "Auto")
public class BlueFrontAuto extends LinearOpMode {
    //add MainAuto's methods

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors and servos
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");


        // Set zero power behavior
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        MainAuto.strafeTo(-12, -38, 0.5, 50, -12, leftFront, leftBack, rightFront, rightBack);
        MainAuto.loadBall(leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(-1.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.strafeTo(-30, -10, 0.5, -12, -38, leftFront, leftBack, rightFront, rightBack);
        MainAuto.turn(2.6, 0.5, leftFront, leftBack, rightFront, rightBack);
        MainAuto.launchBall();
    }
}
@Autonomous(name = "LM1 Auto")
class LM1Auto extends LinearOpMode {
    //add MainAuto's methods

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors and servos
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        // Set zero power behavior
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //move forward 24 inches without using strafe to
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        leftFront.setPower(1);
        leftBack.setPower(1);
        rightFront.setPower(1);
        rightBack.setPower(1);
        sleep(1000); // Adjust time to move approximately 24 inches
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);

    }

}
public class MainAuto {
    public static void turn(double targetAngle, double power, DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack) {
        // Initialize odometry encoders
        DcMotor leftEncoder = hardwareMap.get(DcMotor.class, "leftEncoder");
        DcMotor rightEncoder = hardwareMap.get(DcMotor.class, "rightEncoder");

        // Reset encoders
        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define constants
        final double COUNTS_PER_RADIAN = 500; // Adjust based on your robot's encoder counts per radian
        double currentAngle = 0;

        // Loop until the robot reaches the target angle
        while (Math.abs(targetAngle - currentAngle) > 0.05) { // Allowable error margin
            // Calculate current angle using odometry
            double leftPosition = leftEncoder.getCurrentPosition();
            double rightPosition = rightEncoder.getCurrentPosition();

            // Update current angle
            currentAngle = (rightPosition - leftPosition) / COUNTS_PER_RADIAN;

            // Determine turn direction
            double turnPower = (targetAngle - currentAngle) > 0 ? power : -power;

            // Set motor powers for turning
            leftFront.setPower(-turnPower);
            leftBack.setPower(-turnPower);
            rightFront.setPower(turnPower);
            rightBack.setPower(turnPower);

            // Telemetry for debugging
        }

        // Stop motors
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
    }
    public static void launchBall() {
        // Code to launch a ball
        DcMotor spinA = hardwareMap.get(DcMotor.class, "spinA");
        spinA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        DcMotor spinB = hardwareMap.get(DcMotor.class, "spinB");
        spinB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spinA.setPower(1.0);
        spinB.setPower(-1.0);
        sleep(1000);
        spinA.setPower(0);
        spinB.setPower(0);
    }
    public static void loadBall(DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack){
        DcMotor entrance = hardwareMap.get(DcMotor.class, "entrance");
        entrance.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        entrance.setPower(1.0);
        //move forward
        leftBack.setPower(1);
        leftFront.setPower(1);
        rightBack.setPower(1);
        rightFront.setPower(1);
        sleep(1000); // Loading time
        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
        entrance.setPower(0);
    }
    public static void strafeTo(double targetX, double targetY, double power, double currentX, double currentY, DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack) {
        // Initialize odometry encoders
        DcMotor leftEncoder = hardwareMap.get(DcMotor.class, "leftEncoder");
        DcMotor rightEncoder = hardwareMap.get(DcMotor.class, "rightEncoder");
        DcMotor horizontalEncoder = hardwareMap.get(DcMotor.class, "horizontalEncoder");

        // Reset encoders
        leftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        horizontalEncoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define constants
        final double COUNTS_PER_INCH = 307.699557; // Adjust based on your robot's encoder counts per inch

        // Loop until the robot reaches the target position
        while ((Math.abs(targetX - currentX) > 1 || Math.abs(targetY - currentY) > 1)) {
            // Calculate current position using odometry
            double leftPosition = leftEncoder.getCurrentPosition() / COUNTS_PER_INCH;
            double rightPosition = rightEncoder.getCurrentPosition() / COUNTS_PER_INCH;
            double horizontalPosition = horizontalEncoder.getCurrentPosition() / COUNTS_PER_INCH;

            // Update current X and Y positions
            currentX = (leftPosition + rightPosition) / 2.0;
            currentY = horizontalPosition;

            // Calculate errors
            double xError = targetX - currentX;
            double yError = targetY - currentY;

            // Calculate motor powers
            double frontLeftPower = yError + xError;
            double frontRightPower = yError - xError;
            double backLeftPower = yError - xError;
            double backRightPower = yError + xError;

            // Normalize motor powers
            double max = Math.max(Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower)),
                    Math.max(Math.abs(backLeftPower), Math.abs(backRightPower)));
            if (max > 1.0) {
                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }

            // Set motor powers
            leftFront.setPower(frontLeftPower * power);
            rightFront.setPower(frontRightPower * power);
            leftBack.setPower(backLeftPower * power);
            rightBack.setPower(backRightPower * power);


        }

        // Stop motors

    }
}