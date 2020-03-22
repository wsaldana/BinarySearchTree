/**
 * @author Walter Saldaña #19897
 * Clase que traduce una oracion
 */

import java.io.File;
import java.io.*; 

public class Translator{

    private String diccionario;
    private String oracion;
    private BinarySearchTree<Association<String>> bst;

    /**
     * Constructor sin parametros
     */
    public Translator(){}

    /**
     * Constructor con parametros
     * @param diccionario
     * @param oracion
     */
    public Translator(String diccionario, String oracion){
        this.diccionario = leer(diccionario);
        this.oracion = leer(oracion);
        this.bst = new BinarySearchTree<Association<String>>();
    }

    /**
     * Agrega una definicion al diccionario
     */
    public void agregarDiccionario(String diccionario){
        String[] asociaciones = diccionario.split("\n");
        for(int i=0; i<asociaciones.length; i++){
            String[] traduccion = asociaciones[i].replace("(","").replace(")","").split(", ");
            Association<String> as = new Association<String>(traduccion[0], traduccion[1]);
            this.bst.add(as);
        }
    }

    /**
     * Agregar diccionario sin parametros
     */
    public void agregarDiccionario(){
        agregarDiccionario(this.diccionario);
    }

    public String recorrer(){
        return this.bst.toString();
    }


    /**
     * @param oracion texto que se va a traducir
     * @return Traduccion de una oracion
     */
    public String traducir(String oracion){
        String[] palabras = oracion.split(" ");
        String traduccion = "";
        for(int i=0; i<palabras.length; i++){
            Association<String> asociacion = new Association<String>(palabras[i], null);
            if(this.bst.contains(asociacion)){
                traduccion += this.bst.get(asociacion).getEspanol() + " ";
            }else{
                traduccion += "*" + palabras[i] + "* ";
            }
        }
        return traduccion;
    }

    /**
     * traduccion sin parametros
     */
    public String traducir(){
        return traducir(this.oracion);
    }

    /**
     * Metodo para leer archivos ed texto
     * @param archivo ruta local del archivo
     * @return Cadena de texto que contiene el archivo
     */
    public String leer(String archivo){
        BufferedReader reader = null;
        String cad = "";
        try {
            String line;
            File file = new File(archivo);
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                cad += line+"\n";
            }
        
        } catch (IOException e) {
            System.out.println("Ingrese la direccion a un archivo valido");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cad.substring(0, cad.length()-2);
    }
    
}