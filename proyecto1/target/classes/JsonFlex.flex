package JParser;
import java_cup.runtime.*;

%%

%class JSONLexer
%unicode
%cup
%line
%column
%public
%caseless

%{
StringBuffer string = new StringBuffer();
String lexema = "";

private Symbol symbol(int type) {
return new Symbol(type, yyline, yycolumn);
}
private Symbol symbol(int type, Object value) {
return new Symbol(type, yyline, yycolumn, value);
}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

IDENTIFICADOR = [:jletter:][:jletterdigit:]+
NUMERO = 0 | [1-9][0-9]*
DOUBLE = {NUMERO}"."[0-9]+
%state STRING
%%
<YYINITIAL>"Clases"  {/*System.out.println("CLASES");*/return new Symbol(JSONParserSym.CLASES, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Score"  {/*System.out.println("SCORE");*/return new Symbol(JSONParserSym.SCORE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Variables"  {/*System.out.println("VARIABLES");*/return new Symbol(JSONParserSym.VARIABLES, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Metodos"  {/*System.out.println("METODOS");*/return new Symbol(JSONParserSym.METODOS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Comentarios"  {/*System.out.println("COMENTARIOS");*/return new Symbol(JSONParserSym.COMENTARIOS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Nombre"  {/*System.out.println("NOMBRE");*/return new Symbol(JSONParserSym.NOMBRE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Tipo"  {/*System.out.println("TIPO");*/return new Symbol(JSONParserSym.TIPO, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Funcion"  {/*System.out.println("FUNCION");*/return new Symbol(JSONParserSym.FUNCION, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Parametros"  {/*System.out.println("PARAMETROS");*/return new Symbol(JSONParserSym.PARAMETROS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Texto"  {/*System.out.println("TEXTO");*/return new Symbol(JSONParserSym.TEXTO, (yyline+1), (yycolumn+1));}
<YYINITIAL>":"  {/*System.out.println("COLON");*/return new Symbol(JSONParserSym.COLON, (yyline+1), (yycolumn+1));}
<YYINITIAL>","  {/*System.out.println("COMA");*/return new Symbol(JSONParserSym.COMA, (yyline+1), (yycolumn+1));}
<YYINITIAL>"{"  {/*System.out.println("OPENBRACE");*/return new Symbol(JSONParserSym.OPENBRACE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"}"  {/*System.out.println("CLOSEBRACE");*/return new Symbol(JSONParserSym.CLOSEBRACE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"["  {/*System.out.println("OPENBRACKET");*/return new Symbol(JSONParserSym.OPENBRACKET, (yyline+1), (yycolumn+1));}
<YYINITIAL>"]"  {/*System.out.println("CLOSEBRACKET");*/return new Symbol(JSONParserSym.CLOSEBRACKET, (yyline+1), (yycolumn+1));}
<YYINITIAL>"\""  {/*System.out.println("COMILLA");*/return new Symbol(JSONParserSym.COMILLA, (yyline+1), (yycolumn+1));}
{NUMERO} {/*System.out.println("NUMERO");*/return new Symbol(JSONParserSym.NUMERO, yytext());}
{DOUBLE} {/*System.out.println("DECIMAL");*/return new Symbol(JSONParserSym.DECIMAL, (yyline+1), (yycolumn+1),yytext());}
{IDENTIFICADOR} {/*System.out.println("CADENA");*/return new Symbol(JSONParserSym.CADENA, (yyline+1), (yycolumn+1),yytext());}
{WhiteSpace} {/*ignorarr*/}

[^] { System.out.println("Caracter ilegal <"+ yytext()+">"); }
