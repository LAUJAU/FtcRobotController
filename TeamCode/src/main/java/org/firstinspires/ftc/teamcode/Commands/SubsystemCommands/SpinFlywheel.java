package org.firstinspires.ftc.teamcode.Commands.SubsystemCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;

public class SpinFlywheel extends CommandBase {
    private Flywheel flywheelSubsystem;
    private double power1;
    private double power2;
    public SpinFlywheel(Flywheel subsystem, double power1, double power2) {
        flywheelSubsystem = subsystem;
        this.power1 = power1;
        this.power2 = power2;
    }

    @Override
    public void execute() {
        flywheelSubsystem.setFlywheelPower(power1, power2);
    }
}
