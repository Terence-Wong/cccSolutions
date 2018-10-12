
public class CCC07S4{
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[][] connections = new boolean[n][];
    for(int i = 0; i < n; i++){
      connections[i] = new boolean[n-1-i];
    }