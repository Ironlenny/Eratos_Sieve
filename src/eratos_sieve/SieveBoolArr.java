package eratos_sieve;
import java.util.ArrayList;

public class SieveBoolArr {
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	private boolean markedNums[];
	private int newPrime = 2;
	private int maxNum;
	
	private boolean insert (int insert) {
		if (markedNums[insert]) {}
		else {
			markedNums[insert] = true;
		}
		
		return true;
	}
	
	private boolean findPrime (int test) {
		boolean pass = false;
		if (test > maxNum) {}
		else if (!markedNums[test]) {
			primes.add(test);
			newPrime = test;
			pass = true;
		}
		else {
		pass = findPrime (test + 1);
		}
		
		return pass;
	}
	public SieveBoolArr () {
		this.maxNum = 100;
		primes.add(newPrime);
		markedNums =  new boolean[maxNum + 1];
	}
	
	public SieveBoolArr (int maxNum) {
		this.maxNum = maxNum;
		primes.add(newPrime);
		markedNums =  new boolean[maxNum + 1];
	}
	
	public ArrayList<Integer> solve () {
		int num = 0;
		int seq = 2;

		do {
			num = seq++ * newPrime;
		} while ((num <= maxNum) && (insert (num)));
						
		if (findPrime (newPrime + 1)) {
			solve();
		}
		
		return primes;
	}
}
