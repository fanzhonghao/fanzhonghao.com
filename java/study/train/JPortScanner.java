
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Date: 17-9-6
 * Time: 下午5:16
 * Description:
 *    This code is used to check
 *  the port's state.
 */
public class JPortScanner {
    private String host;//目标主机
    private int fromPort;//起始端口
    private int toPort;//结束端口
    public JPortScanner(String host,int fromPort,int toPort){
        this.host = host;
        this.fromPort = fromPort;
        this.toPort = toPort;
    }
    public JPortScanner(String host){
        this(host,1,1023);//默认端口范围1~1023
    }
    public void start(){
        Socket connect = null;
        for (int port = this.fromPort;port <= this.toPort;port++){
            try {
                connect = new Socket(host,port);
                System.out.println("开放端口：" + port);
            }catch (UnknownHostException e){
                System.err.println("无法识别主机：" + host);
                continue;
            }catch (IOException e){
                System.out.println("未响应端口：" + port);
                continue;
            }
            finally {
                try {
                    connect.close();
                }catch (Exception e){}
            }
        }
    }

    public static void main(String[] args) {

        if (args.length == 1){
            //命令行参数指定主机
            (new JPortScanner(args[0])).start();
        }else if (args.length == 3){
            //命令行参数指定主机、起始端口和结束端口
            (new JPortScanner(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]))).start();
        }else {
            System.out.println("Usage:java JPortScanner [FromPort] [ToPort]");
        }
    }
}
