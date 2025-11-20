package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {
    private final MotorEx intake;
    public Intake(HardwareMap hmap, String intakeName) {
        intake = new MotorEx(hmap, intakeName);
    }

    public void setIntake(double power) {
        intake.set(power);
    }
}
