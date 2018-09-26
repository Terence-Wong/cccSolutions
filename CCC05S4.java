import java.io.*;
import java.util.ArrayList;

public class CCC05S4{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int test = 0; test < tc; test++){
            int msgs = Integer.parseInt(br.readLine()); 
            int og = msgs*10;
            ArrayList<String> list = new ArrayList<String>();
            list.add("*");
            list.add(br.readLine());
            int maxSize = 2;
            for(int x = 1; x < msgs; x++){
                String in = br.readLine();
                if(list.size() == 1){
                    list.add(in);
                }else if(in.equals(list.get(list.size()-2))){
                    list.remove(list.size()-1);
                }else if(list.get(list.size()-2).equals("*")){
                    list.remove(list.size()-1);
                }else{
                    list.add(in);
                }
                if(list.size() > maxSize){
                    maxSize = list.size();
                }
            }
            System.out.println(og-maxSize*20);
        }
    }
}
