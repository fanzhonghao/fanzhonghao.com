package parser;

import lexical_analyzer.Token;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:fan
 * Date: 17-12-16
 * Time: 下午7:36
 * Description:
 */
public class func_filter {//过滤sin,cos,tan,ln,exp,sqrt
    private LinkedList linkedList1 = new LinkedList();
    public LinkedList filterFunc(BlockingQueue<Token> queue){
        LinkedList linkedList = new LinkedList(queue);
        BlockingQueue<Token> queue1 = new LinkedBlockingQueue<>(1000);
//        int listSize = linkedList.size();
        double result;
        for (int i = 0;i < linkedList.size();i++){
            Token token = (Token) linkedList.get(i);
            if (token.getToken_type() == "FUNC"){

//                System.out.println(token.getOriinpt());
                //测试
//                System.out.print("list size: " + linkedList.size() + " " + i + " ");
                //

                inlineFunc(linkedList,i);

                result = new expression_compute().compute(linkedList1);

                //测试
//                System.out.println("before result: " + result);
                //
                linkedList1.removeAll(linkedList1);//清空
                switch (token.getOriinpt()){
                    case "SIN":
                        result = Math.sin(result);break;
                    case "COS":
                        result = Math.cos(result);break;
                    case "TAN":
                        result = Math.tan(result);break;
                    case "SQRT":
                        result = Math.sqrt(result);break;
                    case "LN":
                        result = Math.log(result);break;
                    case "EXP":
                        result = Math.exp(result);break;
                }
                Token token1 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                //测试
//                System.out.println("result: " + result);
                //
                linkedList.add(i,token1);
            }
        }
        //测试
//        for (int i = 0;i < linkedList1.size();i++){
//            Token token1 =(Token) linkedList1.get(i);
//            System.out.println("will return: " + token1.getToken_type() + " " + token1.getOriinpt() + " " + token1.getValue());
//        }
        //
        return linkedList;
    }
    private void inlineFunc(LinkedList linkedList,int i){
        int l_bracket = 1;
        linkedList.remove(i);linkedList.remove(i);//去掉函数标识符和左括号
        for (;;){
            //测试
//            System.out.println("inlineFunc: " + i);
            //

            Token token2 =(Token) linkedList.get(i);
//            System.out.println(token2.getOriinpt());

            Token token1 = (Token) linkedList.get(i);
            if (token1.getToken_type() == "L_BRACKET") l_bracket++;
            else if (token1.getToken_type() == "R_BRACKET") l_bracket--;
            if (l_bracket == 0) {linkedList.remove(i);break;}
            linkedList1.add(token1);
            linkedList.remove(i);
        }

        //测试
//        System.out.println("In inlineFunc");
//        for (int j = 0;j < linkedList1.size();j++){
//            Token token1 =(Token) linkedList1.get(j);
//            System.out.println("will return: " + token1.getToken_type() + " " + token1.getOriinpt() + " " + token1.getValue());
//        }

        return;
    }
}
