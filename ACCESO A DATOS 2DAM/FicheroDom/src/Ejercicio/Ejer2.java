package Ejercicio;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;
import org.xml.sax.SAXException;

public class Ejer2 {

    public static void main(String[] args) throws SAXException, IOException,ParserConfigurationException {
    	//Configurar el entorno para el procesamiento de XML:
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder loader = factory.newDocumentBuilder();
        Document document = loader.parse("continents.xml");
        //Obtener un objeto DocumentTraversal para el documento XML:
        DocumentTraversal traversal = (DocumentTraversal) document;
        /*Crear un TreeWalker para recorrer el documento XML.
         *El TreeWalker se inicia en el elemento raíz del documento y filtra tanto elementos como contenido de texto:
         */
        TreeWalker walker = traversal.createTreeWalker(
                document.getDocumentElement(),
                NodeFilter.SHOW_ELEMENT | NodeFilter.SHOW_TEXT, null, true);
        /*Llamar a la función traverseLevel para comenzar el recorrido del documento,
         *pasando el TreeWalker y una cadena vacía como indentación inicial:
         */
        traverseLevel(walker, "");
    }

    /*La función traverseLevel recibe el TreeWalker y la cadena de indentación como parámetros.
     *Dentro de esta función, se obtiene el nodo actual del TreeWalker.
     */
    private static void traverseLevel(TreeWalker walker,
            String indent) {

        Node node = walker.getCurrentNode();
        //Si el nodo es de tipo ELEMENT_NODE, se imprime el nombre del elemento.
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(indent + node.getNodeName());
        }
        //Si el nodo es de tipo TEXT_NODE, se recorta y muestra el contenido de texto.
        if (node.getNodeType() == Node.TEXT_NODE) {

            String content_trimmed = node.getTextContent().trim();

            if (content_trimmed.length() > 0) {
                System.out.print(indent);
                System.out.printf("%s%n", content_trimmed);
            }
        }
        /*Luego, se realiza una llamada recursiva a traverseLevel para recorrer los hijos 
         *del nodo actual con una indentación aumentada en dos espacios.
         */
        for (Node n = walker.firstChild(); n != null;
                n = walker.nextSibling()) {

            traverseLevel(walker, indent + "  ");
        }
        //Finalmente, se restablece el nodo actual del TreeWalker al nodo original para garantizar un recorrido adecuado.
        walker.setCurrentNode(node);
    }
}