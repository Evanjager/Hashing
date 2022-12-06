import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Hashing {

	int n;

	// Provided for comparison only; feel free not to use
	long hashJava(String s) {
		return s.hashCode();
	}

	long hashPolynomial(String s, int a) throws IOException {
		long hash = 0;
		final char[] x = s.toCharArray();
		final int n = s.length();

		for (int i = 0; i < n; i++) {
			long ascii = x[i];
			long power = (long) Math.pow(a, n - (i + 1));
			hash = hash + (ascii * power);
		}
		return hash; // TO DO MODIFY TO ANSWER THE LAB QUESTION
	}

	long compressionMAD(long i) throws IOException {
		int N = 560000;
		int p = 560017;
		int a = 500000;
		int b = 10000;

		long c = (((a * i + b)) % p) % N;

		return c;
	}

	long[] poly(int a) throws IOException {//reads all the words and calls the hash code method
		String webaddress = "https://github.com/dwyl/english-words/raw/master/words.txt";
		URL url = new URL(webaddress);
		Scanner scan = new Scanner(url.openStream());
		Hashing hash = new Hashing();

		long[] arr = new long[466550];
		int count = 0;
		while (scan.hasNext()) {
			String word = scan.next();
			long hashvalue = hash.hashPolynomial(word,a);

			arr[count] = hashvalue;
			count++;
		}
		return arr;

	}

	long[] MAD(int a) throws IOException {//reads all the words and calls the hash code and compression method
		String webaddress = "https://github.com/dwyl/english-words/raw/master/words.txt";
		URL url = new URL(webaddress);
		Scanner scan = new Scanner(url.openStream());
		Hashing hash = new Hashing();

		long[] arr = new long[466550];
		int count = 0;
		while (scan.hasNext()) {
			String word = scan.next();
			long hashvalue = hash.hashPolynomial(word,a);
			long compress = hash.compressionMAD(hashvalue);

			arr[count] = compress;
			count++;
		}
		return arr;

	}

	String collisions(long[] arr) { // Sorts the array then finds duplicates. if there is a duplicate we add it to a
									// set as sets can not contain duplicates then it returns the size of the set to
									// give us how many collisions there are. also as we are looking for duplicates
									// it tracks the most frequent value

		Arrays.sort(arr);
		HashSet set = new HashSet<>();

		int max = 1;
		int current = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				current++;
				set.add(arr[i]);
			} else {
				if (arr != null) {

				}
				current = 1;
			}

			if (current > max) {
				max = current;
			}
		}
		return "total collisions: " + set.size() + "\nmax collision: " + max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Hashing h = new Hashing();
		int a =41;// change for desired value 

		System.out.println("a="+a+"\nPoly hash \n" + h.collisions(h.poly(a))); 
		System.out.println();
		System.out.println("MAD hash \n" + h.collisions(h.MAD(a)));
		

	}

}
