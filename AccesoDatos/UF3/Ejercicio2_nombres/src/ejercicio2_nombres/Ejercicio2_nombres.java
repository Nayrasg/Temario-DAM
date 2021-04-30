/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_nombres;

import java.io.*;
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
public class Ejercicio2_nombres {

    /**
     * @param args the command line arguments
     * @throws javax.xml.transform.TransformerException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {
        // TODO code application logic here
        String op="s";
        int opcion;
        
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        
        //cremos la instancia para crear el documento
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //creamo el documento xml vacío
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Personas", null);
        document.setXmlVersion("1.0");
        
        
        
       do
       {
                    //menu
                System.out.println("----------------------------------------");
                System.out.println("| 1. Introducir nombres en el fichero  |");
                System.out.println("| 2. Leer nombres del fcihero.         |");
                System.out.println("| 3. Salir.                            |");
                System.out.println("----------------------------------------");
                System.out.println("Introduzca una opción: ");
                opcion = teclado2.nextInt(); //pedimos una opcion

                switch (opcion)
                {
                    case 1:

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
                        break;

                    case 2:

                        factory = DocumentBuilderFactory.newInstance();

                        try
                        {
                            builder = factory.newDocumentBuilder();
                            document = builder.parse(new File("personas.xml"));
                            document.getDocumentElement().normalize();

                            System.out.printf("Elemento raiz: %s %n ", document.getDocumentElement().getNodeName());

                            //crea una lista con todos los nodos persona
                            NodeList personas = document.getElementsByTagName("persona");
                            System.out.printf("Nodos empleados a recorrer: %d %n", personas.getLength());

                            //recorres la lista

                            for(int i = 0; i < personas.getLength(); i ++)
                            {
                                //obtener un nodo persona
                                Node perso = personas.item(i); 
                                //tipo de nodo
                                if (perso.getNodeType() == Node.ELEMENT_NODE)
                                {
                                    //obtener los elemntos del nodo
                                    Element elemento = (Element) perso;
                                    System.out.printf(" * Nombre = %s %n", elemento.getElementsByTagName("nombre").item(0).getTextContent());       
                                    System.out.printf(" * Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
                                }
                            }


                        } catch (Exception e)
                        {e.printStackTrace();}
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Opción no válida");


                 }
       }while(opcion!=3);
        
        
    }
    
    //insertar datos de personas
    static void CrearElemento(String datoPerso, String valor, Element raiz, Document document)
    {
        Element elem = document.createElement(datoPerso);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la tauz
        elem.appendChild(text); //pegamos el valor
    }
    
}
