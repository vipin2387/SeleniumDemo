package jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TestName")
public class constructorDemo {

	private String empId,empLocation,empName;
	private int empLevel;
	
	@XmlElement
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	@XmlElement
	public String getEmpLocation() {
		return empLocation;
	}
	
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	
	@XmlElement
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@XmlElement
	public int getEmpLevel() {
		return empLevel;
	}
	
	public void setEmpLevel(int empLevel) {
		this.empLevel = empLevel;
	}
	
	
	
	public constructorDemo(String empId, String empLocation, String empName, int empLevel) {
		super();
		this.empId = empId;
		this.empLocation = empLocation;
		this.empName = empName;
		this.empLevel = empLevel;
	}

	public constructorDemo() {
		super();
	}
	
}
