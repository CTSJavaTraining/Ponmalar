package com.training.threaddemo;

import java.util.List;

/**
 * This Consumer class implements Runnable lass and overrides the run method in
 * order to consume the messages dropped in taskList by producer class of the
 * same package. The taskList resource is synchronized making the consumer to
 * wait when the list is empty.
 * 
 * @author Ponmalar
 *
 */
class Consumer implements Runnable {
	private final List<Integer> taskList;

	/**
	 * class constructor initializing list
	 * 
	 * @param sharedList
	 */
	public Consumer(List<Integer> sharedList) {
		this.taskList = sharedList;
	}

	/**
	 * run method of Runnable interface overridden and calls consume method when
	 * the list has some messages
	 */
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * the consume method consumes the message in the list and waits when the
	 * list is empty. the list is synchronized with producer thread of the same
	 * package
	 * 
	 * @throws InterruptedException
	 */
	private void consume() throws InterruptedException {
		synchronized (taskList) {
			while (taskList.isEmpty()) {
				System.out.println(
						"List is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskList.size());
				taskList.wait();
			}
			//Thread.sleep(1000);
			int i = (Integer) taskList.remove(0);
			System.out.println("Consumed: " + i);
			taskList.notifyAll();
		}
	}
}