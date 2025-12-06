package org.firstinspires.ftc.teamcode.autos;



import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.DriverCentricDrive;

@Autonomous(name = "testAuto", group = "Autonomous")
public class testAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
    }

    public class intake {
        private final DcMotor move;

        public intake(HardwareMap hardwareMap) {
            move = hardwareMap.get(DcMotor.class, "intakeMotor");
            move.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            move.setDirection(DcMotorSimple.Direction.FORWARD);
        }

        public class forward implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    move.setPower(1);
                    initialized = true;
                }
                return false;
            }
        }

        public Action forward() {
            return new forward();
        }

        public class Stop implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    move.setPower(0);
                    initialized = true;
                }
                return false;
            }

            public Action stop() {
                return new Stop();
            }
        }

        public class Flywheel {
            private CRServo up;

            public Flywheel(HardwareMap hardwareMap) {
                up = hardwareMap.get(CRServo.class, "up");
            }

            public class Up implements Action {
                @Override
                public boolean run(@NonNull TelemetryPacket packet) {
                    up.setPower(1);
                    return false;
                }
            }

            public Action up() {
                return new Up();
            }
        }


        public class turrentMotor {
            private DcMotor outtake, outtake2;
            private Servo position;

            public turrentMotor(HardwareMap hardwareMap) {
                outtake = hardwareMap.get(DcMotor.class, "outtakeMotor");
                outtake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                outtake.setDirection(DcMotorSimple.Direction.FORWARD);
                outtake2 = hardwareMap.get(DcMotor.class, "outtakeMotor");
                outtake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                outtake2.setDirection(DcMotorSimple.Direction.FORWARD);


                position = hardwareMap.get(Servo.class, "position");

            }

            public class Outtake implements Action {
                private boolean initialized = false;

                @Override
                public boolean run(@NonNull TelemetryPacket packet) {
                    if (!initialized) {
                        outtake.setPower(1);
                        outtake2.setPower(1);
                        initialized = true;
                    }
                    return false;
                }
            }

            public Action Outtake() {
                return new Outtake();
            }

            public class End implements Action {
                private boolean initialized = false;

                @Override
                public boolean run(@NonNull TelemetryPacket packet) {
                    if (!initialized) {
                        outtake.setPower(0);
                        outtake2.setPower(0);
                        initialized = true;
                    }
                    return false;
                }
            }

            public Action End() {
                return new End();
            }


            public class turrentServo {
                private Servo open, close;

                public turrentServo(HardwareMap hardwareMap) {
                    open = hardwareMap.get(Servo.class, "open");
                    close = hardwareMap.get(Servo.class, "close");

                }

                public class Open implements Action {
                    @Override
                    public boolean run(@NonNull TelemetryPacket packet) {
                        open.setPosition(0.8);
                        return false;
                    }
                }

                public Action open() {
                    return new Open();
                }

                public class Close implements Action {
                    @Override
                    public boolean run(@NonNull TelemetryPacket packet) {
                        close.setPosition(0);
                        return false;
                    }

                    public Action close() {
                        return new Close();
                    }

                    public void runOpMode() {
                        DriverCentricDrive drive = new DriverCentricDrive(hardwareMap, new Pose2d(-33, -63, Math.PI/2));
                        intake intake = new intake(hardwareMap);
                        turrentMotor turrentMotor = new turrentMotor(hardwareMap);
                        turrentServo turrentServo = new turrentServo(hardwareMap);

                        Action trajectoryAction1;
                        trajectoryAction1 = drive.actionBuilder(drive.pose);
                    }
                }
            }
        }
    }
}