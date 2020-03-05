package example2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/*
 * hat Open-Closed principle verletzt. Es ist nicht offen für Erweiterung da keine getter-Methode für lokales Variable gegeben wurde
 */
public class DirectoryDataReader {
	private PlainTextDataReader fileReader;

	public DirectoryDataReader(PlainTextDataReader fileReader) {
		this.fileReader = fileReader;
	}
	
	public List<String> readDirectory(Path dirPath) throws IOException {
		List<String> result = new ArrayList<>();
		DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath);
		for (Path filePath : stream) {
			result.add(fileReader.readFile(filePath));
		}
		
		return result;
	}
	
	public PlainTextDataReader getFile(){
		return this.fileReader;
	}
}
