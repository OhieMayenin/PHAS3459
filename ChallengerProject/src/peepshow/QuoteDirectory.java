/*
 * this class acts as a directory for peep show quotes
 * designates each quote to a number
 * - version 1
 */

package peepshow;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class QuoteDirectory {


	public QuoteDirectory () {}
	HashMap<String,String> quotes = new HashMap<String,String>(); // holds quotes

	// strings to be set in setQuotes()
	String happy;
	String sad;
	String tired;
	String angry;
	String scared;
	String pessimistic;
	String optimistic;
	String political;
	String judgemental;
	String rebellious;
	String worthless;
	String introverted;
	String profound;
	String broke;
	String green;
	String doubtful;
	String frustrated;
	String guilty;
	String lonely;
	String pathetic;
	String pedantic;
	String ambitious;
	String sluggish;
	String bored;

	String feeling; // input

	// sets quotes to a feeling
	public void setQuotes() {
		// initialising hash map [key: feeling, element: quote]


		// setting quotes

		happy = "Mark: This is good... not really loving her kind of puts me in a position of power.";
		quotes.put("happy", happy);

		sad = "Mark: Loss adjustment. I could do that... my entire life has been one continual adjustment to loss.";
		quotes.put("sad", sad);

		tired = "Mark: How do I feel? Empty? Check. Scared? Check. Alone? Check. Just another ordinary day.";
		quotes.put("tired", tired);

		angry = "Mark: A little bit of me has died, but you know what? A lot of me doesn't give a shit.";
		quotes.put("angry", angry);

		scared = "Mark: I like you and if you can't handle it, you can just, you know, fuck off.";
		quotes.put("scared", scared);

		pessimistic = "Jeremy: I'm having a good time!" +"\n" +"Mark: So am I! I mean, not actually, but it's like I am!";
		quotes.put("pessimistic", pessimistic);

		optimistic = "Maybe she's right. Maybe the truth does work. Maybe Iraq was a good idea. Maybe I'm outing enough into my pension plan." +"\n"
				+ "Maybe computer games aren't a waste of time. Maybe O.J.'s innocent. Maybe everything's going to be okay!";
		quotes.put("optimistic", optimistic);

		judgemental = "She is very attractive. But brown rice and Pop Tarts? Camomile tea and economy vodka? That's a car crash of a shopping basket.";
		quotes.put("judgemental", judgemental);

		rebellious = "Mark: I've been initiated... I am a drug user! Fuck the police!";
		quotes.put("rebellious", rebellious);

		worthless = "Mark: Eating from a bucket... like a human horse";
		quotes.put("worthless", worthless);

		introverted = "Mark: I suppose doing things you hate is just the price you pay to avoid loneliness";
		quotes.put("introverted", introverted);

		profound = "Jeremy: What was it Shakespeare said...?" +"\n" +"Mark: He said a lot of things, Jeremy.";
		quotes.put("profound", profound);

		broke = "Jeremy: Twenty thousand pounds. I’m going to be a millionaire!"; 
		quotes.put("broke", broke);

		green = "Super Hans: A suitcase with wheels? Real men don't get the earth to carry their luggage for them, mate. They carry it themselves.";
		quotes.put("green", green);

		doubtful = "This was definitely a good idea. There’s no chance this wasn’t a good idea.";
		quotes.put("doubtful", doubtful);

		guilty = "Mark: It's like eating a vast portion of chips... very comfortable, but there's this lurking sense that you're killing yourself.";
		quotes.put("guilty", guilty);

		frustrated = "Mark: Why won’t that stupid bitch let me propose to her?";
		quotes.put("frustrated", frustrated);

		political = "Jeremy: Fuck you, Bush.\r\n" + 
				"It's time to get out of Iraq, Bush.\r\n" + 
				"What were you even doing there in the first place, Bush?\r\n" + 
				"You didn't even get properly elected, Bush.\r\n" + 
				"Are you happy now, Bush?\r\n" + 
				"Fuck you, Bush!";
		quotes.put("political", political);
		
		lonely = "Mark: Well, it's the 21st centry and no one actually likes each other anymore, so let's just leave it at that, shall we?";
		quotes.put("lonely", lonely);
		
		pathetic = "Mark: She must never know what a pathetic man I am.";
		quotes.put("pathetic", pathetic);
		
		pedantic = "Jeremy: Relax, I'll credit card the lock." +"\n" +"Mark: That's a debit card.";
		quotes.put("pedantic", pedantic);
		
		ambitious = "Johnson: In business, Jeremy, you learn that every man has his price, and I judge yours to be… £530";
		quotes.put("ambitious", ambitious);
		
		sluggish = "Jeremy: No milk... Not black tea. I’m not some kind of monster!";
		quotes.put("sluggish", sluggish);
			
		bored = "Super Hans: Answer - a wicked big bag of sinister minister";
		quotes.put("bored", bored);

	}

	// get quote for user feeling
	public void getQuote() throws Exception{
		System.out.println("How are you feeling in one word?"); // pose question to user

		Scanner s = new Scanner(System.in);

		feeling = s.nextLine(); // read input word
		
		s.close();

		// check if input is one-worded, if not print error message and repose question
		if (feeling.contains(" ")) {
			System.out.println("Error: Please input a one-word feeling with no spaces." + "\n");

			//System.out.println("How are you feeling in one word? (Hint: Write one word ths time.)"); // pose question to user

			Scanner s2 = new Scanner(System.in);

			feeling = s2.nextLine(); // read input word
		

			s2.close();
		} 

		//		else if (feeling == "indifferent" || feeling == "any" || feeling == "anyquote") {
		//			Random generator = new Random();
		//			Object[] values = quotes.values().toArray();
		//			String randomValue = (String) values[generator.nextInt(values.length)];
		//			System.out.println(randomValue);
		//		}

		else {

			String quoteOutput = quotes.get(feeling);

			if (quoteOutput == null) {
				System.out.println("Couldn't return a relatable quote, although one surely does exist..." +"\n" 
						+"Please write a more commonly used one-word description of feeling...");
			
			}
			else {System.out.println("\n" +quoteOutput);}
		}
	}

		public void checkSynonyms() {
			// sad synonyms
			if (feeling == "upset") {feeling = "sad";}
			if (feeling == "unhappy") {feeling = "sad";}
			if (feeling == "depressed") {feeling = "sad";}
			if (feeling == "miserable") {feeling = "sad";}
			if (feeling == "blue") {feeling = "sad";}
			
			// happy synonyms
			if (feeling == "great") {feeling = "happy";}
			if (feeling == "wonderful") {feeling = "happy";}
			if (feeling == "fantastic") {feeling = "happy";}
			if (feeling == "brilliant") {feeling = "happy";}
			if (feeling == "cheerful") {feeling = "happy";}
			
			// others
			if (feeling == "terrified") {feeling = "scared";}
			if (feeling == "furious") {feeling = "angry";}
			if (feeling == "annoyed") {feeling = "frustrated";}
			if (feeling == "vexed") {feeling = "frustrated";}
			if (feeling == "dubious") {feeling = "doubtful";}
			if (feeling == "shy") {feeling = "introverted";}
			if (feeling == "antisocial") {feeling = "introverted";}
			if (feeling == "anti-social") {feeling = "introverted";}
			
			
		
		}

}
