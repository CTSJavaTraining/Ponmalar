package com.training.threaddemo;

public class ThreadLocalDemo implements Runnable {

	@Override
	public void run() {
		ThreadLocal<Double> tl = new ThreadLocal<Double>();
		Double value = 0.0D;
		tl.set((value = Math.random() * 100D));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Value: " + value);
	}

	public static void main(String[] args) {

		ThreadLocalDemo tlm = new ThreadLocalDemo();
		Thread t1 = new Thread(tlm);
		Thread t2 = new Thread(tlm);
		t1.start();
		t2.start();
	}

}
