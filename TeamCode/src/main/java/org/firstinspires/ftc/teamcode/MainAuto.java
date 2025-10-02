package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name = "Main Auto", group = "Auto")
public class MainAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the drive system
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        
        // Wait for start
        waitForStart();

        if (isStopRequested()) return;

        // Execute trajectory actions
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(0, 0, 0))
                        .strafeTo(new Vector2d(0, 48))// Move forward 48 inches along the Y-axis
                        // Strafe to new position
                        // Move to a specific X, Y position
                        .turn(Math.toRadians(90)) // Turn 90 degrees
                        .build());
    }
}