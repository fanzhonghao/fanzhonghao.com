/* -------------------------------
 *
 * -------------------------------
 */
import java.util.Calendar;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
public class TimeGetAndSet extends JFrame{
  private JPanel panel;
  private BorderLayout borderLayout1 = new BorderLayout();
  //创建组件实例
  private JLabel jLabell = new JLabel();
  private JButton jButton1 = new JButton();
  private JPanel jPanell = new JPanel();
  private JTextField jtf1 = new JTextField();
  private JTextField jtf2 = new JTextField();
  private JTextField jtf3 = new JTextField();
  private JTextField jtf4 = new JTextField();
  private JTextField jtf5 = new JTextField();
  private JTextField jtf6 = new JTextField();
  private TitledBorder tb1;
  private TitledBorder tb2;
  private TitledBorder tb3;
  private TitledBorder tb4;
  private TitledBorder tb5;
  private TitledBorder tb6;
  private TitledBorder tb7;
  private GridLayout gridLayout = new GridLayout();
  String year,month,day,hour,minute,second;
  Calendar cal = Calendar.getInstance();
  private void Jinit(){
    this.year = String.valueOf(cal.get(Calendar.YEAR));
    this.month = String.valueOf(cal.get(Calendar.MONTH));
    this.day = String.valueOf(cal.get(Calendar.DATE));
    this.hour = String.valueOf(cal.get(Calendar.HOUR));
    this.minute = String.valueOf(cal.get(Calendar.MINUTE));
    this.second = String.valueOf(cal.get(Calendar.SECOND));
    //创建TitledBorder边界实例
    panel = (JPanel) this.getContentPane();
    tb1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"年份");
    tb2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"月份");
    tb3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"日期");
    tb4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"时");
    tb5 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"分");
    tb6 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"秒");
    tb7 = new TitledBorder(BorderFactory.createEtchedBorder(Color.red,Color.white),"设置时间");
    jLabell.setFont(new Font("Dialog",Font.BOLD,14));
    jLabell.setText("Now:" + this.year + "年" + this.month + "月" + this.day + "日" + this.hour + "时" +
    this.minute + "分" + this.second + "秒");//显示时间
    panel.setLayout(borderLayout1);
    this.setSize(new Dimension(468,140));
    this.setVisible(true);
    this.setTitle("时间的设置与获取示例");
    jButton1.setText("重新获取时间");
    jButton1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        jButton1_actionPerformed(e);
      }
    });
    //设置JTextField组件的初始显示数，并添加边界
    jtf1.setBorder(this.tb1);
    jtf1.setText(this.year);
    jtf2.setBorder(this.tb2);
    jtf2.setText(this.month);
    jtf3.setBorder(this.tb3);
    jtf3.setText(this.day);
    jtf4.setBorder(this.tb4);
    jtf4.setText(this.hour);
    jtf5.setBorder(this.tb5);
    jtf5.setText(this.minute);
    jtf6.setBorder(this.tb6);
    jtf6.setText(this.second);
    jPanell.setBorder(this.tb7);
    //添加个组件
    panel.add(jLabell,BorderLayout.SOUTH);
    panel.add(jButton1,BorderLayout.CENTER);
    panel.add(jPanell,BorderLayout.NORTH);
    jPanell.add(jtf1,null);
    jPanell.add(jtf2,null);
    jPanell.add(jtf3,null);
    jPanell.add(jtf4,null);
    jPanell.add(jtf5,null);
    jPanell.add(jtf6,null);
  }
  public void jButton1_actionPerformed(ActionEvent e){
    //设置时间
    cal.set(Integer.parseInt(this.jtf1.getText()),Integer.parseInt(this.jtf2.getText()),
    Integer.parseInt(this.jtf3.getText()),Integer.parseInt(this.jtf4.getText()),Integer.parseInt(this.jtf5.getText()),
    Integer.parseInt(this.jtf6.getText()));
    //更新时间数据项
    this.year = String.valueOf(cal.get(Calendar.YEAR));
    this.month = String.valueOf(cal.get(Calendar.MONTH));
    this.day = String.valueOf(cal.get(Calendar.DATE));
    this.hour = String.valueOf(cal.get(Calendar.HOUR));
    this.minute = String.valueOf(cal.get(Calendar.MINUTE));
    this.second = String.valueOf(cal.get(Calendar.SECOND));
    //显示当前时间
    jLabell.setText("Now:" + this.year + "年" + this.month + "月" + this.day + "日" + this.hour + "时" +
    this.minute + "分" + this.second + "秒");
  }
  public static void main(String[] args) {
    new TimeGetAndSet().Jinit();
  }
}
