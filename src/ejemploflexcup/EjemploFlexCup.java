/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ejemploflexcup;

import AST.Nodo;
import AST.dibujador;
import AST.error;
import Analizador.lenguaje.lexico;
import Analizador.lenguaje.sintactico;
import Ejecucion.ejecucion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erick
 */
public class EjemploFlexCup {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<error> todosErrores= new ArrayList();
    public static void main(String[] args) throws FileNotFoundException, Exception 
    {
        lexico scanner;
        sintactico parser;
        String pathArchivo = getPathActual()+ "\\entrada.txt";
        scanner=new lexico(new java.io.FileReader(pathArchivo));                                             
        parser = new sintactico(scanner);                              
        parser.parse();
        

        
        if(parser.listaErrores.isEmpty())
        {
            System.out.println("---------------------Cadena aceptada-----------------");
            dibujador dib = new dibujador();
            dib.generarGrafica(parser.raiz);
        }
        else
        {
            mostrarErrores(parser.listaErrores);        
        }        
        ejecutar(sintactico.raiz);       // Mandamos a ejecutar el AST  
    }
    
    public static void ejecutar(Nodo raiz)
    {
        ejecucion ejecutor = new ejecucion();
        ejecutor.ejecutar(raiz);
        ejecutor.erroresEjecucion.forEach((er) -> {
            todosErrores.add(er);
        });
        mostrarErrores(todosErrores);
        //mostrarSimbolos(ejecutor.tablaGlobal);
    }    
    
    
    
    
    
    public static void mostrarErrores(ArrayList<error> errores)
    {
      
        System.out.println("----------------------------------------ERRORES------------------------------------------");
        errores.forEach((error) -> 
        {
            System.out.println(                
                error.getTexto() + "\t" + 
                error.getDescripcion()+ "\t"+
                error.getLinea()+ "\t" +
                error.getColumna()+ "\t" +
                error.getTipo()) ;                               
        });
        System.out.println("----------------------------------------ERRORES------------------------------------------");
    }    
    
    public static String getPathActual(){
            String path="";
             File miDir = new File (".");
             try {
               //System.out.println (miDir.getCanonicalPath());
               path=miDir.getCanonicalPath();
             }
             catch(Exception e) 
             {
               e.printStackTrace();
             }
             return path;
        }     
}
