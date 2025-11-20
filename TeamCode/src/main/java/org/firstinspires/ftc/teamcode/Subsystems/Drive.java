package org.firstinspires.ftc.teamcode.Subsystems;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.JavaUtil;

public class Drive extends SubsystemBase {
    private final MotorEx fl;
    private final MotorEx fr;
    private final MotorEx bl;
    private final MotorEx br;
    public Drive(HardwareMap hmap, String flName, String frName, String blName, String brName) {
        fl = new MotorEx(hmap, flName);
        fr = new MotorEx(hmap, frName);
        bl = new MotorEx(hmap, blName);
        br = new MotorEx(hmap, brName);

        //initialization settings
        fl.setInverted(false);
        bl.setInverted(false);
        fr.setInverted(true);
        br.setInverted(true);
    }

    public void drive(double xPow, double yPow, double rotPow) {
        double axial = yPow;
        double lateral = -xPow;
        double yaw = rotPow;

        double leftFrontPower = (axial + lateral - yaw);
        double rightFrontPower = (axial - lateral + yaw);
        double leftBackPower = (axial - lateral - yaw);
        double rightBackPower = (axial + lateral + yaw);
        // Normalize the values so no wheel power exceeds 100%
        // This ensures that the robot maintains the desired motion.
        double max = JavaUtil.maxOfList(JavaUtil.createListWith(Math.abs(leftFrontPower), Math.abs(rightFrontPower), Math.abs(leftBackPower), Math.abs(rightBackPower)));
        if (max > 1) {
            leftFrontPower = leftFrontPower / max;
            rightFrontPower = rightFrontPower / max;
            leftBackPower = leftBackPower / max;
            rightBackPower = rightBackPower / max;
        }
        // Send calculated power to wheels.
        fl.set(leftFrontPower);
        fr.set(rightFrontPower);
        bl.set(leftBackPower);
        br.set(rightBackPower);
    }
}