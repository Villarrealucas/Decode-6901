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
                        .lineToX(-6)
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOn();
        sleep(1300);
        outtake.stopFlywheels();


        // ---------- Move to first pickup ----------


        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(45))
                        .build()
        );
        pose = drive.localizer.getPose();

        //sleep(500);

        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .lineToY(-49)
                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOff();
        outtake.flywheelsOn();

        // ---------- Score again ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .lineToY(-7)
                        .turn(Math.toRadians(-45))

                        .build()
        );
        pose = drive.localizer.getPose();


        outtake.runOn();
        sleep(1300);
        outtake.stopFlywheels();

        // ---------- Second pickup ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)

                        .turn(Math.toRadians(105))
                        .lineToX(18)
                        .turn(Math.toRadians(-60))
                        .lineToY(-49)

                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOff();
        outtake.flywheelsOn();

        // ---------- Score again ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(-150))
                        .lineToX(-8)
                        .turn(Math.toRadians(105))

                        .build()
        );
        pose = drive.localizer.getPose();

        outtake.runOn();
        sleep(1000);
        outtake.stopFlywheels();
        // ---------- Final pickup ----------
        Actions.runBlocking(
                drive.actionBuilder(pose)
                        .turn(Math.toRadians(120))
                        .lineToX(35)
                        .turn(Math.toRadians(-75))
                        .lineToY(-49)
//                        .lineToY(-24)
//                        .turn(Math.toRadians(-90))

                        .build()
        );
//        pose = drive.localizer.getPose();
//
//        outtake.runOff();
//
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(10, -58))
//                        .build());
//        pose = drive.localizer.getPose();
//
//                sleep(300);
//                outtake.flywheelsOn();
//
//        Actions.runBlocking(
//                drive.actionBuilder(pose)
//                        .strafeTo(new Vector2d(-7, -9))
//                        .build());
//
//        pose = drive.localizer.getPose();
//
//        outtake.runOn();
//        sleep(1300);
//        outtake.rest();
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
    }
}