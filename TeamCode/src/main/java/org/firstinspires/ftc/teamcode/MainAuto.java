package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Main Auto", group = "Auto")
public class MainAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors and servos
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");


        // Set zero power behavior
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        loadBall();
        launchBall();
    }
    public void launchBall() {
        // Code to launch a ball
        DcMotor spinA = hardwareMap.get(DcMotor.class, "spinA");
        spinA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        DcMotor spinB = hardwareMap.get(DcMotor.class, "spinB");
        spinB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spinA.setPower(1.0);
        spinB.setPower(-1.0);
        sleep(1000); // Spin up time
        spinA.setPower(0);
        spinB.setPower(0);
    }
    public void loadBall(){
        DcMotor entrance = hardwareMap.get(DcMotor.class, "entrance");
        entrance.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        entrance.setPower(1.0);
        sleep(1000); // Loading time
        entrance.setPower(0);
    }
}