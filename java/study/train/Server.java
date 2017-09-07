import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:fan
 * Date: 17-9-7
 * Time: 下午7:28
 * Description:
 *      支持客户端向服务端通信
 */
public class Server implements Runnable {
    private int port;
    private Server(){this.port = 2017;}
    public void run(){
        try {
            ServerSocket server = new ServerSocket(port);//建立服务端
            Socket connection = null;
            connection = server.accept();//接听客户端
            System.out.println("Welcome");

            BufferedReader in =  new BufferedReader(new InputStreamReader(connection.getInputStream()));//获取客户端写入内容
            System.out.println(in.readLine());//输出客户端写向服务端的内容
            PrintWriter out = new PrintWriter(connection.getOutputStream(),true);//获取写往客户端的数据输出流，true自动刷新,这里为什么需要true?
            out.println("connection");
/*
            while (true){
                String input,output;
                input = in.readLine();
                System.out.println(input);
                out.println(input + " hello");
                if (input.equals(".")) break;
            }
            //以上为实现客户端向服务端单向通信部分
*/

            //实现客户端向服务端双向通话，但只能一人说一句
            Scanner enter = new Scanner(System.in);

            while (true){
                String input,output;
                input = in.readLine();
                System.out.println(input);
                if (input.equals(".")) break;
                output = enter.nextLine();
                out.println(output);
            }

            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
