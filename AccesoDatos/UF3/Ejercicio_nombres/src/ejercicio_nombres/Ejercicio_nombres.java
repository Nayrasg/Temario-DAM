/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_nombres;

import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;


/**
 *
 * @author Nayra
 */
public class Ejercicio_nombres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        // TODO code application logic here
        
        String op="s";
        
        Scanner teclado = new Scanner(System.in);
        
        //cremos la instancia para crear el documento
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //creamo el documento xml vacío
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Personas", null);
        document.setXmlVersion("1.0");
        
        
        
        do //hacemos mientras la respuesta sea s
        {
            Element raiz = document.createElement("persona"); //nodo persona
            document.getDocumentElement().appendChild(raiz);
        
            System.out.println("Introduzca un nombre: "); //pedimos el nombre
            String nombre = teclado.nextLine();
            CrearElemento("nombre", nombre, raiz, document); //añadimos nombre
            System.out.println("Introduzca el apellido: ");
            String apellido = teclado.nextLine();
            CrearElemento("apellido", apellido, raiz, document); //añadimos apellido
            System.out.println("¿Desea añadir otro nombre? [s/n] ");
            op=teclado.nextLine();
            
        }while (op.equals("s"));
        
        //Creamos la fuente del xml
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("personas.xml"));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        
    }
    
    //insertar datos de personas
    static void CrearElemento(String persona, String valor, Element raiz, Document document)
    {
        Element elem = document.createElement(persona);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la tauz
        elem.appendChild(text); //pegamos el valor
    }
    
    
}
