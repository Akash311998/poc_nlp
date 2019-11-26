package com.one;

import java.util.HashSet;
import java.util.Set;

import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
/**
 * Hello world!
 *
 */
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;

public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );

		String paragraph = "";
		String heading = "";
		paragraph = paragraph.replaceAll("\\p{Punct}", "");
		TokenizerFactory tokenizerFactory = IndoEuropeanTokenizerFactory.INSTANCE;
		tokenizerFactory = new EnglishStopTokenizerFactory(tokenizerFactory);
		Tokenizer tokenizer = tokenizerFactory.tokenizer(paragraph.toCharArray(), 0, paragraph.length());
		Set<String> setWords = new HashSet<String>();
		for (String token : tokenizer) {
			setWords.add(token);
		}

		String[] headingWords = heading.split(" ");
		int flag = 0 ;
		for(String s:headingWords){
			if(setWords.contains(s)){
				System.out.println("Heading is correct");
				flag++;
				break;
			}
		}
		if(flag==0){
			System.out.println("Heading is incorrect");
		}
		

	}
}
