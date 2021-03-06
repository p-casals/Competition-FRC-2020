/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.commands.auto.TurnCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Vision;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;


public class BallTrack extends CommandBase {

  private Drivetrain drivetrain;
  private Vision vision;
  /**
   * Creates a new EnableShooterCommand.
   */
  public BallTrack(Drivetrain drivetrain, Vision vision) {
      this.drivetrain = drivetrain;
      this.vision = vision;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Block largestBlock = vision.getBlocksOfType(Constants.POWER_CELL_SIG).get(0);
    // Right is positive left is negative
    double angle = -vision.getAnglesOfBlock(largestBlock, false);

    // Positive angle turn right
    if (angle >= 0) drivetrain.tankDrive(-(-angle)/(180+6*angle), (-angle)/(180+6*angle));
    else drivetrain.tankDrive((-angle)/(180+6*angle), -(-angle)/(180+6*angle));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
