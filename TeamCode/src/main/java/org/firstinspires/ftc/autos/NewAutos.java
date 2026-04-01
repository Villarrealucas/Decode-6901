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
@Autonomous(name = "Autos", group = "Autonomous")
public final class NewAutos extends LinearOpMode {

    private MecanumDrive drive;
    private Outtake outtake;
    private TurretMovment turretMovment;

    @Override
    public void runOpMode() throws InterruptedException {

        Pose2d startPose = new Pose2d(-49, -49, Math.toRadians(225));

        drive = new MecanumDrive(hardwareMap, startPose);
        outtake = new Outtake(this);
        turretMovment = new TurretMovment(this);

        waitForStart();
        if (!opModeIsActive()) return;

        Pose2d pose = startPose;

        // ---------- Move to first scoring position ----------

        outtake.flywheelsOn();

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(-9, -11))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.all();
        sleep(1500);
        outtake.rest();

        // ---------- Move to first pickup ----------

        outtake.runOn();

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(45))
                        .strafeTo(new Vector2d(12, -51))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOff();

        // ---------- Score again ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(-45))
                        .strafeTo(new Vector2d(-6, -6))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.all();
        sleep(2000);
        outtake.rest();

        // ---------- Second pickup ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(12, -21))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOn();
        sleep(300);

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(12, -51))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.rest();

        // ---------- Score again ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(-45))
                        .strafeTo(new Vector2d(-6, -6))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.all();
        sleep(2000);
        outtake.rest();

        // ---------- Final pickup ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(36, -21))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOn();
        sleep(300);


        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(36, -51))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOff();

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .splineToSplineHeading(new Pose2d(-6, -6, Math.toRadians(-135)), Math.toRadians(0))
                        .build());

                outtake.flywheelsOn();
               sleep(2000);
                outtake.stopFlywheels();
    }
}