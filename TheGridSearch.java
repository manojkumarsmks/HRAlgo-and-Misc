// https://www.hackerrank.com/challenges/the-grid-search/problem
import java.util.Scanner;

public class TheGridSearch {

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
            int iIndex = 0, jIndex = 0;
            boolean flagResult = false;
            
            while(P.length < (G.length - jIndex)) {
            	String result = gridSearch(G, P[0], C, iIndex, jIndex);
	            if(result == null) {
	            	System.out.println("NO");
	            	break;
	            }
	            String[] index = result.split(" ");
	            iIndex = Integer.parseInt(index[0])+1;
	            jIndex = Integer.parseInt(index[1]);
	            if(checkForSubstring(G, P, Integer.parseInt(index[0]), Integer.parseInt(index[1]))) {
	            	System.out.println("Check for substring true");
	            	flagResult = true;
	            	break;
	            }
	            else {
	            	flagResult = false;
	            }
            }
            if(flagResult)
            	System.out.println("YES");
            else if(!flagResult)
            	System.out.println("NO");
            
        }
        in.close();

        
	}

	private static String gridSearch(String[] g, String p, int C, int iIndex, int jIndex) {
		
		for (int i = iIndex; i < g.length; i++) {
			for(int j=jIndex; j<=C-p.length(); j++) {
				if(g[i].substring(j, j+p.length()).equals(p))
					return i+" " +j+" "+(j+p.length());
			}
		}
		return null;
	}

	private static boolean checkForSubstring(String[] g, String[] p, int iIndex, int jIndex) {
		boolean flag = true;
		System.out.println("iIndex "+iIndex + " jIndex "+jIndex);
		for(int i =0; i<p.length; i++) {
			String mainString = g[iIndex].substring(jIndex, jIndex + p[i].length());
			String subString = p[i];
			if(!mainString.equals(subString)){
				flag = false;
			}
			iIndex++;
		}
		return flag;
	}

}
