package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class unMarshallingDemo {

	public void unmarshal() throws JAXBException {
		JAXBContext TestJCUm=JAXBContext.newInstance(constructorDemo.class);        
		Unmarshaller TestUMS=TestJCUm.createUnmarshaller();		        
		constructorDemo TestObj1 = (constructorDemo)TestUMS.unmarshal(new File("src\\jaxb\\demo.xml"));
		        
		System.out.println("Employee Details are: ");
		System.out.println(TestObj1.getEmpId());
		System.out.println(TestObj1.getEmpName());
		System.out.println(TestObj1.getEmpLevel());
		System.out.println(TestObj1.getEmpLocation());
	}
	
}
