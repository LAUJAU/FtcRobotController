package org.firstinspires.ftc.teamcode.Commands.SubsystemCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Vision;

public class GetVisionData extends CommandBase {
    private Vision visionSubsytem;
    private Telemetry telemetry;
    public GetVisionData(Vision subsystem, Telemetry telemetry) {
        visionSubsytem = subsystem;
        this.telemetry = telemetry;
    }

    @Override
    public void execute() {
        visionSubsytem.getData(telemetry);
    }
}
