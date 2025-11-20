package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.vision.AprilTagDetector;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.easyopencv.OpenCvCamera;

import java.util.List;

public class Vision extends SubsystemBase {
    private AprilTagProcessor tagProcessor;
    private VisionPortal visionPortal;
    private List<AprilTagDetection> detections;

    public Vision(HardwareMap hmap, String camName) {
        tagProcessor = new AprilTagProcessor.Builder()
                .setCameraPose(Constants.Vision.camPos,Constants.Vision.camRot)
                .build();
        visionPortal = new VisionPortal.Builder()
                .setCamera(hmap.get(WebcamName.class, camName))
                .addProcessor(tagProcessor)
                .build();
    }


    public void getData(Telemetry telemetry) {
        detections = tagProcessor.getDetections();
        telemetry.addData("num of tags detected", detections.size());
    }
}
