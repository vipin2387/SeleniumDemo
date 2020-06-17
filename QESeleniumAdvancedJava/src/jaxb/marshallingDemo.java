package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class marshallingDemo {
	
	public void marshall() throws JAXBException {
		
		constructorDemo cDemo = new constructorDemo("AB12345","MDC5C","Rahul Arora",8);
		JAXBContext jaxbc = JAXBContext.newInstance(constructorDemo.class);
		Marshaller mar = jaxbc.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mar.marshal(cDemo, System.out);
		mar.marshal(cDemo, new File("src\\jaxb\\newJaxbDemo.xml"));
	
	}

}
