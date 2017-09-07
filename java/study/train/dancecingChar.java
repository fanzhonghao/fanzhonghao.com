import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Author:fan
 * Date: 17-9-2
 * Time: 下午4:43
 * Description:
 */
public class dancecingChar  extends Applet implements Runnable,MouseListener{
    String str;
    char strChars[];
    Thread runner = null;
    boolean threadSuspended;
    int strLength;
    static final int REGULAR_WD = 15;//字符舞动的宽度
    static final int REGULAR_HT = 36;
    Font regularFont = new Font("Serif",Font.BOLD,REGULAR_HT);
    public void init(){
        str = getParameter("text");
        if (str == null) str = "Hello Java";
        strLength = str.length();
        strChars = new char[strLength];
        str.getChars(0,strLength,strChars,0);
        threadSuspended = false;
        addMouseListener(this);
    }
    public void destroy(){
        removeMouseListener(this);
    }
    public void start(){
        runner = new Thread(this);
        runner.start();
    }
    public synchronized void stop(){
        runner = null;
        if (threadSuspended){
            threadSuspended = false;
            notify();
        }
    }
    public void run(){
        Thread me = Thread.currentThread();
        while (runner == me){
            try{
                Thread.sleep(100);
                synchronized (this){
                    if (threadSuspended)
                        wait();
                }
            }catch (InterruptedException e){ }
            repaint();
        }
    }
    public void paint(Graphics g){
        int length = strChars.length;
        for (int i = 0,x = 0;i < length;i++){
            g.setFont(regularFont);
            int px = (int)(10 * Math.random() + x);
            int py = (int)(10 * Math.random() + REGULAR_HT);
            g.drawChars(strChars,i,1,px,py);
            x += REGULAR_WD;
        }
    }
    public synchronized void mousePressed(MouseEvent e){
        threadSuspended = !threadSuspended;
        if (!threadSuspended) notify();
    }
    public void mouseEntered(MouseEvent e){
        showStatus("Welcome");
    }
    public void mouseExited(MouseEvent e){
        showStatus("Bye");
    }

    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
}
