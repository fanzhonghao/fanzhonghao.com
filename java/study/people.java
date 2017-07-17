public class people{
  String name;
  String phoneNum;
  String email;
  public people(String name,String phoneNum,String email){
    this.name = name;
    this.phoneNum = phoneNum;
    this.email = email;
  }
  public void printMessage(){
    System.out.println("姓名：     " + name);
    System.out.println("联系电话:  " + phoneNum);
    System.out.println("email：    " + email);
  }
  public static void main(String[] args) {
    people people1 = new people("小红","12345678910","xiaohong@sina.com");
    people1.printMessage();
  }
}
