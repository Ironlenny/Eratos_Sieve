package eratos_sieve;
import java.util.ArrayList;

public class SieveInsertSort {
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	private int markedNums[];
	private int newPrime = 2;
	private int maxNum;
	
	private boolean insert (int insert, int pos) {
		int tmp = 0;
		if (insert > maxNum) {}
		else if (insert == markedNums[pos]) {}
		else if ((insert > markedNums[pos]) && (markedNums[pos] != 0)) {
			insert(insert, pos + 1);
		}
		else if (insert < markedNums[pos]) {
			tmp = markedNums[pos];
			markedNums[pos] = insert;
			insert (tmp, pos + 1);
		}
		else {
			markedNums[pos] = insert;
			return true;
		}
		
		return false;
	}
	
	private boolean findPrime (int test, int pos) {
		boolean pass = false;
		if (test > maxNum) {}
		else if (test < markedNums[pos]) {
			primes.add(test);
			newPrime = test;
			pass = true;
		}
		else if (test > markedNums[pos]) {
			pass = findPrime(test, pos + 1);
		}
		else if (test == markedNums[pos]) {
			pass = findPrime (test + 1, pos);
		}
		
		return pass;
	}
	public SieveInsertSort () {
		this.maxNum = 100;
		primes.add(newPrime);
		markedNums =  new int[maxNum + 1];
	}
	
	public SieveInsertSort (int maxNum) {
		this.maxNum = maxNum;
		primes.add(newPrime);
		markedNums =  new int[maxNum + 1];
	}
	
	public ArrayList<Integer> solve () {
		int mCount = 0;
		int num = 0;
		int seq = 2;
		
		do {
			num = seq++ * newPrime;
		} while (insert (num, mCount++) || (num < maxNum));
		
		mCount = 0;
		
		if (findPrime (newPrime + 1, mCount)) {
			solve();
		}
		
		return primes;
	}
}
