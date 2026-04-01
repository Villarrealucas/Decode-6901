package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {
    private final DcMotor position;
    private final DcMotor outtake;
    private final DcMotor outtake2;
    private final DcMotor run;

    private final Servo outtakeServo;
    private final Servo outtakeServo2;
    private final CRServo intakeServo;
    private final CRServo intakeServo2;
    private final Gamepad driver1;

    public Outtake(OpMode opMode) {
        HardwareMap hw = opMode.hardwareMap;
        driver1 = opMode.gamepad1;

        position = hw.get(DcMotor.class, "position");
        outtake = hw.get(DcMotor.class, "outtake");
        outtake2 = hw.get(DcMotor.class, "outtake2");
        run = hw.get(DcMotor.class, "run");
        outtakeServo = hw.get(Servo.class, "outtakeServo");
        outtakeServo2 = hw.get(Servo.class, "outtakeServo2");
        intakeServo = hw.get(CRServo.class, "intakeServo");
        intakeServo2 = hw.get(CRServo.class, "intakeServo2");

        run.setDirection(DcMotorSimple.Direction.REVERSE);
        run.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        position.setDirection(DcMotorSimple.Direction.FORWARD);
        position.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtake.setDirection(DcMotorSimple.Direction.REVERSE);
        outtake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        outtake2.setDirection(DcMotorSimple.Direction.FORWARD);
        outtake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeServo.setDirection(CRServo.Direction.FORWARD);
        intakeServo2.setDirection(CRServo.Direction.FORWARD);
        //outtakeServo.setDirection(Servo.Direction.FORWARD);
        //outtakeServo2.setDirection(Servo.Direction.REVERSE);

        stopFlywheels();
        run.setPower(0);
    }

    public void updateTeleOp() {

        if (driver1.left_bumper) {
            moveLeft(0.6);
        } else if (driver1.right_bumper) {
            moveRight(0.6);
        } else {
            restPos();
        }
        double runPower = 0;

        if (driver1.a || driver1.x) {
            runPower = 1;
        } else if (driver1.b) {
            runPower = -1;
        }
        run.setPower(runPower);

        if (driver1.a || driver1.y) {
           flywheelsOn();
            intakeServo.setPower(-1);
            intakeServo2.setPower(1);
        } else {
           stopFlywheels();
            intakeServo.setPower(0);
            intakeServo2.setPower(0);
        }
    }

    public void restPos() {
        position.setPower(0);
    }

    public void moveLeft(double power) {
        position.setPower(power);
    }

    public void moveRight(double power) {
        position.setPower(-power);
    }

    public void flywheelsOn() {
        outtake.setPower(1.0);
        outtake2.setPower(1.0);

    }

    public void stopFlywheels() {
        outtake.setPower(0);
        outtake2.setPower(0);
    }

    public void runOn() {
        run.setPower(-1);
    }

    public void runOff() {
        run.setPower(0);
    }

    public void all() {
        flywheelsOn();
        runOn();
    }

    public void rest() {
        stopFlywheels();
        runOff();

    }
}