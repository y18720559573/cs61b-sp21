package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.net.StandardSocketOptions;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove () {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> incorrect = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);
        incorrect.addLast(4);
        incorrect.addLast(5);
        incorrect.addLast(6);

        assertEquals(correct.size(), incorrect.size());
        assertEquals(correct.removeLast(), incorrect.removeLast());
        assertEquals(correct.removeLast(), incorrect.removeLast());
    }

    @Test
    public void randomizedTest () {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                assertEquals(L.size(), L2.size());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = L2.size();
                System.out.println("size: " + size);
                assertEquals(size, size2);
            }
            else if (operationNumber == 2) {
                if (L.size() > 0) {
                    int last = L.getLast();
                    int last2 = L2.getLast();
                    System.out.println("last: " + last);
                    assertEquals(last, last2);
                }
            }
            else if (operationNumber == 3) {
                if (L.size() > 0) {
                    int last = L.removeLast();
                    int last2 = L2.removeLast();
                    System.out.println("has removed: " + last);
                    assertEquals(last, last2);
                }
            }
        }
    }
}
