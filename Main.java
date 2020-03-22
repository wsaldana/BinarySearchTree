/**
 * Universidad del Valle de Guatemala Algoritmos y Estructuras de Datos
 * 
 * @author Walter Saldaña #19897
 * @since 21 de marzo del 2020
 * 
 * Modelo de traductor Inglés-Español implementado en un Binary Search Tree
 */

import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("####### - BIENVENIDO AL TRADUCTOR - #######");
        System.out.println("INGERSE LA RUTA A UN DICCIONARIO EN UN ARCHIVO .txt EN FORMATO (ingles, espanol)");
        String archivo = sc.nextLine();
        

        System.out.println("INGERSE LA RUTA A LA ORACION QUE DESEA TRADUCIR EN UN ARCHIVO .txt");
        String oracion = sc.nextLine();

        Translator traductor = new Translator(archivo, oracion);
        traductor.agregarDiccionario();
        System.out.println(traductor.traducir());
    }
}