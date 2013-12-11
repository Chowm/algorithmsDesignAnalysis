package algorithmsDesignAnalysis;

import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args){
		Hashtable<String, String> employees = new Hashtable<String, String>();
		employees.put("one", "Bob");
		employees.put("two", "Owen");
		employees.put("two", "Owen the II");
		employees.put("five", "Ammy");
		employees.put("three", "John");
		
		for(String etm : employees.keySet()){
			System.out.println(etm +" " + employees.get(etm));
		}
		
		String temp = "two";
		if(employees.containsKey("two")){
			System.out.println("Hash("+temp +")= " + employees.get("two"));
		}
	}
}
