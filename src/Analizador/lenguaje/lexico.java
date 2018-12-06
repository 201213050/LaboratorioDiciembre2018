/* The following code was generated by JFlex 1.6.1 */

package Analizador.lenguaje;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import AST.error;
import AST.lexema;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>lexico.jflex</tt>
 */
public class lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int comentarioSimple = 2;
  public static final int comentarioMulti = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  4, 52,  2,  3,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1, 10, 12,  0, 23, 36, 38, 22, 14, 15, 16, 18, 13, 17,  6, 24, 
     5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  0, 31, 33, 32, 34,  0, 
     0, 44,  7,  7,  7, 39, 27,  7, 45, 26,  7,  7, 40, 43, 28, 29, 
    50,  7, 49, 42, 30, 51,  7, 48,  7,  7,  7,  0,  0,  0, 35,  7, 
     0, 44,  7,  7,  7, 39, 27,  7, 45, 26,  7,  7, 40, 43, 28, 29, 
    50,  7, 49, 42, 30, 51,  7, 48,  7,  7,  7, 46, 37, 47,  0,  0, 
     0,  0,  0,  0,  0, 52,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  9,  0,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  9,  0,  0, 
     0,  9,  0,  9,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0, 
     0,  0, 11,  8,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0, 11,  8,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\2\1\1\7\1\10\1\11\1\12\1\13\1\14\2\1"+
    "\1\15\1\1\3\5\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\2\1\1\5\1\1\1\5\1\24\1\25\2\5"+
    "\1\26\1\27\1\26\2\0\1\30\2\0\1\31\1\32"+
    "\2\0\1\33\1\0\1\34\1\0\1\34\4\5\1\35"+
    "\1\36\1\37\1\40\1\41\1\5\1\0\3\5\1\42"+
    "\1\0\1\43\1\44\2\0\2\33\5\0\1\45\1\5"+
    "\1\45\1\46\2\5\1\0\1\5\1\0\1\5\1\0"+
    "\1\5\1\0\1\5\7\0\1\5\1\0\1\5\1\47"+
    "\2\50\1\0\1\5\1\0\1\5\1\0\1\5\10\0"+
    "\2\51\2\52\2\53\2\54\2\55\14\0\1\51\17\0"+
    "\1\51\5\0\1\51\6\0\1\51\6\0\1\51\3\0"+
    "\2\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[189];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\237\0\237\0\237\0\324\0\u0109"+
    "\0\u013e\0\u0173\0\u01a8\0\u01dd\0\237\0\237\0\237\0\u0212"+
    "\0\u0247\0\u027c\0\u02b1\0\u02e6\0\u031b\0\u0350\0\u0385\0\u03ba"+
    "\0\u03ef\0\237\0\u0424\0\u0459\0\u048e\0\237\0\237\0\u04c3"+
    "\0\u04f8\0\u052d\0\u0562\0\u0597\0\237\0\237\0\u05cc\0\u0601"+
    "\0\237\0\237\0\u0212\0\u0636\0\u013e\0\237\0\u066b\0\u06a0"+
    "\0\237\0\237\0\u06d5\0\u070a\0\u073f\0\u0774\0\u07a9\0\u07de"+
    "\0\u0813\0\u0848\0\u087d\0\u08b2\0\u08e7\0\237\0\237\0\237"+
    "\0\237\0\237\0\u091c\0\u0951\0\u0986\0\u09bb\0\u09f0\0\u0636"+
    "\0\u0a25\0\237\0\237\0\u0a5a\0\u0a8f\0\u0ac4\0\237\0\u0af9"+
    "\0\u07a9\0\u0b2e\0\u0b63\0\u0b98\0\237\0\u0bcd\0\u0109\0\u0109"+
    "\0\u0c02\0\u0c37\0\u0c6c\0\u0ca1\0\u0cd6\0\u0d0b\0\u0d40\0\u0d75"+
    "\0\u0daa\0\u0ddf\0\u0e14\0\u0e49\0\u0e7e\0\u0eb3\0\u0ee8\0\u0f1d"+
    "\0\u0f52\0\u0f87\0\u0fbc\0\u0ff1\0\u0109\0\237\0\u0109\0\u1026"+
    "\0\u105b\0\u1090\0\u10c5\0\u10fa\0\u112f\0\u1164\0\u1199\0\u11ce"+
    "\0\u1203\0\u1238\0\u126d\0\u12a2\0\u12d7\0\237\0\u0109\0\237"+
    "\0\u0109\0\237\0\u0109\0\237\0\u0109\0\237\0\u0109\0\u130c"+
    "\0\u1341\0\u1376\0\u13ab\0\u13e0\0\u1415\0\u144a\0\u147f\0\u14b4"+
    "\0\u14e9\0\u151e\0\u1553\0\u0ee8\0\u1588\0\u15bd\0\u15f2\0\u1627"+
    "\0\u165c\0\u1691\0\u16c6\0\u16fb\0\u1730\0\u1765\0\u179a\0\u17cf"+
    "\0\u1804\0\u1839\0\u186e\0\u144a\0\u18a3\0\u18d8\0\u190d\0\u1942"+
    "\0\u1977\0\u11ce\0\u19ac\0\u19e1\0\u1a16\0\u1a4b\0\u1a80\0\u1ab5"+
    "\0\u16fb\0\u1aea\0\u1b1f\0\u1b54\0\u1b89\0\u1bbe\0\u1bf3\0\u1415"+
    "\0\u1c28\0\u1c5d\0\u1c92\0\u19ac\0\u1aea";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[189];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\3\5\1\6\1\7\1\4\1\10\1\11\1\4"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\3\4\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\2\10\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\10\1\43\1\44\3\10\1\45"+
    "\1\46\1\47\1\10\1\50\1\10\1\0\2\51\2\0"+
    "\1\52\57\51\1\0\2\51\3\0\13\51\1\53\43\51"+
    "\73\0\1\7\1\54\63\0\1\10\1\0\1\10\1\55"+
    "\21\0\5\10\10\0\2\10\1\0\4\10\2\0\4\10"+
    "\12\0\1\10\113\0\1\56\47\0\1\57\41\0\20\60"+
    "\1\0\44\60\30\0\1\52\55\0\1\61\65\0\1\62"+
    "\42\0\20\63\1\0\44\63\20\0\1\64\6\0\1\65"+
    "\55\0\1\66\77\0\1\67\1\70\35\0\1\10\1\0"+
    "\1\10\1\55\21\0\1\10\1\71\1\72\2\10\10\0"+
    "\2\10\1\0\4\10\2\0\4\10\6\0\1\10\1\0"+
    "\1\10\1\55\21\0\3\10\1\73\1\10\10\0\2\10"+
    "\1\0\2\10\1\74\1\10\2\0\4\10\6\0\1\10"+
    "\1\0\1\10\1\55\21\0\5\10\10\0\2\10\1\0"+
    "\4\10\2\0\1\10\1\75\2\10\41\0\1\76\64\0"+
    "\1\77\64\0\1\100\71\0\1\101\65\0\1\102\23\0"+
    "\1\10\1\0\1\10\1\55\21\0\5\10\10\0\1\10"+
    "\1\103\1\0\4\10\2\0\4\10\54\0\1\104\16\0"+
    "\1\10\1\0\1\10\1\55\21\0\5\10\10\0\2\10"+
    "\1\0\1\10\1\105\2\10\2\0\4\10\6\0\1\10"+
    "\1\0\1\10\1\55\21\0\5\10\10\0\2\10\1\0"+
    "\3\10\1\106\2\0\4\10\6\0\1\10\1\0\1\10"+
    "\1\55\21\0\5\10\10\0\2\10\1\0\4\10\2\0"+
    "\1\10\1\107\2\10\6\0\1\110\103\0\1\111\40\0"+
    "\14\60\1\112\50\60\26\63\1\113\36\63\20\114\1\115"+
    "\44\114\3\65\1\116\1\117\60\65\20\0\1\120\45\0"+
    "\4\121\22\0\1\122\1\123\3\0\1\124\66\0\1\125"+
    "\27\0\4\121\1\10\1\0\1\10\1\55\16\0\1\122"+
    "\1\123\1\0\2\10\1\126\2\10\10\0\2\10\1\0"+
    "\4\10\2\0\4\10\6\0\1\10\1\0\1\10\1\55"+
    "\21\0\4\10\1\127\10\0\2\10\1\0\4\10\2\0"+
    "\4\10\6\0\1\10\1\0\1\10\1\55\21\0\5\10"+
    "\10\0\2\10\1\0\4\10\2\0\1\10\1\130\2\10"+
    "\6\0\1\10\1\0\1\10\1\55\21\0\5\10\10\0"+
    "\1\10\1\131\1\0\4\10\2\0\4\10\6\0\1\10"+
    "\1\0\1\10\1\55\21\0\5\10\10\0\2\10\1\0"+
    "\4\10\2\0\3\10\1\132\6\0\1\10\1\0\1\10"+
    "\1\55\20\0\1\133\1\134\4\10\10\0\2\10\1\0"+
    "\4\10\2\0\4\10\55\0\1\135\15\0\1\10\1\0"+
    "\1\10\1\55\21\0\5\10\10\0\2\10\1\0\2\10"+
    "\1\136\1\10\2\0\4\10\6\0\1\10\1\0\1\10"+
    "\1\55\20\0\1\137\1\140\4\10\10\0\2\10\1\0"+
    "\4\10\2\0\4\10\6\0\1\10\1\0\1\10\1\55"+
    "\20\0\1\141\1\142\4\10\10\0\2\10\1\0\4\10"+
    "\2\0\4\10\1\0\20\143\1\0\44\143\20\114\1\144"+
    "\44\114\20\0\1\115\6\0\1\117\41\0\1\117\60\0"+
    "\20\145\1\120\7\145\1\0\34\145\20\0\1\146\6\0"+
    "\1\147\55\0\1\150\101\0\1\151\34\0\1\10\1\0"+
    "\1\10\1\55\21\0\3\10\1\152\1\10\10\0\2\10"+
    "\1\0\4\10\2\0\4\10\6\0\1\10\1\0\1\10"+
    "\1\55\21\0\5\10\10\0\2\10\1\153\1\154\3\10"+
    "\2\0\4\10\6\0\1\10\1\0\1\10\1\55\21\0"+
    "\5\10\10\0\1\155\1\10\1\0\4\10\2\0\4\10"+
    "\34\0\1\156\36\0\1\10\1\0\1\10\1\55\21\0"+
    "\1\10\1\157\3\10\10\0\2\10\1\0\4\10\2\0"+
    "\4\10\52\0\2\160\17\0\1\10\1\0\1\10\1\55"+
    "\21\0\5\10\10\0\2\10\1\160\1\161\3\10\2\0"+
    "\4\10\51\0\1\162\21\0\1\10\1\0\1\10\1\55"+
    "\21\0\5\10\10\0\1\10\1\163\1\0\4\10\2\0"+
    "\4\10\35\0\1\164\35\0\1\10\1\0\1\10\1\55"+
    "\21\0\2\10\1\165\2\10\10\0\2\10\1\0\4\10"+
    "\2\0\4\10\1\0\13\143\1\166\51\143\20\114\1\144"+
    "\6\114\1\117\35\114\20\145\1\167\44\145\20\170\1\171"+
    "\44\170\3\147\2\121\22\147\1\172\1\173\3\147\1\174"+
    "\30\147\20\0\1\175\102\0\1\176\33\0\1\10\1\0"+
    "\1\10\1\55\21\0\4\10\1\177\10\0\2\10\1\0"+
    "\4\10\2\0\4\10\50\0\1\200\22\0\1\10\1\0"+
    "\1\10\1\55\21\0\5\10\10\0\1\201\1\10\1\0"+
    "\4\10\2\0\4\10\56\0\1\202\14\0\1\10\1\0"+
    "\1\10\1\55\21\0\5\10\10\0\2\10\1\0\3\10"+
    "\1\203\2\0\4\10\50\0\1\204\22\0\1\10\1\0"+
    "\1\10\1\55\21\0\5\10\10\0\1\205\1\10\1\0"+
    "\4\10\2\0\4\10\37\0\1\206\33\0\1\10\1\0"+
    "\1\10\1\55\21\0\4\10\1\207\10\0\2\10\1\0"+
    "\4\10\2\0\4\10\1\0\13\143\1\166\7\143\1\210"+
    "\41\143\20\145\1\167\7\145\1\117\34\145\20\170\1\211"+
    "\44\170\20\0\1\171\6\0\1\121\35\0\3\147\2\121"+
    "\13\147\1\212\6\147\1\172\1\173\3\147\1\174\33\147"+
    "\2\121\13\147\1\213\6\147\1\172\1\173\3\147\1\174"+
    "\33\147\2\121\22\147\1\172\1\173\3\147\1\174\1\214"+
    "\27\147\20\215\1\175\7\215\1\0\34\215\13\143\1\166"+
    "\11\143\1\112\37\143\20\170\1\211\6\170\1\121\35\170"+
    "\3\216\2\217\13\216\1\147\6\216\1\220\1\221\3\216"+
    "\1\222\30\216\3\147\2\121\13\147\1\223\6\147\1\172"+
    "\1\173\3\147\1\174\33\147\2\121\22\147\1\172\1\173"+
    "\3\147\1\174\1\147\1\224\26\147\20\215\1\225\44\215"+
    "\3\216\2\217\13\216\1\226\6\216\1\220\1\221\3\216"+
    "\1\222\30\216\1\170\4\217\13\170\1\211\6\170\1\227"+
    "\1\230\3\170\1\231\30\170\3\216\2\217\22\216\1\220"+
    "\1\221\3\216\1\222\33\216\2\217\13\216\1\232\6\216"+
    "\1\220\1\221\3\216\1\222\33\216\2\217\13\216\1\226"+
    "\6\216\1\220\1\221\3\216\1\222\1\233\27\216\3\234"+
    "\2\235\13\234\1\223\6\234\1\236\1\173\3\234\1\237"+
    "\30\234\20\215\1\225\7\215\1\121\34\215\3\216\2\217"+
    "\13\216\1\226\6\216\1\172\1\221\3\216\1\222\30\216"+
    "\20\170\1\240\6\170\1\216\55\170\1\241\64\170\1\211"+
    "\14\170\1\242\27\170\3\216\2\217\13\216\1\243\6\216"+
    "\1\172\1\221\3\216\1\222\33\216\2\217\13\216\1\226"+
    "\6\216\1\220\1\221\3\216\1\222\1\216\1\244\26\216"+
    "\3\234\2\235\13\234\1\223\6\234\1\236\4\234\1\237"+
    "\30\234\1\215\4\235\13\215\1\225\6\215\1\245\4\215"+
    "\1\246\30\215\3\234\2\235\13\234\1\247\6\234\1\236"+
    "\4\234\1\237\33\234\2\235\13\234\1\223\6\234\1\236"+
    "\4\234\1\237\1\250\27\234\20\170\1\211\6\170\1\217"+
    "\55\170\1\251\6\170\1\121\55\170\1\211\15\170\1\252"+
    "\26\170\3\253\2\254\13\253\1\243\6\253\1\236\1\221"+
    "\3\253\1\255\30\253\20\215\1\256\6\215\1\234\55\215"+
    "\1\225\14\215\1\257\27\215\3\253\2\254\13\253\1\223"+
    "\6\253\1\260\1\221\3\253\1\255\30\253\3\234\2\235"+
    "\13\234\1\223\6\234\1\236\4\234\1\237\1\234\1\261"+
    "\26\234\20\262\1\251\6\262\1\235\1\170\34\262\3\253"+
    "\2\254\13\253\1\243\6\253\1\260\4\253\1\255\30\253"+
    "\1\262\4\254\13\262\1\263\6\262\1\264\4\262\1\265"+
    "\30\262\3\253\2\254\13\253\1\243\6\253\1\260\4\253"+
    "\1\255\1\266\27\253\20\262\1\267\7\262\1\217\34\262"+
    "\20\215\1\225\15\215\1\270\26\215\3\253\2\254\13\253"+
    "\1\271\6\253\1\260\4\253\1\255\30\253\20\262\1\263"+
    "\64\262\1\263\6\262\1\235\1\217\54\262\1\272\6\262"+
    "\1\253\55\262\1\263\14\262\1\273\27\262\3\253\2\254"+
    "\13\253\1\243\6\253\1\260\4\253\1\255\1\253\1\274"+
    "\26\253\20\215\1\267\6\215\1\235\1\121\34\215\3\253"+
    "\2\254\13\253\1\243\6\253\1\260\1\221\3\253\1\255"+
    "\30\253\20\262\1\263\6\262\1\254\1\217\54\262\1\263"+
    "\15\262\1\275\26\262";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7367];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\3\11\6\1\3\11\12\1\1\11\3\1\2\11"+
    "\5\1\2\11\2\1\2\11\1\1\2\0\1\11\2\0"+
    "\2\11\2\0\1\1\1\0\1\1\1\0\5\1\5\11"+
    "\1\1\1\0\4\1\1\0\2\11\2\0\1\1\1\11"+
    "\5\0\1\11\5\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\7\0\1\1\1\0\2\1\1\11"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\1\1\10\0"+
    "\1\11\1\1\1\11\1\1\1\11\1\1\1\11\1\1"+
    "\1\11\1\1\14\0\1\1\17\0\1\1\5\0\1\1"+
    "\6\0\1\1\6\0\1\1\3\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[189];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
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
 



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public lexico(java.io.Reader in) {
    this.zzReader = in;
  }



  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { 	return new Symbol(sym.EOF);    
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("Caracter ilegal: " + yytext()+" Linea : "+yyline +" Columna: "+yychar); 
                adderror(yyline, yychar, yytext());
            }
          case 46: break;
          case 2: 
            { System.out.println("Salto de linea");
            }
          case 47: break;
          case 3: 
            { yychar=0;
            }
          case 48: break;
          case 4: 
            { addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.entero, yychar, yyline, yytext());
            }
          case 49: break;
          case 5: 
            { addLexema("Identificador", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.identificador, yychar, yyline, yytext());
            }
          case 50: break;
          case 6: 
            { addLexema("logico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.no, yychar, yyline, yytext());
            }
          case 51: break;
          case 7: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.coma, yychar, yyline, yytext());
            }
          case 52: break;
          case 8: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.parA, yychar, yyline, yytext());
            }
          case 53: break;
          case 9: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.parC, yychar, yyline, yytext());
            }
          case 54: break;
          case 10: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.multi, yychar, yyline, yytext());
            }
          case 55: break;
          case 11: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.menos, yychar, yyline, yytext());
            }
          case 56: break;
          case 12: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.mas, yychar, yyline, yytext());
            }
          case 57: break;
          case 13: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.div, yychar, yyline, yytext());
            }
          case 58: break;
          case 14: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.puntocoma, yychar, yyline, yytext());
            }
          case 59: break;
          case 15: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.asignacion, yychar, yyline, yytext());
            }
          case 60: break;
          case 16: 
            { addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.menorque, yychar, yyline, yytext());
            }
          case 61: break;
          case 17: 
            { addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.mayorque, yychar, yyline, yytext());
            }
          case 62: break;
          case 18: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.potencia, yychar, yyline, yytext());
            }
          case 63: break;
          case 19: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.modulo, yychar, yyline, yytext());
            }
          case 64: break;
          case 20: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.corcheteA, yychar, yyline, yytext());
            }
          case 65: break;
          case 21: 
            { addLexema("simbolo", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.corcheteC, yychar, yyline, yytext());
            }
          case 66: break;
          case 22: 
            { /**/
            }
          case 67: break;
          case 23: 
            { yybegin(YYINITIAL);
            }
          case 68: break;
          case 24: 
            { addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.diferente, yychar, yyline, yytext());
            }
          case 69: break;
          case 25: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.decremento, yychar, yyline, yytext());
            }
          case 70: break;
          case 26: 
            { addLexema("aritmetico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.incremento, yychar, yyline, yytext());
            }
          case 71: break;
          case 27: 
            { Imprimir(yytext());
            }
          case 72: break;
          case 28: 
            { addLexema("reservada", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.si, yychar, yyline, yytext());
            }
          case 73: break;
          case 29: 
            { addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.igual, yychar, yyline, yytext());
            }
          case 74: break;
          case 30: 
            { addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.menorIgual, yychar, yyline, yytext());
            }
          case 75: break;
          case 31: 
            { addLexema("relacional", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.mayorIgual, yychar, yyline, yytext());
            }
          case 76: break;
          case 32: 
            { addLexema("logico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.or, yychar, yyline, yytext());
            }
          case 77: break;
          case 33: 
            { addLexema("logico", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.and, yychar, yyline, yytext());
            }
          case 78: break;
          case 34: 
            { addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.decimal, yychar, yyline, yytext());
            }
          case 79: break;
          case 35: 
            { addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.cadena, yychar, yyline, yytext());
            }
          case 80: break;
          case 36: 
            { addLexema("Valor", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.caracter, yychar, yyline, yytext());
            }
          case 81: break;
          case 37: 
            { addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.integer, yychar, yyline, yytext());
            }
          case 82: break;
          case 38: 
            { addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.para, yychar, yyline, yytext());
            }
          case 83: break;
          case 39: 
            { addLexema("nativa", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.verdadero, yychar, yyline, yytext());
            }
          case 84: break;
          case 40: 
            { addLexema("reservada", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.sinosi, yychar, yyline, yytext());
            }
          case 85: break;
          case 41: 
            { addLexema("sino", yyline, yychar, yytext(), yytext());
            return new Symbol(sym.sino, yychar, yyline, yytext());
            }
          case 86: break;
          case 42: 
            { addLexema("nativa", yyline, yychar,yytext(),yytext());  	        
            return new Symbol(sym.falso, yychar, yyline, yytext());
            }
          case 87: break;
          case 43: 
            { addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.smash, yychar, yyline, yytext());
            }
          case 88: break;
          case 44: 
            { addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.mientras, yychar, yyline, yytext());
            }
          case 89: break;
          case 45: 
            { addLexema("reservada", yyline, yychar,yytext(), yytext());  	        
            return new Symbol(sym.imprimir, yychar, yyline, yytext());
            }
          case 90: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}