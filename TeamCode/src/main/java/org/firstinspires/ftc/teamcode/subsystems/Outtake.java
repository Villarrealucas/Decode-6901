package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {
    public static DcMotor position, outtake, outtake2;
    public static Servo outtakeServo, outtakeServo2;
    private HardwareMap hardwareMap;
    private Gamepad Driver1;


    public Outtake(OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;
        Driver1 = opMode.gamepad1;

        position = opMode.hardwareMap.get(DcMotor.class, "position");
        outtake = opMode.hardwareMap.get(DcMotor.class, "outtake");
        outtake2 = opMode.hardwareMap.get(DcMotor.class, "outtake2");
        outtakeServo = opMode.hardwareMap.get(Servo.class, "outtakeServo");
        outtakeServo2 = opMode.hardwareMap.get(Servo.class, "outtakeServo2");


        position.setDirection(DcMotorSimple.Direction.FORWARD);
        position.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtake.setDirection(DcMotorSimple.Direction.FORWARD);
        outtake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtake2.setDirection(DcMotorSimple.Direction.FORWARD);
        outtake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        outtakeServo.setDirection(Servo.Direction.FORWARD);
        outtakeServo2.setDirection(Servo.Direction.REVERSE);
        outtakeServo.setPosition(0);
        outtakeServo2.setPosition(0);

    }

    public void outtake() {

        if (Driver1.left_trigger >= 0.1) {
            position.setPower(0.5);
        } else {
            position.setPower(0);
        }
        if (Driver1.right_trigger >= 0.1) {
            position.setPower(-0.5);
        } else {
            position.setPower(0);



            if (Driver1.x) {
                outtake.setPower(1);
                outtake2.setPower(1);
            } else {
                outtake.setPower(0);
                outtake2.setPower(0);
            }

            if (Driver1.right_bumper) {
                outtakeServo.setPosition(1);
                outtakeServo2.setPosition(1);
                }
            else if (Driver1.left_bumper) {
                outtakeServo.setPosition(0);
                outtakeServo2.setPosition(0);
            }
        }
    }
}