package parser;

import lexical_analyzer.Token;

/**
 * Author:fan
 * Date: 17-12-15
 * Time: 下午8:31
 * Description:
 */
public class sentence_pattern {//句子模式
    private String pattern = new String();
    private boolean origin_pattern = false;
    private boolean rot_pattern = false;
    private boolean scale_pattern = false;
    private boolean for_pattern = false;
    private boolean setcolor_pattern = false;

    private boolean expression_pattern = false;
    private String[] all_fun = {
            "SIN","COS","TAN","LN","EXP","SQRT"//方法
    };
    private boolean const_pattern = false;//"PI","E"常量
    private boolean vary_pattern = false;// "T"变量

    public void setPattern() {
        if (origin_pattern) pattern = "origin_pattern";
        else if (rot_pattern) pattern = "rot_pattern";
        else if (scale_pattern) pattern = "scale_pattern";
        else if (for_pattern) pattern = "for_pattern";
        else if (setcolor_pattern) pattern = "setcolor_pattern";
    }

    public String getPattern() {
        setPattern();
        return pattern;
    }

    public void setPattern(Token token){
        if (token.getOriinpt() == "ORIGIN") origin_pattern = true;
        else if (token.getOriinpt() == "ROT") rot_pattern = true;
        else if (token.getOriinpt() == "SCALE") scale_pattern = true;
        else if (token.getOriinpt() == "FOR") for_pattern = true;
        else if (inString(token.getOriinpt())) expression_pattern = true;
        else if (token.getOriinpt() == "PI" || token.getOriinpt() == "E") const_pattern = true;
        else if (token.getOriinpt().equalsIgnoreCase("T")) vary_pattern = true;
        else if (token.getOriinpt() == "SETCOLOR") setcolor_pattern = true;
    }
    private boolean inString(String s){
        for (int i = 0;i < 6;i++)
            if (s.equals(all_fun[i])) return true;
        return false;
    }
}
