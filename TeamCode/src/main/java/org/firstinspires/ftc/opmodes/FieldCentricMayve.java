package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.FieldCentricDrive;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;

@TeleOp
public class FieldCentricMayve extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        FieldCentricDrive fieldCentricDrive = new FieldCentricDrive(this);
        Outtake outtake = new Outtake(this);
        waitForStart();
        while(opModeIsActive()) {
            fieldCentricDrive.fieldCentric();
            outtake.updateTeleOp();
        }
    }
}
