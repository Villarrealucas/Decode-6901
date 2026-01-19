package Mecanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class MecanumDriveOrientatedOpMode extends OpMode {
MecanumDrive drive = new MecanumDrive();
    double forward, strafe, rotate;
    @Override
    public void init() {
        drive.init(hardwareMap);
    }
    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        drive.driverFieldRelative(forward,strafe,rotate);
    }
}

