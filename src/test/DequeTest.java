package test;
import static org.junit.Assert.*;

import java.util.Iterator;

import junit.framework.Assert;

import main.Deque;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author deki
 *
 */
public class DequeTest {
	private static int testCount;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting Test on Deque");
		testCount = 0;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Test End");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testCount++;
		System.out.println("Test " + testCount);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test // tests if the constructor is working
	public void testConstructor() {
		Deque<String> testDeque = new Deque<String>();
		assertEquals("Error in Deque Constructor", testDeque.size(), 0);
	}
	
	@Test // testing addFirst() and removeFirst()
	public void testaddFirst() {
		Deque<String> testDeque = new Deque<String>();
		
		// adding Strings to test
		testDeque.addFirst("God");
		testDeque.addFirst("a");
		testDeque.addFirst("are");
		testDeque.addFirst("You");
		testDeque.addFirst("Hey");
		
		// System.out.println("testDeque.removeFirst(): " + testDeque.removeFirst());
		// System.out.println("testDeque.removeLast(): " + testDeque.removeLast());
		
		// testing removeFirst() Method
		assertEquals("Error in Deque addFirst - removeFirst", testDeque.removeFirst(), "Hey");
		assertEquals("Error in Deque addFirst - removeFirst", testDeque.removeFirst(), "You");
		assertEquals("Error in Deque addFirst - removeFirst", testDeque.removeFirst(), "are");
		assertEquals("Error in Deque addFirst - removeFirst", testDeque.removeFirst(), "a");
		assertEquals("Error in Deque addFirst - removeFirst", testDeque.removeFirst(), "God");
		
	}
	
	@Test // tests addLast() and removeLast() methods
	public void testaddLast() {
		Deque<String> testDeque = new Deque<String>();
		testDeque.addLast("Hey");
		testDeque.addLast("You");
		testDeque.addLast("are");
		testDeque.addLast("a");
		testDeque.addLast("God");
		
		assertEquals("Error in Deque addFirst", testDeque.removeLast(), "God");
		assertEquals("Error in Deque addFirst", testDeque.removeLast(), "a");
		assertEquals("Error in Deque addFirst", testDeque.removeLast(), "are");
		assertEquals("Error in Deque addFirst", testDeque.removeLast(), "You");
		assertEquals("Error in Deque addFirst", testDeque.removeLast(), "Hey");
	}
	@Test // testing if size is updating like it should
	public void testSize() {
		Deque<String> testDeque = new Deque<String>();
		testDeque.addLast("Hey");
		testDeque.addLast("You");
		testDeque.addLast("are");
		testDeque.addLast("a");
		testDeque.addLast("God");
		
		testDeque.removeLast();
		testDeque.removeLast();
		
		assertEquals("Error in size()", testDeque.size(), 3);

	}
	
	@Test // testing iterator
	public void testIterator(){
		Deque<String> testDeque = new Deque<String>();
		testDeque.addLast("Hey");
		testDeque.addLast("You");
		testDeque.addLast("are");
		testDeque.addLast("a");
		testDeque.addLast("God");
		
		Iterator<String> iterator = testDeque.iterator();
		
		assertEquals("Error in iteraor()", iterator.next(), "Hey");
		assertEquals("Error in iteraor()", iterator.next(), "You");
		assertEquals("Error in iteraor()", iterator.next(), "are");
		assertEquals("Error in iteraor()", iterator.next(), "a");
		assertEquals("Error in iteraor()", iterator.next(), "God");
		
	}
	
	

}
