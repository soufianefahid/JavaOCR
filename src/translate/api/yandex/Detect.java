package translate.api.yandex;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.Scanner;




public class Detect {

	
	private static final String API_CALL ="https://translate.yandex.net/api/v1.5/tr.json/detect?key=%s&text=%s";
	private static final String API_KEY = "trnsl.1.1.20151229T141923Z.d4b1ac0d9720beb9.921169db57da13d7a38d676a85c026c1c5234143";
	public static void main(String[] args) throws ParseException {
		
		try {	
				System.out.println("detecter ou traduire");
				
				BufferedReader cr=new BufferedReader(new InputStreamReader(System.in));
				String choix=cr.readLine();
				
				if(choix.equals("traduire")){
				String lang=cr.readLine();
				String text=cr.readLine();
				System.out.println(callURL(String.format(API_CALL,API_KEY,lang,text)));
				System.out.println();
				
				}
				
				else {
					String text=cr.readLine();
					System.out.println(callURL(String.format(API_CALL,API_KEY,text)));
					System.out.println();
					
				}
			
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
	
	public static String callURL(String myURL) {
		myURL = myURL.replace(" ", "%20");
		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
}
