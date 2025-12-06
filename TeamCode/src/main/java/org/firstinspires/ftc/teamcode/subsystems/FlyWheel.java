package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class FlyWheel {
    private static CRServo intakeServo, intakeServo2;
    private final Gamepad Driver1;

    public FlyWheel(OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;
        Driver1 = opMode.gamepad1;

        intakeServo = hardwareMap.get(CRServo.class, "intakeServo");
        intakeServo2 = hardwareMap.get(CRServo.class, "intakeServo2");

        intakeServo.setDirection(CRServo.Direction.FORWARD);
        intakeServo2.setDirection(CRServo.Direction.REVERSE);

        intakeServo.setPower(0);
        intakeServo2.setPower(0);
    }

    public void flyWheel() {
            if (Driver1.y) {
            intakeServo.setPower(1.0);
            intakeServo2.setPower(1.0);


        } else {
            intakeServo.setPower(0);
            intakeServo2.setPower(0);}
    }
}
