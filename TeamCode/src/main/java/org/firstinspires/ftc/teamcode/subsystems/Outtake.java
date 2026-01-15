package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {
    public static DcMotor position, outtake, outtake2;
    private static Servo outtakeServo, outtakeServo2;
    private static CRServo intakeServo, intakeServo2;
    private HardwareMap hardwareMap;
    private final Gamepad Driver1;


    public Outtake(OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;
        Driver1 = opMode.gamepad1;

        position = opMode.hardwareMap.get(DcMotor.class, "position");
        outtake = opMode.hardwareMap.get(DcMotor.class, "outtake");
        outtake2 = opMode.hardwareMap.get(DcMotor.class, "outtake2");
        outtakeServo = opMode.hardwareMap.get(Servo.class, "outtakeServo");
        outtakeServo2 = opMode.hardwareMap.get(Servo.class, "outtakeServo2");
        intakeServo = hardwareMap.get(CRServo.class, "intakeServo");
        intakeServo2 = hardwareMap.get(CRServo.class, "intakeServo2");

        position.setDirection(DcMotorSimple.Direction.FORWARD);
        position.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtake.setDirection(DcMotorSimple.Direction.REVERSE);
        outtake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtake2.setDirection(DcMotorSimple.Direction.FORWARD);
        outtake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeServo.setDirection(CRServo.Direction.REVERSE);
        intakeServo2.setDirection(CRServo.Direction.FORWARD);
        outtakeServo.setDirection(Servo.Direction.FORWARD);
        outtakeServo2.setDirection(Servo.Direction.REVERSE);

        intakeServo.setPower(0);
        intakeServo2.setPower(0);
    }
    public void Position() {
        //Turrent movement
        if (Driver1.left_bumper) {
            MoveLeft();}
        else {
            RestPos();}
        if (Driver1.right_bumper) {
            MoveRight();
        } else {
            RestPos();}

        if (Driver1.x) {
            MoveUp();
        }
        if (Driver1.y) {
            restServos();
        }

        // Fly Wheels
        if (Driver1.b) {
            FlyWheelsON();
        }else {
            FlyWheelsRest();
        }
    }
    private void MoveUp() {
        outtakeServo.setPosition(1);
        outtakeServo2.setPosition(1);
    }
    private void restServos(){
        outtakeServo.setPosition(0);
        outtakeServo2.setPosition(0);
    }
    private void RestPos() {
        position.setPower(0);
        outtakeServo.setPosition(0);
        outtakeServo2.setPosition(0);
    }
    private void MoveRight() {
        position.setPower(-1);
    }
    private void MoveLeft() {
        position.setPower(1);
    }

    public static void FlyWheelsON() {
        outtake.setPower(1.0);
        outtake2.setPower(1.0);
        intakeServo.setPower(1.0);
        intakeServo2.setPower(1.0);
    }
    public static void FlyWheelsRest() {
        outtake.setPower(0);
        outtake2.setPower(0);
        intakeServo.setPower(0);
        intakeServo2.setPower(0);
    }
}