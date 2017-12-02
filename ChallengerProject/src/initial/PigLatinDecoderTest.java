package initial;

public class PigLatinDecoderTest {

	public static void main(String[] args) {
		String code1 = "itlerhay illway nvadeiay ritainbay noay uesday!tay uicklyqay lertaay hurchill!cay";
		String code2 = "tucksay niay azi-nay ccupiedoay aris!pay leasepay endsay elp!hay";
		String code3 = "loccinaucinihilipilificationfay";
		String code4 = "acheay ordway niay histay entencesay ustmay ebay onvertedcay otay igpay atinlay";
		
		PigLatinDecoder.decodePL(code1);
		PigLatinDecoder.decodePL(code2);
		PigLatinDecoder.decodePL(code3);
		PigLatinDecoder.decodePL(code4);
	}

}
