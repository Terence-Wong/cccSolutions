import java.io.*;
import java.util.*;

public class CCC05S3{
	public static void main(String[]args) throws IOException{
		int maxT = 0,minT = 0,maxRS = 0,minRS = 0,maxCS = 0,minCS = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] current = {{1}};
		int[][] b;
		
		for(int t = 0; t < n; t++){
			String[] in = br.readLine().split(" ");
			int yc = Integer.parseInt(in[0]), xc = Integer.parseInt(in[1]);
			b = new int[yc][xc];
			
			for(int y = 0; y < yc; y++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < xc; x++){
					b[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			current = quantize(current,b,t == n-1);
		}

	}
	public static int[][] quantize(int[][] am, int[][] bm, boolean last){
		int[][] rm = new int[am.length*bm.length][am[0].length*bm[0].length];//[height][width] 
		
		if(!last){
			for(int y = 0; y < am.length; y++){//group height
				for(int x = 0; x < am[0].length; x++){//group width
					
					for(int yy = 0; yy < bm.length; yy++){//cell height
						for(int xx = 0; xx < bm[0].length; xx++){//cell width
							
							rm[y*bm.length + yy][x*bm[0].length + xx] = am[y][x] * bm[yy][xx];
							
						}
					}
					
				}
			}
		}else{
			int maxT = Integer.MIN_VALUE,minT = Integer.MAX_VALUE,maxRS = Integer.MIN_VALUE,minRS = Integer.MAX_VALUE,maxCS = Integer.MIN_VALUE,minCS = Integer.MAX_VALUE;
			
			for(int y = 0; y < am.length; y++){//group height
				for(int x = 0; x < am[0].length; x++){//group width
					
					for(int yy = 0; yy < bm.length; yy++){//cell height
						for(int xx = 0; xx < bm[0].length; xx++){//cell width
							int val = am[y][x] * bm[yy][xx];
							rm[y*bm.length + yy][x*bm[0].length + xx] = val;
							
							//value tests
							if(val > maxT){
								maxT = val;
							}
							if(val < minT){
								minT = val;
							}
						}
					}
					
				}
			}
			//coloumn/row value tests
			for(int x = 0; x < rm[0].length; x++){//every column
				int sum = 0;
				for(int y = 0; y < rm.length; y++){
					int val = rm[y][x];
					sum += val;
					
				}
				if(sum < minCS){
					minCS = sum;
				}
				if(sum > maxCS){
					maxCS = sum;
				}
			}
			for(int y = 0; y < rm.length; y++){//every row
				int sum = 0;
				for(int x = 0; x < rm[0].length; x++){
					int val = rm[y][x];
					sum += val;
					
				}
				if(sum < minRS){
					minRS = sum;
				}
				if(sum > maxRS){
					maxRS = sum;
				}
			}
			
			//output
			System.out.println(maxT);
			System.out.println(minT);
			System.out.println(maxRS);
			System.out.println(minRS);
			System.out.println(maxCS);
			System.out.println(minCS);
		}
		return rm;
	}
}
