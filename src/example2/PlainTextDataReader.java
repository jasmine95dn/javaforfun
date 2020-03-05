package example2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlainTextDataReader {
	String readFile(Path path) throws IOException {
		  byte[] encoded = Files.readAllBytes(path);
		  return new String(encoded, StandardCharsets.UTF_8);
	}
}

