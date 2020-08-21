import java.util.*;  

public class answer { 
	
	static int countFreq(String pat, String txt) {		 
		int M = pat.length();		 
		int N = txt.length();		 
		int res = 0; 
		for (int i = 0; i <= N - M; i++) { 
			int j;			 
			for (j = 0; j < M; j++) { 
				if (txt.charAt(i + j) != pat.charAt(j)) { 
					break; 
				} 
			} 

			// if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
			if (j == M) {				 
				res++;				 
				j = 0;				 
			}			 
		}		 
		return res;		 
	} 
	static public void main(String[] args) { 
	    Scanner sc= new Scanner(System.in); 
		System.out.print("Enter a text string: ");  
		String txt = sc.nextLine();	
		System.out.print("Enter a pattern to be searched: ");   
		String pat = sc.nextLine();			 
		System.out.println(countFreq(pat, txt));		 
	} 
} 

