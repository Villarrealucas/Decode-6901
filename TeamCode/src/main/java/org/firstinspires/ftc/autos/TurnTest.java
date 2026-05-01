package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.TurretMovment;


@Config
@Autonomous(name = "TurnTest", group = "Autonomous")
public final class TurnTest extends LinearOpMode {

    private MecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        Pose2d startPose = new Pose2d(-49, -49, Math.toRadians(225));

        drive = new MecanumDrive(hardwareMap, startPose);

        waitForStart();
        if (!opModeIsActive()) return;

        Pose2d pose = startPose;

        // ---------- Move to first scoring position ----------

        Actions.runBlocking(
                drive.actionBuilder(pose)

                        .turn(Math.toRadians(180))
                        .build()
        );
    }}