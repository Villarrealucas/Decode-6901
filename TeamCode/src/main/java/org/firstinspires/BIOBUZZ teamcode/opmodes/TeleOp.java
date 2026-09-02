package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.drive.DriverCentricDrive;
import org.firstinspires.ftc.teamcode.subsystems.MotorIntake;
import org.firstinspires.ftc.teamcode.subsystems.MotorTest;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp

public class TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DriverCentricDrive driverCentricDrive = new DriverCentricDrive(this);
        Outtake outtake = new Outtake(this);
        MotorTest motorTest = new MotorTest(this);

        waitForStart();
        while (opModeIsActive()) {
            driverCentricDrive.Drive();
            outtake.updateTeleOp();
           //motorTest.updateTeleOp();

        }
    }
}