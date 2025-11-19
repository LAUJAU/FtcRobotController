package org.firstinspires.ftc.teamcode;

import org.openftc.easyopencv.OpenCvCameraRotation;

public class Constants {

    public static class Vision {
        public static final int camSightWidth = 1280;
        public static final int camSightHeight = 720;
        public static final OpenCvCameraRotation camOrientation = OpenCvCameraRotation.UPRIGHT;
        public static final boolean camGPUEnabled = true;
        public static final String camName = "";
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
