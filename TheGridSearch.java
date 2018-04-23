// https://www.hackerrank.com/challenges/the-grid-search/problem
import java.util.Scanner;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.plaf.synth.SynthSeparatorUI;

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
            
            int initialX = 0, initialY =0;
            
            while(P.length < G.length - initialY) {
            	System.out.println("P lenght "+P.length +" G "+ (G.length - initialY));
            	
	            String result = gridSearch(G, P[0], C, initialX, initialY);
	            System.out.println("Results "+result);
	            if(result == null) {
	            	System.out.println("NO");
	            	return;
	            }
	            String[] index = result.split(" ");
	            initialX = Integer.parseInt(index[0])+1;
	            initialY = Integer.parseInt(index[1]);
	            if(checkForSubstring(G, P, Integer.parseInt(index[0]), Integer.parseInt(index[1]))) {
	            	System.out.println("YES");
	            	return;
	            }
            }
            System.out.println("NO");
            
        }
        in.close();

        
	}

	private static String gridSearch(String[] g, String p, int C, int x, int y) {
		
		for (int i = x; i < g.length; i++) {
			for(int j=y; j<=C-p.length(); j++) {
				if(g[i].substring(j, j+p.length()).equals(p))
					return i+" " +j;
			}
		}
		return null;
	}

	private static boolean checkForSubstring(String[] g, String[] p, int iIndex, int jIndex) {
		boolean flag = true;
		for(int i =0; i<p.length; i++) {
			String mainString = g[iIndex].substring(jIndex, jIndex + p[i].length());
			String subString = p[i];
			System.out.println("Main String "+mainString + " Sub String "+subString);
			if(!mainString.equals(subString)) {
				flag = false;
			}
			iIndex++;
		}
		return flag;
	}

}
