import java.util.*; 

public class ans
{ 
static String censor(String text, Vector<String> vec) 
{ 
	String[] word_list = text.split("\\s+"); 
	String result = ""; 
	for(String word : vec) 
	{
	    int index = 0; 
		String stars = ""; 
		for (int i = 0; i < word.length(); i++) 
			stars += '*'; 
		for (String i : word_list) 
		{ 
			if (i.compareTo(word) == 0) 
				word_list[index] = stars; 
			index++; 
		} 
	}
	for (String i : word_list) 
		result += i + ' '; 

	return result; 
} 


public static void main(String[] args) 
{ 
	Scanner sc= new Scanner(System.in); 
	System.out.print("Enter a text string: ");  
	String extract = sc.nextLine();
	System.out.print("Enter a size of vector: ");  
	int n = sc.nextInt();
	Vector<String> vec = new Vector<String>(n); 
	for (int i = 0; i < n; i++) 
	{
		System.out.print("Enter element: ");  
		String element = sc.nextLine();
		vec.add(element);		
	}
	System.out.println(censor(extract, vec)); 
} 
} 




