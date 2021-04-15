//importando clases
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;


/***************************************
 * @author Javier Mombiela 20067
 * 
 * Clase Main, funcionamiento del programa
 * se encarga de leer el archivo y ordenar
 * todo.
 ***************************************/
public class prueba {
    public static void main(String[] args) {

        //creando instancias
        //Scanner leer = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        //creando la listas para tener los diccionarios
        ArrayList<Association> listaIE = new ArrayList();
        ArrayList<Association> listaIF = new ArrayList();

        ArrayList<Association> listaEI = new ArrayList();
        ArrayList<Association> listaEF = new ArrayList();

        ArrayList<Association> listaFI = new ArrayList();
        ArrayList<Association> listaFE = new ArrayList();

        ArrayList<String> opciones = new ArrayList<>();

        //Para leer el archivo
        ArrayList<String> archivo = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(
                    Paths.get("diccionario.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(archivo::add);

        } catch (IOException e ){
            System.out.println("No se ha encontrado el archivo!");
        }

        for (String linea : archivo) {

            ArrayList<String> traduc = new ArrayList();

            for (String palabra : linea.split(",")) {
                traduc.add(palabra);
            }

            //creando diccionarios de ingles
            listaIE.add(new Association<String, String>(traduc.get(0).toLowerCase(), traduc.get(1).toLowerCase()));
            listaIF.add(new Association<String, String>(traduc.get(0).toLowerCase(), traduc.get(2).toLowerCase()));

            //creando diccionarios de espanol
            listaEI.add(new Association<String, String>(traduc.get(1).toLowerCase(), traduc.get(0).toLowerCase()));
            listaEF.add(new Association<String, String>(traduc.get(1).toLowerCase(), traduc.get(2).toLowerCase()));

             //creando diccionarios de espanol
             listaFI.add(new Association<String, String>(traduc.get(2).toLowerCase(), traduc.get(0).toLowerCase()));
             listaFE.add(new Association<String, String>(traduc.get(2).toLowerCase(), traduc.get(1).toLowerCase()));

        }

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

        //creando una lista vacia para poder cambiarle el valor dependiendo de que traduccion se quiera
        ArrayList<Association> queLista = new ArrayList<>();

        //viendo cual es la traduccion final
        if(idiom1.equals("Ingles") && idiom2.equals("Español")) {
            queLista = listaIE;
        } else if(idiom1.equals("Ingles") && idiom2.equals("Frances")) {
            queLista = listaIF;
        }  else if(idiom1.equals("Español") && idiom2.equals("Ingles")) {
            queLista = listaEI;
        } else if(idiom1.equals("Español") && idiom2.equals("Frances")) {
            queLista = listaEF;
        } else if(idiom1.equals("Frances") && idiom2.equals("Ingles")) {
            queLista = listaFI;
        } else if(idiom1.equals("Frances") && idiom2.equals("Español")) {
            queLista = listaFE;
        } 

        //creando la instancia del arbol con el diccionario y la lista que sean necesarios
        BinaryTree<Association> elDiccionario = new BinaryTree<Association>(queLista.get(0));

        //for para agregar el diccionario al arbol
        for (int n = 0; n < queLista.size(); n++) {
            if ((n+1) < queLista.size()) {
                BinaryTree<Association> btSiguiente = new BinaryTree<>(queLista.get(n+1));
                agregar(elDiccionario, btSiguiente);
            }
        }

        //agregando arbol in ordcer
        elDiccionario.inOrder(elDiccionario);
        System.out.println("\n------Diccionario------");
        System.out.println(elDiccionario.inOrder(elDiccionario));


         //Leyendo el archivo
         System.out.println();
         System.out.println("------Texto ingresado------");
         archivo = new ArrayList<>();

         //haciendo try catch para asegurar que si se encuentre el archivo
         try {
             Stream<String> lines = Files.lines(
                     Paths.get("texto.txt"),
                     StandardCharsets.UTF_8
             );
             lines.forEach(archivo::add);

         } catch (IOException e ){
             System.out.println("Ha ocurrido un error");
         }

         //haciendo la traduccion
         String traduccion = "";
        for (String linea : archivo) {
            //quitandole los puntos a la oracion
            System.out.println(linea);
            String lineaClean = linea.replaceAll("\\.","");

            for (String palabra : lineaClean.trim().split("\\s+")) {

                //if para ver si la palabra esta en el diccionario o no 
                //para ver si se le agregan los asteriscos.
                if (elDiccionario.buscar(palabra) == null) {
                    traduccion += "*"+palabra+"* ";
                } else {
                    traduccion += elDiccionario.buscar(palabra) + " ";
                }
            }
            traduccion += "\n";
        }

        //imprimir el resultado final de la traduccion
        System.out.println("\n------Traduccion------");
        System.out.println(traduccion+"\n");
        scanner.close();

    }


    public static void agregar(BinaryTree btActual, BinaryTree btSiguiente) {

        if (btActual.value().toString().compareTo(btSiguiente.value().toString()) > 0) {
            if (btActual.left().value() == null) {
                btActual.setLeft(btSiguiente);
            } else {
                agregar(btActual.left(), btSiguiente);
            }
        } else if (btActual.value().toString().compareTo(btSiguiente.value().toString()) < 0) {
            if (btActual.right().value() == null) {
                btActual.setRight(btSiguiente);
            } else {
                agregar(btActual.right(), btSiguiente);
            }
        }

    }
}