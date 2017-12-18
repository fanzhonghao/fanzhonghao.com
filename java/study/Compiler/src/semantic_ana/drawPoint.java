package semantic_ana;


import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Author:fan
 * Date: 17-12-17
 * Time: 上午11:14
 * Description:
 */
public class drawPoint extends JFrame{
    private Graphics jg;
    private Color rectColor = new Color(0xf5f5f5);
    public void draw(LinkedList linkedList){
        Container p = getContentPane();
        setBounds(100,500,500,500);
        setVisible(true);
        p.setBackground(rectColor);
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        jg = this.getGraphics();//获取画图对象
        paintComponents(jg,linkedList);
    }
    public void paintComponents(Graphics g,LinkedList linkedList){
        try {
            g.setColor(Color.black);
            int size = linkedList.size();
            for (int i = 0;i < size;i++){
                pointClass point = (pointClass) linkedList.get(i);
                g.drawLine((int)(point.getX()),(int)(point.getY()),(int)(point.getX()),(int)(point.getY()));
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
