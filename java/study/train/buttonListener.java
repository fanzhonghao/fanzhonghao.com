import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class buttonListener extends JFrame{
    JButton jb = new JButton();
    int i = 1;
    public buttonListener() {
        this.setTitle("创建按钮");
        jb.setText("按下次数: 0");
        this.add(jb);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                buttonListener.this.jb.setText("按下次数： " + (i++) + "次");
            }

        });
        this.setBounds(300,250,300,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//按下关闭时，JVM关闭
    }
    public static void main(String args[]) {
        buttonListener b = new buttonListener();

    }
}
