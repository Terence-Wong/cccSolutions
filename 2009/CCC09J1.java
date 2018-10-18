import java.io.*;

public class CCC09J1{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 91;
    sum += Integer.parseInt(br.readLine());
    sum += Integer.parseInt(br.readLine())*3;
    sum += Integer.parseInt(br.readLine());
    System.out.println("The 1-3-sum is " + sum);
  }
}