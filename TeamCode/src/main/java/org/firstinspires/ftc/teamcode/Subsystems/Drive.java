package org.firstinspires.ftc.teamcode.Subsystems;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive extends SubsystemBase {
    private MotorEx fl;
    private MotorEx fr;
    private MotorEx bl;
    private MotorEx br;
    public Drive(HardwareMap hmap, String flName, String frName, String blName, String brName) {
        fl = new MotorEx(hmap, flName);
        fr = new MotorEx(hmap, frName);
        bl = new MotorEx(hmap, blName);
        br = new MotorEx(hmap, brName);

        //initialization settings
    }

    public void drive(double xPow, double yPow, double rotPow) {

    }
}