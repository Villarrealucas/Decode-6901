package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class MotorIntake {
    private final DcMotor run;
    private final Gamepad Driver1;

    public MotorIntake(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        HardwareMap hardwareMap = opMode.hardwareMap;

        run = hardwareMap.get(DcMotor.class, "run");
        run.setDirection(DcMotorSimple.Direction.FORWARD);
        run.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void motorIntake() {
        if (Driver1.x) {
            run.setPower(1);
        } else if (Driver1.b) {
            run.setPower(-1);
        } else {
            run.setPower(0);
        }
    }
}