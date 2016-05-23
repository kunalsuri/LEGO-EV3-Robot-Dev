/*
 *  Author: KUNAL SURI
 */

package org.lejos.ev3.remote.api.example;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.lejos.ev3.remote.api.example.implementation.EV3LeJOSAPI;


@Path("/ev3/motor-d/degree-of-rotation/")
public class RunEV3Motor {

	@GET
	@Produces("application/xml")
	public String defaultMotorExecution(){

		String port ="D";
		int motorSpeed = 300; 
		int rotation_degree = 360;
		EV3LeJOSAPI moveEv3Motor = new EV3LeJOSAPI();
		try {
			moveEv3Motor.runEV3Motor(port, motorSpeed ,rotation_degree);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "@Produces(\"application/xml\") Output: \n\n EV3 Robot Motor Executed Successfully!";
		return "<EV3Service>" + "<EV3ServiceResponse>" + result + "</EV3ServiceResponse>" + "</EV3Service>";

	}

	@Path("{rotationDegree}")
	@GET
	@Produces("application/xml")
	public String runEV3RobotMotor(@PathParam("rotationDegree") int rotation_degree) {

		String port ="D";
		int motorSpeed = 300; 
		EV3LeJOSAPI moveEv3Motor = new EV3LeJOSAPI();
		try {
			moveEv3Motor.runEV3Motor(port, motorSpeed, rotation_degree);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "@Produces(\"application/xml\") Output: \n\n EV3 Robot Motor Executed Successfully with " + rotation_degree + " degree of rotation";
		return "<EV3Service>" + "<EV3ServiceResponse>" + result + "</EV3ServiceResponse>" + "</EV3Service>";

	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		RunEV3Motor obj = new RunEV3Motor();
		System.out.println(obj.runEV3RobotMotor(360));
	}

}
