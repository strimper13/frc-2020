package frc.robot.maps;

import com.chopshop166.chopshoplib.maps.DifferentialDriveMap;
import com.chopshop166.chopshoplib.outputs.EncodedSpeedController;
import com.chopshop166.chopshoplib.outputs.IDSolenoid;
import com.chopshop166.chopshoplib.outputs.MockDSolenoid;
import com.chopshop166.chopshoplib.outputs.MockSpeedController;
import com.chopshop166.chopshoplib.outputs.SendableSpeedController;
import com.chopshop166.chopshoplib.sensors.MockEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap {

    public DifferentialDriveMap getDriveMap() {
        return new DifferentialDriveMap() {

            @Override
            public EncodedSpeedController getRight() {
                return getMock();
            }

            @Override
            public EncodedSpeedController getLeft() {
                return getMock();
            }

            private EncodedSpeedController getMock() {
                return EncodedSpeedController.join(new MockSpeedController(), new MockEncoder());
            }
        };
    }

    public static class IntakeMap {
        public SendableSpeedController intake() {
            return new MockSpeedController();
        }

        public IDSolenoid deployIntake() {
            return new MockDSolenoid();
        }
    }

    public IntakeMap getIntakeMap() {
        return new IntakeMap();
    }

    public static class ShooterMap {
        public SendableSpeedController shooterWheel() {
            return new MockSpeedController();
        }
    }

    public ShooterMap getShooterMap() {
        return new ShooterMap();
    }

    public static class ControlPanelMap {
        public SendableSpeedController spinner() {
            return new MockSpeedController();
        }
    }

    public ControlPanelMap getControlPanelMap() {
        return new ControlPanelMap();
    }

    public static class LiftMap {
        public SendableSpeedController elevatorLeft() {
            return new MockSpeedController();
        }

        default public SendableSpeedController elevatorRight() {
            return new MockSpeedController();
        }

        default public Solenoid liftBrake() {
            return new Solenoid(0);
        }

        default public InvertDigitalInput upperLiftLimit() {
            return new InvertDigitalInput(0);
        }

        default public InvertDigitalInput lowerLiftLimit() {
            return new InvertDigitalInput(0);
        }

        default public Encoder getLeftEncoder() {
            return new Encoder(6, 7);
        }

        default public Encoder getRightEncoder() {
            return new Encoder(8, 9);
        }

        public Encoder getLeftEncoder() {
            return new Encoder(6, 7);
        }

        public Encoder getRightEncoder() {
            return new Encoder(8, 9);
        }
    }

    public LiftMap getLiftMap() {
        return new LiftMap();
    }

}