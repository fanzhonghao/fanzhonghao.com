package lexical_analyzer;

/**
 * Author:fan
 * Date: 17-12-11
 * Time: 下午4:56
 * Description:
 */
public class Token_Type {//记录所有记号
    private String[] mark = {
            "ORIGIN","SCALE", "ROT", "IS", "TO", "STEP", "DRAW", "FOR", "FROM",//保留字
            "T",//参数
            "SEMICO", "L_BRACKET", "R_BRACKET", "COMMA",//分隔符
            "PLUS", "MINUS", "MUL", "DIV", "POWER",//运算符
            "FUNC",//函数
            "CONST_ID",//常数
            "NONTOKEN",//空记号
            "COMMENT",//注释
            "SETCOLOR",
            "RED",
            "BLUE",
            "YELLOW",
            "BLACK",
            "GREEN",
            //
            "ERRORTOKEN"//出错记号
    };

    private String type = new String("ERRORTOKEN");

    public void setType(String s) {
        for (String a : mark){
            if (s.equals(a)){
                type = a;
            }
        }
    }
    public String getType() {
        return type;
    }
}
