import java.io.*;
//fail :(
public class CCC09J5{
  static boolean[][] map;
  static boolean[] visited;
  public static void main(String[]args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new boolean[49][49];
    command(0, 5, 'i');
    command(1, 5, 'i');
    command(2, 5, 'i');
    command(3, 5, 'i');
    command(4, 5, 'i');
    command(6, 5, 'i');
    command(7, 6, 'i');
    command(7, 8, 'i');
    command(9, 8, 'i');
    command(11, 8, 'i');
    command(10, 9, 'i');
    command(10, 11, 'i');
    command(11, 12, 'i');
    command(12, 13, 'i');
    command(12, 14, 'i');
    command(15, 16, 'i');
    command(17, 16, 'i');
    command(17, 15, 'i');
    command(2, 14, 'i');
    command(2, 4, 'i');
    command(2, 3, 'i');
    command(3, 4, 'i');
    char command = br.readLine().charAt(0);
    while(command!='q'){
      int x = Integer.parseInt(br.readLine())-1;
      if(command == 'n' || command == 'f'){
        command(x, 0, command);
      }else{
        int y = Integer.parseInt(br.readLine())-1;
        command(x, y, command);
      }
      command = br.readLine().charAt(0);
    }
  }
  public static int connectivity(int x, int y){
    visited[x] = true;
    if(map[x][y]){
      return 1;
    }
    int l = Integer.MAX_VALUE;
    for(int i = 0; i < 49; i++){
      if(map[x][i] && !visited[i]){
        int r = connectivity(i, y);
        if(r != Integer.MAX_VALUE){
          l = Math.min(r+1,l);
        }
      }
    }
    return l;
  }
  public static void command(int x, int y, char c){
    int sum = 0;
    switch(c){
      case 'i':
        map[x][y] = true;
        map[y][x] = true;
        break;
      case 'd':
        map[x][y] = false;
        map[y][x] = false;
        break;
      case 'n':
        sum = 0;
        for(int i = 0; i < 49; i++){
          if(map[x][i]){
            sum++;
          }
        }
        System.out.println(sum);
        break;
      case 'f':
        boolean[] r = new boolean[49];
        for(int i = 0; i < 49; i++){
          if(map[x][i]){
            for(int j = 0; j < 49; j++){
              if(map[i][j]){
                r[j] = true;
              }
            }
          }
        }
        r[x] = false;
        sum = 0;
        for(int i = 0; i < 49; i++){
          if(r[i] && !map[x][i]){
            sum++;
          }
        }
        System.out.println(sum);
        break;
      case 's':
        visited = new boolean[49];
        int result = connectivity(x, y);
        if(result == Integer.MAX_VALUE){
          System.out.println("Not connected");
        }else{
          System.out.println(result);
        }
        break;
      //case 'q'
    }
  }
}


