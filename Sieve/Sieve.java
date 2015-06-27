import java.util.*;


public class Sieve {

	Queue<Integer> numbersQueue;
	Queue<Integer> primesQueue;
	int max;
	boolean initialized = false;

	public void computeTo(int number) {

		if (number < 2) {
			throw new IllegalArgumentException("n should be not less than 2");
		}

		numbersQueue = new LinkedList<Integer>();
		primesQueue = new LinkedList<Integer>();
		max = number;
		initialized = true;

		for (int i=2; i<= max; i++) {
			numbersQueue.add(i);
		}

		int p;

		 do {

			p = numbersQueue.poll();

			primesQueue.add(p);

			Iterator<Integer> iter = numbersQueue.iterator();

			while (iter.hasNext()) {
				int n = iter.next();
				if ((n % p) == 0) {
					iter.remove();
				}
			}
			
		} while (p <= Math.sqrt(max));

		primesQueue.addAll(numbersQueue);
	}

	public void reportResults() {

		if (!initialized) {
			throw new IllegalStateException();
		}

		int count = 0;

		for (int element: primesQueue) {
			System.out.print(element+" ");
			count++;
			if (count == 12) {
				System.out.println();
				count = 0;
			}
		}
		System.out.println();
	}

	public int getMax() {

		if (!initialized) {
			throw new IllegalStateException();
		}

		return max;
	
	}

	public int getCount() {

		if (!initialized) {
			throw new IllegalStateException();
		}

		return primesQueue.size();
		
	}
}

