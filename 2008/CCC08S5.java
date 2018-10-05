import java.io.*;
//no ac on dmoj :( not fast enough 
public class CCC08S5{
  static int[][] moves = {
    {2,1,0,2},
    {1,1,1,1},
    {0,0,2,1},
    {0,3,0,0},
    {1,0,0,1}
  };
  public static void main(String[]args)throws IOException{    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    for(int tc = 0; tc < testCase; tc++){
      String[] input = br.readLine().split(" ");
      int[] parts = new int[4];
      for(int x = 0; x < 4; x++){
        parts[x] = Integer.parseInt(input[x]);
      }
      if(miniMax(parts)){
        System.out.println("Patrick");
      }else{
        System.out.println("Roland");
      }
    }
  }
  public static boolean miniMax(int[] parts){ //return true == can win
    boolean[] choice = new boolean[moves.length];
    for(int x = 0; x < moves.length; x++){
      int[] r = makeMove(parts, x);
      if(r[0] != -1){
        if(!miniMax(r)){
          return true;
        }
      }
    }
    return false;
  }
  public static int[] makeMove(int[] parts, int m){
    int[] r = new int[4];
    for(int x = 0; x < 4; x++){
      r[x] = parts[x] - moves[m][x];
      if(r[x] < 0){
        r[0] = -1;
        return r;
      }
    }
    return r;
  }
}