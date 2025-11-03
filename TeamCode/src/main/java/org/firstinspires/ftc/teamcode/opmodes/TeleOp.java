package org.firstinspires.ftc.Decode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.Decode.drive.DriverCentricDrive;
import org.firstinspires.ftc.Decode.drive.FieldCentricDrive;
import org.firstinspires.ftc.Decode.subsystems.MotorIntake;
import org.firstinspires.ftc.Decode.subsystems.flyWheel;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DriverCentricDrive drive = new DriverCentricDrive(this);
        MotorIntake motorIntake = new MotorIntake(this);
        flyWheel flyWheel = new flyWheel(this);


        waitForStart();
        while(opModeIsActive()) {
            drive.DriverCentricDrive();
            motorIntake.motorIntake();
            flyWheel.flyWheel();

        }

    }
}
