package org.firstinspires.ftc.Decode.subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class flyWheel {

    private static Servo intakeServo, intakeServo2;

    private HardwareMap hardwareMap;
    private Gamepad Driver2;
    private Gamepad Driver1;

    private final double score = 1;

    public flyWheel(OpMode opMode) {

        hardwareMap = opMode.hardwareMap;
        Driver2 = opMode.gamepad2;
        Driver1 = opMode.gamepad1;

        intakeServo = opMode.hardwareMap.get(Servo.class, "intakeServo");
        intakeServo2 = opMode.hardwareMap.get(Servo.class, "intakeServo2");

        intakeServo.setDirection(Servo.Direction.REVERSE);
        intakeServo2.setDirection(Servo.Direction.FORWARD);

    }

    public void flyWheel() {
        if (Driver1.left_trigger >= 0.1) {
            intakeServo.setPosition(score);
            intakeServo2.setPosition(score);
        }
        if (Driver1.right_trigger >= 0.1) {
            intakeServo.setPosition(0);
            intakeServo2.setPosition(0);
        }
    }
}
