package algorithmsDesignAnalysis;

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class HashTableTest {
        static int[] hash=new int[10000000];
        static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        static int[] num={231552,234756,596873,648219,726312,981237,988331,1277361,1283379};
        static int[] flag=new int[9];
        
        public static void read(String filename) throws IOException{
                BufferedReader in=new BufferedReader(new FileReader(filename));
                String s;
                int i=0;
                while((s=in.readLine())!=null){
                        int temp=Integer.parseInt(s);
                        map.put(i,temp);
                        System.out.println(temp);
                        for(int j=0;j<9;j++){
                                if(map.containsValue(num[j]-temp)){
                                        flag[j]=1;
                                }
                        }
                        i++;
                }
        }
        
        public static void read_second(String filename) throws IOException{
                BufferedReader in =new BufferedReader(new FileReader(filename));
                String s;
                int i=0;
                
                while((s=in.readLine())!=null){
                        int temp=Integer.parseInt(s);
                        System.out.println(temp);
                        for(int j=0;j<9;j++){
                                if((num[j]-temp)>0&&hash[num[j]-temp]==1){
                                        flag[j]=1;
                                }
                        }
                        hash[temp]++;
                }
        }
        public static void main(String[] args){
                try{read_second("C:/Users/Yan/Desktop/cpp/prob2sum.txt");
                for(int i=0;i<9;i++){
                        System.out.print(flag[i]);
                }
                }catch(IOException err){
                        System.out.println(err.toString());
                        err.printStackTrace();
                }
        }
}
