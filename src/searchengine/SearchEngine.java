package searchengine;

import java.io.*;
/**
 * This SearchEngine tests how the other classes and methods work. The test should solve the problem of finding the document
 * that ist most similar to a given query.
 * @author dungnguyen
 *
 */
public class SearchEngine {
	/**
	 * Finds the most similar document with its cosinus value in corpus to the given query
	 * @param corpus 
	 * @param query
	 * @return name of the file and its cosine similarity value computed
	 */
	public static String searchfile(Corpus corpus, Document query){
		Double max = Double.valueOf(0);
		String title = null;
		
		for(Document doc: corpus.getCorpus()){
			if (!doc.equals(query)){
				TfIdfVector doc_vec = new TfIdfVector(doc, corpus);
				TfIdfVector query_vec = new TfIdfVector(query, corpus);
				Double cosine = query_vec.cosineSim(doc_vec);
				if (cosine > max){
					max = cosine;
					title = doc.getFileName();
				}
			}
		}
		return title + " with cosinus value " + max;
	}
	
	public static void main(String[] args) throws IOException{
		Document doc1 = new Document("./material-ex10/example_data/doc1.txt");
		Document doc2 = new Document("./material-ex10/example_data/doc2.txt");
		Document doc3 = new Document("./material-ex10/example_data/doc3.txt");
		Document doc4 = new Document("./material-ex10/example_data/doc4.txt");
		Document doc5 = new Document("./material-ex10/example_data/doc5.txt");
		
		
		Document query = new Document("can a swallow carry a coconut");
		//Document query1 = new Document("can we have a chance");
		/*Corpus corpus = new Corpus(Document.removeStopwords(doc1), Document.removeStopwords(doc2), Document.removeStopwords(doc3), 
				Document.removeStopwords(doc4), Document.removeStopwords(doc5),query);*/
		Corpus corpus = new Corpus(doc1, doc2, doc3, doc4, doc5, query);
		System.out.println("The most similar document to query is: "+ searchfile(corpus, query));
		
		
		//
	}
}
