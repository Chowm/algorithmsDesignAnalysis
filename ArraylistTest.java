package algorithmsDesignAnalysis;

import java.util.ArrayList;

public class ArraylistTest {
	public static void main(String[] args){
		
		System.out.println("1234%10= " + (1234%10) +".   -1234%10= " + (-1234%10));
		
		
		ArrayList<Integer> List = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++){
			int temp= i*2;
			List.add(temp+2);
		}
		
		for(int k=0; k<List.size(); k++){
			System.out.println("indexOf k= " + k + ". List[" +k +"] = " + List.get(k));
		}
	}

}
