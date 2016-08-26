package com.training.threaddemo;

import java.util.*;

public class EvenClass extends Thread {

	List<Integer> numbers = new ArrayList<Integer>();

	public void run() {
		try {
			printEven();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void printEven() throws InterruptedException {
		synchronized (numbers) {
			
			for (int i = 0; i < 10; i++) {
				if(i%2!=0)
				{
				System.out.println(i);
				numbers.wait();
				}
				else
				{
				numbers.notifyAll();
				}
			
				
			}
			Thread.sleep(1000);
			
		}
	}
}
