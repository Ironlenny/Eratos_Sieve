package eratos_sieve;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sortTime = 0;
		long boolTime = 0;
		long start = 0;
		long stop = 0;
		
		SieveInsertSort eratosSort = null;
		SieveBoolArr eratosBool = null;
		try {
		eratosSort = new SieveInsertSort(Integer.parseInt(args[0]));	
		eratosBool = new SieveBoolArr(Integer.parseInt(args[0]));
		}
		catch(IndexOutOfBoundsException e){
			eratosSort = new SieveInsertSort();
			eratosBool = new SieveBoolArr();
		}
		
		start = System.nanoTime();
		ArrayList<Integer> primesSort = eratosSort.solve();
		stop = System.nanoTime();
		sortTime = stop - start;
		
		start = System.nanoTime();
		ArrayList<Integer> primesBool = eratosBool.solve();
		stop = System.nanoTime();
		boolTime = stop - start;		
		
		System.out.println("Insert Sort Primes:");
		for (int num: primesSort) {
			System.out.printf("%d ", num);
		}
		
		System.out.println();
		
		System.out.println("Bool Array Primes:");
		for (int num: primesBool) {
			System.out.printf("%d ", num);
		}
		
		System.out.println();
		
		System.out.printf("Insert Sort time: %d\n", sortTime);
		System.out.printf("Bool Array time: %d\n", boolTime);
	}

}
