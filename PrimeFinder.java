// Print all prime numbers between 1 and n, as well as the count of primes
public class PrimeFinder {

    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
    	int counter = 0;

        for (int i = 2; i <= MAX_NUMBER; i++) {
        	boolean isPrime = true;

            for(int j = 2; j < i; j++) {

                if (i % j == 0) {
        			isPrime = false;
        			break;
                }
            }

            if (isPrime) {
            	System.out.println("Prime number: " + i);
            	counter++;
        	}
        }

		System.out.println("Total number of primes between 1 and " + MAX_NUMBER + ": " + counter);        
    }
}