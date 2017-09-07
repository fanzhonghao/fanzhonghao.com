import java.applet.Applet;
import java.awt.*;

/**
 * Author:fan
 * Date: 17-8-31
 * Time: 上午10:41
 * Description:
 *  Showing six different color
 * shape.
 * Attention:
 *  The Applet code doesn't have
 * the main() function. The start()
 * function and paint() function are
 * usually executed automatically.
 */
public class appletColor extends Applet {
    public void paint(Graphics g){
        for (int i = 0;i < 6;i++){
            showGraphics(i,g);
        }
    }
    public void showGraphics(int n,Graphics g){
        g.clearRect(0,0,200,200);
        switch (n){
            case 0:
                g.setColor(Color.black);
                g.drawLine(30,30,160,160);//直线
                break;
            case 1:
                g.setColor(Color.blue);
                g.drawRect(30,30,160,160);//蓝色空心矩形
                break;
            case 2:
                g.setColor(Color.darkGray);
                g.drawRoundRect(30,30,160,160,20,120);//圆角矩形
                break;
            case 3:
                g.setColor(Color.green);
                g.drawOval(30,30,160,160);
                break;
            case 4:
                g.setColor(Color.orange);
                g.fillOval(30,30,160,160);//椭圆
                break;
            case 5:
                g.setColor(Color.magenta);
                g.draw3DRect(30,30,160,160,true);//凸起三维矩形
                break;
        }
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.exit(0);
        }
    }
}
