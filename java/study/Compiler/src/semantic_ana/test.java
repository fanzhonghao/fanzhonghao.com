package semantic_ana;

import lexical_analyzer.Token;
import parser.func_filter;
import parser.expression_compute;
import lexical_analyzer.usedclass;
import parser.analySentence;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:fan
 * Date: 17-12-18
 * Time: 上午11:33
 * Description:
 */
public class test {
    public static void main(String[] args) {
        String string = "SETCOLOR(RED); ";
        BlockingQueue<Token> queue1 = new usedclass().StringToTokenTable(string);
        BlockingQueue<Token> queue2 = new analySentence().alaly_sentence(queue1);
        LinkedList<Token> list = new LinkedList<>(queue2);

        Token token = (Token) list.get(0);
//        token = queue2.poll();
//        token = queue2.poll();
//        token = queue2.poll();
//        token =queue2.poll();
        System.out.println(token.getToken_type() + " " + token.getOriinpt());

    }
}
