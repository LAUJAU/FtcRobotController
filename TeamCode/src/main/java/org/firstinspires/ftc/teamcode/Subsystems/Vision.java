package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.vision.AprilTagDetector;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.openftc.easyopencv.OpenCvCamera;

public class Vision extends SubsystemBase {
    private AprilTagDetector apriltagDetector;
    private OpenCvCamera cam;

    public Vision(HardwareMap hmap, String camName) {
        apriltagDetector = new AprilTagDetector(hmap, camName);
        apriltagDetector.GPU_ENABLED = Constants.Vision.camGPUEnabled;
        apriltagDetector.HEIGHT = Constants.Vision.camSightHeight;
        apriltagDetector.WIDTH = Constants.Vision.camSightWidth;
        apriltagDetector.ORIENTATION = Constants.Vision.camOrientation;

        apriltagDetector.init();
        apriltagDetector.setTargets();//input IDs of goal
        cam = apriltagDetector.getCamera();
    }


    public void getData() {}
}
