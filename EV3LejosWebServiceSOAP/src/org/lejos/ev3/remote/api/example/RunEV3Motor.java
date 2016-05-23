/*
 *  Author: KUNAL SURI
 */

package org.lejos.ev3.remote.api.example;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.lejos.ev3.remote.api.example.implementation.EV3LeJOSAPI;

@WebService(targetNamespace = "http://example.api.remote.ev3.lejos.org/", portName = "RunEV3MotorPort", serviceName = "RunEV3MotorService")
public class RunEV3Motor {

	@WebMethod(operationName = "runEV3RobotMotor", action = "urn:RunEV3RobotMotor")
	@RequestWrapper(className = "org.lejos.ev3.remote.api.example.jaxws.RunEV3RobotMotor", localName = "runEV3RobotMotor", targetNamespace = "http://example.api.remote.ev3.lejos.org/")
	@ResponseWrapper(className = "org.lejos.ev3.remote.api.example.jaxws.RunEV3RobotMotorResponse", localName = "runEV3RobotMotorResponse", targetNamespace = "http://example.api.remote.ev3.lejos.org/")
	@WebResult(name = "returnString")
	public String runEV3RobotMotor(   @WebParam(name = "EV3Port") String port,  @WebParam(name = "EV3MotorSpeed") int motorSpeed,  @WebParam(name = "DegreeOfRotation") int rotation_degree) {
		EV3LeJOSAPI moveEv3Motor = new EV3LeJOSAPI();
		try {
			moveEv3Motor.runEV3Motor(port, motorSpeed ,rotation_degree);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String returnValue = "EV3 Robot motor ran successfully";
		return returnValue;
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		RunEV3Motor obj = new RunEV3Motor();
		System.out.println(obj.runEV3RobotMotor("A",300,360));
	}

}
