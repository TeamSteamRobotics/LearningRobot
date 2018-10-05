package frc.team5119.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Robot extends TimedRobot {

    Joystick m_stick;

    PWMTalonSRX m_leftFrontController;
    PWMTalonSRX m_rightFrontController;
    PWMTalonSRX m_leftBackController;
    PWMTalonSRX m_rightBackController;
    MecanumDrive m_drive;

    public void robotInit() {
        m_stick = new Joystick(0);
        m_leftFrontController = new PWMTalonSRX(0);
        m_leftBackController = new PWMTalonSRX(2);
        m_rightFrontController = new PWMTalonSRX(1);
        m_rightBackController = new PWMTalonSRX(3);
        m_drive = new MecanumDrive(m_leftFrontController, m_leftBackController, m_rightFrontController, m_rightBackController);
    }

    public void robotPeriodic() {

    }

    public void autonomousInit() {
        try {
            m_leftFrontController.set(1);
            m_rightFrontController.set(1);
            m_rightBackController.set(1);
            m_leftBackController.set(1);
            Thread.sleep(1000); //Thread.sleep() takes milliseconds, so 1000 milliseconds = 1 second
            m_leftFrontController.set(0);
            m_rightFrontController.set(0);
            m_rightBackController.set(0);
            m_leftBackController.set(0);
        } catch (InterruptedException e) { //Thread.sleep() can throw an InterruptedException, so we have to catch it
            e.printStackTrace();
        }
    }

    public void autonomousPeriodic() {

    }

    public void teleopInit() {

    }

    public void teleopPeriodic() {
        m_drive.driveCartesian(m_stick.getY(), m_stick.getX(), m_stick.getZ());
    }
}