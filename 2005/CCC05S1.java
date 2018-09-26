import java.io.*;
public class CCC05S1{
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++){
			char[] in = br.readLine().toCharArray();
			String out = "";
			int y = 10;
			for(int x = 0; x < in.length && x < y; x++){
				if(in[x] != '-'){
					//num 48-57
					if((int)in[x] >= 48 && (int)in[x] <= 57){
						out += String.valueOf(in[x]);
						continue;
					}
					out += lton(in[x]);
				}else{
					y++;
				}
			}
			//System.out.println(out);
			System.out.println(out.substring(0,3)+"-"+out.substring(3,6)+"-"+out.substring(6,10));
		}
	}
	public static String lton(char a){
		//65-90
		if		((int)a >= 65 && (int)a <= 67){//2
			return "2";
		}else if((int)a >= 68 && (int)a <= 70){//3
			return "3";
		}else if((int)a >= 71 && (int)a <= 73){//4
			return "4";
		}else if((int)a >= 74 && (int)a <= 76){//5
			return "5";
		}else if((int)a >= 77 && (int)a <= 79){//6
			return "6";
		}else if((int)a >= 80 && (int)a <= 83){//7
			return "7";
		}else if((int)a >= 84 && (int)a <= 86){//8
			return "8";
		}else if((int)a >= 87 && (int)a <= 90){//9
			return "9";
		}
		return "";
	}
}
