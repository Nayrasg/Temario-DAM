/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3_sax;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 *
 * @author Nayra
 */
public class Ejercicio3_sax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
        // TODO code application logic here
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor= new GestionContenido(); //clase que realiza la lectura
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("personas.xml");
        procesadorXML.parse(fileXML); 
    }
    
   /* class GestionContenido extends DefaultHandler
    {
        public GestionContenido()
        {
            super();
        }
        public void starDocument()
        {
            System.out.println("Comienzo del documento XML");
        }
        @Override
        public void endDocument()
        {
            System.out.println("Final del documento XML");
        }
        public void startElement(String uri, String nombre, String nombreC, Attributes atts)
        {
            System.out.printf("\t Principio Elemento: %s %n", nombre);
        }
        @Override
        public void endElement(String uri, String nombre, String nombreC)
        {
            System.out.printf("\t Fin Elemento: %s %n", nombre);
        }
        public void characters(char[] ch, int inicio, int longitud)
        {
            String car=new String(ch, inicio, longitud);
            //quitar saltos de línea
            car=car.replaceAll("[\t\n]", "");
            System.out.printf("\t Caracteres: %s %n", car);
        }
    }*/
}
