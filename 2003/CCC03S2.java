import java.io.*;

public class CCC03S2{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int verses = Integer.parseInt(br.readLine());
        for(int v = 0; v < verses; v++){
            String[] rhyme = new String[4];
            for(int x = 0; x < 4; x++){
                String[] input = br.readLine().split(" ");
                rhyme[x] = findRhyme(input[input.length-1].toLowerCase());
            }
            if(rhyme[0].equals(rhyme[1]) && rhyme[1].equals(rhyme[2]) && rhyme[2].equals(rhyme[3])){
                System.out.println("perfect");
            }else if(rhyme[0].equals(rhyme[1]) && rhyme[2].equals(rhyme[3])){
                System.out.println("even");
            }else if(rhyme[0].equals(rhyme[2]) && rhyme[1].equals(rhyme[3])){
                System.out.println("cross");
            }else if(rhyme[0].equals(rhyme[3]) && rhyme[2].equals(rhyme[1])){
                System.out.println("shell");
            }else{
                System.out.println("free");
            }
        }
    }
    public static String findRhyme(String in){
        String out = "";
        char[] input = in.toCharArray();
        for(int x = 0; x < input.length; x++){
            if(isVowel(input[x])){
                out = String.valueOf(input[x]);
            }else{
                out += String.valueOf(input[x]);
            }
        }
        return out;
    }
    public static boolean isVowel(char in){
        return in == 'u' || in == 'o' || in == 'i' || in == 'e' || in == 'a';
    }
}