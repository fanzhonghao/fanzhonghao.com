import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:fan
 * Date: 17-9-7
 * Time: 下午7:36
 * Description:
 */
class send implements Runnable{
    private int port;
    private String server;//服务器地址
    public send(){
        port = 2017;
        server = "localhost";
    }

    @Override
    public void run() {
        try {
            Socket client = new Socket(server,port);//与服务端连接
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);//获得向服务器端写内容的数据流
            out.println("thx");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));//获得接收服务器发送内容的缓冲流
            System.out.println(in.readLine());//输出从服务端输出的内容
            Scanner input = new Scanner(System.in);
/*
            while (true){
                String data = input.nextLine();
                out.println(data);
                if (data.equals(".")) break;
                System.out.println(in.readLine());
            }
            //实现客户端单向向服务端通信部分
*/
            //实现客户端向服务端双向通话，但只能每人轮流说一句
            String data,data1;
            while (true){
                data = input.nextLine();
                if (data != null) out.println(data);
                if (data.equals(".")) break;
                data1 = in.readLine();
                if (data1 == null) continue;
                else System.out.println(data1);
            }


            client.close();//客户端关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Client{
    public static void main(String[] args) {
        send c = new send();
        c.run();
    }
}
