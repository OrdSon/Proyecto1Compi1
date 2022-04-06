
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package JParser;

import java_cup.runtime.*;
import Util.DataRecorder;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class JSONParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return JSONParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public JSONParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public JSONParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public JSONParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\042\000\002\002\004\000\002\017\005\000\002\020" +
    "\005\000\002\020\005\000\002\020\005\000\002\020\005" +
    "\000\002\020\005\000\002\020\003\000\002\020\003\000" +
    "\002\020\003\000\002\020\003\000\002\020\002\000\002" +
    "\002\005\000\002\002\005\000\002\021\005\000\002\023" +
    "\002\000\002\022\006\000\002\022\003\000\002\003\007" +
    "\000\002\004\005\000\002\004\003\000\002\005\011\000" +
    "\002\006\007\000\002\007\005\000\002\007\003\000\002" +
    "\010\023\000\002\011\007\000\002\012\005\000\002\012" +
    "\003\000\002\013\023\000\002\014\007\000\002\015\005" +
    "\000\002\015\003\000\002\016\007" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\156\000\004\021\004\001\002\000\016\004\011\005" +
    "\021\006\013\007\015\010\016\022\ufff6\001\002\000\004" +
    "\002\006\001\002\000\004\002\001\001\002\000\006\020" +
    "\157\022\ufff7\001\002\000\006\020\155\022\ufff8\001\002" +
    "\000\004\017\137\001\002\000\004\020\135\001\002\000" +
    "\004\017\076\001\002\000\006\020\074\022\ufffa\001\002" +
    "\000\004\017\044\001\002\000\004\017\030\001\002\000" +
    "\004\022\027\001\002\000\006\020\025\022\ufff9\001\002" +
    "\000\004\017\022\001\002\000\006\026\023\027\024\001" +
    "\002\000\004\020\ufff4\001\002\000\004\020\ufff5\001\002" +
    "\000\016\004\011\005\021\006\013\007\015\010\016\022" +
    "\ufff6\001\002\000\004\022\ufffd\001\002\000\004\002\000" +
    "\001\002\000\004\023\031\001\002\000\004\021\032\001" +
    "\002\000\004\015\040\001\002\000\006\020\036\024\uffe1" +
    "\001\002\000\004\024\035\001\002\000\006\020\uffe3\022" +
    "\uffe3\001\002\000\004\021\032\001\002\000\004\024\uffe2" +
    "\001\002\000\004\017\041\001\002\000\004\025\042\001" +
    "\002\000\004\022\043\001\002\000\006\020\uffe0\024\uffe0" +
    "\001\002\000\004\023\045\001\002\000\004\021\046\001" +
    "\002\000\004\011\054\001\002\000\006\020\052\024\uffe5" +
    "\001\002\000\004\024\051\001\002\000\006\020\uffe7\022" +
    "\uffe7\001\002\000\004\021\046\001\002\000\004\024\uffe6" +
    "\001\002\000\004\017\055\001\002\000\004\030\056\001" +
    "\002\000\004\025\057\001\002\000\004\030\060\001\002" +
    "\000\004\020\061\001\002\000\004\012\062\001\002\000" +
    "\004\017\063\001\002\000\004\030\064\001\002\000\004" +
    "\025\065\001\002\000\004\030\066\001\002\000\004\020" +
    "\067\001\002\000\004\014\070\001\002\000\004\017\071" +
    "\001\002\000\004\026\072\001\002\000\004\022\073\001" +
    "\002\000\006\020\uffe4\024\uffe4\001\002\000\016\004\011" +
    "\005\021\006\013\007\015\010\016\022\ufff6\001\002\000" +
    "\004\022\ufffe\001\002\000\004\023\077\001\002\000\004" +
    "\021\100\001\002\000\004\011\106\001\002\000\004\024" +
    "\105\001\002\000\006\020\103\024\uffe9\001\002\000\004" +
    "\021\100\001\002\000\004\024\uffea\001\002\000\006\020" +
    "\uffeb\022\uffeb\001\002\000\004\017\107\001\002\000\004" +
    "\030\110\001\002\000\004\025\111\001\002\000\004\030" +
    "\112\001\002\000\004\020\113\001\002\000\004\012\114" +
    "\001\002\000\004\017\115\001\002\000\004\030\116\001" +
    "\002\000\004\025\117\001\002\000\004\030\120\001\002" +
    "\000\004\020\121\001\002\000\004\013\122\001\002\000" +
    "\004\017\123\001\002\000\004\030\125\001\002\000\004" +
    "\022\134\001\002\000\004\025\127\001\002\000\004\030" +
    "\133\001\002\000\006\020\130\030\ufff0\001\002\000\004" +
    "\025\ufff2\001\002\000\004\025\127\001\002\000\004\030" +
    "\ufff1\001\002\000\004\022\ufff3\001\002\000\006\020\uffe8" +
    "\024\uffe8\001\002\000\016\004\011\005\021\006\013\007" +
    "\015\010\016\022\ufff6\001\002\000\004\022\uffff\001\002" +
    "\000\004\023\140\001\002\000\004\021\141\001\002\000" +
    "\004\011\147\001\002\000\004\024\146\001\002\000\006" +
    "\020\144\024\uffed\001\002\000\004\021\141\001\002\000" +
    "\004\024\uffee\001\002\000\006\020\uffef\022\uffef\001\002" +
    "\000\004\017\150\001\002\000\004\030\151\001\002\000" +
    "\004\025\152\001\002\000\004\030\153\001\002\000\004" +
    "\022\154\001\002\000\006\020\uffec\024\uffec\001\002\000" +
    "\016\004\011\005\021\006\013\007\015\010\016\022\ufff6" +
    "\001\002\000\004\022\ufffc\001\002\000\016\004\011\005" +
    "\021\006\013\007\015\010\016\022\ufff6\001\002\000\004" +
    "\022\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\156\000\004\017\004\001\001\000\016\002\011\003" +
    "\013\006\017\011\007\014\006\020\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\016\002" +
    "\011\003\013\006\017\011\007\014\006\020\025\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\015\033\016\032\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\015" +
    "\036\016\032\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\012\047\013\046\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\012\052\013\046\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\016\002\011\003\013\006\017\011\007\014\006\020\074" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\007" +
    "\100\010\101\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\007\103\010\101\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\021\123\001\001" +
    "\000\002\001\001\000\004\022\125\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\023\130\001\001\000\004" +
    "\022\131\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\002\011\003\013\006\017\011\007" +
    "\014\006\020\135\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\004\141\005\142\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\004\144\005" +
    "\142\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\016\002\011" +
    "\003\013\006\017\011\007\014\006\020\155\001\001\000" +
    "\002\001\001\000\016\002\011\003\013\006\017\011\007" +
    "\014\006\020\157\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$JSONParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$JSONParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$JSONParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


