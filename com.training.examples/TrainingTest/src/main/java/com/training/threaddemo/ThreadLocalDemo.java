package com.training.threaddemo;

/**
 * this class shows a simple demo of ThreadLocal concept
 * 
 * @author 447383
 *
 */
public class ThreadLocalDemo implements Runnable {
	/**
	 * the value is going to be set as the threadlocal value and is defined as
	 * static to understand the threadlocal concept more clearly
	 */
	static Double value = 0.0D;
	ThreadLocal<Double> threadLocal = new ThreadLocal<Double>();

	/**
	 * the run method is overriden and the value is set to threadlocal here and
	 * displayed on console
	 */
	@Override
	public void run() {

		threadLocal.set((value = Math.random() * 100D));
		checkA();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Value: " + threadLocal.get());
	}

	public void checkA() {
		System.out.println(Thread.currentThread().getName() + " Value: " + threadLocal.get() + "Inside Class A");
		CheckB();

	}

	public void CheckB() {
		System.out.println(Thread.currentThread().getName() + " Value: " + threadLocal.get() + "Inside Class B");

	}

	/**
	 * main method creates two separate thread objects for the ThreadLocalDemo
	 * class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadLocalDemo tlm = new ThreadLocalDemo();
		Thread t1 = new Thread(tlm);
		Thread t2 = new Thread(tlm);
		t1.start();
		t2.start();

	}

}
