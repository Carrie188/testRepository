import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;


public class Test {
	
	enum Month {JAN,FEB,MAR,APR};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		ArrayList<String> aryList = new ArrayList<String>();
		
		aryList.add("1");
		aryList.add("1");
		aryList.add(0, "9");
		aryList.set(2,"8");

		

		
//		Arrays.sort(ary,2,5);
//		Arrays.fill(ary, 0);
		for (String j : aryList) {
			System.out.println(j);
			Logger.getLogger("this is a new log comment");
		}
		System.out.println(Month.MAR);
	}

}
