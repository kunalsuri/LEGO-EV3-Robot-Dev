/*
 * Author: KUNAL SURI
 * 
 */

package org.lejos.ev3.implementation;

import lejos.hardware.Sound;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;


public class EV3LeJOSAPI {

	public EV3LeJOSAPI()
	{

	} 

	RMIRegulatedMotor motor ;

	/*
	 * To create a remote connection to EV3 running LEJOS
	 */
	public RemoteEV3 getEV3Connection() throws RemoteException, MalformedURLException, NotBoundException
	{
		RemoteEV3 ev3 = new RemoteEV3("10.0.1.1");
		return ev3;
	}

	/*
	 * To Create Motors
	 */
	public void getCreatedMotors(String port) throws RemoteException, MalformedURLException, NotBoundException{

		RemoteEV3 ev3 = getEV3Connection(); // Connect to Remote EV3
		ev3.getPort(port); 					// Get the Ports and Create the Motors
		if (motor==null){ motor =ev3.createRegulatedMotor(port,'L');}

	}

	/*
	 * To run the Motor of the EV3 robot with a specific degree of rotation
	 * The Motor should be plugged into one of the Port {A,B,C or D}
	 * In general, Motor Speed = 360 degree/second
	 * 
	 */
	public void runEV3Motor(String port, int motorSpeed, int rotation_degree) throws RemoteException, MalformedURLException, NotBoundException{

		System.out.println("Start Running EV3 Robot Motor...");
		getCreatedMotors(port); 			
		Sound.beepSequenceUp();
		motor.setSpeed(motorSpeed);
		motor.rotate(rotation_degree);		
		motor.stop(true);
		motor.close();
		System.out.println("End Running EV3 Robot Motor...");
	}


	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException 
	{
		EV3LeJOSAPI moveev3 = new EV3LeJOSAPI();
		moveev3.runEV3Motor("D", 300 ,720);
		//moveev3.runCarFactoryBeltEV3("D", 300 ,720);
	}

}
