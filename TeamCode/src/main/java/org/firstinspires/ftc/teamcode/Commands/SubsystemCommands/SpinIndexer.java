package org.firstinspires.ftc.teamcode.Commands.SubsystemCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Indexer;

public class SpinIndexer extends CommandBase {
    private Indexer indexerSubsystem;
    private double power;
    public SpinIndexer(Indexer subsystem, double power) {
        indexerSubsystem = subsystem;
        this.power = power;
    }

    @Override
    public void execute() {
        indexerSubsystem.setIndexer(power);
    }
}
