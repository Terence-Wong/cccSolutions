import java.io.*;

public class CCC05S2{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int width = Integer.parseInt(input[0]);
        int height = Integer.parseInt(input[1]);
        int x = 0;
        int y = 0;
        input = br.readLine().split(" ");
        while (!(input[0].equals("0") && input[1].equals("0"))){
            int xx = Integer.parseInt(input[0]);
            int yy = Integer.parseInt(input[1]);
            if(x + xx < 0){
                x = 0;
            }else if(x + xx > width){
                x = width;
            }else{
                x += xx;
            }
            if(y + yy < 0){
                y = 0;
            }else if(y + yy > height){
                y = height;
            }else{
                y += yy;
            }
            System.out.println(x + " " + y);
            input = br.readLine().split(" ");
        }

    }
}
