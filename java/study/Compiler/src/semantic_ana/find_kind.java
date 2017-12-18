package semantic_ana;

import lexical_analyzer.Token;

import java.util.LinkedList;

/**
 * Author:fan
 * Date: 17-12-17
 * Time: 上午3:53
 * Description:
 */
public class find_kind {//找出该句所属类别
    private String kind = new String();
    public String fKind(LinkedList linkedList){
        Token token = (Token) linkedList.get(0);
        switch (token.getToken_type()){
            case "ROT": kind = "ROT";
            case "FOR": kind = "FOR";
            case "ORIGIN": kind = "ORIGIN";
            case "SCALE": kind = "SCALE";
            default: kind = "ERROR";
        }
        return kind;
    }
}
