package frc.team5119.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

class Robot extends IterativeRobot {

    Joystick m_stick;

    PWMTalonSRX m_leftFrontController;
    PWMTalonSRX m_rightFrontController;
    PWMTalonSRX m_leftBackController;
    PWMTalonSRX m_rightBackController;
    SpeedControllerGroup m_leftControllers;
    SpeedControllerGroup m_rightControllers;
    DifferentialDrive m_drive;

    public void robotInit() {
        m_stick = new Joystick(0);

        m_leftControllers = new SpeedControllerGroup(m_leftFrontController, m_leftBackController);
        m_rightControllers = new SpeedControllerGroup(m_rightFrontController, m_rightBackController);
        m_drive = new DifferentialDrive(m_leftControllers, m_rightControllers);
    }

    public void autonomousInit() {

    }

    public void autonomousPeriodic() {

    }

    public void teleopInit() {

    }

    public void teleopPeriodic() {
        m_drive.arcadeDrive(m_stick.getY(), m_stick.getX());
    }
}