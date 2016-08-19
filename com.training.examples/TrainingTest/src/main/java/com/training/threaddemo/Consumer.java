package com.training.threaddemo;

import java.util.List;

class Consumer implements Runnable {
	private final List<Integer> taskList;

	public Consumer(List<Integer> sharedQueue) {
		this.taskList = sharedQueue;
	}

	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (taskList) {
			while (taskList.isEmpty()) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: "
						+ taskList.size());
				taskList.wait();
			}
			Thread.sleep(1000);
			int i = (Integer) taskList.remove(0);
			System.out.println("Consumed: " + i);
			taskList.notifyAll();
		}
	}
}