import java.io.*;

public class CCC07S4{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[][] connections = new boolean[n][];
    //saving space technique
    for(int i = 0; i < n; i++){
      connections[i] = new boolean[n-1-i];
    }
    int[] paths = new int[n];
    paths[0] = 1;
    while(true){
      String[] in = br.readLine().split(" ");
      int x = Integer.parseInt(in[0])-1;
      int y = Integer.parseInt(in[1])-1;
      if(x == -1){
        break;
      }
      connections[x][y-x-1] = true;
    }
    for(int i = 0; i < n; i++){
      if(paths[i] > 0){
        for(int j = i + 1; j < n; j++){
          if(connections[i][j-i-1]){
            paths[j] += paths[i];
          }
        }
      }
    }
    System.out.println(paths[n-1]);
  }
}