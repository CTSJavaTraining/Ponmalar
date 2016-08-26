package com.training.threaddemo;

public class OddEvenThread implements Runnable {

	private int max;
	private OddEvenClass oec;
	private boolean isEvenNumber;

	OddEvenThread(OddEvenClass print, int max, boolean isEvenNumber) {
		this.oec = print;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
	public void run() {

		int number = isEvenNumber == true ? 2 : 1;
		while (number <= max) {

			if (isEvenNumber) {

				oec.printEven(number);

			} else {

				oec.printOdd(number);
			}
			number += 2;
		}

	}

}
