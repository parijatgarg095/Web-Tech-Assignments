import java.util.*; 
import java.io.*; 
import java.util.Arrays; 
import java.util.Collections; 

public class ans 
{ 
	static boolean areAnagram(char[] str1, char[] str2) 
	{ 
		int n1 = str1.length; 
		int n2 = str2.length;
		if (n1 != n2) 
			return false; 
          
        		// sort tempArray 
        Arrays.sort(str1); 
        Arrays.sort(str2);
		for (int i = 0; i < n1; i++) 
            if (str1[i] != str2[i]) 
                return false;   
		return true; 
	} 

	public static void main(String args[]) 
	{ 
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter 2 strings: ");  
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		char tempArray1[] = str1.toCharArray(); 
		char tempArray2[] = str2.toCharArray(); 

		if (areAnagram(tempArray1, tempArray2)) 
			System.out.println("The two strings are"+ " anagram of each other"); 
		else
			System.out.println("The two strings are not"+ " anagram of each other"); 
	} 
} 
