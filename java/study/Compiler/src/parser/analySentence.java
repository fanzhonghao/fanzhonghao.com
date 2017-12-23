package parser;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.prism.PrImage;
import lexical_analyzer.Token;
import lexical_analyzer.Token_Table;
import lexical_analyzer.usedclass;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:fan
 * Date: 17-12-16
 * Time: 下午7:59
 * Description:
 */
public class analySentence {//分析传进来的句子结构，并且替换函数和表达式,目标返回一句话
    public BlockingQueue<Token> alaly_sentence(BlockingQueue<Token> queue){
        LinkedList linkedList = new LinkedList(queue);

        //替换PI和E
        for (int i = 0;i < linkedList.size();i++){
            Token token1 =(Token) linkedList.get(i);
            if (token1.getOriinpt() == "PI") {
                Token token11 = new Token("CONST_ID",String.valueOf(token1.getValue()),token1.getValue(),"NULL");
                linkedList.remove(i);linkedList.add(i,token11);
            }else if (token1.getOriinpt() == "E"){
                Token token11 = new Token("CONST_ID",String.valueOf(token1.getValue()),token1.getValue(),"NULL");
                linkedList.remove(i);linkedList.add(i,token11);
            }
        }
        linkedList = new func_filter().filterFunc(link2queue(linkedList));//过滤函数

        sentence_pattern sentencePattern = new sentence_pattern();
        Token token1 =(Token) linkedList.get(0);
        sentencePattern.setPattern(token1);
        //开始匹配句子,判定语法模式
        switch (sentencePattern.getPattern()){
            case "origin_pattern":
                linkedList = testOriinputPattern(linkedList);
                break;//origin模式
            case "rot_pattern":
                linkedList = testRotPattern(linkedList);
                break;//rot模式
            case "scale_pattern":
                linkedList = testOriinputPattern(linkedList);
                break;//scale模式
            case "for_pattern":
                linkedList = testForPattern(linkedList);
                break;//for模式
            //
            case "setcolor_pattern":
                linkedList = testSetColorPattern(linkedList);
                break;
            //
        }
        //测试
//        System.out.println("After test");//输出过滤函数结果
//        for (int i = 0;i < linkedList.size();i++){
//            Token token100 =(Token) linkedList.get(i);
//            System.out.println( token100.getToken_type() + " " + token100.getOriinpt() + " " + token100.getValue());
//        }
        //
        queue.clear();
        for (int i = 0;i < linkedList.size();i++){
            Token token =(Token) linkedList.get(i);
            queue.add(token);
        }
        return queue;
    }
    private LinkedList testOriinputPattern(LinkedList linkedList){//判定ori语法模式和scale语法模式正确性
        LinkedList linkedList1 = new LinkedList();
        if (linkedList.size() < 8) {
            System.out.println("语法错误 analySentence_1");
            System.exit(-1);
        }
        Token token11 = (Token) linkedList.get(1);
        if (token11.getOriinpt() != "IS"){
            System.out.println("语法错误 analySentence_2");
            System.exit(-1);
        }
        token11 = (Token) linkedList.get(2);
        if (token11.getOriinpt() != "("){
            System.out.println("语法错误 analySentence_3");
            System.exit(-1);
        }
        token11 = (Token) linkedList.get(linkedList.size()-2);
        if (token11.getOriinpt() != ")"){
            System.out.println("语法错误 analySentence_4");
            System.exit(-1);
        }
        int flag = 0;
        for (int i = 3;i < linkedList.size()-1;){//计算括号中的表达式                               //attention -1
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type()) ){//属于正常状态
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getOriinpt() == ","){
                flag++;
                double result = new expression_compute().compute(linkedList1);
                Token token12 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token12);
                linkedList1.clear();
                i += 2;//
            }else {

                System.out.println("语法错误 analySentence_5");
                System.exit(-1);
            }
            if (flag > 1){
                System.out.println("语法错误 analySentence_6");
                System.exit(-1);
            }
        }

        double result = new expression_compute().compute(linkedList1);
        Token token = new Token("CONST_ID",String.valueOf(result),result,"NULL");
        linkedList.add(5,token);
        Token token1 = new Token("R_BRACKET",")",0.0,"NULL");
        linkedList.add(6,token1);
        return linkedList;
    }
    private LinkedList testRotPattern(LinkedList linkedList){//匹配rot模式
        LinkedList linkedList1 = new LinkedList();
        if (linkedList.size() < 4){
            System.out.println("语法错误 analySentence_7");
            System.exit(-1);
        }
        Token token =(Token) linkedList.get(1);
        if (token.getOriinpt() != "IS"){
            System.out.println("语法错误 analySentence_8");
            System.exit(-1);
        }
        for (int i = 2;i < linkedList.size() - 1;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){
                linkedList1.add(token1);
                linkedList.remove(i);
            }else {
                System.out.println("语法错误 analySentence_9");
                System.exit(-1);
            }
        }
        //测试
