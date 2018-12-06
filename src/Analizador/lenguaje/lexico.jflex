package Analizador.lenguaje;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import AST.error;
import AST.lexema;


%%
%{	
    public ArrayList<error> listaLexico=new ArrayList();
    public ArrayList<error> listaerrores = new ArrayList();
    public ArrayList<lexema> lexema_ = new ArrayList();	
	public String urlAuxliar="";
	public Boolean fin=false;
	public String txt_temporal="";
	public int linea=0;
	public int columna=0;
    public int flagInicio = 0;
    public String cadena = "";
    public String estado="";


    public void adderror(int linea, int columna, String valor)
    {
        error errorLexico=new error("Lexico",linea, columna, valor);
        listaerrores.add(errorLexico);
    }

    public void addLexema(String tipo, int linea, int columna, String descripcion, String valor)
    {                                                                               
        lexema simbolo=new lexema(valor, linea, columna, descripcion, tipo);
        Imprimir(simbolo.getTipo() +"\t"+ simbolo.getValor());
        lexema_.add(simbolo);	            
    } 
    public void Imprimir(String cadena)
    {
        System.out.println(cadena);
    }   
 

%}
%class lexico /*Nombre de la clase a generar.%cupsym simbolos*/
%unicode /*Caracteres unicode*/
%public /*Se generará una clase pública.*/
%cup
%full
%line   /*Almacenar el número de linea actual.*/
%char   /* Contador de caracteres.*/
%ignorecase /*Indiferente entre mayusculas y minusculas*/
%eofval{
	return new Symbol(sym.EOF);    
%eofval}

espacio = \t|\f|" "|\r|\n
numero = ([0-9][0-9]*)
decimal= {numero}"."{numero}
letra = ([a-zA-Z]|"ñ"|"á"|"é"|"í"|"ó"|"ú")
linea = ([^\r\n\"\\])
InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n
simbolos1= ("@"|":"|"!"|"¿"|"\""|"ñ"|",")
simbolos2= ("("|")"|"*"|"-"|"+"|"."|"!")
id = (({letra}|"_")({letra}|{numero}|"_")*)
rgb = "#"([0-9][a-fA-F])
cadenaComillas = (("\"" [^*] ~"\"") | ("\“" [^*] ~"\”"))
cadComilla = ("'" [^*] ~"'")
direccionWindows= ("\"" ({letra}":"("\\"({id}|{espacio}|"_"|"-"|{numero})+)+"."{id}) "\"")

comentario = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "$*" [^*] ~"*$" | "$*" "*"+ "$"
EndOfLineComment = "$$" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"
si = ("if")
sino={si}({comentario}|{espacio})*("not")
%state comentarioSimple, comentarioMulti

%%
<YYINITIAL>
{
[\n] { yychar=0;}
    {espacio}
    {System.out.println("Salto de linea");}
{comentario} {Imprimir(yytext());}

"int"  {  
            addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.integer, yychar, yyline, yytext());             
        }
","  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.coma, yychar, yyline, yytext());             
        }       
";"  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.puntocoma, yychar, yyline, yytext());             
        } 

"="  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.asignacion, yychar, yyline, yytext());             
        }
"++"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.incremento, yychar, yyline, yytext());             
        }  
"--"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.decremento, yychar, yyline, yytext());             
        }  
"=="  {  
            addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.igual, yychar, yyline, yytext());             
        }   
"!="  {  
            addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.diferente, yychar, yyline, yytext());             
        }   

"<="  {  
            addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.menorIgual, yychar, yyline, yytext());             
        }                                      
">="  {  
            addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.mayorIgual, yychar, yyline, yytext());             
        }        
"+"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.mas, yychar, yyline, yytext());             
        }  
"-"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.menos, yychar, yyline, yytext());             
        }               
"*"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.multi, yychar, yyline, yytext());             
        }     
   
"/"     {  
            
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.div, yychar, yyline, yytext());             
        }     
     
"^"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.potencia, yychar, yyline, yytext());             
        }

"%"  {  
            addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.modulo, yychar, yyline, yytext());             
        }

     
 
"<"  {  
            addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.menorque, yychar, yyline, yytext());             
        }
">"  {  
            addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.mayorque, yychar, yyline, yytext());             
        }  
"||"  {  
            addLexema("logico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.or, yychar, yyline, yytext());             
        }       
"&&"  {  
            addLexema("logico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.and, yychar, yyline, yytext());             
        }      
"!"  {  
            addLexema("logico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.no, yychar, yyline, yytext());             
    } 

{sino} 
        {
            addLexema("sino", yyline, yychar, yytext(), yytext());
            return new Symbol(sym.sino, yychar, yyline, yytext());             
        }
/*
"not"  {  
            addLexema("reservada", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.no, yychar, yyline, yytext());             
        } 
*/           
{si}  {  
            addLexema("reservada", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.si, yychar, yyline, yytext());             
        } 

"elif"  {  
            addLexema("reservada", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.sinosi, yychar, yyline, yytext());             
        }         

"smash"  {  
            addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.smash, yychar, yyline, yytext());             
        }    
"{"  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.corcheteA, yychar, yyline, yytext());             
        }           
"}"  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.corcheteC, yychar, yyline, yytext());             
        }
"("  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.parA, yychar, yyline, yytext());             
        }    
")"  {  
            addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.parC, yychar, yyline, yytext());             
        }                

"while"  {  
            addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.mientras, yychar, yyline, yytext());             
        }
"for"  {  
            addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.para, yychar, yyline, yytext());             
        }


"print"  {  
            addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.imprimir, yychar, yyline, yytext());             
        }
 

"true"  {  
            addLexema("nativa", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.verdadero, yychar, yyline, yytext());             
        }       
"false"  {  
            addLexema("nativa", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.falso, yychar, yyline, yytext());             
        }            

{id}  {  
            
            addLexema("Identificador", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.identificador, yychar, yyline, yytext());             
        }        
{decimal}  { 
             
            addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.decimal, yychar, yyline, yytext());             
        }   
{numero}  { 
             
            addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.entero, yychar, yyline, yytext());             
        }         
{cadComilla}  
        {  
            addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.caracter, yychar, yyline, yytext());             
        }         
{cadenaComillas}  
        {  
            addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.cadena, yychar, yyline, yytext());             
        }               
.			{
                System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
                adderror(yyline, yychar, yytext());
			}
<comentarioMulti> "*/"  
                {yybegin(YYINITIAL);} 
<comentarioMulti> . 
                { /**/}
<comentarioSimple> "\n"
                {yybegin(YYINITIAL);}
<comentarioSimple> .
                    {/**/}            	
}


		
