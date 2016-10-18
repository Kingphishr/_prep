package ctci;



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
	private static StringBuilder builder = new StringBuilder();
	
	
	// this is my implementation. Dunno why I should use true_length
	public String urlify_1(String raw, int true_length){
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
	
	//implementations taking advantage of true_length
	public String urlify_2(String raw, int true_length) {
		return null;
	}
}


