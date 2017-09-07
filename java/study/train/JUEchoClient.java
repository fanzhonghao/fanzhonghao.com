
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Date: 17-9-7
 * Time: 下午5:20
 * Description:
 *      用DatagramSocket类实现
 *      客户端
 */
class JUEchoSender extends Thread {
    private InetAddress server;//Echo服务器
    private int port;
    private DatagramSocket dsocket;

    public JUEchoSender(InetAddress server,int port,DatagramSocket dsocket){
        this.server =server;
        this.port = port;
        this.dsocket = dsocket;
        setName("Thread-JUEchoSender");
    }

    public void run(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String line = input.readLine();
                if (line.equals(".")){
                    break;
                }

                byte[] data = line.getBytes();
                DatagramPacket outgoing = new DatagramPacket(data,data.length,server,port);
                dsocket.send(outgoing);
            }
        }catch (IOException e){ }
        finally {
            //关闭dsocket
            if (dsocket != null) dsocket.close();
            System.out.println(getName() + " exit");//输出线程结束信息
        }
    }
}
class JUEchoReceiver extends Thread{
    private DatagramSocket dsocket;
    public JUEchoReceiver(DatagramSocket dsocket){
        this.dsocket = dsocket;
        setName("Thread-JUEchoReceiver");
    }
    public void run(){
        byte[] buffer = new byte[8192];
        try {
            while (true){//构造接收数据报
                DatagramPacket incomming = new DatagramPacket(buffer,buffer.length);
                //接收数据报
                dsocket.receive(incomming);
                String data = new String(incomming.getData(),0,incomming.getLength());
                System.out.println(data);
            }
        }catch (IOException e){}
        finally {//关闭dscoket
            if (dsocket != null) dsocket.close();
            System.out.println(getName() + " exit");
        }
    }
}
public class JUEchoClient{
    private InetAddress server;
    private int port;
    public JUEchoClient(String server) throws UnknownHostException{
        this(server,2017);
    }
    public JUEchoClient(String server,int port) throws UnknownHostException{
        this.server = InetAddress.getByName(server);
        this.port = port;
    }
    public void start(){
        try{
            //创建客户端
            DatagramSocket dsocket = new DatagramSocket();
            (new JUEchoSender(server,port,dsocket)).start();
            //创建并启动接收线程
            (new JUEchoReceiver(dsocket)).start();
        }catch (SocketException e){

        }
    }

    public static void main(String[] args) {
        try {
            JUEchoClient client;
            if (args.length == 1){
                //命令行指定服务器
                client = new JUEchoClient(args[0]);
            }else if (args.length == 2){
                client = new JUEchoClient(args[0],Integer.parseInt(args[1]));
            }else {
                System.out.println("Usage: java JUEchoClient Host Port");
                return;
            }
            client.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
