import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 *
 * @author Nayra
 */

public class cifrardescifrar {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto;
        int codigo;
        char opcion;
        boolean salir = false;
        
        Scanner sn = new Scanner(System.in);
        
        
        
        while (!salir) //pedimos opciones mientras no sea salir=true
        {
           System.out.println("1. Cifrar texto");
           System.out.println("2. Descifrar texto");
           System.out.println("3. Salir");

           try
           {
           
                System.out.println("Elige una opción:");
                opcion = (char) sn.nextInt();
               
        
                //usamos switch para cada opción
                switch(opcion)
                {
                    case 1: //si elegimos cifrar
                        
                            System.out.println("Has seleccioando cifrar");
                             do { 
                                    System.out.print("Introduce un texto: ");
                                    texto = sc.nextLine();
                             } while (texto.isEmpty()); //si se deja el texto en blanco volvemos a pedir el texto
                                //Introducir el valor del desplazamiento
                                 do {
                                     System.out.print("Introduce el código: ");
                                      codigo = sc.nextInt();
                               } while (codigo < 1); //si el codigo es menos que 1 volvemos a pedir el codigo
                            
                                 
                                 System.out.println("Texto cifrado: " + cifrar(texto, codigo)); //llama a cifrar y muestra el texto cifrado
                            
                            break;
                    case 2: //si elegimos descifrar
                          
                             do { 
                                    System.out.print("Introduce un texto: ");
                                    texto = sc.nextLine();
                              } while (texto.isEmpty()); //si se deja el texto en blanco volvemos a pedir el texto
                                //Introducir el valor del desplazamiento
                              do {
                                    System.out.print("Introduce el código: ");
                                    codigo = sc.nextInt();
                               } while (codigo < 1); //si el codigo es menos que 1 volvemos a pedir el codigo


                            System.out.println("Has seleccioando descifrar");
                            System.out.println("Texto descifrado: " + descifrar(texto, codigo)); //lamamos descifrar y muestra el texto descifrado
                         
                            break;
                    case 3:
                            salir=true; //si elegimos salir convertimos salir en true y salimos del bucle
                            break;
                    default:
                            System.out.println("El número no es correto"); //si introduccimos otro numero
                }
           } catch (InputMismatchException e) //creamos un caso especial en caso de no introducir un número
           {
               System.out.println("Debes insertar un número");
               sn.next();
               
           }
        }
    }
    /*método para cifrar el texto. Sustituyo cada letra por otra n posiciones 
    adelante en abecedario. N es codigo*/
    
   
    public static String cifrar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) { //recorremos el texto
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') { //si son minusculas
                //se calcula la posición
                //si la posicion de letra más el codigo pasa de z vuelve al principio del abecedario (no se cuenta la ñ)
                //sino solo se suma codigo a las posiciones
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') { //lo mismo para mayusculas
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    /*método para descifrar el texto. Sustituyo cada letra por otra n posiciones 
    por detrás en abecedario. N es codigo*/

    /**
     *
     * @param texto
     * @param codigo
     * @return
     */
    public static String descifrar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder(); //creamos StringBuilder
        codigo = codigo % 26; //resto de codigo y 26
        for (int i = 0; i < texto.length(); i++) { //recorremos el texto
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') { //si es mayor o igual que a y z minisculas
                //según la posción 
                //si la posicion de la letra menos el codigo es antes de a vuelve al final del abecedario (no se cuenta la ñ)
                //sino solo se resta codigo a las posiciones
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') { //lo mismo para mayusculas
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString(); //devuelve la cadena decifrada
    }
} //Fin cifrado Cesar