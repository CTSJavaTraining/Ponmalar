package com.training.threaddemo;

import java.util.List;
import java.util.ArrayList;

/**
 * this class creates thread objects for producer and consumer class and starts
 * both the threads
 */
public class ThreadMain {
	public static void main(String[] args) {
		List<Integer> taskList = new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		Thread tProducer = new Thread(new Producer(taskList, MAX_CAPACITY), "Producer");
		Thread tConsumer = new Thread(new Consumer(taskList), "Consumer");
		tProducer.start();
		tConsumer.start();
	}
}
