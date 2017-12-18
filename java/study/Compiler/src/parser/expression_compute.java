package parser;

import lexical_analyzer.Token;

import java.util.LinkedList;

import java.util.TreeSet;


/**
 * Author:fan
 * Date: 17-12-15
 * Time: 下午9:55
 * Description:
 * Attention:
 *  Will you use list you should
 * not add the same variate with
 * the same storage space.
 */
public class expression_compute {//计算带括号的表达式 Token[]
    private LinkedList<token_priority> list = new LinkedList<token_priority>();//优先级列表
    private token_priority tokenPriority = new token_priority();//优先级算符
    private TreeSet set = new TreeSet();//保存已有的优先级,且已经排序好

    public double compute(LinkedList queue){//分配优先级并传递计算
        if (queue.size() == 0) return 0.0;
        Token tokentest =(Token) queue.get(0);
        if (queue.size() == 1){
            if (tokentest.getToken_type() == "CONST_ID") return tokentest.getValue();
        }
        if (tokentest.getToken_type() == "MINUS") {
            Token tokenadd = new Token("CONST_ID","0.0",0.0,"NULL");
            queue.add(0,tokenadd);
        }

        int flag = 0;//表示当前优先级

        int queue_size = queue.size();
        int list_no = 0;
        for (int i = 0;i < queue_size;i++)
        {
            Token token_t =(Token) queue.get(i);
            Token token = new Token(token_t.getToken_type(),token_t.getOriinpt(),token_t.getValue(),token_t.getFunc());
            token_priority tokenPriority = new token_priority();//优先级算符

//            System.out.println("expression: " + token.getToken_type() + " " + token.getValue());
            switch (token.getToken_type()){//确定优先级并放入list中
                case "L_BRACKET": flag++; break;//提高优先级并删除左括号
                case "R_BRACKET": flag--; break;//提高优先级并删除右括号
                case "CONST_ID": tokenPriority.setToken(token);list.add(list_no,tokenPriority);
                list_no++;break;
                case "PLUS": tokenPriority.setToken(token);tokenPriority.setPriority(flag*3+1);list.add(list_no,tokenPriority);
//                System.out.println("list: " + list_no + " " + list.get(list_no).getToken().getToken_type() + " " + list.get(list_no).getToken().getValue());
                //测试
                list_no++;set.add(flag*3+1);break;
                case "MINUS": tokenPriority.setToken(token);tokenPriority.setPriority(flag*3+1);list.add(list_no,tokenPriority);
                list_no++;set.add(flag*3+1);break;
                case "MUL": tokenPriority.setToken(token);tokenPriority.setPriority(flag*3+2);list.add(list_no,tokenPriority);
                list_no++;set.add(flag*3+2);break;
                case "DIV": tokenPriority.setToken(token);tokenPriority.setPriority(flag*3+2);list.add(list_no,tokenPriority);
                list_no++;set.add(flag*3+2);break;
                case "POWER": tokenPriority.setToken(token);tokenPriority.setPriority(flag*3+3);list.add(list_no,tokenPriority);
                list_no++;set.add(flag*3+3);break;
            }
        }

//        System.out.println("list: " + 3 + " " + list.get(3).getToken().getToken_type() + " " + list.get(3).getToken().getValue());

//        int list_size = list.size();
//        for (int k = 0;k < list_size;k++)
//        {
//            System.out.println(k + " list: " + list.get(k).getToken().getToken_type()+ " " + list.get(k).getToken().getValue());
//        }

//        System.out.print("优先级： ");
        for (;set.size() != 0; ){
//            System.out.println("set last: " + set.last());
            int pri = (int) set.last();//当前最高优先级
//            System.out.println(pri + "  ");
            set.remove(pri);
            int no = list.size();
            for (int i = 1;i < no;i++){
                int temp = 0;//标记当前优先级的个数
                if (list.get(i).getPriority() == pri){//优先级匹配
                    temp = 1;
                    double r = 0;
                    if (list.get(i).getToken().getOriinpt() == "+"){
                        r = list.get(i-1).getToken().getValue() + list.get(i+1).getToken().getValue();
                    }else if (list.get(i).getToken().getOriinpt() == "-"){
                        r = list.get(i-1).getToken().getValue() - list.get(i+1).getToken().getValue();
                    }else if (list.get(i).getToken().getOriinpt() == "*"){
                        r = list.get(i-1).getToken().getValue() * list.get(i+1).getToken().getValue();
                    }else if (list.get(i).getToken().getOriinpt() == "/"){
                        r = list.get(i-1).getToken().getValue() / list.get(i+1).getToken().getValue();
                    }else if (list.get(i).getToken().getOriinpt() == "**"){
                        r = 1;
                        double num = list.get(i+1).getToken().getValue();
                        for (int j = 0;j < num;j++){
                            r *= list.get(i-1).getToken().getValue();
                        }
                    }
                    Token token1 = new Token("CONST_ID",String.valueOf(r),r,"NULL");
                    System.out.println("CONST_ID: " + token1.getToken_type() + " " + token1.getValue());

                    token_priority tokenPriority = new token_priority();
                    tokenPriority.setToken(token1);

                    list.set(i-1,tokenPriority);
                    list.remove(i);list.remove(i);
                    no -= 2;
                }
                if (temp == 1) i = 0;
            }
        }
        return list.get(0).getToken().getValue();
    }
}
