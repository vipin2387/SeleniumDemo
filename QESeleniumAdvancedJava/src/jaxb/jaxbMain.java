package jaxb;

import javax.xml.bind.JAXBException;

public class jaxbMain {

	public static void main(String[] args) throws JAXBException {
		
		unMarshallingDemo umd = new unMarshallingDemo();
		umd.unmarshal();
		
		marshallingDemo md = new marshallingDemo();
		md.marshall();

	}

}
