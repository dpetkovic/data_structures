package test;
import static org.junit.Assert.*;

import java.util.Iterator;

import main.RandomizedQueue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RandomQueueTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandom() {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("Hey");
		queue.enqueue("you");
		queue.enqueue("Dark");
		queue.enqueue("Elf");
		queue.enqueue("Master");
		queue.enqueue("Evil");
		queue.enqueue("Of Doom");
		queue.enqueue("must");
		queue.enqueue("mad");
		queue.enqueue("happy");
		
		assertEquals(queue.size(), 10);
		System.out.println("====Test1======");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		assertEquals(queue.size(), 5);
	}
	
	@Test
	public void testRandomIteration() {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("Hey");
		queue.enqueue("you");
		queue.enqueue("Dark");
		queue.enqueue("Elf");
		queue.enqueue("Master");
		queue.enqueue("Evil");
		queue.enqueue("Of Doom");
		queue.enqueue("must");
		queue.enqueue("mad");
		queue.enqueue("happy");
		
		Iterator<String> iterator = queue.iterator();
		System.out.println("====Test2======");
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
				

	}
	
	@Test
	public void testSample() {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("Hey");
		queue.enqueue("you");
		queue.enqueue("Dark");
		queue.enqueue("Elf");
		queue.enqueue("Master");
		queue.enqueue("Evil");
		queue.enqueue("Of Doom");
		queue.enqueue("must");
		queue.enqueue("mad");
		queue.enqueue("happy");
		
		System.out.println("====Test3======");
		for (String s : queue){
			System.out.println(s);
		}
	}
	
	@Test
	public void testFirstItem() {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("Hey");
		
		
		System.out.println("====Test4======");
		System.out.println(queue.sample());
	}
	
	

}
