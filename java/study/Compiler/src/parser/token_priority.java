package parser;

import lexical_analyzer.Token;

/**
 * Author:fan
 * Date: 17-12-16
 * Time: 上午9:33
 * Description:
 */
public class token_priority {//表示算符的优先级
    private Token token;
    private int priority;
    public token_priority(){
        setPriority(0);
    }
    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
