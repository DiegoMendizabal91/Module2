/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}

	public List<Integer> getPositionList(String line){
		List<Integer> posList = new ArrayList<>();
		for (int i = 0 ; i<line.length() ; i++)
			if (line.charAt(i) == '"')
				posList.add(i);
		return posList;
	}

	public List<Book> getAllBooks(){
		List<Book> bookList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String title;
			String author;
			String yearToConvert;
			int publicationYear;
			List<Integer> posList = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				String j = line;
				posList = getPositionList(line);
				if(j.charAt(0) == '"'){
					title = line.substring(posList.get(0)+1, posList.get(1));
					author = line.substring(posList.get(2)+1, posList.get(3));
					yearToConvert = line.substring(posList.get(3)+1);
					int i = 5;
				}else {
					title = line.substring(0, posList.get(0));
					title = title.replaceAll("\t","");
					author = line.substring(posList.get(0)+1, posList.get(1));
					yearToConvert = line.substring(posList.get(1)+1);
				}
				publicationYear = Integer.parseInt(yearToConvert.replaceAll("\\s+",""));
				Book currentBook = new Book(title, author, publicationYear);
				bookList.add(currentBook);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookList;
	}
}
