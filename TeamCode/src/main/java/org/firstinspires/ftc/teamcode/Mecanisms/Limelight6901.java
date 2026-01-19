package Mecanisms;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import java.util.List;

public class Limelight6901 implements Limelight {
    Limelight3A limelight6901;
    @Override
    public void init() {
        limelight6901 = hardwareMap.get(Limelight3A.class, "limelight6901");
        limelight6901.setPollRateHz(100);
        limelight6901.start();

        limelight6901.pipelineSwitch(1);
        LLResult result = limelight6901.getLatestResult();
        if (result != null && result.isValid()) {
            double tx = result.getTx(); // How far left or right the target is (degrees)
            double ty = result.getTy(); // How far up or down the target is (degrees)
            double ta = result.getTa(); // How big the target looks (0%-100% of the image)

            telemetry.addData("Target X", tx);
            telemetry.addData("Target Y", ty);
            telemetry.addData("Target Area", ta);
        } else {
            telemetry.addData("Limelight", "No Targets");
        }
        limelight6901.pipelineSwitch(0); // Switch to pipeline number 0


        List<LLResultTypes.ColorResult> colorTargets = result.getColorResults();
        for (LLResultTypes.ColorResult colorTarget : colorTargets) {
            LLResultTypes.ColorResult detection = null;
            double x = detection.getTargetXDegrees(); // Where it is (left-right)
            double y = detection.getTargetYDegrees(); // Where it is (up-down)
            double area = colorTarget.getTargetArea(); // size (0-100)
            telemetry.addData("Color Target", "takes up " + area + "% of the image");
        }





    }
}
