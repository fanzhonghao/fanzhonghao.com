/* ---------------------------------
 *  Author:fan
 *  Date:2017.7.20
 * ---------------------------------
 *  Description:
 *    This code is used to create a
 *  clock.
 * ---------------------------------
 *  Attention:
 *    Lack of main() function. I
 *  don't have ability to write it
 *  at now...
 * ---------------------------------
 */
import java.util.Date;
import java.lang.Thread;
import java.applet.Applet;
import java.awt.*;
public class MoveClock extends Applet implements Runnable {
  Thread hourThread = null;//时针线程
  Thread minuteThread = null;//分针线程
  Thread secondThread = null;//秒针线程
  int hourX,hourY,minuteX,minuteY,secondX,secondY;//表示时，分，秒针端点的XY坐标点
  int currentHour = 0;//获取当前时间中代表小时的数字值
  int currentMinute = 0;
  int currentSecond = 0;
  Graphics secondGraphics = null;//绘制秒针的Graphics对象
  Graphics minuteGraphics = null;//绘制分针的Graphics对象
  Graphics hourGraphics = null;//绘制时针的Graphics对象
  Graphics2D minuteg2D = null;//创建Graphics2D对象
  Graphics2D hourg2D = null;//创建Graphics2D对象
  Graphics2D secondg2D = null;
  double drawX[] = new double[61];//存放表盘刻度的X轴数组
  double drawY[] = new double[61];
  double dial_x[] = new double[61];//供绘制表盘使用的x点坐标值
  double dial_y[] = new double[61];
  int isRestart = 0;//判断是否重新开始
  public void init(){//初始化
    hourGraphics = this.getGraphics();//实例化时针Graphics对象
    hourGraphics.setColor(Color.white);//设置时针颜色
    hourg2D = (Graphics2D) hourGraphics;//实例化时针Graphics2D对象
    hourGraphics.translate(200,200);//进行坐标系统变换原点设在(200,200)处

    minuteGraphics = this.getGraphics();
    minuteg2D = (Graphics2D) minuteGraphics;
    minuteGraphics.setColor(Color.green);
    minuteGraphics.translate(200,200);

    secondGraphics = this.getGraphics();
    secondg2D = (Graphics2D) secondGraphics;
    secondGraphics.setColor(Color.blue);
    secondGraphics.translate(200,200);

    drawX[0] = 0;//各个时针12点处的位置坐标(按新坐标系的坐标)
    drawY[0] = -120;
    dial_x[0] = 0;//12点处的刻度位置坐标(按新坐标系的坐标)
    dial_y[0] = -140;
    double jiaodu = 6 * Math.PI / 180;
    //表盘分割成60分，将分割点的坐标放在数组中
    for(int i = 0;i < 60;i++){
      drawX[i + 1] = drawX[i] * Math.cos(jiaodu) - Math.sin(jiaodu) * drawY[i];
      drawY[i + 1] = drawY[i] * Math.cos(jiaodu) + Math.sin(jiaodu) * drawX[i];
    }
    drawX[60] = 0;
    drawY[60] = -120;
    //表盘分割成60分，将分割点的坐标存放在绘制数组中
    for(int i = 0;i < 60;i++){
      dial_x[i + 1] = dial_x[i] * Math.cos(jiaodu) - Math.sin(jiaodu) * dial_y[i];
      dial_y[i + 1] = dial_y[i] * Math.cos(jiaodu) + Math.sin(jiaodu) * dial_x[i];
    }
    dial_x[60] = 0;
    dial_y[60] = -140;
  }
  public void start(){
    if(isRestart >= 1){
      secondThread.interrupt();//唤醒线程
      minuteThread.interrupt();
      hourThread.interrupt();
    }
    hourThread = new Thread(this);
    minuteThread = new Thread(this);
    secondThread = new Thread(this);
    secondThread.start();
    minuteThread.start();
    hourThread.start();
    isRestart++;
    if(isRestart >= 2) isRestart = 1;
  }
  public void stop(){
    secondThread.interrupt();//唤醒线程
    minuteThread.interrupt();
    hourThread.interrupt();
  }
  public void paint(Graphics g){//绘制圆形
    this.setBackground(Color.black);
    this.start();
    g.drawOval(50,50,300,300);//表盘的外圈
    g.translate(200,200);//进行坐标系统变换
    for(int i = 0;i < 60;i++){//绘制表盘的小刻度和大刻度
      if(i % 5 == 0){
        g.setColor(Color.red);
        g.fillOval((int) dial_x[i],(int) dial_y[i],10,10);
      }else{g.fillOval((int) dial_x[i],(int) dial_y[i],5,5); }
    }
  }
  public void run(){
    Date date = new Date();//获取本地时间
    String string = date.toString();
    currentHour = Integer.parseInt(string.substring(11,13));//获取当前时间的小时
    currentMinute = Integer.parseInt(string.substring(14,16));
    currentSecond = Integer.parseInt(string.substring(17,19));

    if(Thread.currentThread() == secondThread){//当前线程为秒线程
      secondX = (int) drawX[currentSecond];//秒初始化
      secondY = (int) drawY[currentSecond];
      //用背景色清除前一秒的秒针
      secondGraphics.drawLine(0,0,secondX,secondY);
      secondg2D.setStroke(new BasicStroke(2.0f));//设置绘制秒针的宽度
      int i = currentSecond;
      while(true){
        try{
          secondThread.sleep(1000);//每隔一秒休眠
          Color c = getBackground();//获取背景颜色
          secondGraphics.setColor(c);
          //用背景色清楚前一秒的秒针
          secondGraphics.drawLine(0,0,secondX,secondY);
          secondg2D.setStroke(new BasicStroke(2.0f));
          //秒针与分针重合，恢复分针显示
          if((secondX == minuteX) && (secondY == minuteY)){
            //用背景色清除前一分的分针
            minuteGraphics.drawLine(0,0,minuteX,minuteY);
          }
          //秒针与时针重合，恢复时针显示
          if((secondX == hourX) && (secondY == hourY)){
            //用背景色清楚前一时的时针
            hourGraphics.drawLine(0,0,hourX,hourY);
            hourg2D.setStroke(new BasicStroke(4.0f));
          }
        }catch(InterruptedException e){
          Color c = getBackground();
          secondGraphics.setColor(c);
          secondGraphics.drawLine(0,0,secondX,secondY);
          secondg2D.setStroke(new BasicStroke(2.0f));
          return;
        }
        secondX = (int) drawX[(i + 1) % 60];//秒针向前走一个单位
        secondY = (int) drawY[(i + 1) % 60];
        secondGraphics.setColor(Color.blue);
        secondGraphics.drawLine(0,0,secondX,secondY);
        secondg2D.setStroke(new BasicStroke(2.0f));
        i++;
      }
    }
    if(Thread.currentThread() == minuteThread){//当前线程为分线程
      minuteX = (int) drawX[currentMinute];
      minuteY = (int) drawY[currentMinute];
      minuteGraphics.drawLine(0,0,minuteX,minuteY);
      minuteg2D.setStroke(new BasicStroke(3.0f));
      int i = currentMinute;
      while(true){
        try{
          minuteThread.sleep(1000 * 60 - currentSecond * 1000);
          currentSecond = 0;
          Color c = getBackground();
          minuteGraphics.setColor(c);
          minuteg2D.setStroke(new BasicStroke(3.0f));
          minuteGraphics.drawLine(0,0,minuteX,minuteY);
          if((hourX == minuteX) && (hourY == minuteY)){
            hourGraphics.drawLine(0,0,minuteX,minuteY);
            hourg2D.setStroke(new BasicStroke(4.0f));
          }
        }catch (InterruptedException e) {
          return;
        }
        minuteX = (int) drawX[(i + 1) % 60];
        minuteY = (int) drawY[(i + 1) % 60];
        minuteGraphics.setColor(Color.BLUE);
        minuteg2D.setStroke(new BasicStroke(3.0f));
        minuteGraphics.drawLine(0,0,minuteX,minuteY);
        i++;
        currentSecond = 0;
      }
    }
    if(Thread.currentThread() == hourThread){
      int h = currentHour % 12;
      hourX = (int) drawX[h * 5 + currentMinute / 12];
      hourY = (int) drawY[h * 5 + currentMinute / 12];
      int i = h * 5 + currentMinute / 12;
      hourGraphics.drawLine(0,0,hourX,hourY);
      hourg2D.setStroke(new BasicStroke(4.0f));
      while(true){
        try{
          hourThread.sleep(1000 * 60 * 12 - 1000 * 60 * (currentMinute % 12) - currentSecond * 1000);
          currentMinute = 0;
          Color c = getBackground();
          hourGraphics.setColor(c);
          hourGraphics.drawLine(0,0,hourX,hourY);
          hourg2D.setStroke(new BasicStroke(4.0f));
        }catch (InterruptedException e) {
          return;
        }
        hourX = (int) drawX[(i + 1) % 60];
        hourY = (int) drawY[(i + 1) % 60];
        hourGraphics.setColor(Color.BLACK);
        hourGraphics.drawLine(0,0,hourX,hourY);
        hourg2D.setStroke(new BasicStroke(4.0f));
        i++;
        currentMinute = 0;
      }
    }
  }
  /*public static void main(String[] args) {
    MoveClock clock = new MoveClock();
    clock.init();

  }*/
}
