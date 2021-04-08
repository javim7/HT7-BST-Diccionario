//importando clases externas
import java.util.*; 
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/***************************************
 * @author Javier Mombiela 20067
 * 
 * Clase Main, funcionamiento del programa.
 ***************************************/
public class Main {


    /** 
     * @param args
     * Metodo utilizado para controlar el programa
     */
    public static void main(String[] args) {

        //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try{

            //creando variables
            File archivoTexto = new File("diccionario.txt"); //creando nuestro nuevo archivo

            Scanner scan = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            while(scan.hasNextLine()) { //while para que se lean todas las lineas en el archivo

                String linea = scan.nextLine(); //guardando los elementos (de cada linea) como variables
                
                //imprimiendo
                System.out.println(linea); //imprimiendo las lineas

            }

            //se hace un catch por si el archivo no se puede leer
        } catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("\nEl archivo de texto diccionario.txt no ha sido encontrado.\n");
        }

        
    }
}