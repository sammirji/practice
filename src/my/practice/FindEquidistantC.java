package my.practice;

/**
 * The distance between two strings s and t of the same length consisting of digits 0 and 1 
 * as the number of positions i, such that si isn't equal to ti. Given two strings of same 
 * length containing 0’s and 1’s, find a 3rd string C which is equi-distant from both the strings. 
 * If it’s impossible to find such string print -1.
 * 
 * Eg1. S 1100
 *      T 1111
 *      
 * Distance, |ST| = 2
 * 
 * |CS| = |CT|
 * 
 * Solution, C = 1110
 */
public class FindEquidistantC {

	public static void main(String[] args) {
		String s = "1100";
		String t = "1111";
		findingC(s, t);
	}
	
	static void findingC(String s, String t) {
		if (s.length() != t.length())
			return;
		int distance = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) != t.charAt(i))
				distance++;
		}
		System.out.println("Distance: " + distance);
	}

}
