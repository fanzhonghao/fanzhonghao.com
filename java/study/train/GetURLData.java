import java.io.*;
import java.net.*;

/**
 * Date: 17-9-7
 * Time: 下午6:57
 * Description:
 *      Check the web's
 * information.
 */
public class GetURLData {
   public static void readURLData(String resource) {
       BufferedReader in = null;
       try {
           URL url = new URL(resource);
           in = new BufferedReader(new InputStreamReader (url.openStream()));
           String nextLine;
           //从输入流不断读数据
           while ((nextLine = in.readLine()) != null){
               System.out.println(nextLine);
           }
       }catch (MalformedURLException e){
           System.out.println("无效的URL： " + e);
       }catch (Exception e){
           System.out.println("Exception: " + e);
       }finally {
           try {
               if (in != null){
                   in.close();
               }
           }catch (IOException e){}
       }
   }

    public static void main(String[] args) {
        if (args.length != 1){
            //通过命令行参数指定URL资源
            System.out.println("Usage: java GetURLData url");
        }
        readURLData(args[0]);
    }
}
