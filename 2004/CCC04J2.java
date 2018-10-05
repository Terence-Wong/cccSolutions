import java.io.*;

public class CCC04J2{
  public static void main(String[]args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int start = Integer.parseInt(br.readLine());
    int end   = Integer.parseInt(br.readLine());
    for(int year = start; year <= end; year++){
      int interval = year - start;
      if(
        interval % 2 == 0 &&
        interval % 4 == 0 &&
        interval % 3 == 0 &&
        interval % 5 == 0 ){
        System.out.println("All positions change in year " + year);
      }
    }
  }
}