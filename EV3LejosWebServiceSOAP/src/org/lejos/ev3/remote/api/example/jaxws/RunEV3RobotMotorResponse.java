
package org.lejos.ev3.remote.api.example.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.5
 * Mon May 23 18:43:46 CEST 2016
 * Generated source version: 3.1.5
 */

@XmlRootElement(name = "runEV3RobotMotorResponse", namespace = "http://example.api.remote.ev3.lejos.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "runEV3RobotMotorResponse", namespace = "http://example.api.remote.ev3.lejos.org/")

public class RunEV3RobotMotorResponse {

    @XmlElement(name = "returnString")
    private java.lang.String returnString;

    public java.lang.String getReturnString() {
        return this.returnString;
    }

    public void setReturnString(java.lang.String newReturnString)  {
        this.returnString = newReturnString;
    }

}

