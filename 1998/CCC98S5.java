import java.io.*;

public class CCC98S5{
  static int[][] map;
  static int[][] values;
  static int n;
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for(int t = 0; t < tc; t++){
      n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      values = new int[n][n];
      for(int y = 0; y < n; y++){
        for(int x = 0; x < n; x++){
          map[y][x] = Integer.parseInt(br.readLine());
          values[y][x] = Integer.MAX_VALUE;
        }
      }
      values[0][0] = 0;
      recurse(0,0);
      if(values[n-1][n-1] == Integer.MAX_VALUE){
        System.out.println("CANNOT MAKE THE TRIP");
      }else{
        System.out.println(values[n-1][n-1]);
      }
      System.out.println("");
    }
  }
  public static void recurse(int x, int y){
    update(x, y, x+1, y);
    update(x, y, x-1, y);
    update(x, y, x, y+1);
    update(x, y, x, y-1);
  }
  public static void update(int x1, int y1, int x2, int y2){
    if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= n){
      return;
    }
    int a = map[y1][x1]-map[y2][x2];
    if(a > 2 || -a > 2){
      return;
    }
    int pVal = values[y1][x1];
    if(map[y1][x1] > map[0][0] || map[y2][x2] > map[0][0]){
      pVal++;
    }
    if(pVal < values[y2][x2]){
      values[y2][x2] = pVal;
      recurse(x2, y2);
      return;
    }
    return;
  }
}
