package lexical_analyzer;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:fan
 * Date: 17-12-15
 * Time: 下午6:03
 * Description:
 */
public class usedclass {//通过词法分析，得到符号表
    Token_Table token_table = new Token_Table();
    Token token;
    private String string = new String();
    private BlockingQueue<Token> queue = new LinkedBlockingQueue<Token>(1000);

    public BlockingQueue<Token> lexi_ana(String string1){//输出匹配的符号表
        File file = new File(string1);
        Reader reader = null;
        int c;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            while ((c = reader.read()) != -1){
                string +=(char) c;
            }
            reader.close();
        }catch (IOException e){
            System.out.println("打开文件错误");
            e.printStackTrace();//
        }
        queue = StringToTokenTable(string);
        return queue;
    }

    //将字符串转换为符号表
    public BlockingQueue<Token> StringToTokenTable(String string){
        int string_len = string.length();
        String test = new String();
        for (int i = 0;i < string_len;i++)
        {
            if(Character.isLetter(string.charAt(i))){
                test += string.charAt(i);//得到连续字母字符串
                if (i < string_len - 1 && !Character.isLetter(string.charAt(i+1)))
                {
                    token = token_table.test(test);
                    if (token.getToken_type() == "ERRORTOKEN"){
                        System.out.println("词法错误");
                        System.exit(-1);
                    }
                    queue.add(token);
                    test = "";
                }
            }
            else if (Character.isDigit(string.charAt(i)) || (string.charAt(i) == '.'
                    && Character.isDigit(string.charAt(i-1)) && Character.isDigit(string.charAt(i+1)))){//得到连续数字
                test += string.charAt(i);
                if (i < string_len - 1 && !Character.isDigit(string.charAt(i+1)) && string.charAt(i+1) != '.')
                {
                    token = token_table.test(test);
                    queue.add(token);
                    test = "";
                }
            }
            else if (string.charAt(i) == '/'){//匹配 // 和 /
                test = "";
                if (i < string_len - 1 && string.charAt(i+1) == '/'){
                    token = token_table.test("//");
                    queue.add(token);
                    i ++;
                    for (;string.charAt(i) != '\n' && i < string_len-1;i++);
                }else {
                    token = token_table.test("/");
                    queue.add(token);
                }
            }
            else if (string.charAt(i) == '-'){//匹配 -- 和 -
                test = "";
                if (i < string_len - 1 && string.charAt(i+1) == '-'){
                    i++;
                    token = token_table.test("--");
                    queue.add(token);
                    for (;string.charAt(i) != '\n' && i < string_len - 1;i++);
                }else {
                    token = token_table.test("-");
                    queue.add(token);
                }
            }
            else if (string.charAt(i) == ';' || string.charAt(i) == '(' || string.charAt(i) == ')' ||
                    string.charAt(i) == ','
                    || string.charAt(i) == '+'){//匹配 ; ( ) , +
                test = "";
                token = token_table.test(String.valueOf(string.charAt(i)));
                queue.add(token);
            }
            else if (string.charAt(i) == '*'){//匹配 ** 和 *
                test = "";
                if (i < string_len - 1 && string.charAt(i+1) == '*'){
                    i ++;
                    token = token_table.test("**");
                    queue.add(token);
                }else {token = token_table.test("*");queue.add(token);}
            }
        }
        return queue;
    }
}