//        System.out.println("test");//输出过滤函数结果
//        for (int i = 0;i < linkedList1.size();i++){
//            Token token100 =(Token) linkedList1.get(i);
//            System.out.println( token100.getToken_type() + " " + token100.getOriinpt() + " " + token100.getValue());
//        }
        //

        double result = new expression_compute().compute(linkedList1);
        Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
        linkedList.add(2,token2);
        return linkedList;
    }
    private LinkedList testForPattern(LinkedList linkedList){
        LinkedList linkedList1 = new LinkedList();
        if (linkedList.size() < 15){
            System.out.println("语法错误 1");
            System.exit(-1);
        }
        Token token;
        token = (Token) linkedList.get(1);
        if (token.getToken_type() != "T"){
            System.out.println("语法错误 2");
            System.exit(-1);
        }
        token = (Token) linkedList.get(2);
        if (token.getToken_type() != "FROM"){
            System.out.println("语法错误 3");
            System.exit(-1);
        }
        for (int i = 3;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//正常模式
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "TO"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else {
                System.out.println("语法错误 4");
                System.exit(-1);
            }
        }
        for (int i = 5;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//正常模式
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "STEP"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else {
                System.out.println("语法错误 5");
                System.exit(-1);
            }
        }
        for (int i = 7;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//正常模式
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "DRAW"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else {
                System.out.println("语法错误 6");
                System.exit(-1);
            }
        }
        Token token10 =(Token) linkedList.get(9);
        if (token10.getOriinpt() != "("){
            System.out.println("语法错误 7");
            System.exit(-1);
        }
        for (int i = 10;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//正常模式
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "COMMA"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else if (token1.getToken_type() == "T"){
                break;
            } else {
                System.out.println("语法错误 8");
                System.exit(-1);
            }
        }
        int flag = 1;
        LinkedList linkedList2 = new LinkedList();

        for (int i = 12;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//正常模式
                linkedList2.add(token1);
                linkedList.remove(i);
                if (token1.getOriinpt() == "(") flag++;
                else if (token1.getOriinpt() == ")") flag--;
            }else if (token1.getToken_type() == "T"){
                break;
            }
            if (flag == 0) {
                double result = new expression_compute().compute(linkedList2);
                Token token2= new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                Token token3 = new Token("R_BRACKET",")",0.0,"NULL");
                linkedList.add(i+1,token3);
                break;
            }
        }

        return linkedList;
    }
    private String[] patter = {//+-*/括号
            "PLUS","MINUS","MUL","DIV",
            "POWER","CONST_ID","L_BRACKET",
            "R_BRACKET"
    };
    private boolean in_pattern(String a){
        for (int i = 0;i < 8;i++)if (a.equalsIgnoreCase(patter[i])) return true;
        return false;
    }
    //
    private LinkedList testSetColorPattern(LinkedList linkedList){
        Token token;
        int flag = 0;
        String[] color = {"RED","YELLOW","BLUE","GREEN","BLACK"};
        if (((Token) linkedList.get(1)).getOriinpt() != "("){
            System.out.println("语法错误-");
            System.exit(-1);
        }else if (((Token) linkedList.get(3)).getOriinpt() != ")"){
            System.out.println("语法错误--");
            System.exit(-1);
        }
        token =(Token) linkedList.get(2);
        for (;flag < 5;flag++){
            if (token.getOriinpt().equalsIgnoreCase(color[flag])) break;
        }
        if (flag == 5 && !token.getOriinpt().equalsIgnoreCase(color[4])){
            System.out.println(token.getOriinpt());
            System.out.println("语法错误---");
            System.exit(-1);
        }


        return linkedList;
    }
    private BlockingQueue<Token> link2queue(LinkedList<Token> linkedList){
        BlockingQueue<Token> queue = new LinkedBlockingQueue<>(100);
        for (int i = 0;i < linkedList.size();i++){
            queue.add(linkedList.get(i));
        }
        return queue;
    }
}
