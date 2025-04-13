package rough;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringPrograms {


	

	// reverse a string
	static void reverseString(String str) {
		
		String reverse = "";
		
		for (int i=str.length()-1;i>=0;i--) {
			
			
			reverse= reverse + str.charAt(i);
		}
		
		
        System.out.println("Reversed String: " + reverse);

		
	}

	
	// vowels and consonants
	
	static void findVowelsConsonants(String str) {
		
		int vowels=0; int consonants = 0;
		
		str.toLowerCase();
		
		for (int i= 0; i< str.length(); i++) {
			
			char ch= str.charAt(i);
			
			
			if(ch>='a' && ch<='z') { //check if alphabet
				
				
				 if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					 
	                    vowels++;
	                    
	                } 
				 
				 else {
	                    consonants++;
	                }
	            }
	        }

	        System.out.println("Vowels: " + vowels);
	        System.out.println("Consonants: " + consonants);
	    }
			
		
		
	// find duplicates in a string and print result by removing them
	
	static void findDuplicates(String str) {
		
		String result ="";
		
		for(int i=0; i<str.length(); i++) {
			
			String ch = ""+ str.charAt(i); // empty string is concatenated to conver ch to string
			
			if(result.contains(ch)) {
				
				continue;
				
			}
			
            result+= ch;	// display result without duplicates		
		}
		
		System.out.println(result);
		
	}


	
	// check if two words are anagram
	
	static boolean isAnagram(String str1, String str2) {
		
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		
		if(str1.length()!=str2.length()) {
			
			return false;
		}
		
		
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		return Arrays.equals(array1, array2);

		
	}
	
	
     // converting lower to upper case and vice versa
	
	static void convertOpposite(StringBuffer str)
    {
        int ln = str.length();
 
        // Conversion using predefined methods
        for (int i = 0; i < ln; i++) {
            Character c = str.charAt(i);
            if (Character.isLowerCase(c))
                str.replace(i, i + 1,
                            Character.toUpperCase(c) + "");
            else
                str.replace(i, i + 1,
                            Character.toLowerCase(c) + "");
        }
    }
	
	
	
	
	
 
    public static void main(String[] args)
    {
    	
    	if (isAnagram("power","powerful")){
    		
    		System.out.println("anagram");
    	}
    	
    	else
    		
    		System.out.println("not anagram");

    	
    }}
	
	
	
