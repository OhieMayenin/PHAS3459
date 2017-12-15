package peepshow;

public class PSQuote {

	public static void main(String[] args) {
		
		QuoteDirectory q = new QuoteDirectory();

		q.setQuotes();
		 
		try {
		q.getQuote();
		}
		catch (Exception e) {
			System.out.println("Let's try again.");
			try {
				q.getQuote();
				}	
			catch (Exception e1) {System.out.println("Seriously, is a one-word descriptor of feeling too much to ask?");}
		
	}

}
}
