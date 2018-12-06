/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejecucion;

import java.util.*;
/**
 *
 * @author erick
 */
public class Entorno 
{
    private Hashtable tabla;
    protected Entorno ant;
    
    public Entorno(Entorno padre)
    {
        tabla = new Hashtable();
        ant = padre;
    }
    
    public void put(String s, Simbolo sim)
    {
        tabla.put(s, sim);
    }    
    public Simbolo get(String s)
    {
        for(Entorno e = this; e != null ; e = e.ant)
        {
            Simbolo encontro = (Simbolo)(e.tabla.get(s));
            if(encontro !=null)
            {
                return encontro;
            }
        }
        return null;
    }
    
}
