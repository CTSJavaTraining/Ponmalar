package com.training.threaddemo;

public class OddEvenMain {
	public static void main(String args[]) {
		OddEvenClass oec = new OddEvenClass();
		Thread t1 = new Thread(new OddEvenThread(oec, 10, false));
		Thread t2 = new Thread(new OddEvenThread(oec, 10, true));
		t1.start();
		t2.start();
	}

}
