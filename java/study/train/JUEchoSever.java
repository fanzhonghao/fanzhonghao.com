
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Date: 17-9-7
 * Time: 下午5:08
 * Description:
 *      用DatagramSocket类实现
 *      服务器，返回从客户端接收的信息
 */
public class JUEchoSever implements Runnable {
    private int port;
    private DatagramSocket dsocket;
    public JUEchoSever() throws SocketException{
        this(2017);//Echo服务器默认端口2017
    }
    public JUEchoSever(int port) throws SocketException{
        this.port = port;
        this.dsocket = new DatagramSocket(this.port);//创建Echo服务器的DatagramSocket对象
    }
    public void run(){
        byte[] buffer = new byte[8192];
        while (true){
            //构造接收数据包
            DatagramPacket incomming = new DatagramPacket(buffer,buffer.length);
            try {
                dsocket.receive(incomming);
                DatagramPacket outgoing = new DatagramPacket(
                        incomming.getData(),incomming.getLength(),incomming.getAddress(),incomming.getPort());
                dsocket.send(outgoing);
            }catch (IOException e){}
        }
    }

    public static void main(String[] args) {
        try {
            JUEchoSever server = null;
            if (args.length == 0){
                server = new JUEchoSever();
            }else if (args.length == 1){
                //指定端口号
                server = new JUEchoSever(Integer.parseInt(args[0]));
            }else {
                System.out.println("Usage: java JUEchoSever Port");
                return;
            }
            (new Thread(server)).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
