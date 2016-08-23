package com.training.threaddemo;

import java.util.List;

/**
 * This Producer class implements Runnable lass and overrides the run method in
 * order to produce messages and drop it in taskList that should be consumed by
 * Consumer class of the same package. The taskList resource is synchronized
 * making the Producer to wait when the list is full.
 * 
 * @author Ponmalar
 *
 */

class Producer implements Runnable {
	public int counter = 0;
	private final List<Integer> taskList;
	private final int MAX_CAPACITY;

	/**
	 * class constructor initializing list and maximum capacity of the list
	 * 
	 * @param sharedList
	 */
	public Producer(List<Integer> sharedList, int size) {
		this.taskList = sharedList;
		this.MAX_CAPACITY = size;
	}

	/**
	 * run method of Runnable interface overridden and calls produce method
	 * incrementing the counter as the messages count increases
	 */
	public void run() {

		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * the produce method consumes the message in the list and waits when the
	 * list is full, the list is synchronized with consumer thread of the same
	 * package
	 * 
	 * @param i
	 * @throws InterruptedException
	 */
	private void produce(int i) throws InterruptedException {
		synchronized (taskList) {
			while (taskList.size() == MAX_CAPACITY) {
				System.out.println(
						"List is full " + Thread.currentThread().getName() + " is waiting , size: " + taskList.size());
				taskList.wait();
			}

			//Thread.sleep(1000);
			taskList.add(i);
			System.out.println("Produced: " + i);
			taskList.notifyAll();

		}

	}
}