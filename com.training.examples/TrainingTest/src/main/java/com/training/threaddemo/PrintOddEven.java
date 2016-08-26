package com.training.threaddemo;

public class PrintOddEven {

	public static void main(String[] args) {
			
		OddClass oc = new OddClass();
		EvenClass ec = new EvenClass();
		
		Thread t1=new Thread(oc);
		Thread t2=new Thread(ec);
		
		t1.start();
		t2.start();
	}

}
