package org.firstinspires.ftc.teamcode.Commands.SubsystemCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Subsystems.Drive;

public class RunDrive extends CommandBase {
    private Drive driveSubsystem;
    private GamepadEx controller;
    public RunDrive(Drive subsystem, GamepadEx controller) {
        driveSubsystem = subsystem;
        this.controller = controller;
    }

    @Override
    public void execute() {
        driveSubsystem.drive(controller.getLeftX(), controller.getLeftY(), controller.getRightX());
    }
}
