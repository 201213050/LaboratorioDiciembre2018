/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import AST.Nodo;
import AST.error;
/**
 *
 * @author erick
 */
public class ejecucion 
{
    public Hashtable<String, Simbolo> tablaLocal = new Hashtable<>();
    public Hashtable<String, Simbolo> tablaGlobal = new Hashtable<>();    
    public ArrayList<Nodo> inicial;
    public ArrayList<Nodo> obj_temporal;    
    public ArrayList<error> erroresEjecucion = new ArrayList<>();
    public int flagError = 0;    
    
    public Entorno EntornoGlobal = new Entorno(null);

    public Simbolo crearSimbolo(Nodo nodo)
    {        
        Simbolo sim = new Simbolo();        
        sim.setNombre(nodo.getValue());
        sim.setRol("variable");
        sim.setTipo("variable"); 
        sim.setLinea(nodo.getLinea());
        sim.setColumna(nodo.getColumna());
        if(nodo.getHijos().size()==1)
        {            
            Nodo nuevo = realizarOperacion(nodo.getHijos().get(0));
            if(nuevo==null){return null;}
            sim.setTipo(nuevo.getTipo());            
            sim.setValor(nuevo.getValue());
        }                
        return sim;
    }
           
    
    public void actualizarValor(Nodo nombre)
    {
        Nodo valor = nombre.getHijos().get(0);
        String id = nombre.getValue();
        String val = valor.getValue();
        String type = valor.getTipo();        
        //Simbolo sim = tablaGlobal.get(id);
        Simbolo sim = EntornoGlobal.get(id);
        if(sim!=null)
        {
            Nodo nuevo = realizarOperacion(valor);
            if(flagError==0)
            {
                sim.setValor(nuevo.getValue());
                sim.setTipo(nuevo.getTipo());
                tablaGlobal.remove(id);
                tablaGlobal.put(id, sim);                
                flagError = 0;
            }
        }
        else
        {
            errorNoDeclarada(nombre);
        }
    }
    
