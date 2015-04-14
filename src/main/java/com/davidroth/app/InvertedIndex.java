package com.davidroth.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The Class InvertedIndex.
 */
public abstract class InvertedIndex {

	/** The index. */
	private HashMap<String, HashSet<?>> index;

	/** The data. */
	public String[] data;

	/**
	 * Instantiates a new inverted index.
	 */
	public InvertedIndex() {
		index = new HashMap<String, HashSet<?> >();
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String[] getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(String[] data) {
		this.data = data;
		generateIndex();
	}

	/**
	 * Generate index.
	 */
	private void generateIndex() {
		for (int i = 0; i < this.getData().length; i++) {
			String[] aux = this.getData()[i].split(" ");
			for (int j = 0; j < aux.length; j++) {
				this.addItemToIndex(aux[j].toUpperCase().replaceAll("\\.|,", ""),i,j);
			}
		}
	}

	/**
	 * Gets the.
	 *
	 * @param key
	 *            the key
	 * @return the string[]
	 */
	public Collection<String> get(String key) {
		return (key.length()>0)?this.intersection(key.split(" ")):new ArrayList<String>();
	}

	/**
	 * intersection.
	 *
	 * @param split the split
	 * @return the string[]
	 */
	protected abstract Collection<String> intersection(String[] split); 
	
	/**
	 * Adds the item to index.
	 *
	 * @param word the word
	 * @param line the line
	 * @param position the position
	 */
	protected abstract void addItemToIndex(String word, int line, int position);

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	protected HashMap<String, HashSet<?>> getIndex() {
		return this.index;
	}
}
