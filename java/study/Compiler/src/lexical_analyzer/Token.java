package lexical_analyzer;

/**
 * Author:fan
 * Date: 17-12-11
 * Time: 下午4:49
 * Description:
 */
public class Token {//记录输入字符串可有的属性
    private Token_Type token_type = new Token_Type();//类别
    private String oriinpt = new String();//原始字符串
    private double value;//常数的值
    private String Func = new String();//函数类别

    public Token(String a,String b,double c,String d){
        setToken_type(a);
        setOriinpt(b);
        setValue(c);
        setFunc(d);
    }

    public void setToken_type(String token_type) {
        this.token_type.setType(token_type);
    }

    public String getToken_type() {
        return token_type.getType();
    }

    public void setOriinpt(String oriinpt) {
        this.oriinpt = oriinpt;
    }

    public String getOriinpt() {
        return oriinpt;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setFunc(String func) {
        Func = func;
    }

    public String getFunc() {
        return Func;
    }

}
