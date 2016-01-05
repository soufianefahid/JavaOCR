package main;

import java.util.ArrayList;
import java.util.List;
// First Try

public class Main {

	public static void main(String[] args) {
		Transformator transformator = new Transformator();
		Search search = new Search();
		List<String> tokens = new ArrayList<String>();
		
		tokens.add("E8767");
		
		String text = transformator.imageToString("rsc/input/TEST_2.JPG", "rsc/output/result.txt");
		List<String> results = search.findWords(text, tokens);
		
		System.out.println("Results : "+results.size()+" matchs");
		System.out.println("OCR Result : \n"+text);
	}
}
