package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private MotorEx intake;
    public Intake(HardwareMap hmap, String intakeName) {
        intake = new MotorEx(hmap, intakeName);
    }

    public void setIntake(double power) {
        intake.set(power);
    }
}
