package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "TeleOP - Food Truck", group = "TeleOp")
public class FoodTruckTeleOP extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        // Initialize motors
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        DcMotor spinA = hardwareMap.get(DcMotor.class, "spinA");
        DcMotor spinB = hardwareMap.get(DcMotor.class, "spinB");
        DcMotor entrance = hardwareMap.get(DcMotor.class, "entrance");

        // Set motor directions
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);

        spinA.setDirection(DcMotor.Direction.FORWARD);
        spinB.setDirection(DcMotor.Direction.REVERSE);

        // Set zero power behavior
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            // Tank drive control
            double leftPower = -gamepad1.left_stick_y;  // Left joystick controls left motors
            double rightPower = -gamepad1.right_stick_y; // Right joystick controls right motors

            // Set motor powers
            leftFront.setPower(leftPower);
            leftBack.setPower(leftPower);
            rightFront.setPower(rightPower);
            rightBack.setPower(rightPower);

            // Control for spin motors
            if (gamepad1.left_trigger > 0.5) {
                spinA.setPower(1); // Turn the motor on
                spinB.setPower(-1);
            } else {
                spinA.setPower(0); // Turn the motor off
                spinB.setPower(0);
            }

            // Control for entrance motor
            if (gamepad1.left_bumper) {
                entrance.setPower(1); // Turn the motor on
            } else {
                entrance.setPower(0); // Turn the motor off
            }

            // Telemetry for debugging
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Left Power", leftPower);
            telemetry.addData("Right Power", rightPower);
            telemetry.update();
        }
    }
}