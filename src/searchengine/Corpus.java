package searchengine;

import java.util.*;
import java.io.*;
/**
 * Corpus collects all documents
 * @author dungnguyen
 *
 */
public class Corpus {
	private List<Document> list = new ArrayList<Document>();
	
	public Corpus(Document... docs) throws IOException{
		this.list.addAll(Arrays.asList(docs));
	}
	
	/**
	 * creates a list of vocabulary in whole corpus
	 * @return set of tokens in corpus
	 */
	public HashSet<String> getVocabulary(){
		HashSet<String> set = new HashSet<String>();
		for (Document doc : this.list){
			set.addAll(doc.getTokens());
		}
		return set;
	}
	
	/**
	 * Counts the documents in which each word is found
	 * @return df a map of each token and the number of document this token is found in
	 */
	public HashMap<String, Integer> countDocumentsWithToken(){
		HashMap<String, Integer> df = new HashMap<String, Integer>();
		for (String word: this.getVocabulary()){
			df.put(word, 0);
		}
		
		for(String token: df.keySet()){
			for(Document doc: this.list){
				if (doc.getTokens().contains(token)){
					df.put(token, df.get(token)+1);
				}
			}
		}
		return df;
	}
	
	/**
	 * Counts the occurrence of each word in whole corpus
	 * @return tp a map of each token and its occurence in corpus
	 */
	public HashMap<String, Integer> countTokensinCorpus(){
		HashMap<String, Integer> tp = new HashMap<String, Integer>();
		for (String word: this.getVocabulary()){
			tp.put(word, 0);
		}
		
		for(Document doc: this.list){
			for(String token: doc.getTokens()){
				tp.put(token, tp.get(token)+1);
			}
		}
		return tp;
	}
	
	/**
	 * Count the number of documentes in corpus
	 * @return size of the cor
	 */
	public int getCountDocuments(){
		return this.list.size();
	}
	
	public List<Document> getCorpus(){
		return this.list;
	}
	
}
