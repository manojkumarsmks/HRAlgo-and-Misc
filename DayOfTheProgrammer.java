//https://www.hackerrank.com/challenges/day-of-the-programmer/problem
import java.util.Scanner;

public class DayOfTheProgrammer {

	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		String result = solve(year);
		System.out.println(result);
	}

	private static String solve(int year) {
		
		if(year < 1917) {
			if(JulianLeapYear(year)) {
				return "12.09."+year;
			}
			else {
				return "13.09."+year;
			}
		}
		else if(year == 1918) {
			return "26.09."+year;
		}
		else {
			if(GregorianLeapYear(year)) {
				return "12.09."+year;
			}
			else {
				return "13.09."+year;
			}
		}
		
	}
	
	public static Boolean JulianLeapYear(int year) {
		if(year % 4 == 0) {
			return true;
		}
		return false;
	}
	
	public static Boolean GregorianLeapYear(int year) {
		if(year % 400 == 0)
			return true;
		else if(JulianLeapYear(year)) {
			if(year % 100 != 0) {
				return true;
			}
			return false;
		}
		return false;
	}

}
