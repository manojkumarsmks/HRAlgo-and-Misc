import java.util.HashMap;

/* A queue of people are waiting to buy ice cream from you. 
Each person buys one ice cream, which sells for $5. 
Each customer is holding a bill of $5, $10 or $20. 
Your initial balance is 0. 
Find whether you will be able to make change for every customer in the queue. You must serve customers in the order they come in. 

For example 
5, 5, 5, 10, 20 -> true, 
5, 5, 10 -> true, 
10, 10 -> false */

public class ChangeForCustomers {

	public static void main(String[] args) {
	
		int[] input = {5, 5, 10};
		System.out.println(checkbalance(input));

	}
	
	// Using HashTable
	// O(n) space complexity 
	// O(n) Time Complexity
	public static boolean checkForChange(int[] customersMoney) {
		
		HashMap<Integer, Integer> moneyTable = new HashMap<>();
		
		for (int i = 0; i < customersMoney.length; i++) {
			if(moneyTable.containsKey(customersMoney[i])) {
				moneyTable.put(customersMoney[i], moneyTable.get(customersMoney[i])+1);
			}
			else {
				moneyTable.put(customersMoney[i], 1);
			}
		}
		
		for (int i = 0; i < customersMoney.length; i++) {
			
			if(customersMoney[i] > 5) {
				int remaining = customersMoney[i] - 5;
				
				if(remaining == 5) {
					if(moneyTable.containsKey(remaining))
						moneyTable.put(remaining, moneyTable.get(remaining)-1);
					else 
						return false;
				}
				if(remaining == 15) {
					if(moneyTable.get(10) >= 1) {
						if(moneyTable.get(5) == 1)
							moneyTable.put(10, moneyTable.get(10) -1);
							moneyTable.put(5, moneyTable.get(5) - 1);
					}
					
					else if(moneyTable.get(5) >= 3) {
						moneyTable.put(5, moneyTable.get(5)-3);
					}
					else 
						return false;
				}
			}
		}
		
		return true;	
	}
	
	// O(n) Time Complexity 
	// O(1) Space Complexity
	public static boolean checkbalance(int[] customersMoney) {
		
		int fiveDollars = 0, tenDollars = 0, twentyDollars = 0;
		
		for (int i = 0; i < customersMoney.length; i++) {
			if(customersMoney[i] == 5) {
				fiveDollars ++; 
			}
			else if(customersMoney[i] == 10) {
				if(fiveDollars <= 0)
					return false;
				else {
					fiveDollars--;
					tenDollars++;
				}
			}
			else if(customersMoney[i] == 20) {
				if(fiveDollars > 0 && tenDollars > 0) {
					fiveDollars--;
					tenDollars--;
					twentyDollars++;
				}
				else if(fiveDollars >= 3) {
					fiveDollars = fiveDollars-3;
					twentyDollars++;
				}
				else 
					return false;
			}
		}
		
		return true;	
	}
}
