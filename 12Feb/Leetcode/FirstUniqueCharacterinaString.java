package Leetcode;

import java.util.HashMap;
import java.util.Map;

//387. First Unique Character in a String

public class FirstUniqueCharacterinaString {
	class Solution {
	    public int firstUniqChar(String s) {
	        Map<Character, Integer> freq= new HashMap<>();
	        for(int i=0; i<s.length(); i++){
	            if(freq.get(s.charAt(i))==null){
	                freq.put(s.charAt(i),1);
	            }
	            else{
	                freq.put(s.charAt(i),freq.get(s.charAt(i))+1);
	            }
	        }
	        for(int i=0; i<s.length();i++){
	            if(freq.get(s.charAt(i))==1){
	                return i;
	            }
	        }
	        return -1;
	    }
	}

}
