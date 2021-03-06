package frc.robot.triggers;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotContainer;

public class StorageLimitSwitchTrigger extends Trigger {

    private RobotContainer rCon;

    public StorageLimitSwitchTrigger(RobotContainer rContainer) {
        this.rCon = rContainer;
    }

    @Override
    public boolean get(){
        return  rCon.shouldStorageIntake();
    }
}