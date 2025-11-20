package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.openftc.easyopencv.OpenCvCameraRotation;

public class Constants {

    public static class Vision {
        public static final String camName = "";
        public static final Position camPos = new Position(DistanceUnit.INCH, 0,0,0,0);
        public static final YawPitchRollAngles camRot = new YawPitchRollAngles(AngleUnit.DEGREES, 0,0,0,0);
    }

    public static class Drive {
        public static final String flName = "fl";
        public static final String frName = "fr";
        public static final String blName = "bl";
        public static final String brName = "br";
    }

    public static class Flywheel {
        public static final String flywheel1Name = "fw1";
        public static final String flywheel2Name = "fw2";
    }

    public static class Intake {
        public static final String intakeName = "intake";
    }

    public static class Indexer {
        public static final String indexerName = "indexer";
    }
}
