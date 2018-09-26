import java.io.*;

public class CCC03S1{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int space = 1;
        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                System.out.println("You Quit!");
                break;
            }
            if(space + input < 100){
                space += input;
                space = SpecialCase(space);
            }else if(space + input == 100){
                System.out.println("You are now on square 100");
                System.out.println("You Win!");
                break;
            }
            System.out.println("You are now on square " + space);
        }
    }
    public static int SpecialCase(int in){
        switch(in){
            case 54:
                return 19;
            case 90:
                return 48;
            case 99:
                return 77;
            case 9:
                return 34;
            case 40:
                return 64;
            case 67:
                return 86;
        }
        return in;
    }
}