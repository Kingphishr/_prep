package chapter_1;


import java.util.Arrays;

/*Question 1.3 - URLify
 * 
 * @input
 * "Mr John Smith    ", 13
 * 
 * @output
 * "Mr%20John%20Smith"
 * 
 * */
	

public class Ch1_3__URLify {
	
	// this is my implementation. Dunno why I should use true_length
	private static StringBuilder builder = new StringBuilder();
	public static String urlify_1(String raw, int true_length){
		raw = raw.trim();
		String[] just_words = raw.split(" ");
		
		//empty builder
		builder.setLength(0);
		
		for(int i = 0; i < just_words.length; i++){
			builder.append(just_words[i]);
			if(i != just_words.length - 1)
				builder.append("%20");
		}
		
		return builder.toString();
	}
	
	//implementations taking advantage of true_length. This uses less space.
	public static String urlify_2(String raw, int true_length) {
		char[] str = raw.toCharArray();
		int newLength = 1;
		for(int i = true_length-1; i > 0; i--){
			if(str[i] == ' '){
				str[str.length - newLength] = '0';
				str[str.length - newLength - 1] = '2';
				str[str.length - newLength -2] = '%';
				newLength += 3;
			}
			else{
				str[str.length - newLength] = str[i];
				newLength++;
			}
		}
		return new String(str);
	}
	
	
	public static void main(String[] args){
		System.out.println(urlify_1("Mr John Smith    ", 13)); //Pass!
		System.out.println(urlify_2("Mr John Smith    ", 13)); //Pass!
	}

}


