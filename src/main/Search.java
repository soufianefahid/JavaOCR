package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Search {

	public List<String> findWords(String text, List<String> tokens) {

		String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		
		ArrayList<String> results = new ArrayList<String>();

		while (matcher.find()) {
			results.add(matcher.group(1));
		}

		return results;
	}

}
