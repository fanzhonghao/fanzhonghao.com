import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:fan
 * Date: 17-9-18
 * Time: 下午1:03
 * Description:
 */
public class Serve extends Thread{
    public Serve(){}
    @Override
    public void run() {
        try {
            int i = 0;
            ServerSocket serverSocket = new ServerSocket(9123);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("第 " + (i+1) + " 个客户端连接成功");
                i++;

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(bufferedReader.readLine());

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);//获取写望客户端的输出流
                printWriter.println("Connection");
                printWriter.flush();

                socket.close();

                if (i == 3)break;
            }
//            serverSocket.close();

//            ServerSocket serverSocket = new ServerSocket(2017);
//            Socket socket = serverSocket.accept();
//            System.out.println("客户端已连接");

            serverSocket.close();
            System.out.println("服务器关闭");

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("服务端异常");
        }
    }

    public static void main(String[] args) {
        Serve serve = new Serve();
        serve.start();
    }
}