    public void errorNoDeclarada(Nodo nodo)
    {
        flagError = 1;
        erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, nodo.getValue(),"No se ha declarado la variable " + nodo.getValue()));
    }
    
    public void ejecutar(Nodo raiz)
    {
        //System.out.println(raiz.getTipo()+"\t"+raiz.getValue() );
        switch(raiz.getTipo().toLowerCase())
        {
            case "declaracion":
                Nodo lista = raiz.getHijos().get(1);
                for(Nodo var: lista.getHijos())
                {   
                    Simbolo sim = crearSimbolo(var);                    
                    if(sim!=null)
                    {
                        EntornoGlobal.put(var.getValue(),sim);
                    }
                    
                    //tablaGlobal.put(var.getValue(),crearSimbolo(var));
                }
                break;
            case "asignacion":                       
                    actualizarValor(raiz.getHijos().get(0));                
                break;
            case "imprimir":
                    imprimir(raiz.getHijos().get(0));
                break;
            case "si":
                    OperarIf(raiz);
                break;
            case "para":
                    OperarFor(raiz);
                 break;
            case "mientras":
                    OperarWhile(raiz);
                 break;                 
        }                        
        for(Nodo hijo: raiz.getHijos())
        {
            ejecutar(hijo);
        }
    }
    int con = -10;
    
    public void OperarIf(Nodo raiz)
    {
        
    }
    
    public void OperarWhile(Nodo raiz)
    {
        
    }
    
    public void OperarFor(Nodo raiz)
    {
        
    }    
    
    
    public Nodo realizarOperacion(Nodo nodo)
    {
        switch(nodo.getTipo().toLowerCase())
        {
            case "numerico":
            case "cadena":
            case "caracter":
            case "booleano":
                return nodo;                
            case "!":
                return negar(realizarOperacion(nodo.getHijos().get(0)));                
            case "-":
                return menos(realizarOperacion(nodo.getHijos().get(0)));  
            case "incremento":
                //return incremento(realizarOperacion(nodo.getHijos().get(0)));   
                return incremento(nodo.getHijos().get(0));   
            case "decremento":
                //return decremento(realizarOperacion(nodo.getHijos().get(0)));  
                return decremento(nodo.getHijos().get(0));  
            case "variable":
                Simbolo sim = buscarSimbolo(nodo);                
                if(sim!=null)
                {
                    nodo.setTipo(sim.getTipo());
                    nodo.setValue(sim.getValor());
                    return nodo;                                       
                }                
                break;
            case "suma":
            case "resta":
            case "multi":
            case "div":
            case "mod":                
            case "pow":                
                return aritmeticaOperacion(nodo);
            case "logica":
                return logicaOperacion(nodo);
            case "relacional":
                return relacionalOperacion(nodo);
        }
        return null;
    }
    
    public Nodo relacionalOperacion(Nodo nodo)
    {
        switch(nodo.getValue())
        {
        
        }
        return nodo;
    }
    
    public Nodo logicaOperacion(Nodo nodo)
    {
        switch(nodo.getValue())
        {            
            case "&&":
            case "||":
                return (Logico(nodo.getHijos().get(0),nodo.getHijos().get(1), nodo.getValue()));                           
        }                
        return nodo;
    }    
    
    public Nodo aritmeticaOperacion(Nodo nodo)
    {
        switch(nodo.getTipo())
        {
            case "suma":                               
                return (sumar(aritmeticaOperacion(nodo.getHijos().get(0)),aritmeticaOperacion(nodo.getHijos().get(1))));    
            case "multi":                               
                return (multiplicar(aritmeticaOperacion(nodo.getHijos().get(0)),aritmeticaOperacion(nodo.getHijos().get(1)))); 
            case "div":                               
                return (division(aritmeticaOperacion(nodo.getHijos().get(0)),aritmeticaOperacion(nodo.getHijos().get(1)))); 
            case "pow":                               
                return (potencia(aritmeticaOperacion(nodo.getHijos().get(0)),aritmeticaOperacion(nodo.getHijos().get(1)))); 
            case "mod":                               
                return (modulo(aritmeticaOperacion(nodo.getHijos().get(0)),aritmeticaOperacion(nodo.getHijos().get(1))));                 
            case "resta":                               
                return (restar(aritmeticaOperacion(nodo.getHijos().get(0)),aritmeticaOperacion(nodo.getHijos().get(1))));                   
            case "numerico":
                return nodo;               
            case "variable":
                Simbolo sim = buscarSimbolo(nodo);                
                if(sim!=null)
                {
                    if(sim.getTipo().equals("numerico"))
                    { 
                        nodo.setTipo(sim.getTipo());
                        nodo.setValue(sim.getValor());
                        return nodo;
                    }                    
                }                
                break;                            
        }                
        return nodo;
    }
    
    
    public void imprimir(Nodo nodo)
    {
        Nodo result = realizarOperacion(nodo);
        if(result !=null)
        {
            System.out.println("--->" +  result.getValue());
        }
    }
   
    public Nodo Logico(Nodo nodo1, Nodo nodo2, String tipo)
    {
        Nodo tmp1 = realizarOperacion(nodo1);
        Nodo tmp2 = realizarOperacion(nodo2);
        if(tmp1.getTipo().equals("booleano") &&  tmp2.getTipo().equals("booleano"))
        {
            switch(tipo)
            {
                case "&&":
                    return andLogico(tmp1, tmp2);
                case "||":
                    return orLogico(tmp1, tmp2);
            }            
        }
        else            
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Operacion OR: tipos de datos inválidos.  " + nodo1.getTipo() +" && " + nodo2.getTipo()));
        }
        
        return nodo1;
    }
    
    public Nodo andLogico(Nodo nodo1, Nodo nodo2)
    {
        if(nodo1.getValue().equals("true") && nodo2.getValue().equals("true"))
        {
            nodo1.setValue("true");
        }            
        else
        {
            nodo1.setValue("false");
        }
        nodo1.setTipo("booleano");
        return nodo1;
    }
    public Nodo orLogico(Nodo nodo1, Nodo nodo2)
    {
        if(nodo1.getValue().equals("true") || nodo2.getValue().equals("true"))
        {
            nodo1.setValue("true");
        }            
        else
        {
            nodo1.setValue("false");
        }
        nodo1.setTipo("booleano");
        return nodo1;
    }    
    
    public Nodo sumar(Nodo nodo1, Nodo nodo2)
    {
        Nodo arg1 = null ;
        Nodo arg2 = null;
        
        if(nodo1!=null)
        {
            arg1 = realizarOperacion(nodo1);
        }
        if(nodo2!=null)
        {
            arg2 = realizarOperacion(nodo2);
        }       
        
        if(arg2 ==null || arg1 == null)
        {
            return null;
        }
        
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            if(tmp1.getValue().equals("true") || tmp2.getValue().equals("true"))
            {
                nodo1.setValue("true");
            }
            else
            {
                nodo1.setValue("false");
            }                        
        }else              
        // 2.  booleano numerico = suma
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp2.getValue());
            if(tmp1.getValue().equals("true"))
            {
                valor++;
            }
            nodo1.setValue(String.valueOf(valor));
        }else   
        // 3.  booleano cadena = concatenar
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("cadena"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;                  
            if(tmp1.getValue().equals("true"))
            {
                nodo1.setValue("true"+tmp2.getValue());   
            }
            else
            {
                nodo1.setValue("false"+tmp2.getValue());   
            }
            nodo1.setTipo("cadena");
        }else   
        // 4.  booleano caracter = concatenar
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("caracter"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;                  
            if(tmp1.getValue().equals("true"))
            {
                nodo1.setValue("true"+tmp2.getValue());   
            }
            else
            {
                nodo1.setValue("false"+tmp2.getValue());   
            }
            nodo1.setTipo("cadena");
        }else  
        // 5.  numerico booleano  = suma
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp1.getValue());
            if(tmp2.getValue().equals("true"))
            {
                valor++;
            }
            nodo1.setValue(String.valueOf(valor));
        }else              
        //6 numero numero = suma
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;              
            Double valor = Double.valueOf(tmp1.getValue())+ Double.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
        }else            
        //7 numerico cadena = concatenar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("cadena"))
        {    
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;             
            nodo1.setValue(tmp1.getValue()+tmp2.getValue());
            nodo1.setTipo("cadena");
        }else             
        //8 numero caracter = concatenar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("caracter"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            nodo1.setValue(tmp1.getValue() + tmp2.getValue());
            nodo1.setTipo("cadena");
        }          
        else            
        // 9.  cadena booleano  = concatenar
        if(arg1.getTipo().equals("cadena") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;                  
            if(tmp2.getValue().equals("true"))
            {
                nodo1.setValue(tmp1.getValue()+"true");   
            }
            else
            {
                nodo1.setValue(tmp1.getValue()+"false");   
            }
            nodo1.setTipo("cadena");
        }else             
        //10 cadena numerico = concatenar
        if(arg1.getTipo().equals("cadena") && arg2.getTipo().equals("numerico"))
        {            
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;            
            nodo1.setValue(tmp1.getValue()+tmp2.getValue());
        }else  
        //11 cadena cadena  = concatenar
        if(arg1.getTipo().equals("cadena") && arg2.getTipo().equals("cadena"))
        {  
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;            
            nodo1.setValue(tmp1.getValue()+tmp2.getValue());
        }                  
        else  
        //12 cadena caracter  = concatenar
        if(arg1.getTipo().equals("cadena") && arg2.getTipo().equals("caracter"))
        {  
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;            
            nodo1.setValue(tmp1.getValue()+tmp2.getValue());
        }                  
        else             
        //13 caracter booleano = sumaAscci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("booleano"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0);
            if(tmp2.getValue().equals("true")){valor++;}
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else            
        //14 caracter numero = sumaAscci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("numerico"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0) + Integer.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else   
        //15 caracter cadena = concatenar
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("cadena"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            nodo1.setValue(tmp1.getValue() + tmp2.getValue());
            nodo1.setTipo("cadena");
        }else 
        //16 caracter caracter = concatenar
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("caracter"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            nodo1.setValue(tmp1.getValue() + tmp2.getValue());
            nodo1.setTipo("cadena");
        }else                                                              
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Suma no es posible, tipos incorrectos  " + nodo1.getTipo() +" + " + nodo2.getTipo()));
        }
        
        return nodo1;
    }
    
    public Nodo restar(Nodo nodo1, Nodo nodo2)
    {        
        
        Nodo arg1 = null ;
        Nodo arg2 = null;
        
        if(nodo1!=null)
        {
            arg1 = realizarOperacion(nodo1);
        }
        if(nodo2!=null)
        {
            arg2 = realizarOperacion(nodo2);
        }       
        
        if(arg2 ==null || arg1 == null)
        {
            return null;
        }
              
        // 2.  booleano numerico = Restar
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp2.getValue());
            if(tmp1.getValue().equals("true"))
            {
                valor = 1 - valor;
            }
            else
            {
                valor = 0-valor;
            }
            nodo1.setValue(String.valueOf(valor));
        }else    
        // 5.  numerico booleano  = Restar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp1.getValue());
            if(tmp2.getValue().equals("true"))
            {
                valor--;
            }
            nodo1.setValue(String.valueOf(valor));
        }else              
        //6 numero numero = Restar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;              
            Double valor = Double.valueOf(tmp1.getValue())- Double.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
        }else                                   
        //10 cadena numerico = Restar ascii
        if(arg1.getTipo().equals("cadena") && arg2.getTipo().equals("numerico"))
        {            
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            Double valor = 0.00;
            String cadena = tmp1.getValue();
            for(int x = 0 ; x < cadena.length(); x++)
            {
                valor += cadena.charAt(x);
            }
            valor  += Double.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
        }else              
        //13 caracter booleano = Restar ascii
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("booleano"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0);
            if(tmp2.getValue().equals("true")){valor--;}
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else            
        //14 caracter numero = Restar ascii
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("numerico"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0) - Integer.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else                                                                
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Suma no es posible, tipos incorrectos  " + nodo1.getTipo() +" + " + nodo2.getTipo()));
        }        
        return nodo1;
    }    
    
    public Nodo multiplicar(Nodo nodo1, Nodo nodo2)
    {
        
        Nodo arg1 = null ;
        Nodo arg2 = null;
        
        if(nodo1!=null)
        {
            arg1 = realizarOperacion(nodo1);
        }
        if(nodo2!=null)
        {
            arg2 = realizarOperacion(nodo2);
        }       
        
        if(arg2 ==null || arg1 == null)
        {
            return null;
        }
                
        //1 booleano booleano = and
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            if(tmp1.getValue().equals("true") && tmp2.getValue().equals("true"))
            {
                nodo1.setValue("true");
            }
            else
            {
                nodo1.setValue("false");
            }                        
        }else              
        // 2.  booleano numerico = multi
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp2.getValue());
            if(!tmp1.getValue().equals("true"))
            {   
                valor = -1*valor;
            }
            nodo1.setValue(String.valueOf(valor));
        }else    
        // 5.  numerico booleano  = multi
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp1.getValue());
            if(!tmp2.getValue().equals("true"))
            {
                valor = valor * 0;
            }
            nodo1.setValue(String.valueOf(valor));
        }else              
        //6 numero numero = multi
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;              
            Double valor = Double.valueOf(tmp1.getValue())* Double.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
        }else            
        //13 caracter booleano =  multi Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("booleano"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0);
            if(!tmp2.getValue().equals("true")){valor = valor*0;}
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else            
        //14 caracter numero =  multi Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("numerico"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0) * Integer.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else                                                                
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Suma no es posible, tipos incorrectos  " + nodo1.getTipo() +" + " + nodo2.getTipo()));
        }
        
        return nodo1;
    }

    
    public Nodo division(Nodo nodo1, Nodo nodo2)
    {     
        
        Nodo arg1 = null ;
        Nodo arg2 = null;
        
        if(nodo1!=null)
        {
            arg1 = realizarOperacion(nodo1);
        }
        if(nodo2!=null)
        {
            arg2 = realizarOperacion(nodo2);
        }       
        
        if(arg2 ==null || arg1 == null)
        {
            return null;
        }
            
        // 2.  booleano numerico = division
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp2.getValue());
            if(tmp1.getValue().equals("true"))
            {
                valor = 1 /valor;
            }
            else
            {                
                valor = valor* 0;
            }
            nodo1.setValue(String.valueOf(valor));
            nodo1.setValue("numerico");
        }else       
        // 5.  numerico booleano  = division
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp1.getValue());
            if(!tmp2.getValue().equals("true"))
            {
                erroresEjecucion.add(new error("Ejecución",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Division es igual a infinito, valor seteado a 0  " + valor +" / " + 0));
                valor = valor * 0;
            }
            nodo1.setValue(String.valueOf(valor));
        }else              
        //6 numero numero = div
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;  
            Double valor  = Double.valueOf(tmp1.getValue());
            if(tmp2.getValue().equals("0"))
            {
               erroresEjecucion.add(new error("Ejecución",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Division es igual a infinito, valor seteado a 0  " + valor +" / " + 0)); 
               valor = valor* 0;
            }
            else
            {
               valor  = Double.valueOf(tmp1.getValue()) / Double.valueOf(tmp2.getValue());
            }
            nodo1.setValue(String.valueOf(valor));
        }else            
        //13 caracter booleano =  div Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("booleano"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            int valor = tmp1.getValue().charAt(0);
            if(!tmp2.getValue().equals("true"))
            {
                valor = valor*0;
                erroresEjecucion.add(new error("Ejecución",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Division es igual a infinito, valor seteado a 0  " + valor +" / " + 0));
            }
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else            
        //14 caracter numero =  div Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("numerico"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            Double val1 = Double.valueOf(tmp1.getValue());
            Double val2 = Double.valueOf(tmp2.getValue());
            if(val2 == 0 )
            {
              erroresEjecucion.add(new error("Ejecución",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Modulo es igual a infinito, valor seteado a 0  " + val1 +" % " + 0)); 
              val1 = val1*0;
            }
            else
            {
                val1 = Double.valueOf(tmp1.getValue().charAt(0)) % Integer.valueOf(tmp2.getValue());
            }                        
            nodo1.setValue(String.valueOf(val1));
            nodo1.setTipo("numerico");
        }else                                                                
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Suma no es posible, tipos incorrectos  " + nodo1.getTipo() +" + " + nodo2.getTipo()));
        }
        
        return nodo1;
    }  

    
    public Nodo potencia(Nodo nodo1, Nodo nodo2)
    {        
        Nodo arg1 = null ;
        Nodo arg2 = null;
        
        if(nodo1!=null)
        {
            arg1 = realizarOperacion(nodo1);
        }
        if(nodo2!=null)
        {
            arg2 = realizarOperacion(nodo2);
        }       
        
        if(arg2 ==null || arg1 == null)
        {
            return null;
        }
               
        // 2.  booleano numerico = elevar
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = 0.00;            
            if(tmp1.getValue().equals("true"))
            {
                valor = valor++;                
            }            
            valor = Math.pow(valor, Double.valueOf(tmp2.getValue()));
            nodo1.setValue(String.valueOf(valor));
        }else   
        // 5.  numerico booleano  = elevar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp1.getValue());
            if(tmp2.getValue().equals("true"))
            {
                valor = Math.pow(valor, 1);
            }
            else
            {
                valor = Math.pow(valor, 0 );
            }
            nodo1.setValue(String.valueOf(valor));
        }else              
        //6 numero numero = elevar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;              
            Double valor = Math.pow(Double.valueOf(tmp1.getValue()), Double.valueOf(tmp2.getValue()));
            nodo1.setValue(String.valueOf(valor));
        }else            
        //13 caracter booleano =  elevar Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("booleano"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            Double valor = Double.valueOf(tmp1.getValue().charAt(0));
            if(tmp2.getValue().equals("true")){valor = Math.pow(valor, 1);}else {valor = Math.pow(valor, 0);}
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else            
        //14 caracter numero =  elevar Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("numerico"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            Double valor = Math.pow(Double.valueOf(tmp1.getValue().charAt(0)), Integer.valueOf(tmp2.getValue()));
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else                                                                
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Suma no es posible, tipos incorrectos  " + nodo1.getTipo() +" + " + nodo2.getTipo()));
        }        
        return nodo1;
    }    
    
    public Nodo modulo(Nodo nodo1, Nodo nodo2)
    {      
        
        Nodo arg1 = realizarOperacion(nodo1);
        Nodo arg2 = realizarOperacion(nodo2);
        
        if(arg2==null || arg1 == null)
        {
            return null;
        }        
        // 2.  booleano numerico = modulo
        if(arg1.getTipo().equals("booleano") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = 0.00;            
            if(tmp1.getValue().equals("true"))
            {
                valor = valor++;                
            }            
            valor =  valor % Double.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else   
        // 5.  numerico booleano  = modulo
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("booleano"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;      
            Double valor = Double.valueOf(tmp1.getValue());
            if(tmp2.getValue().equals("true"))
            {
                valor = valor % 1;
            }
            else
            {
                erroresEjecucion.add(new error("Ejecución",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Modulo es indefinido, valor seteado a 0  " + valor +" 0 " + 0)); 
                valor = valor  * 0;
            }
            nodo1.setValue(String.valueOf(valor));
        }else              
        //6 numero numero = elevar
        if(arg1.getTipo().equals("numerico") && arg2.getTipo().equals("numerico"))
        {
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;              
            Double valor = Double.valueOf(tmp1.getValue()) %  Double.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
        }else            
        //13 caracter booleano =  elevar Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("booleano"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            Double valor = Double.valueOf(tmp1.getValue().charAt(0));
            if(tmp2.getValue().equals("true")){valor = valor% 1;}
            else 
            {
                erroresEjecucion.add(new error("Ejecución",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Division es igual a infinito, valor seteado a 0  " + valor +" / " + 0)); 
                valor = valor  * 0;
            }
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else            
        //14 caracter numero =  elevar Ascci
        if(arg1.getTipo().equals("caracter") && arg2.getTipo().equals("numerico"))
        {                        
            Nodo tmp1 = arg1;
            Nodo tmp2 = arg2;
            Double valor = Double.valueOf(tmp1.getValue().charAt(0)) % Integer.valueOf(tmp2.getValue());
            nodo1.setValue(String.valueOf(valor));
            nodo1.setTipo("numerico");
        }else                                                                
        {
            erroresEjecucion.add(new error("Semantico",  nodo1.getColumna(), nodo1.getLinea() + 1, nodo1.getValue(),"Suma no es posible, tipos incorrectos  " + nodo1.getTipo() +" + " + nodo2.getTipo()));
        }        
        return nodo1;
    }    
    public Nodo negar(Nodo nodo)
    {
        String tipo = nodo.getTipo().toLowerCase();
        String valor = nodo.getValue();
        switch(tipo)
        {            
            case "booleano":
                if(valor.equals("false")){nodo.setValue("true");}
                if(valor.equals("true")){nodo.setValue("false");}
                break;
            case "numerico":
                if(valor.equals("1")){ nodo.setValue("0");}
                else if(valor.equals("0")){ nodo.setValue("1");}
                else
                {
                    flagError = 1;
                    erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '!'   " + nodo.getValue()));
                }                
                break;
            default:
                flagError = 1;
                erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '!'   " + nodo.getValue()));
                break;
        }
        return nodo;
    }
    
    public Nodo menos(Nodo nodo)
    {
        String tipo = nodo.getTipo().toLowerCase();
        String valor = nodo.getValue();
        switch(tipo)
        {      
            case "numerico":
                nodo.setValue("-"+valor);
                break; 
            case "variable":
                Simbolo sim = buscarSimbolo(nodo);
                if(sim!=null)
                {
                    if(sim.getTipo().equals("numerico"))
                    { 
                        nodo.setValue("-"+sim.getValor());
                    }                    
                }                
                break;
            default:
                flagError = 1;
                erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '-'   " + nodo.getValue()));
                break;
        }
        return nodo;
    }  
    
    public Nodo incremento(Nodo nodo)
    {
        String tipo = nodo.getTipo().toLowerCase();
        String valor = nodo.getValue();
        switch(tipo)
        {            
            case "numerico":
                double total = Double.valueOf(valor)+1;
                nodo.setValue(String.valueOf(total));
                break;
            case "variable":
                Simbolo sim = buscarSimbolo(nodo);
                if(sim!=null)
                {
                    if(sim.getTipo().equals("numerico"))
                    {                         
                        nodo.setValue(String.valueOf(Double.valueOf(sim.getValor())+1));
                        nodo.setTipo("numerico");
                    } 
                    else
                    {
                        flagError = 1;
                        erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '++'   " + nodo.getValue()));
                    }                    
                } 
                break;
            default:
                flagError = 1;
                erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '++'   " + nodo.getValue()));
                break;
        }
        return nodo;
    } 
    public Nodo decremento(Nodo nodo)
    {
        String tipo = nodo.getTipo().toLowerCase();
        String valor = nodo.getValue();
        switch(tipo)
        {            
            case "numerico":
                double total = Double.valueOf(valor)-1;
                nodo.setValue(String.valueOf(total));
                break;
            case "variable":
                Simbolo sim = buscarSimbolo(nodo);
                if(sim!=null)
                {
                    if(sim.getTipo().equals("numerico"))
                    {                         
                        nodo.setValue(String.valueOf(Double.valueOf(sim.getValor())-1));
                        nodo.setTipo("numerico");
                    }     
                    else
                    {
                        flagError = 1;
                        erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '--'   " + nodo.getValue()));
                    }
                }   
                break;
            default:
                flagError = 1;
                erroresEjecucion.add(new error("Semantico",  nodo.getColumna(), nodo.getLinea() + 1, "El tipo de dato no aplica para el operador unario '--'   " + nodo.getValue()));
                break;
        }
        return nodo;
    }    

    
    
    public Simbolo buscarSimbolo(Nodo nodo)
    {                     
        //Simbolo sim = tablaGlobal.get(nodo.getValue());
        Simbolo sim = EntornoGlobal.get(nodo.getValue());
        if(sim==null)
        {
            errorNoDeclarada(nodo);
        }
        return sim;
    }
    
    
}