//código que modifica el comportamiento del parser [sobreescribiendo o creado métodos]    
    public JSONParser(JSONLexer lexer){//nuevo constructor
        super(lexer);        
    }    
    public void report_error(String message, Object info) {
        System.out.println("public void report_error");
    }
    
    public void report_fatal_error(String message, Object info) {
        System.out.println("public void report_fatal_error");
    }

    public void syntax_error(Symbol cur_token) {
        System.out.println("El error es el simbolo: " + JSONParserSym.terminalNames[cur_token.sym]);
        System.out.println(String.format("En la posicion: %d, %d", cur_token.left, cur_token.right));
    }

    public void unrecovered_syntax_error(Symbol cur_token) {
        if (cur_token.sym == JSONParserSym.EOF) {
            System.out.println("public void unrecoveredsyntax_error");
        }
    }
    protected int error_sync_size(){
        return 1;
    }
    JSONRecorder recorder;
    public JSONRecorder getRecorder(){
        return this.recorder;
    }
    public void setRecorder(JSONRecorder recorder){
    this.recorder = recorder;
}
//


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$JSONParser$actions {




  private final JSONParser parser;

  /** Constructor */
  CUP$JSONParser$actions(JSONParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$JSONParser$do_action_part00000000(
    int                        CUP$JSONParser$act_num,
    java_cup.runtime.lr_parser CUP$JSONParser$parser,
    java.util.Stack            CUP$JSONParser$stack,
    int                        CUP$JSONParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$JSONParser$result;

      /* select the action based on the action number */
      switch (CUP$JSONParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).value;
		RESULT = start_val;
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$JSONParser$parser.done_parsing();
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= OPENBRACE cuerpo CLOSEBRACE 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("inicio",13, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // cuerpo ::= score COMA cuerpo 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // cuerpo ::= clases COMA cuerpo 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // cuerpo ::= variables COMA cuerpo 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // cuerpo ::= metodos COMA cuerpo 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // cuerpo ::= comentarios COMA cuerpo 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // cuerpo ::= clases 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // cuerpo ::= variables 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // cuerpo ::= metodos 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // cuerpo ::= comentarios 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // cuerpo ::= 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cuerpo",14, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // score ::= SCORE COLON DECIMAL 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.peek()).value;
		System.out.println("El score es: "+n); recorder.setScore(n);
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("score",0, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // score ::= SCORE COLON NUMERO 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.peek()).value;
		System.out.println("El score es: "+n); recorder.setScore(n);
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("score",0, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // cadena ::= COMILLA cadenaBody COMILLA 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cadena",15, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // NT$0 ::= 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).value;
System.out.println("funcion: "+c); recorder.append(c+",");
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("NT$0",17, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // cadenaBody ::= CADENA COMA NT$0 cadenaBody 
            {
              Object RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-3)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-3)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-3)).value;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cadenaBody",16, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-3)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // cadenaBody ::= CADENA 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.peek()).value;
		System.out.println("funcion: "+c);recorder.append(c);
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("cadenaBody",16, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // clases ::= CLASES COLON OPENBRACKET classBody CLOSEBRACKET 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("clases",1, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-4)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // classBody ::= className COMA classBody 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("classBody",2, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // classBody ::= className 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("classBody",2, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // className ::= OPENBRACE NOMBRE COLON COMILLA CADENA COMILLA CLOSEBRACE 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)).value;
		System.out.println("Clase "+c);recorder.addClase(c);
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("className",3, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // variables ::= VARIABLES COLON OPENBRACKET varBody CLOSEBRACKET 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("variables",4, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-4)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // varBody ::= singleVar COMA varBody 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("varBody",5, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // varBody ::= singleVar 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("varBody",5, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // singleVar ::= OPENBRACE NOMBRE COLON COMILLA CADENA COMILLA COMA TIPO COLON COMILLA CADENA COMILLA COMA FUNCION COLON cadena CLOSEBRACE 
            {
              Object RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-12)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-12)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-12)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)).value;
		System.out.println("Variable: "+n+" Tipo: "+t); recorder.addVariable(n,t);
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("singleVar",6, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-16)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // metodos ::= METODOS COLON OPENBRACKET metodosBody CLOSEBRACKET 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("metodos",7, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-4)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // metodosBody ::= singleMetodo COMA metodosBody 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("metodosBody",8, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // metodosBody ::= singleMetodo 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("metodosBody",8, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // singleMetodo ::= OPENBRACE NOMBRE COLON COMILLA CADENA COMILLA COMA TIPO COLON COMILLA CADENA COMILLA COMA PARAMETROS COLON NUMERO CLOSEBRACE 
            {
              Object RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-12)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-12)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-12)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-6)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-1)).value;
		System.out.println("Metodo: "+c+ "Tipo: "+t+ "Parametros: "+d);
                recorder.addMetodo(c,t,d);
              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("singleMetodo",9, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-16)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // comentarios ::= COMENTARIOS COLON OPENBRACKET comentarioBody CLOSEBRACKET 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("comentarios",10, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-4)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // comentarioBody ::= singleComment COMA comentarioBody 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("comentarioBody",11, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-2)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // comentarioBody ::= singleComment 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("comentarioBody",11, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // singleComment ::= OPENBRACE TEXTO COLON CADENA CLOSEBRACE 
            {
              Object RESULT =null;

              CUP$JSONParser$result = parser.getSymbolFactory().newSymbol("singleComment",12, ((java_cup.runtime.Symbol)CUP$JSONParser$stack.elementAt(CUP$JSONParser$top-4)), ((java_cup.runtime.Symbol)CUP$JSONParser$stack.peek()), RESULT);
            }
          return CUP$JSONParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$JSONParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$JSONParser$do_action(
    int                        CUP$JSONParser$act_num,
    java_cup.runtime.lr_parser CUP$JSONParser$parser,
    java.util.Stack            CUP$JSONParser$stack,
    int                        CUP$JSONParser$top)
    throws java.lang.Exception
    {
              return CUP$JSONParser$do_action_part00000000(
                               CUP$JSONParser$act_num,
                               CUP$JSONParser$parser,
                               CUP$JSONParser$stack,
                               CUP$JSONParser$top);
    }
}

}
