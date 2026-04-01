package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TurretMovment {

    private HardwareMap hardwareMap;

    private final Servo outtakeServo, outtakeServo2;
    private final Gamepad Driver1;

    public TurretMovment(OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;
        Driver1 = opMode.gamepad1;

        outtakeServo = opMode.hardwareMap.get(Servo.class, "outtakeServo");
        outtakeServo.setDirection(Servo.Direction.REVERSE);

        outtakeServo2 = opMode.hardwareMap.get(Servo.class, "outtakeServo2");
        outtakeServo2.setDirection(Servo.Direction.FORWARD);

    }
    public void position() {
        if (Driver1.dpad_up) {
            outtakeServo.setPosition(0.5);
            outtakeServo.setPosition(0.5);
        }
        if (Driver1.dpad_down){
            outtakeServo.setPosition(-0.5);
            outtakeServo.setPosition(-0.5);
        }
    }
}
