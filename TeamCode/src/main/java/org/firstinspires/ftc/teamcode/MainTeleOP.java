package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Omni-Directional Drive", group = "TeleOp")
public class MainTeleOP extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the motors
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Get joystick values
            double y = -gamepad1.left_stick_y; // Forward/backward
            double x = gamepad1.left_stick_x;  // Strafing
            double rotation = gamepad1.right_stick_x; // Rotation

            // Calculate motor powers
            double leftFrontPower = y + x + rotation;
            double leftBackPower = y - x + rotation;
            double rightBackPower = y + x - rotation;
            double rightFrontPower = y - x - rotation;

            // Normalize motor powers to keep them within [-1, 1]
            double maxPower = Math.max(1.0, Math.abs(leftFrontPower));
            maxPower = Math.max(maxPower, Math.abs(rightFrontPower));
            maxPower = Math.max(maxPower, Math.abs(leftBackPower));
            maxPower = Math.max(maxPower, Math.abs(rightBackPower));

            leftFrontPower /= maxPower;
            rightFrontPower /= maxPower;
            leftBackPower /= maxPower;
            rightBackPower /= maxPower;

            // Set motor powers
            leftFront.setPower(leftFrontPower);
            rightFront.setPower(rightFrontPower);
            leftBack.setPower(leftBackPower);
            rightBack.setPower(rightBackPower);

            // Telemetry for debugging
            telemetry.addData("LF Power", leftFrontPower);
            telemetry.addData("RF Power", rightFrontPower);
            telemetry.addData("LB Power", leftBackPower);
            telemetry.addData("RB Power", rightBackPower);
            telemetry.update();
        }
    }
}