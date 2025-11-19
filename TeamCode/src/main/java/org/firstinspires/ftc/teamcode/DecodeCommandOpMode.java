package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Commands.SubsystemCommands.SpinFlywheel;
import org.firstinspires.ftc.teamcode.Commands.SubsystemCommands.SpinIndexer;
import org.firstinspires.ftc.teamcode.Commands.SubsystemCommands.SpinIntake;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.Subsystems.Indexer;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Vision;

public class DecodeCommandOpMode extends CommandOpMode {
    private Drive driveSubsystem;
    private Flywheel flywheelSubsystem;
    private Indexer indexerSubsystem;
    private Intake intakeSubsystem;
    private Vision visionSubsystem;
    private GamepadEx controller;
    private SpinFlywheel spinFlywheel;
    private SpinFlywheel stopFlywheel;
    private SpinIntake spinIntake;
    private SpinIntake reverseIntake;
    private SpinIntake stopIntake;
    private SpinIndexer spinIndexer;
    private SpinIndexer reverseIndexer;
    private SpinIndexer stopIndexer;
    @Override
    public void initialize() {
        controller = new GamepadEx(gamepad1);

        initSubsystems();
        initCommands();
    }

    private void initSubsystems() {
        driveSubsystem = new Drive(hardwareMap, Constants.Drive.flName, Constants.Drive.frName, Constants.Drive.blName, Constants.Drive.brName);
        flywheelSubsystem = new Flywheel(hardwareMap, Constants.Flywheel.flywheel1Name, Constants.Flywheel.flywheel2Name);
        indexerSubsystem = new Indexer(hardwareMap, Constants.Indexer.indexerName);
        intakeSubsystem = new Intake(hardwareMap, Constants.Intake.intakeName);
        visionSubsystem = new Vision(hardwareMap, Constants.Vision.camName);
    }

    private void initCommands() {
        spinFlywheel = new SpinFlywheel(flywheelSubsystem, 0.76, -0.76);
        stopFlywheel = new SpinFlywheel(flywheelSubsystem, 0, 0);

        spinIntake = new SpinIntake(intakeSubsystem, -1);
        reverseIntake = new SpinIntake(intakeSubsystem, 1);
        stopIntake = new SpinIntake(intakeSubsystem, 0);

        spinIndexer = new SpinIndexer(indexerSubsystem, 1);
        reverseIndexer = new SpinIndexer(indexerSubsystem, -1);
        stopIndexer = new SpinIndexer(indexerSubsystem, 0);
    }

    private void configBindings() {
        controller.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(reverseIntake).whenReleased(stopIntake);
        new Trigger(() -> controller.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.2).whenActive(spinIntake).whenInactive(stopIntake);

        controller.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(reverseIndexer).whenReleased(stopIndexer);
        new Trigger(() -> controller.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.2).whenActive(spinIndexer).whenInactive(stopIndexer);
    }
}
