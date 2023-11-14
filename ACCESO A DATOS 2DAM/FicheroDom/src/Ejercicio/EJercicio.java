package Ejercicio;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EJercicio {

	public static void main(String[] args) throws SAXException,
        IOException, ParserConfigurationException {
		//Crear un objeto "File" que representa el archivo XML "users.xml":
	    File xmlFile = new File("users.xml");
	    //Imprimir la ruta absoluta del archivo XML:
	    System.out.println(xmlFile.getAbsoluteFile());
	    //Configurar el entorno para el procesamiento de XML:
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = factory.newDocumentBuilder();
	    Document doc = dBuilder.parse(xmlFile);
	    doc.getDocumentElement().normalize();
	    //Obtener una lista de nodos "user" del archivo XML:
	    NodeList nList = doc.getElementsByTagName("user");
	    //Iterar a través de la lista de nodos "user" y extraer información de cada usuario:
	    for (int i = 0; i < nList.getLength(); i++) {
	
	        Node nNode = nList.item(i);
	
	        System.out.println();

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element elem = (Element) nNode;
            //Extraer información del usuario (id, firstname, lastname y occupation)
            String uid = elem.getAttribute("id");

            Node node1 = elem.getElementsByTagName("firstname").item(0);
            String fname = node1.getTextContent();

            Node node2 = elem.getElementsByTagName("lastname").item(0);
            String lname = node2.getTextContent();

            Node node3 = elem.getElementsByTagName("occupation").item(0);
            String occup = node3.getTextContent();
            //Mostrar info del .xml
            System.out.printf("User id: %s%n", uid);
            System.out.printf("First name: %s%n", fname);
            System.out.printf("Last name: %s%n", lname);
            System.out.printf("Occupation: %s%n", occup);
        }
    }
}
}

	


