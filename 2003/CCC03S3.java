import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class CCC03S3{
	static boolean[][] map;//true for visited
	static int r,c;
	//static boolean[][] visited;
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int f = Integer.parseInt(br.readLine());
		r = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		map = new boolean[r][c];
		ArrayList<Integer> rooms = new ArrayList<Integer>();
		for(int x = 0; x < r; x++){
			char[] in = br.readLine().toCharArray();
			for(int y = 0 ; y < c; y++){
				map[x][y] = (in[y] == 'I');
			}
		}
		for(int x = 0; x < r; x++){
			for(int y = 0 ; y < c; y++){
				if(!map[x][y]){
					rooms.add(recurse(x,y));
				}
			}
		}
		//bubble
		for(int x = rooms.size()-1; x > 0; x--){
			for(int y = 0; y < x; y++){
				if(rooms.get(y) < rooms.get(y+1)){
					int store = rooms.get(y);
					rooms.remove(y);
					rooms.add(y+1,store);
				}
			}
		}
		int R = 0;//floors = f
		for(int x = 0; x < rooms.size(); x++){
			if(f >= rooms.get(x)){
				f-= rooms.get(x);
				R++;
			}else{
				break;
			}
		}
		if(R == 1){
			System.out.println(R + " room, "  + f + " square metre(s) left over");
		}else{
			System.out.println(R + " rooms, " + f + " square metre(s) left over");
		}
		
	}
	public static int recurse(int x, int y){
		if(x < 0 || x >= r || y < 0 || y >= c){
			return 0;
		}
		if(map[x][y]){
			return 0;
		}
		int sum = 1;
		map[x][y] = true;
		sum += recurse(x+1,y);
		sum += recurse(x-1,y);
		sum += recurse(x,y+1);
		sum += recurse(x,y-1);
		return sum;
	}
}