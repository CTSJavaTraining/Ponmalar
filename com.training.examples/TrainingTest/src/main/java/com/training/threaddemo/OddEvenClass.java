package com.training.threaddemo;

public class OddEvenClass {

	boolean isOdd = false;

	synchronized void printEven(int number) {

		while (isOdd == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(number);
		isOdd = false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		while (isOdd == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(number);
		isOdd = true;
		notifyAll();
	}

}
