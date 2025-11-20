package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Flywheel extends SubsystemBase {
    private final MotorEx flywheel1;
    private final MotorEx flywheel2;
    public Flywheel(HardwareMap hmap, String fw1, String fw2) {
        flywheel1 = new MotorEx(hmap, fw1);
        flywheel2 = new MotorEx(hmap, fw2);
    }

    public void setFlywheelPower(double power1, double power2) {
        flywheel1.set(power1);
        flywheel2.set(power2);
    }
}
