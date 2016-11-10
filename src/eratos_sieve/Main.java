package eratos_sieve;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sieve eratos = null;
		try {
		eratos = new Sieve(Integer.parseInt(args[0]));	
		}
		catch(IndexOutOfBoundsException e){
			eratos = new Sieve();
		}
		ArrayList<Integer> primes = eratos.solve();
		
		for (int num: primes) {
			System.out.println(num);
		}
		
	}

}
