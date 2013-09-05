package main;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> first;
	private Node<Item> last;
	private int size;

	private class Node<Item> {
		Item item;
		Node<Item> next;
		Node<Item> previous;
	}

	public Deque() {
		this.size = 0;
		first = null;
		last = null;
	}

	// is the dequeue empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the dequeue
	public int size() {
		return size;
	}

	// insert the item at the front
	public void addFirst(Item item) {

		// we check if item is null and after that if its the first item
		isNullItem(item);
		if (size == 0) {
			isFirstItem(item);
		} else {
			// now we can add the item
			Node<Item> oldFirst = first; // saving the old first item in Linked
											// List
			first = new Node<Item>(); // make a new first Node
			first.item = item;
			first.next = oldFirst; // we set new first item to point to the old
									// first newFirst => oldFirst
			oldFirst.previous = first; // we set the old first to point back at
										// the
										// new first newFirst <= oldFirst
			first.previous = null;

			// Increase the size of List
			size++;

		}
	}

	// insert the item at the end
	public void addLast(Item item) {

		// we check if item is null
		isNullItem(item);
		if (size == 0) {
			isFirstItem(item);
		} else {

			Node<Item> oldLast = last; // save the old last item

			last = new Node<Item>(); // make a new last Node
			last.item = item; // add item to last no
			last.next = null; // set next item to null since its the end of the
			last.previous = oldLast;

			oldLast.next = last;

			// Increase the size of List
			size++;
		}

	}

	// delete and return the item at the front
	public Item removeFirst() {
		if (isNullDeque()) { throw new NoSuchElementException(); }
		
		Node<Item> oldFirst = first; // set first to the old first so we can
										// return it
		first = first.next; // set the new first to the next item in the Linked
		size--; // we removed an item so we need to down-size

		return oldFirst.item;
	}

	private boolean isNullDeque() {
		if (size == 0) { return true; }
		return false;
	}

	// delete and return the item at the end
	public Item removeLast() {
		Node<Item> oldLast = last;
		// change last to point to the previous
		last = last.previous;
		size--; // we removed an item so we need to down-size

		return oldLast.item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Item>() {
			private Node<Item> current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Item next() {
				if (!hasNext()) throw new NoSuchElementException();
				
				Item item = current.item; // we store the current node item in
											// an generic object
				current = current.next; // advance the node if its not null
				// else throw new NoSuchElementException();
				return item; // now we return the item
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();

			}
		};
	}

	private boolean isNullItem(Item item) {
		if (item == null)
			return true;
		else return false;
	}

	private void isFirstItem(Item item) {

		first = new Node<Item>(); // we create a new node
		first.item = item; // we add the item the client wants to add
		first.next = null; // there is just one item
		first.previous = null; // same as above

		// we set the first and the last node to point to the same object
		last = first;
		size++; // we set the size to be 1 now

	}

	public static void main(String[] args) {

		Deque<String> testDeque = new Deque<String>();
		testDeque.addLast("Hey");
		testDeque.addLast("You");
		testDeque.addLast("are");
		testDeque.addLast("a");
		testDeque.addLast("God");

		
		for (String s: testDeque){
			System.out.println(s);
		}
	}

}
