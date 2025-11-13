package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.JavaUtil;

@TeleOp(name = "Omni-Directional Drive", group = "TeleOp")
public class NotRealTeleOP extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the motors
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DcMotor spinA = hardwareMap.get(DcMotor.class, "spinA");
        spinA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        DcMotor spinB = hardwareMap.get(DcMotor.class, "spinB");
        spinB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            // Map joystick inputs to robot movement
            double axial = -gamepad1.left_stick_y;
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x;

            // Dead zone to prevent unintended movement
            double deadZone = 0.05;
            if (Math.abs(axial) < deadZone) axial = 0;
            if (Math.abs(lateral) < deadZone) lateral = 0;
            if (Math.abs(yaw) < deadZone) yaw = 0;

            // Combine the joystick requests for each axis-motion to determine each wheel's power
            double frontLeftPower = axial + lateral + yaw;
            double frontRightPower = (axial - lateral) - yaw;
            double backLeftPower = (axial - lateral) + yaw;
            double backRightPower = (axial + lateral) - yaw;

            // Normalize the values so no wheel power exceeds 100%
            double max = JavaUtil.maxOfList(JavaUtil.createListWith(Math.abs(frontLeftPower), Math.abs(frontRightPower), Math.abs(backLeftPower), Math.abs(backRightPower)));
            if (max > 1) {
                frontLeftPower = frontLeftPower / max;
                frontRightPower = frontRightPower / max;
                backLeftPower = backLeftPower / max;
                backRightPower = backRightPower / max;
            }

            // Send calculated power to wheels
            leftFront.setPower(frontLeftPower);
            rightFront.setPower(frontRightPower);
            leftBack.setPower(backLeftPower);
            rightBack.setPower(backRightPower);

            // Show the elapsed game time and wheel power
            telemetry.addData("Status", "Run Time: ");
            telemetry.addData("Front left/Right", JavaUtil.formatNumber(frontLeftPower, 4, 2) + ", " + JavaUtil.formatNumber(frontRightPower, 4, 2));
            telemetry.addData("Back  left/Right", JavaUtil.formatNumber(backLeftPower, 4, 2) + ", " + JavaUtil.formatNumber(backRightPower, 4, 2));
            telemetry.update();

            if (gamepad1.x) {
                spinA.setPower(1); // Turn the motor on
                spinB.setPower(-1);
            } else {
                spinA.setPower(0); // Turn the motor off
                spinB.setPower(0);
            }
        }
    }
}