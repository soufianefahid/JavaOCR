package main;

import java.io.File;

import com.asprise.ocr.Ocr;

public class Transformator {
	
	public String imageToString(String input, String output) {
		Ocr.setUp(); // one time setup
		Ocr ocr = new Ocr(); // create a new OCR engine
		ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
		String rs = ocr.recognize(new File[] {new File(input)},  Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		ocr.stopEngine();
		return rs;
		//6522
	}
}
