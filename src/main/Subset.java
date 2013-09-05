package main;

import java.util.Random;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Subset {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);

		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}

		for (int i = 0; i < k; i++) {
			StdOut.println(queue.dequeue());
		}
	}
}
