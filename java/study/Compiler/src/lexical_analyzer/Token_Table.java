package lexical_analyzer;
/**
 * Author:fan
 * Date: 17-12-11
 * Time: 下午7:32
 * Description:
 */
public class Token_Table {//记录符号表

    public Token[] tokens = {
            new Token("CONST_ID","PI",3.1415926,"NULL"),
            new Token("CONST_ID","E",2.71828,"NULL"),
            new Token("T","T",0.0,"NULL"),
            new Token("FUNC","SIN",0.0,"sin"),
            new Token("FUNC","COS",0.0,"cos"),
            new Token("FUNC","TAN",0.0,"tan"),//5
            new Token("FUNC","LN",0.0,"log"),
            new Token("FUNC","EXP",0.0,"exp"),
            new Token("FUNC","SQRT",0.0,"sqrt"),
            new Token("ORIGIN","ORIGIN",0.0,"NULL"),
            new Token("SCALE","SCALE",0.0,"NULL"),//10
            new Token("ROT","ROT",0.0,"NULL"),
            new Token("IS","IS",0.0,"NULL"),
            new Token("FOR","FOR",0.0,"NULL"),
            new Token("FROM","FROM",0.0,"NULL"),
            new Token("TO","TO",0.0,"NULL"),//15
            new Token("STEP","STEP",0.0,"NULL"),
            new Token("DRAW","DRAW",0.0,"NULL"),
            new Token("ERRORTOKEN","ERRORTOKEN",0.0,"NULL"),//18
            new Token("COMMENT","//",0.0,"NULL"),
            new Token("COMMENT","--",0.0,"NULL"),//20
            new Token("SEMICO",";",0.0,"NULL"),
            new Token("L_BRACKET","(",0.0,"NULL"),
            new Token("R_BRACKET",")",0.0,"NULL"),
            new Token("COMMA",",",0.0,"NULL"),
            new Token("PLUS","+",0.0,"NULL"),//25
            new Token("MINUS","-",0.0,"NULL"),
            new Token("MUL","*",0.0,"NULL"),
            new Token("DIV","/",0.0,"NULL"),
            new Token("POWER","**",0.0,"NULL"),//29
            new Token("SETCOLOR","SETCOLOR",0.0,"SETCOLOR"),//30
            new Token("COLOR","RED",0.0,"NULL"),
            new Token("COLOR","YELLOW",0.0,"NULL"),
            new Token("COLOR","BLUE",0.0,"NULL"),
            new Token("COLOR","GREEN",0.0,"NULL"),
            new Token("COLOR","BLACK",0.0,"NULL")//35
            //没有数字串和其它的字母串
    };
    public Token test(String a){
        if (a.equalsIgnoreCase("PI")) return tokens[0];
        else if (a.equalsIgnoreCase("E")) return tokens[1];
        else if (a.equalsIgnoreCase("T")) return tokens[2];
        else if (a.equalsIgnoreCase("SIN")) return tokens[3];
        else if (a.equalsIgnoreCase("cos")) return tokens[4];
        else if (a.equalsIgnoreCase("tan")) return tokens[5];
        else if (a.equalsIgnoreCase("ln")) return tokens[6];
        else if (a.equalsIgnoreCase("exp")) return tokens[7];
        else if (a.equalsIgnoreCase("sqrt")) return tokens[8];
        else if (a.equalsIgnoreCase("origin")) return tokens[9];
        else if (a.equalsIgnoreCase("scale")) return tokens[10];
        else if (a.equalsIgnoreCase("rot")) return tokens[11];
        else if (a.equalsIgnoreCase("is")) return tokens[12];
        else if (a.equalsIgnoreCase("for")) return tokens[13];
        else if (a.equalsIgnoreCase("from")) return tokens[14];
        else if (a.equalsIgnoreCase("to")) return tokens[15];
        else if (a.equalsIgnoreCase("step")) return tokens[16];
        else if (a.equalsIgnoreCase("draw")) return tokens[17];
        else if (a.equalsIgnoreCase("//")) return tokens[19];
        else if (a.equalsIgnoreCase("--")) return tokens[20];
        else if (a.equalsIgnoreCase(";")) return tokens[21];
        else if (a.equalsIgnoreCase("(")) return tokens[22];
        else if (a.equalsIgnoreCase(")")) return tokens[23];
        else if (a.equalsIgnoreCase(",")) return tokens[24];
        else if (a.equalsIgnoreCase("+")) return tokens[25];
        else if (a.equalsIgnoreCase("-")) return tokens[26];
        else if (a.equalsIgnoreCase("*")) return tokens[27];
        else if (a.equalsIgnoreCase("/")) return tokens[28];
        else if (a.equalsIgnoreCase("**")) return tokens[29];
        else if (a.equalsIgnoreCase("setcolor")) return tokens[30];
        else if (a.equalsIgnoreCase("red")) return tokens[31];
        else if (a.equalsIgnoreCase("yellow")) return tokens[32];
        else if (a.equalsIgnoreCase("blue")) return tokens[33];
        else if (a.equalsIgnoreCase("green")) return tokens[34];
        else if (a.equalsIgnoreCase("black")) return tokens[35];
        else if (Character.isDigit(a.charAt(0))) return new Token("CONST_ID",a,Double.parseDouble(a),"NULL");
        return tokens[18];
    }
}
