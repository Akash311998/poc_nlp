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
public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
        
        String sentence = "";
        sentence  = sentence.replaceAll("\\p{Punct}",""); 
        TokenizerFactory tokenizerFactory =
        	    IndoEuropeanTokenizerFactory.INSTANCE;
        	tokenizerFactory = new EnglishStopTokenizerFactory(tokenizerFactory);
        	Tokenizer tokenizer = tokenizerFactory.tokenizer(
        		    sentence.toCharArray(), 0, sentence.length());
        	int count  = 0; 
        	Set<String> set = new HashSet<String>();
        	for (String token : tokenizer) {
        	    set.add(token);
        	    count++;
        	}
        	System.err.println(count+" " +sentence.split(" ").length);
        	System.err.println(set.size());
    }
}
