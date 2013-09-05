package main;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int size;
	private Item[] randomItems;

	// construct an empty randomized queue
	public RandomizedQueue() {
		this.size = 0;
		randomItems = (Item[]) new Object[2];
	}

	// is the queue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the queue
	public int size() {
		return size;
	}

	// add the item
	public void enqueue(Item item) {
		if (isNullItem(item)) {
			throw new NullPointerException();
		}
		if (size == randomItems.length) { resize(2 * randomItems.length); } // we double the size of the array
		
		randomItems[size++] = item;
	}

	// delete and return a random item
	public Item dequeue() {
		if (isQueueEmpty())
			throw new NoSuchElementException();
		int random = StdRandom.uniform(size); // create a random int size 0 to
												// size
		Item item = randomItems[random]; // save return item
		randomItems[random] = randomItems[size - 1]; // overwrite the random
														// item with the last in
														// the list
		randomItems[size - 1] = null; // and delete the last item
		size--; // since we have one less item we lower the size of array
		return item;
	}

	// return (but do not delete) a random item
	public Item sample() {
		if (isQueueEmpty())
			throw new NoSuchElementException();

		int random = StdRandom.uniform(size); // create a random int size 0 to
												// size
		Item item = randomItems[random]; // save return item
		return item;
	}

	// return an independent iterator over items in random order
	@Override
	public Iterator<Item> iterator() {

		return new RandomIterator();
	}

	private class RandomIterator implements Iterator<Item> {
		private Item[] randomIteratorItems = (Item[]) new Object[size];
		private int iteratorSize;

		public RandomIterator() {

			for (int i = 0; i < size; i++) {
				randomIteratorItems[i] = randomItems[i];
			}
			iteratorSize = size;
		}

		@Override
		public boolean hasNext() {
			return iteratorSize != 0;
		}

		@Override
		public Item next() {
			if (hasNext()) {

				int random = StdRandom.uniform(iteratorSize);
				Item item = randomIteratorItems[random];
				randomIteratorItems[random] = randomIteratorItems[iteratorSize - 1];
				randomIteratorItems[iteratorSize - 1] = null;
				iteratorSize--;
				return item;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}
	private void resize(int capacity){
		assert capacity >= size;
		Item[] biggerArray = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++){
			biggerArray[i] = randomItems[i];
		}
		randomItems = biggerArray; // we overwrite the old array with the bigger one we created
	}

	private boolean isQueueEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	private boolean isNullItem(Item item) {
		if (item == null) {
			return true;
		}
		return false;
	}

}
