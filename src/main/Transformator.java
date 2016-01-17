package main;

import java.io.File;

import com.asprise.ocr.Ocr;

public class Transformator {
	
	public String imageToString(String input,int Format , String language) {
		Ocr.setUp(); // one time setup
		Ocr ocr = new Ocr(); // create a new OCR engine
		ocr.startEngine(language, Ocr.SPEED_FASTEST); // English
		String rs , text;
		System.out.println("Format = "+Format);
		text = ocr.recognize(new File[] {new File(input)},Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		if(Format==0){
			 rs = ocr.recognize(new File[] {new File(input)},Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT, "PROP_PLAINTEXT_OUTPUT_FILE=ocr-result.txt");
			
		}
		else if(Format==2){
			rs =ocr.recognize(new File[] {new File(input)},  Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PDF, "PROP_PDF_OUTPUT_FILE=ocr-result.pdf|PROP_PDF_OUTPUT_TEXT_VISIBLE=true");
		}
		else{
			 rs = ocr.recognize(new File[] {new File(input)},Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_RTF, "PROP_RTF_OUTPUT_FILE=ocr-result.rtf");
		}
		
		ocr.stopEngine();
		
		
		
		return text;
	}
}
