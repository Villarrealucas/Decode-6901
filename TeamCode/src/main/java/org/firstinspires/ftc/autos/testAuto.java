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
@Autonomous(name = "testAutos", group = "Autonomous")
public final class testAuto extends LinearOpMode {

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

        outtake.runOn();
        sleep(1300);
        outtake.stopFlywheels();

        // ---------- Move to first pickup ----------

        outtake.moveRight();

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(45))
                        .build()
        );
        pose = drive.localizer.getPose();

        sleep(500);

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(12, -49))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOff();
        outtake.flywheelsOn();

        // ---------- Score again ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(-9, -11))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.moveRight();
        sleep(100);
        outtake.restPos();
        outtake.runOn();
        sleep(1300);
        outtake.stopFlywheels();

        // ---------- Second pickup ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(-4, -18))
                        .splineToSplineHeading(new Pose2d(12, -49, Math.toRadians(-90)), Math.toRadians(-90))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOff();
        outtake.flywheelsOn();

        // ---------- Score again ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .strafeTo(new Vector2d(-9, -11))
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOn();
        sleep(1300);
        outtake.stopFlywheels();
    }}
// ---------- Final pickup ----------
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(12, -22))
//                        .splineToSplineHeading(new Pose2d(36, -49, Math.toRadians(-90)), Math.toRadians(-90))
//                        .build()
//        );
//        pose = drive.localizer.getPose();
//
//        outtake.runOff();
//
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(6, -54))
//                        .build());
//        pose = drive.localizer.getPose();
//
//                sleep(300);
//                outtake.flywheelsOn();
//
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(-9, -11))
//                        .build());
//
//        pose = drive.localizer.getPose();
//
//        outtake.runOn();
//        sleep(1300);
//        outtake.stopFlywheels();
//
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(6, -54))
//                        .build());
//        pose = drive.localizer.getPose();
//
//
//        sleep(300);
//        outtake.runOff();
//        outtake.flywheelsOn();
//
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(-9, -11))
//                        .build());
//
//        pose = drive.localizer.getPose();
//
//        outtake.runOn();
//        sleep(1300);
//        outtake.rest();
//    }
//}