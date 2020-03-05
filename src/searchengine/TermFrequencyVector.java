package searchengine;

import java.util.*;

/**
 * TermFrequencyVector represents a vector of a document in corpus
 * having value as frequency of each token of vocabulary in this document
 * @author dungnguyen
 *
 */

public class TermFrequencyVector {
	//private HashMap<String, Double> map = new HashMap<String, Double>();
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public TermFrequencyVector(Document document, Corpus corpus){
		
		// Initialises document vector with zeros
		//HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word: corpus.getVocabulary()){
			map.put(word, 0);
		}
		
		// Counts frequency of each token in document, and assign to its position in document vector
		for(String token: document.getTokens()){
			map.put(token, map.get(token)+1);
		}
		/*
		HashMap<String, Integer> freqmap = corpus.countTokensinCorpus();
		
		// Creates tf-vector for this document
		for(String token: map.keySet()){
			this.map.put(token, (double)map.get(token)/(double)freqmap.get(token));
		}*/
	}
	
	/**
	 * gets the map of each token with its frequency in document
	 * @return the vector represented as a dictionary of tokens and their values 
	 */
	//public HashMap<String, Double> getMap(){
	public HashMap<String, Integer> getMap(){
		return this.map;
	}
	
}
