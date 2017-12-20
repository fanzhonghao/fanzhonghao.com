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
    public void draw(LinkedList linkedList,LinkedList<colorClass> colorlist){
        Container p = getContentPane();
        setBounds(100,500,720,480);
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
        paintComponents(jg,linkedList,colorlist);
    }
    public void paintComponents(Graphics g,LinkedList linkedList,LinkedList<colorClass> colorlist){
        try {
            int size = linkedList.size();
            g.setColor(Color.black);
            int colorListSize = colorlist.size();
            int colorCount = 0;
            if (colorListSize == 0){
                colorlist.add(0,new colorClass(0,"BLACK"));
            }
            for (int i = 0;i < size;i++){
                if (i == colorlist.get(colorCount).getNo()){
                    g.setColor(setcolor(colorlist.get(colorCount).getColor()));
                    if (colorCount < colorListSize-1) colorCount++;
                }
                pointClass point = (pointClass) linkedList.get(i);
                  g.drawOval((int)(point.getX()),(int)(point.getY()),2,2);
                try {
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Color setcolor(String string){
        switch (string){
            case "RED": return Color.RED;
            case "YELLOW":return Color.yellow;
            case "BLUE": return Color.blue;
            case "GREEN": return Color.green;
            default: return Color.black;
        }
    }
}
