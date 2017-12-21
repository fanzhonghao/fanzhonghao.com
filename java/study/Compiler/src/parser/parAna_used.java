package parser;

import lexical_analyzer.Token;
import lexical_analyzer.usedclass;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

/**
 * Author:fan
 * Date: 17-12-17
 * Time: 上午2:40
 * Description:
 */
public class parAna_used {
    public LinkedList paraAna(String url){
        BlockingQueue<Token> queue = new usedclass().lexi_ana(url);
        //
        if (queue.isEmpty()) return new LinkedList(queue);
        //
        queue = new analySentence().alaly_sentence(queue);

        LinkedList linkedList = new LinkedList(queue);
        return linkedList;
    }
}
