import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:fan
 * Date: 17-9-18
 * Time: 下午1:14
 * Description:
 */
public class Customer extends Thread{
    String name;
    public Customer(String name){
        this.name = name;
    }
    @Override
    public void run() {

        Socket socket = null;
        try {
            socket = new Socket("localhost",9123);
            System.out.println(name + " 连接到服务端");

            send sendMessage = new send(socket);
            sendMessage.start();
            receive receiveMessage = new receive(socket);
            receiveMessage.start();


        }catch (IOException e){
            System.out.println("连接失败");
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 3;i++){
            Customer customer = new Customer("Test");
            customer.start();
        }
    }
}


class receive extends Thread{//接收信息
    Socket socket;
    public receive(Socket socket){
        this.socket = socket;
    }
    @Override

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取过来内容
            while (true){
                String a = in.readLine();
                if (a != null)
                    System.out.println(a);
                sleep(50);
            }

        } catch (IOException e) {
            System.out.println("获取内容异常");
        }catch (InterruptedException e){
            System.out.println("等待异常");
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class send extends Thread{//发送信息
    Scanner sc = new Scanner(System.in);
    String outString;
    Socket socket;
    public send(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            while (socket.isConnected()){
                System.out.println("等待输入：-------------");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outString = sc.nextLine();
                printStream.println(outString);
                System.out.println(Thread.currentThread().getName() + ": "+Thread.currentThread().getState() + " : " + socket.isConnected());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
