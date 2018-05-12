package javaIQs;

import java.util.Scanner;
import org.junit.Test;

public class GenericProgram {

	static int n1=0,n2=1,n3=0;    
	
	void printFibonacci(int count){    
	    if(count>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         printFibonacci(count-1);    
	     }    
	 }    
	 
	public void fibonacciEx()
	 {
	  int count=10;    
	  System.out.print(n1+" "+n2);//printing 0 and 1    
	  printFibonacci(count-2);//n-2 because 2 numbers are already printed    ==> RECURSIVE loop
	 }  
	 
	public void swappingWithOutTempVariable()
	{
		int x = 1231;
		int y = 5223;

		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

	public void leapYear()
	{
		/*a year is a leap year if it is divisible by four, UNLESS it is also divisible by 100. 
		A year is NOT a leap year if it is divisible by 100 UNLESS it is also divisible by 400.*/

	    	int year;
	    	boolean isLeap = false;
	    	
	    	System.out.println("Enter any Year:");

	    	//Scanner - accepts inputs
	    	Scanner scan = new Scanner(System.in);
	    year = scan.nextInt();
	    	scan.close();
        
	    	//Logic 1
	   	if((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0))
	    	{ 
	    		System.out.println(year + " is a Leap Year.");
	    	}
	    else
	    {
	        System.out.println(year + " is not a Leap Year.");
	    }
	    	
	   //Logic 2	
       if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    isLeap = true;
                else
                    isLeap = false;
            }
            else
            {
                isLeap = true;
            }
        }
        else 
        {
            isLeap = false;
        }

        if(isLeap==true)
            System.out.println(year + " is a Leap Year.");
        else
            System.out.println(year + " is not a Leap Year.");
            
            
    }

	
	
	 
	 
}
