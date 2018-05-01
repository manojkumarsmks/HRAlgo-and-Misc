// https://www.hackerrank.com/challenges/extra-long-factorials/problem
import java.math.BigInteger;
import java.util.Scanner;

public class ExtralongFactorial {

	static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger("1");
        
        for (int i = 2; i <= n; i++) {
			bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
		}
        
        System.out.println(bigInteger);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
