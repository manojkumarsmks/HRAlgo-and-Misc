// https://www.hackerrank.com/challenges/the-grid-search/problem
import java.util.Scanner;
 class TheGridSearch {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i = 0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i = 0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            while(P.length <= G.length) {
            	// Search for the first string in P in G
            	// gridSearchchecks if the 1st string of P exists in G
            	if(!gridSearch(G, P, C)) {
	            	System.out.println("NO");
	            	break;
	            }
	            else {
	            	System.out.println("YES");
	            	break;
	            }
            }
        }
        in.close();

        
	}

	// return true if the P exists in G
	private static boolean gridSearch(String[] g, String[] p, int C) {	
		for (int i = 0; i < g.length; i++) {
			System.out.println("GLEnghkl;laf "+(p[0].length()));
			for(int j=0; j<=(g[i].length()-p[0].length()); j++) {
				
				String mainString = g[i].substring(j, j+ p[0].length());

				String subString = p[0];
					if(mainString.equals(subString)) {
					if(checkForSubstring(g, p, i, j)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean checkForSubstring(String[] g, String[] p, int rowIndex, int columnIndex) {
		int temp = p.length;
		int pIndex = 0;
		while(temp != 0) {
			if(!g[rowIndex].substring(columnIndex, columnIndex+p[pIndex].length()).equals(p[pIndex])) {
				return false;
			}
			temp--;
			rowIndex++;
			pIndex++;
		}
		return true;
	}
}
