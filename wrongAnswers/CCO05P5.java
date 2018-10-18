import java.io.*;

public class CCO05P5{
  public static void main(String[]args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int startx = 1;
    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n-1; i++){
      String[] in = br.readLine().split(" ");
      int a = Integer.parseInt(in[0]);
      int b = Integer.parseInt(in[1]);
      int minD = distance(a, b, startx, 1);
      int minI = 1;
      for(int j = 2; j <= n; j++){
        int q = distance(a, b, startx, j);
        if(q < minD){
          minD = q;
          minI = j;
        }
        //System.out.println(distance(a, b, startx, j));
      }
      startx = minI;
      sum += minD;
    }
    String[] in = br.readLine().split(" ");
    int a = Integer.parseInt(in[0]);
    int b = Integer.parseInt(in[1]);
    sum += distance(a, b, startx, n);
    System.out.println(sum);
  }
  public static int distance(int a, int b, int s, int d){
    int r = 0;
    if(s < a){
      r += b - s;
      return Math.abs(b-d) + r; 
    }else if(s > b){
      r += s - a;
      return Math.abs(s-d) + r;
    }else if(d < a){
      r += b - d;
      return Math.abs(b-s) + r; 
    }else if(d > b){
      r += d - a;
      return Math.abs(s-s) + r;
    }
    int x = Math.min(s,d);
    int y = Math.max(s,d);
    //System.out.println("");
    //System.out.print(a-s + " ");
   // System.out.print(b-d + " ");
    //System.out.print(b-a + " ");
    //System.out.println("");
    
    r += (x-a);
    r += (b-y);
    r += (b-a);
    return r;
    // 7, 6, 7, 8, 7, 6
  }
}