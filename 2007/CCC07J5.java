import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
//two motels at the same location? no didnt have to worry about it
public class CCC07J5{
  public static void main(String[]args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] ways = new int[7001];
    int min = Integer.parseInt(br.readLine());
    int max = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int[] data = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
    ArrayList<Integer> motels = new ArrayList<Integer>();
    for(int i = 0; i < data.length; i++){
      motels.add(data[i]);
    }
    for(int i = 0; i < n; i++){
      motels.add(Integer.parseInt(br.readLine()));
    }
    Collections.sort(motels);
    ways[0] = 1;
    for(int x = 0; x < motels.size(); x++){
      if(ways[motels.get(x)] > 0){
        for(int y = x+1; y < motels.size(); y++){
          int a = motels.get(x);
          int b = motels.get(y);
          if(b-a >= min && b-a <= max){
            ways[b]+=ways[a];
          }
        }
      }
    }
    System.out.println(ways[7000]);
  }
}