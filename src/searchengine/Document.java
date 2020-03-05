package searchengine;

import java.util.*;
import java.nio.file.*;
import java.io.*;

/**
 * Document reads a text files and 
 * returns a list of the tokens inside this file with/without stopwords
 * 
 * @author Dung Nguyen
 */


public class Document {
	private List<String> tokens = new ArrayList<String>();
	private String filename;
	/**
	 * creates a constructor of a Document object based on a text file
	 * If IOException found, this is not a text file, but a query, 
	 * then a document will be created based on this query
	 * @param file
	 * 
	 */
	public Document(String file) {
		
		try{
			for (String line: Files.readAllLines(Paths.get(file))){
				line = line.trim().toLowerCase();
				if (line != ""){
					this.tokens.addAll(Arrays.asList(line.split(" ")));
				}
			}
			this.filename = file;
			
		}
		
		catch (IOException e){
			this.tokens.addAll(Arrays.asList(file.split(" ")));
		}
		
	}
	
	/**
	 * removes stopwords in this document
	 * @throws IOException
	 */
	public static Document removeStopwords(Document doc) throws IOException{
		for (String word: Files.readAllLines(Paths.get("./material-ex10/stopwords.txt"))){
			word = word.trim().toLowerCase();
			if (doc.getTokens().contains(word)){
				doc.getTokens().remove(word);
			}
		}
		return doc;
	}
	
	public List<String> getTokens(){
		return this.tokens;
	}
	
	public String getFileName(){
		return this.filename;
	}
}
