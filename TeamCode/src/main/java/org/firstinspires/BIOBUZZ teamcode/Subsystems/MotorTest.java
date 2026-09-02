package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorTest {

    private DcMotor leftFront, leftBack, rightFront, rightBack;
    private Gamepad Driver1;
    double speed = .85;

    public MotorTest(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        HardwareMap hardwareMap = opMode.hardwareMap;
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
    public void updateTeleOp() {
        if (Driver1.a) {
            leftBack.setPower(1);
        }
        else {leftBack.setPower(0);}

        if (Driver1.b) {
            leftFront.setPower(1);
        }
        else {leftFront.setPower(0);}

        if (Driver1.y) {
            rightBack.setPower(1);
        }
        else {rightBack.setPower(0);}

        if (Driver1.x) {
            rightFront.setPower(1);
        }
        else {rightFront.setPower(0);}

    }}
