package org.firstinspires.ftc.teamcode.Commands.SubsystemCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class SpinIntake extends CommandBase {
    private Intake intakeSubsystem;
    private double power;
    public SpinIntake(Intake subsystem, double power) {
        intakeSubsystem = subsystem;
        this.power = power;
    }

    @Override
    public void execute() {
        intakeSubsystem.setIntake(power);
    }
}
