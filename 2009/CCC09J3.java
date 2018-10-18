import java.io.*;

public class CCC09J3{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    System.out.println(a + " in Ottawa");
    System.out.println(hour(remainder(a-300)) + " in Victoria");
    System.out.println(hour(remainder(a-200)) + " in Edmonton");
    System.out.println(hour(remainder(a-100)) + " in Winnipeg");
    System.out.println(a + " in Toronto");
    System.out.println(hour(remainder(a+100)) + " in Halifax");
    System.out.println(hour(remainder(a+130)) + " in St. John's");
  }
  public static int remainder(int i){
    if(i < 0){
      return i + 2400;
    }
    return i % 2400;
  }
  public static int hour(int i){
    if(i % 100 > 59){
      i += 100 - 60;
    }
    return i;
  }
}