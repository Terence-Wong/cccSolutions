import java.io.*;

public class CCC09J2{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    int t = Integer.parseInt(br.readLine());
    int sum = 0;
    for(int x = 0; x <= t / a; x++){
      for(int y = 0; y <= t / b; y++){
        for(int z = 0; z <= t / c; z++){
          if((x != 0 || y != 0 || z != 0) && t >= x*a+y*b+z*c){
            sum++;
            System.out.println(x + " Brown Trout, " + y + " Northern Pike, " + z + " Yellow Pickerel");
          }
        }
      }  
    }
    System.out.println("Number of ways to catch fish: " + sum);
  }
}