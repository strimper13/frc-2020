package frc.robot.subsystems;

import com.chopshop166.chopshoplib.outputs.SendableSpeedController;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.maps.RobotMap;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

public class ControlPanel extends SubsystemBase {

    private final SendableSpeedController spinnerMotor;

    @Config(tabName = "Configurable Values")
    private static final double spinnerMotorSpeed = 1;

    public ControlPanel(final RobotMap.ControlPanelMap map) {
        super();
        spinnerMotor = map.spinner();
    }

    public CommandBase spinForwards() {
        return new StartEndCommand(() -> {
            spinnerMotor.set(-spinnerMotorSpeed);
        }, () -> {
            spinnerMotor.stopMotor();
        }, this);
    }

    public CommandBase spinBackwards() {
        return new StartEndCommand(() -> {
            spinnerMotor.set(spinnerMotorSpeed);
        }, () -> {
            spinnerMotor.stopMotor();
        }, this);
    }
}