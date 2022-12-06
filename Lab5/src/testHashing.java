import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class testHashing {//make sure a value is the same as in Hasing.java

	@Test
	void testHashPolynomial() throws IOException { //tests if the word "Test" has the correct hash code
		Hashing hash = new Hashing();
		long x = hash.hashPolynomial("Test",41);
		// with a = 41
		String s = "Test";
		long h = 0;
		final char[] x2 = s.toCharArray();
		final int n = s.length();
		final int a = 41;

		for (int i = 0; i < n; i++) {
			long ascii = x2[i];
			long power = (long) Math.pow(a, n - (i + 1));
			h = h + (ascii * power);
		}

		// with a = 41
		assertEquals(h, x);
	}

	@Test
	void testCompressionMAD() throws IOException {//tests if the word "Test" has the correct compression
		Hashing hash = new Hashing();
		long x = hash.hashPolynomial("Test",41);
		long y = hash.compressionMAD(x);

		// with a = 41
		String s = "Test";
		long h = 0;
		final char[] x2 = s.toCharArray();
		final int n = s.length();
		final int a = 41;

		for (int i = 0; i < n; i++) {
			long ascii = x2[i];
			long power = (long) Math.pow(a, n - (i + 1));
			h = h + (ascii * power);
		}
		int N = 560000;
		int p = 560017;
		int a2 = 500000;
		int b = 10000;

		long c = (Math.abs((a2 * h + b)) % p) % N;

		assertEquals(c, y);

	}
	@Test
	void testpoly() throws IOException { //tests if the first word has the calculated hash code
		Hashing hash = new Hashing();
		assertEquals(50, hash.poly(41)[0]);

	}

	@Test
	void testMAD() throws IOException {//tests if the word "Test" has the correct compression
		Hashing hash = new Hashing();
		assertEquals(369252, hash.MAD(41)[0]);
	}

	@Test
	void testcollisions() {//tests the collisions method works with this given array
		long[] arr = new long[6];
		long a = 2;
		long b = 2;
		long c = 2;
		long d = 1;
		long e = 1;
		long f = 3;

		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		arr[4] = e;
		arr[5] = f;

		Hashing hash = new Hashing();
		String result = hash.collisions(arr);

		assertEquals("total collisions: " + 2 + "\nmax collision: " + 3, result);
	}

}
