package com.cognizant.revcast.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Test2().toGoatLatin("I speak Goat Latin"));

	}
	
	public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        String output="";
        String[] wordArr = S.split("\\s+");
        
        for(int i=0;i<wordArr.length;i++){
          //  System.out.println(wordArr[i]);
        	String v ="";
        	String c="";
            String w = wordArr[i];
       
            Character first = w.charAt(0);
            
            if(vowels.contains(Character.toLowerCase(first))){
                String a="";
                for(int k=1;k<=i+1;k++){
                    a += "a";
                }
                v += wordArr[i] + "ma" + a + " ";
            }
            else{
                String a="";
                for(int k=1;k<=i+1;k++){
                    a += "a";
                }
                c += wordArr[i].substring(1) + first + "ma" + a + " ";
            }
            
            output += v+c;
        }
        
        return output.trim();
        
    }

}
