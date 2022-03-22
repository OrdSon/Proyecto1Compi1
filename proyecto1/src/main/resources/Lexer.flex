package Parser;
import java_cup.runtime.*;

%%

%class Lexer
%unicode
%cup
%line
%column
%public

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
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
/*Expresiones regulares*/
IDENTIFICADOR = [:jletter:] [:jletterdigit:]*
NUMERO = 0 | [1-9][0-9]*
DOUBLE = {NUMERO}"."[0-9]+
%state STRING
%%

/*Palabras reservadas*/
<YYINITIAL>"int"  {return new Symbol(sym.INT, (yyline+1), (yycolumn+1));}
<YYINITIAL>"char" {return new Symbol(sym.CHAR, (yyline+1), (yycolumn+1));}
<YYINITIAL>"double" {return new Symbol(sym.DOUBLE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"short" {return new Symbol(sym.SHORT, (yyline+1), (yycolumn+1));}
<YYINITIAL>"String" {return new Symbol(sym.STRING, (yyline+1), (yycolumn+1));}
<YYINITIAL>"byte" {return new Symbol(sym.BYTE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"float" {return new Symbol(sym.FLOAT, (yyline+1), (yycolumn+1));}
<YYINITIAL>"long" {return new Symbol(sym.LONG, (yyline+1), (yycolumn+1));}
<YYINITIAL>"boolean" {return new Symbol(sym.BOOLEAN, (yyline+1), (yycolumn+1));}
<YYINITIAL>"public" {return new Symbol(sym.PUBLIC, (yyline+1), (yycolumn+1));}
<YYINITIAL>"private" {return new Symbol(sym.PRIVATE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"protected" {return new Symbol(sym.PROTECTED, (yyline+1), (yycolumn+1));}
<YYINITIAL>"class" {return new Symbol(sym.CLASS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"new" {return new Symbol(sym.NEW, (yyline+1), (yycolumn+1));}
<YYINITIAL>"void" {return new Symbol(sym.VOID, (yyline+1), (yycolumn+1));}
<YYINITIAL>"return" {return new Symbol(sym.RETURN, (yyline+1), (yycolumn+1));}
<YYINITIAL>"break" {return new Symbol(sym.BREAK, (yyline+1), (yycolumn+1));}
<YYINITIAL>"import" {return new Symbol(sym.IMPORT, (yyline+1), (yycolumn+1));}
<YYINITIAL>"final" {return new Symbol(sym.FINAL, (yyline+1), (yycolumn+1));}
<YYINITIAL>"switch" {return new Symbol(sym.SWITCH, (yyline+1), (yycolumn+1));}
<YYINITIAL>"case" {return new Symbol(sym.CASE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"if" {return new Symbol(sym.IF, (yyline+1), (yycolumn+1));}
<YYINITIAL>"else" {return new Symbol(sym.ELSE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"do" {return new Symbol(sym.DO, (yyline+1), (yycolumn+1));}
<YYINITIAL>"while" {return new Symbol(sym.WHILE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"for" {return new Symbol(sym.FOR, (yyline+1), (yycolumn+1));}
<YYINITIAL>"default" {return new Symbol(sym.DEFAULT, (yyline+1), (yycolumn+1));}
<YYINITIAL>"continue" {return new Symbol(sym.CONTINUE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"static" {return new Symbol(sym.STATIC, (yyline+1), (yycolumn+1));}

<YYINITIAL>{
/*Identificador*/

"+" {return new Symbol(sym.MAS, (yyline+1), (yycolumn+1));}
"-" {return new Symbol(sym.RESTA, (yyline+1), (yycolumn+1));}
"/" {return new Symbol(sym.DIV, (yyline+1), (yycolumn+1));}
"%" {return new Symbol(sym.MOD, (yyline+1), (yycolumn+1));}
"*" {return new Symbol(sym.POR, (yyline+1), (yycolumn+1));}
"&" {return new Symbol(sym.AND, (yyline+1), (yycolumn+1));}
"|" {return new Symbol(sym.OR, (yyline+1), (yycolumn+1));}
"<" {return new Symbol(sym.MENOR, (yyline+1), (yycolumn+1));}
">" {return new Symbol(sym.MAYOR, (yyline+1), (yycolumn+1));}
"=" {return new Symbol(sym.EQUALS, (yyline+1), (yycolumn+1));}
"!" {return new Symbol(sym.NOT, (yyline+1), (yycolumn+1));}
"." {return new Symbol(sym.DOT, (yyline+1), (yycolumn+1));}
";" {return new Symbol(sym.SEMICOLON, (yyline+1), (yycolumn+1));}
":" {return new Symbol(sym.COLON, (yyline+1), (yycolumn+1));}
"," {return new Symbol(sym.COMA, (yyline+1), (yycolumn+1));} 
"(" {return new Symbol(sym.OPENPAR, (yyline+1), (yycolumn+1));}
")" {return new Symbol(sym.CLOSEPAR, (yyline+1), (yycolumn+1));}
"{" {return new Symbol(sym.OPENBRACE, (yyline+1), (yycolumn+1));}
"}" {return new Symbol(sym.CLOSEBRACE, (yyline+1), (yycolumn+1));}
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, (yyline+1), (yycolumn+1),yytext());}
"\""(.)*"\"" {return new Symbol(sym.CADENA, (yyline+1), (yycolumn+1),yytext());}
{NUMERO} {return new Symbol(sym.NUMERO, (yyline+1), (yycolumn+1),yytext());}
{DOUBLE} {return new Symbol(sym.DECIMAL, (yyline+1), (yycolumn+1),yytext());}
{Comment} {/*ignorarr*/}
{WhiteSpace} {/*ignorarr*/}
}


[^]                              { throw new Error("Caracter ilegal <"+ yytext()+">"); }
