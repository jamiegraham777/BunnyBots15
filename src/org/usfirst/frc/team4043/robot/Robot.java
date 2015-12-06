package org.usfirst.frc.team4043.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;

//BunnyBots Code 2015
// 12/5/15

//******************[ Start Code ]*********************************************************************

public class Robot extends SampleRobot {
	Talon frontWheels, backWheels, beltMotor;
	RobotDrive myRobot;
    Joystick xbox, xbox2;  // set to ID 1 in DriverStation
    
    public Robot() {
    	frontWheels = new Talon(0);
    	backWheels = new Talon(1);
    	beltMotor = new Talon(2);
    	myRobot = new RobotDrive(frontWheels,backWheels);
        xbox = new Joystick(0);
    }    
    
    public void operatorControl() {
        
        while (isOperatorControl() && isEnabled()) {
        	
//**************[ conveyer belt code ]**********************************************************************
        	  if((xbox.getRawAxis(2)>0.1 || xbox.getRawAxis(2)<-0.1)){
        		  beltMotor.set(xbox.getRawAxis(2)/1.5);
        			}
        	  else if (xbox.getRawAxis(2) == 0)
        	      beltMotor.set(0);
        	       
        	       if(((xbox.getRawAxis(3)>0.1 || xbox.getRawAxis(3)<-0.1))) {// && !Bottom.get()){
        			beltMotor.set(-xbox.getRawAxis(3)/1.5);
        			}
        	       else if (xbox.getRawAxis(3) == 0)
             	      beltMotor.set(0);
        	
//****************[ drives robot ]*********************************************************************
        	
       if(xbox.getRawAxis(1)>0.1 || xbox.getRawAxis(1)<-0.1){
    	   frontWheels.set(-xbox.getRawAxis(1)/1.5);
		}
       else if (xbox.getRawAxis(3) < 0.1 || xbox.getRawAxis(3) > -0.1 )
  	      frontWheels.set(0);
       
       if(xbox.getRawAxis(5)>0.1 || xbox.getRawAxis(5)<-0.1){
		backWheels.set(xbox.getRawAxis(5)/1.5);
		}
       else if (xbox.getRawAxis(3) < 0.1 || xbox.getRawAxis(3) > -0.1 )
   	      backWheels.set(0);
     
       
//**************[ spin-y wheels ]**********************************************************************
       	
   //    myRobot.arcadeDrive(-xbox2.getRawAxis(1)/1.5, -xbox2.getRawAxis(5)/1.5);

       /* if (xbox.getRawButton(0)) {        //pulls out
    	   leftSpinyWheel.set(1);
    	   rightSpinyWheel.set(-1);
    	   
       }
       else {
    	   leftSpinyWheel.set(0);
           rightSpinyWheel.set(0);
       }
       if (xbox.getRawButton(1)) {       //turns clockwise
    	   leftSpinyWheel.set(-1);
    	   rightSpinyWheel.set(-1);
       }
       else {
    	   leftSpinyWheel.set(0);
       rightSpinyWheel.set(0);
       }
       
       if (xbox.getRawButton(2)) {        //pushes in
    	   leftSpinyWheel.set(-1/5);
    	   rightSpinyWheel.set(1/5);
       }
       else {
       leftSpinyWheel.set(0);
       rightSpinyWheel.set(0);
       }
       
       if (xbox.getRawButton(3)) {       //turns counter-clockwise
    	   leftSpinyWheel.set(1);
    	   rightSpinyWheel.set(1);
       }
       else {
    	   leftSpinyWheel.set(0);
       rightSpinyWheel.set(0);
       }
       */
            Timer.delay(0.01);		// wait for a motor update time      
} 
    }
    
}    
   /* 
    public void autonomous() {
    	
    	while(isEnabled()==true){
    		
       rightWheel.set(.5);
       leftWheel.set(.5);// drive forwards half speed
        
       Timer.delay(2.0);		//    for 2 seconds        
    }
    	rightWheel.set(0);     //stops robot
    	leftWheel.set(0);
    }
} */