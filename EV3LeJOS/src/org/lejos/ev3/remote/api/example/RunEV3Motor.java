/*
 *  Author: KUNAL SURI
 */

package org.lejos.ev3.remote.api.example;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.lejos.ev3.remote.api.example.implementation.EV3LeJOSAPI;

public class RunEV3Motor {

	public String runEV3RobotMotor(   String port,  int motorSpeed,  int rotation_degree) throws RemoteException, MalformedURLException, NotBoundException {
		EV3LeJOSAPI moveEv3Motor = new EV3LeJOSAPI();
		moveEv3Motor.runEV3Motor(port, motorSpeed ,rotation_degree);
		String returnValue = "EV3 Robot motor ran successfully";
		return returnValue;
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		RunEV3Motor obj = new RunEV3Motor();
		System.out.println(obj.runEV3RobotMotor("A",300,360));
	}

}
