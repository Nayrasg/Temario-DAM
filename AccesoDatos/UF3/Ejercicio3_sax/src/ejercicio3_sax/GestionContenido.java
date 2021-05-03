/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3_sax;

import jdk.internal.org.xml.sax.Attributes;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Nayra
 */
public class GestionContenido extends DefaultHandler {
    public GestionContenido()
        {
            super();
        }
    @Override
        public void startDocument()
        {
            System.out.println("Comienzo del documento XML");
        }
        @Override
        public void endDocument()
        {
            System.out.println("Final del documento XML");
        }
       @Override
       public void startElement(String uri, String nombre, String nombreC, org.xml.sax.Attributes atrbts) throws SAXException 
        {
            System.out.printf("\t Principio Elemento: %s %n", nombre);
            
        }
        @Override
        public void endElement(String uri, String nombre, String nombreC)
        {
            System.out.printf("\t Fin Elemento: %s %n", nombre);
        }
    @Override
        public void characters(char[] ch, int inicio, int longitud)
        {
            String car=new String(ch, inicio, longitud);
            //quitar saltos de línea
            car=car.replaceAll("[\t\n]", "");
            System.out.printf("\t Caracteres: %s %n", car);
        }
    
}
