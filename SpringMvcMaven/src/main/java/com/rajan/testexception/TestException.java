package com.rajan.testexception;

import java.io.FileInputStream;
import java.io.IOException;

public class TestException {

	public static void callDivide() throws BadNumberException, InterruptedException, IOException{
        try {
            int result = divide(2,0);
            System.out.println(result);
        } catch (BadNumberException e) {
            //do something clever with the exception
            System.out.println("exception caught "+e);
            System.out.println("exception sda ");
            Thread.sleep(5000);
            System.out.println("exception asd ");
            System.out.println("exception vvvvvvv ");
            throw new BadNumberException(e);
        }finally{
        	FileInputStream fis=null;
        	System.out.println("before finally");
				//fis.close();
				Thread.sleep(5000);
        	System.out.println("in finally");
        }
        System.out.println("Division attempt done");
    }
	public static int divide(int x,int y) throws BadNumberException{
		int a=0;
		try {
			a=x/y;
		} catch (Exception e) {
			throw new BadNumberException(e);
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		try {
			callDivide();
		} catch (BadNumberException e) {
			// TODO Auto-generated catch block
			System.out.println("Caught in main"+e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Caught in main exception"+e);		}

	}

}
