package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.JavaUtil;

@TeleOp(name = "DeBuild")
public class LauJausBot extends LinearOpMode {

    private DcMotor fl;
    private DcMotor bl;
    private DcMotor fr;
    private DcMotor br;
    private DcMotor indexer;
    private DcMotor intake;
    private DcMotor flywheel1;
    private DcMotor flywheel2;


    double leftFrontPower;
    double leftBackPower;
    double rightFrontPower;
    double rightBackPower;

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


        fl = hardwareMap.get(DcMotor.class, "fl");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");
        intake = hardwareMap.get(DcMotor.class, "intake");
        indexer = hardwareMap.get(DcMotor.class, "indexer");
        flywheel1 = hardwareMap.get(DcMotor.class, "fw1");
        flywheel2 = hardwareMap.get(DcMotor.class, "fw2");


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
        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        br.setDirection(DcMotor.Direction.FORWARD);
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();
        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            // Note: pushing stick forward gives negative value
            axial = gamepad1.left_stick_y;
            lateral = -gamepad1.left_stick_x;
            yaw = gamepad1.right_stick_x * 0.5f;
            // Assuming you're using right stick y-axis for forward/backward
            double rightStickY = gamepad1.right_stick_y;  // Invert y-axis input

            // Assuming you're using right stick x-axis for left/right
            double rightStickX = gamepad1.left_stick_x;  // Invert x-axis input

            // Use these adjusted values to control the motor power
            leftFrontPower = rightStickY - rightStickX;
            leftBackPower = - rightStickY + rightStickX;
            rightFrontPower = rightStickY + rightStickX;
            rightBackPower = - rightStickY - rightStickX;
            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            leftFrontPower = (axial + lateral - yaw);
            rightFrontPower = (axial - lateral + yaw);
            leftBackPower = (axial - lateral - yaw);
            rightBackPower = (axial + lateral + yaw);
            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = JavaUtil.maxOfList(JavaUtil.createListWith(Math.abs(leftFrontPower), Math.abs(rightFrontPower), Math.abs(leftBackPower), Math.abs(rightBackPower)));
            if (max > 1) {
                leftFrontPower = leftFrontPower / max;
                rightFrontPower = rightFrontPower / max;
                leftBackPower = leftBackPower / max;
                rightBackPower = rightBackPower / max;
            }
            // Send calculated power to wheels.
            fl.setPower(leftFrontPower);
            fr.setPower(rightFrontPower);
            bl.setPower(leftBackPower);
            br.setPower(rightBackPower);

            if (gamepad1.left_bumper) {
                intake.setPower(1);
            }
            else if (gamepad1.left_trigger > 0.2) {
                intake.setPower(-1);
            } else {
                intake.setPower(0);
            }

            if (gamepad1.right_trigger>0.2) {
                indexer.setPower(1);
            }
            else if (gamepad1.right_bumper) {
                indexer.setPower(-1);
            } else {
                indexer.setPower(0);
            }

            if (gamepad1.dpad_left) {
                flywheel1.setPower(0.76);
                flywheel2.setPower(-0.76);
            }
            if (gamepad1.dpad_right) {
                flywheel1.setPower(0);
                flywheel2.setPower(0);
            }



            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            // telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}

