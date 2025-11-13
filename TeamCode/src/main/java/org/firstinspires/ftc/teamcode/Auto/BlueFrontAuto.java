import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Auto.MainAuto;

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