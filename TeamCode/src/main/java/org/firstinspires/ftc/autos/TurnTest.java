package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Rotation2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ftc.LazyImu;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.drive.MecanumDrive;

@Autonomous(name = "TurnTest", group = "Autonomous")
public class TurnTest extends LinearOpMode {

    private MecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {

        Pose2d startPose = new Pose2d(0, 0, 0);
        drive = new MecanumDrive(hardwareMap, startPose);

        waitForStart();

        // Build the action (NO var)
        Action turnAction = drive.actionBuilder(startPose)
                .turn(Math.toRadians(90))
                .build();

        // Run action manually so we can update telemetry
        while (opModeIsActive()) {

            TelemetryPacket packet = new TelemetryPacket();

            boolean stillRunning = turnAction.run(packet);

            // 🔁 READ IMU EVERY LOOP
            YawPitchRollAngles angles =
                    drive.lazyImu.get().getRobotYawPitchRollAngles();

            telemetry.addData("IMU yaw (deg)",
                    angles.getYaw(AngleUnit.DEGREES));

            telemetry.addData("RR heading (deg)",
                    Math.toDegrees(drive.localizer.getPose().heading.toDouble()));

            telemetry.update();

            if (!stillRunning) break;
        }
    }
}
