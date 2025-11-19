package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Indexer {
    private MotorEx indexerMotor;
    public Indexer(HardwareMap hmap, String indexerName) {
        indexerMotor = new MotorEx(hmap, indexerName);
    }

    public void setIndexer(double power) {
        indexerMotor.set(power);
    }
}
