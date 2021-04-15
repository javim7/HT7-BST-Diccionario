import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class prueba {
    public static void main(String[] args) {

        //creando instancias
        Scanner leer = new Scanner(System.in);

        //creando la listas para tener los diccionarios
        ArrayList<Association> listaIE = new ArrayList();
        ArrayList<Association> listaIF = new ArrayList();

        ArrayList<Association> listaEI = new ArrayList();
        ArrayList<Association> listaEF = new ArrayList();

        ArrayList<Association> listaFI = new ArrayList();
        ArrayList<Association> listaFE = new ArrayList();

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

        BinaryTree<Association> diccionarioIng1 = new BinaryTree<Association>(listaIE.get(0));

        for (int n = 0; n < listaIE.size(); n++) {
            if ((n+1) < listaIE.size()) {
                BinaryTree<Association> btSiguiente = new BinaryTree<>(listaIE.get(n+1));
                agregar(diccionarioIng1, btSiguiente);
            }
        }

        System.out.println(diccionarioIng1);

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