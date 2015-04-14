package com.davidroth.app;

import java.util.ArrayList;

/**
 * Inverted index examples
 *
 */
public class App 
{
    public static void main( String[] args )
    {	InvertedIndex invertedIndex = new SimpleInvertedIndex();
		String[] data = new String[] {
				"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
				"Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
				"Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
				"This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
				"Another book with music related content" 
		};
		invertedIndex.setData(data);
		String search = "music";
		ArrayList<String> results = (ArrayList<String>) invertedIndex.get(search);
		System.out.println("Total Results for '"+search+"' search: " + results.size());
		System.out.println(results.toString());

		search = "Time";
		results = (ArrayList<String>) invertedIndex.get(search);
		System.out.println("Total Results for '"+search+"' search: " + results.size());
		System.out.println(results.toString());
		
		search = "A writes";
		results = (ArrayList<String>) invertedIndex.get(search);
		System.out.println("Total Results for '"+search+"' search: " + results.size());
		System.out.println(results.toString());
	}
}
