package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class MotorIntake {
    private DcMotor run;

    private HardwareMap hardwareMap;
    private Gamepad Driver1;

    public MotorIntake(OpMode opMode){
        Driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;

        run = hardwareMap.get(DcMotor.class,"run");
        run.setDirection(DcMotorSimple.Direction.FORWARD);
        run.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }
    public void motorIntake() {
            if (Driver1.a) Start();
            else if (Driver1.b) Outake ();
            else Stop();
        }

    private void Outake() {
        run.setPower(-1);
    }

    private void Start() {
        run.setPower(1);


    }
    private void Stop() {
        run.setPower(0);
    }
}
