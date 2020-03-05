package searchengine;

import java.util.*;
/**
 * Creates a vector of a document using TF-IDF method
 * @author dungnguyen
 *
 */

public class TfIdfVector {
	private HashMap<String, Double> map = new HashMap<String, Double>();
	
	public TfIdfVector(Document doc, Corpus corpus){
		TermFrequencyVector vector = new TermFrequencyVector(doc,corpus);
		
		//HashMap<String, Double> tf = vector.getMap();
		HashMap<String, Integer> tf = vector.getMap();
		
		HashMap<String, Integer> df = corpus.countDocumentsWithToken();
		
		for(String token: tf.keySet()){
			Double tfidf = (double)corpus.getCountDocuments() / df.get(token) * tf.get(token);
			this.map.put(token, tfidf);
		}
		
	}
	
	/**
	 * gets the map of each token with its tfidf-value in document
	 *  
	 */
	public HashMap<String,Double> getMap(){
		return this.map;
	}
	
	/**
	 * computes euclidean norm of this vector
	 * @return a value of type Double
	 */
	public Double norm(){
		Double norm = Double.valueOf(0);
		for(Double value: this.map.values()){
			norm += value * value;
		}
		return Math.sqrt(norm);
	}
	
	/**
	 * compute the cosinus similarity of this vector and another vector
	 * @param other TfIdfVector
	 * @return cosinus similarity value 
	 */
	public Double cosineSim(TfIdfVector other){
		Double sum = Double.valueOf(0);
		for(String token: this.map.keySet()){
			sum += this.getMap().get(token) * other.getMap().get(token);
		}
		return sum / (this.norm() * other.norm());
	}
	
	
}
