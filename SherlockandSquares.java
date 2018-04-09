import java.util.Scanner;

public class SherlockandSquares {

	static int squares(int a, int b) {
		int sqrt_a = (int)Math.sqrt(a);
		int sqrt_b = (int)Math.sqrt(b);
	
		if((sqrt_a - Math.sqrt(a)) == 0)
			return Math.abs(sqrt_a-sqrt_b) + 1;
		return Math.abs(sqrt_a-sqrt_b);
		
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
