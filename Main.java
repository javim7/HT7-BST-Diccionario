//importando clases externas
import java.util.*; 
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/***************************************
 * @author Javier Mombiela 20067
 * 
 * Clase Main, funcionamiento del programa
 * se encarga de leer el archivo y ordenar
 * todo.
 ***************************************/
public class Main {


    /** 
     * @param args
     * Metodo utilizado para controlar el programa
     */
    public static void main(String[] args) {

        //creando instancias
        ArrayList<Association> diccionario = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        BinaryTree miArbol = new BinaryTree();
       //Association diccionarioIng1;
        //Association diccionarioIng2;

        //creando variables
        String ing = null, esp=null, fra=null;
        ArrayList<String> opciones = new ArrayList<>();

        //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try{

            //creando variables
            File archivoTexto = new File("diccionario.txt"); //creando nuestro nuevo archivo

            Scanner scan = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            while(scan.hasNextLine()) { //while para que se lean todas las lineas en el archivo


                String linea = scan.nextLine(); //guardando los elementos (de cada linea) como variables
                //separando los elementos por sus comas
                String[] separar = linea.split(",");

                //guardando cada lenguaje en variables
                ing = separar[0];
                esp = separar[1];
                fra = separar[2];

                //creando los diccionarios en ingles
                Association diccionarioIng1 = new Association<>(ing, esp);
                Association diccionarioIng2 = new Association<>(ing, fra);

                //creando los diccionarios en espanol
                Association diccionarioEsp1 = new Association<>(esp, ing);
                Association diccionarioEsp2 = new Association<>(esp, fra);

                //creando los diccionarios en frances
                Association diccionarioFra1 = new Association<>(fra, ing);
                Association diccionarioFra2 = new Association<>(fra, esp);

                //System.out.println(diccionarioIng1);
                //System.out.println(ing + " " +esp +" " + fra); //imprimiendo las lineas

            }

            //se hace un catch por si el archivo no se puede leer
        } catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("\nEl archivo de texto diccionario.txt no ha sido encontrado.\n");
        }

        //creando los diccionarios en ingles
        //diccionarioIng1 = new Association<>(ing, esp);
        //diccionarioIng2 = new Association<>(ing, fra);


        //agregando las opciones al arraylist
        opciones.add("Ingles");
        opciones.add("Español");
        opciones.add("Frances");

        //pidiendo al usuario que ingrese el idioma que quiere traducir
        System.out.println("\nQue idioma es el que desea traducir?");

        //imprimiendo las tres opciones
        for(int i=0;i<opciones.size();i++){
            int op = i+1;
            System.out.println(op + " " + opciones.get(i));
        }

        //creando la variable del primer idioma
        int idioma1;

        //creando un try catch para asegurar que se ingrese una opcion correcta entre 1 y 3
        while(true){
            try{
                System.out.print("Opcion: ");
                idioma1 = scanner.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a tres, seguirá pidiendo la opción. 
                if(idioma1 > 3 || idioma1 < 1){
                    System.out.println("Opcion incorrecta, intenta de nuevo..");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                scanner.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        }  

        //if para ver que idioma sacar de la lista
        String idiom1 = "";
        if(idioma1==1) {
            idiom1 = "Ingles";
            opciones.remove(0);
        } 
        else if(idioma1==2) {
            idiom1 = "Español";
            opciones.remove(1);
        } 
        else if(idioma1==3) {
            idiom1 = "Frances";
            opciones.remove(2);
        }
        //System.out.println(idiom1);

        //viendo a que idioma quiere traducir el usuario
        System.out.println("\nA que idioma quiere traducir su texto?");

        //imprimiendo las opciones restantes
        for(int i=0;i<opciones.size();i++){
            int op = i+1;
            System.out.println(op + " " + opciones.get(i));
        }

          //creando la variable del primer idioma
          int idioma2;

          //creando un try catch para asegurar que se ingrese una opcion correcta entre 1 y 3
          while(true){
              try{
                  System.out.print("Opcion: ");
                  idioma2 = scanner.nextInt();
                  //(Programación defensiva)
                  //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                  if(idioma2 > 2 || idioma2 < 1){
                      System.out.println("Opcion incorrecta, intenta de nuevo..");
                  }
                  //Si el usuario ingresa los datos correctos terminará el ciclo while
                  else{break;}
              }
              //Si el usuario ingresa una letra regresará un mensaje de error. 
              catch(Exception o){
                  scanner.nextLine();
                  System.out.println("Caracter invalido! Intenta de nuevo..");
              }
          }  

          //if para ver que idioma se selecciono
          String idiom2 = "";
          if(opciones.contains("Ingles") && opciones.contains("Español") && idioma2==1){idiom2="Ingles";}
          if(opciones.contains("Ingles") && opciones.contains("Frances") && idioma2==1){idiom2="Ingles";}
          if(opciones.contains("Ingles") && opciones.contains("Español") && idioma2==2){idiom2="Español";}
          if(opciones.contains("Ingles") && opciones.contains("Frances") && idioma2==2){idiom2="Frances";}
          if(opciones.contains("Español") && opciones.contains("Frances") && idioma2==1){idiom2="Español";}
          if(opciones.contains("Español") && opciones.contains("Frances") && idioma2==2){idiom2="Frances";}
          //System.out.println(idiom2);


           //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try{

            //creando variables
            File archivoTexto = new File("texto.txt"); //creando nuestro nuevo archivo

            Scanner scan = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            while(scan.hasNextLine()) { //while para que se lean todas las lineas en el archivo


                String linea = scan.nextLine(); //guardando los elementos (de cada linea) como variables
               
                //System.out.println(linea); //imprimiendo las lineas
            }

            //se hace un catch por si el archivo no se puede leer
        } catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("\nEl archivo de texto texto.txt no ha sido encontrado.\n");
        }

        
        
    }
}