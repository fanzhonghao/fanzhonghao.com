package semantic_ana;

import jdk.nashorn.internal.ir.Block;
import lexical_analyzer.Token;
import parser.parAna_used;
import lexical_analyzer.usedclass;
import parser.func_filter;
import parser.expression_compute;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:fan
 * Date: 17-12-17
 * Time: 上午2:53
 * Description:
 */
public class Main_used {//使用函数
    private double sca_a,sca_b,rot_c,ori_d,ori_e;
    private String color;

    public static void main(String[] args) {
        int pointCount = 0;
        LinkedList<pointClass> pointList = new LinkedList<pointClass>();
        LinkedList<colorClass> colorList = new LinkedList<>();
        Main_used main_used = new Main_used();
        String url = "/home/fan/Compiler/src/lexical_analyzer/test1.txt";
        Split_txt split_txt = new Split_txt();
        split_txt.readIn("/home/fan/Compiler/src/lexical_analyzer/test.txt");
        split_txt.writeTo();

        for (;split_txt.readFile() != "";){
            String string = split_txt.readFile();
            int j = string.length();
            if (j == 1) break;
            String string1 = new String();
            int flag = 0;
            for (int i = 0;i < j;i++){
                if (Character.isLetter(string.charAt(i))) {
                    string1 += string.charAt(i);
                    flag++;
                }
                if (flag == 3) break;
            }
            flag = 0;//标记右括号个数
            String expressionInIt = new String();
            String l_expression = new String();
            String r_expression = new String();
            if (string1.equalsIgnoreCase("FOR")){
                LinkedList linkedList1 = new LinkedList();
                int begin = 0,end = 0;//左右括号的位置

                String string2 = new String();
                for (int i = j-1;i >= 0;i--){
                    if (string.charAt(i) == ')'){
                        flag++;
                        if (flag != 1){
                            linkedList1.add(string.charAt(i));
                        }else {end = i;linkedList1.removeLast();}
                    }else if (string.charAt(i) == '('){
                        flag--;
                        if (flag != 0) linkedList1.add(string.charAt(i));
                        else {begin=i;break;}
                    }else {
                        linkedList1.add(string.charAt(i));
                    }
                    //linkedList1中包含括号中的所有内容,逆序排列
                }
                int list_size = linkedList1.size();
                for (int i = list_size-1;i >= 0;i--){
                    expressionInIt += linkedList1.get(i);
                }

                String[] temp = expressionInIt.split(",");
                if (temp.length != 2) {
                    System.out.println("Main_used: 语法错误");
                    System.exit(-1);
                }
                l_expression = temp[0];//得到左表达式
                r_expression = temp[1];//得到右表达式

                for (int i = 0;i <= begin;i++){//开始到左括号
                    string2 += string.charAt(i);
                }
                string2 += new String("t,t);");



                File file = new File("/home/fan/Compiler/src/lexical_analyzer/test1.txt");
                if (file.exists()){
                    file.delete();
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println("创建文件错误");
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }else {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }

                PrintStream p = null;
                try {
                    p = new PrintStream(new FileOutputStream(file));
                    p.println(string2);
                    p.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }

                //
                System.out.println("End rewrite ");
                //重写结束
                //现在我们有左表达式和右表达式
            }

            System.out.println("l_expression: " + l_expression);
            System.out.println("r_expression: " + r_expression);

            l_expression+=" ";
            r_expression+=" ";
            BlockingQueue<Token> l_exp1 = new usedclass().StringToTokenTable(l_expression);
            LinkedList<Token> l_exp = new LinkedList<Token>(l_exp1);
            //
            System.out.println("l_exp.size(): " + l_exp.size());
            //
//            for (int i = 0;i < l_exp.size();i++){
//                Token token = (Token) l_exp.get(i);
//                System.out.println(token.getToken_type() + " " + token.getOriinpt() + " " + token.getValue());
//            }
            //
            BlockingQueue<Token> r_exp1 = new usedclass().StringToTokenTable(r_expression);
            LinkedList<Token> r_exp = new LinkedList<Token>(r_exp1);
            //
//            System.out.println("r_exp.size(): " + r_exp.size());
//            for (int i = 0;i < r_exp.size();i++){
//                Token token = (Token) r_exp.get(i);
//                System.out.println(token.getToken_type() + " " + token.getOriinpt() + " " + token.getValue());
//            }
            //

            //已经得到左右表达式的Token List即 l_exp,r_exp;
            //
            LinkedList<Token> tokens123 = new Main_used().setTInExp(l_exp,23);//把T替换
            BlockingQueue<Token> tokens22 = new LinkedBlockingQueue<Token>(100);
            int sizel = tokens123.size();
            for (int i = 0;i < sizel;i++){
                tokens22.add(tokens123.get(i));
            }
            tokens123 = new func_filter().filterFunc(tokens22);//函数常量过滤

            for (int i = 0;i < tokens123.size();i++){
                Token token23 = tokens123.get(i);
                System.out.println("Token24: " + token23.getToken_type() + " " + token23.getOriinpt() + " " + token23.getValue());
            }

            double re = new expression_compute().compute(tokens123);//表达式计算
            System.out.println("re: " + re);
            //相同的运行过程，答案被覆盖

//            LinkedList<Token> tokens223 = new Main_used().setTInExp(l_exp,24);
//            BlockingQueue<Token> tokens33 = new LinkedBlockingQueue<>(100);
//            int size2 = tokens223.size();
//            for (int i = 0;i < size2;i++){
//                tokens33.add(tokens223.get(i));
//            }
//            tokens223 = new func_filter().filterFunc(tokens33);
//            for (int i = 0;i < tokens223.size();i++){
//                Token token23 = tokens223.get(i);
//                System.out.println("Token23: " + token23.getToken_type() + " " + token23.getOriinpt() + " " + token23.getValue());
//            }

            //
            LinkedList linkedList = new parAna_used().paraAna(url);

//            for (int i = 0;i < linkedList.size();i++)
//            {
//                Token token =(Token) linkedList.get(i);
//                System.out.println(token.getToken_type() + " " + token.getOriinpt() + " " + token.getValue());
//            }

            if (linkedList.size() != 0){
                Token token = (Token) linkedList.get(0);
                switch (token.getToken_type()){
                    case "ROT": {
                        Token token1 = (Token) linkedList.get(2);
                        main_used.rot_c = token.getValue();
                        break;
                    }
                    case "ORIGIN": {
                        Token token1 = (Token) linkedList.get(3);
                        Token token2 = (Token) linkedList.get(5);
                        main_used.ori_d = token1.getValue();
                        main_used.ori_e = token2.getValue();
                        break;
                    }
                    case "SCALE": {
                        Token token1 = (Token) linkedList.get(3);
                        Token token2 = (Token) linkedList.get(5);
                        main_used.sca_a = token1.getValue();
                        main_used.sca_b = token2.getValue();
                        break;
                    }
                    //
                    case "SETCOLOR":{
                        Token token1 = (Token) linkedList.get(2);
                        main_used.color = token1.getOriinpt();
                        colorClass colorClass1 = new colorClass(pointCount,main_used.color);
                        colorList.add(colorClass1);
                        break;
                    }
                    //
                    case "FOR": {
//                        for (int i = 0;i < linkedList.size();i++){
//                            Token token1 = (Token) linkedList.get(i);
//                            System.out.println("For: " + token1.getToken_type() + " " + token1.getOriinpt() + " " + token1.getValue());
//                        }

//                        System.out.println("linklist size: " + linkedList.size());
                        double begin;
                        double end;
                        double step;
                        Token token1 = (Token) linkedList.get(3);
                        begin = token1.getValue();
                        token1 = (Token) linkedList.get(5);
                        end = token1.getValue();
                        token1 = (Token) linkedList.get(7);
                        step = token1.getValue();
                        for (double p = begin;p <= end;p+=step){
                            //
                            LinkedList l = new Main_used().setTInExp(l_exp,p);
                            //
//                            int l_size = l.size();
//                            for (int i = 0;i < l_size;i++)
//                            {
//                                Token token2 =(Token) l.get(i);
//                                System.out.println(token2.getToken_type() + " " + token2.getOriinpt() + " " + token2.getValue());
//                            }
                            //

                            BlockingQueue<Token> tokens = new LinkedBlockingQueue<Token>(100);
                            int size = l.size();
                            for (int i = 0;i < size;i++){
                                tokens.add((Token) l.get(i));
                            }
                            l = new func_filter().filterFunc(tokens);
                            double l_x = new expression_compute().compute(l);


                            LinkedList r = new Main_used().setTInExp(r_exp,p);
                            BlockingQueue<Token> tokens1 = new LinkedBlockingQueue<Token>(100);
                            size = r.size();
                            for (int i = 0;i < size;i++){
                                tokens1.add((Token) r.get(i));
                            }
                            r = new func_filter().filterFunc(tokens1);
                            double r_y = new expression_compute().compute(r);

                            pointClass point = new pointClass();
                            //
                            point.setX(l_x);
                            point.setY(r_y);
                            System.out.println("p: " + p);
                            System.out.println("point: " + l_x + " , " + r_y);
                            //
                            point.setX(point.getX()*main_used.sca_a*Math.cos(main_used.rot_c)+point.getY()*main_used.sca_b*Math.sin(main_used.rot_c)+main_used.ori_d);
                            point.setY(point.getY()*main_used.sca_b*Math.cos(main_used.rot_c)-point.getX()*main_used.sca_a*Math.sin(main_used.rot_c)+main_used.ori_e);
                            pointList.add(point);
                            //
                            pointCount++;
                            //
                        }
                        break;
                    }

                }

            }
            split_txt.writeTo();
        }

//        for (int i = 0;i < pointList.size();i++){
//            pointClass point = new pointClass();
//            point = pointList.get(i);
//            System.out.println("X: " + point.getX() + " Y: " + point.getY());
//        }
        //点已经存储在pointlist中
        //
        //
        int color = colorList.size();
        for (int i = 0;i < color;i++){
            colorClass colorClass1 = colorList.get(i);
            System.out.println(colorClass1.getColor() + " : " + colorClass1.getNo());
        }
        //

        //
        new drawPoint().draw(pointList,colorList);
    }
    public Main_used(){
        sca_a = 1;
        sca_b = 1;
        rot_c = 0;
        ori_d = 0;
        ori_e = 0;
        color = "BLACK";
    }
    public LinkedList<Token> setTInExp(LinkedList<Token> linkedList,double x){//替换左右Token List中的T
        Token token = new Token("CONST_ID",String.valueOf(x),x,"NULL");
        LinkedList<Token> linkedList1 = new LinkedList<Token>();
        for (int i = 0;i < linkedList.size();i++)
        {
            linkedList1.add(linkedList.get(i));
        }
        int size = linkedList1.size();
        for (int i = 0;i < size;i++){
            Token token1 = (Token) linkedList1.get(i);
            if (token1.getToken_type() == "T"){
                linkedList1.remove(i);
                linkedList1.add(i,token);
            }
        }
        return linkedList1;
    }
}
