package org.firstinspires.ftc.teamcode.autos;



import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.MecanumDrive;

@Autonomous(name = "testAuto", group = "Autonomous")
public class testAuto extends LinearOpMode {
        private MecanumDrive drive;

        @Override
        public void runOpMode() throws InterruptedException {

            Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));

            drive = new MecanumDrive(hardwareMap, startPose);

            waitForStart();
            if (!opModeIsActive()) return;


            Actions.runBlocking(
                    drive.actionBuilder(new Pose2d(0,0,0))
                            .lineToX(70)

                            .build()

            );

        }}
