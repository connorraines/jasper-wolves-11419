package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Main Auto", group = "Auto")
public class MainAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the motor
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Servo mainServo = hardwareMap.get(Servo.class, "mainServo");

        // Initialize the servo
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // Set motor power to 50%
        leftFront.setPower(1);

        mainServo.setPosition(1);
        sleep(1000);

        // Move the servo to position 0.5
        mainServo.setPosition(0.5);

        // Let the motor run for 10 seconds
        sleep(10000);

        mainServo.setPosition(0);

        // Stop the motor
        leftFront.setPower(0);

        // Move the servo back to position 0
        mainServo.setPosition(0);

        telemetry.addData("Status", "Motor and Servo Test Complete");
        telemetry.update();
    }
}