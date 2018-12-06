/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */


public class Simbolo 
{
    public String nombre;
    public String valor;
    public String tipo;    
    public String peso;
    public String rol;
    public boolean existe;
    public int linea=0;
    public int columna=0;

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
    
    //Como estructura
    boolean isStruct;
    Hashtable<String, Simbolo> atributos;
        
    //Como vector
    boolean isVector;
    ArrayList<String> arreglo;
    ArrayList<String> tipoVector;
    public int tamanoVector;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public boolean isIsStruct() {
        return isStruct;
    }

    public void setIsStruct(boolean isStruct) {
        this.isStruct = isStruct;
    }

    public Hashtable<String, Simbolo> getAtributos() {
        return atributos;
    }

    public void setAtributos(Hashtable<String, Simbolo> atributos) {
        this.atributos = atributos;
    }

    public boolean isIsVector() {
        return isVector;
    }

    public void setIsVector(boolean isVector) {
        this.isVector = isVector;
    }

    public ArrayList<String> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<String> arreglo) {
        this.arreglo = arreglo;
    }

    public ArrayList<String> getTipoVector() {
        return tipoVector;
    }

    public void setTipoVector(ArrayList<String> tipoVector) {
        this.tipoVector = tipoVector;
    }

    public int getTamanoVector() {
        return tamanoVector;
    }

    public void setTamanoVector(int tamanoVector) {
        this.tamanoVector = tamanoVector;
    }
    
    
    
    public Simbolo() {
        this.valor = "";
        this.tipo = "";
        this.nombre = "";
        this.rol = "";                              
        isStruct = false;
        atributos = null;        
        arreglo=new ArrayList<>();        
        tamanoVector=0;
        isVector=false;
        existe=false;
    }
    
    


    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "RedundantStringConstructorCall", "null"})
    protected Object clone()
    {
        Simbolo obj = null;
        try 
        {
            obj = (Simbolo) super.clone(); //To change body of generated methods, choose Tools | Templates.
        } catch (CloneNotSupportedException ex) 
        {
            Logger.getLogger(Simbolo.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.nombre = new String(nombre);
        obj.valor = new String(valor);
        obj.tipo = new String(tipo);
        obj.rol = new String(rol);        
        obj.isVector=new Boolean(isVector);
        obj.tipoVector=(ArrayList)tipoVector.clone();
        obj.arreglo=(ArrayList)(arreglo.clone());
        obj.tamanoVector=new Integer(tamanoVector);                
        obj.isStruct = new Boolean(isStruct);
        obj.existe=new Boolean(existe);        
        obj.atributos=(Hashtable)atributos.clone();
        return obj;        
    }
    
}
