/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.ArrayList;
import java.util.List;

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}

	public List<String> findBookTitlesByAuthor(String author){
		List<String> titlesList = new ArrayList<>();
		List<Book> bookList = dataTier.getAllBooks();
		for (Book currentBook : bookList) {
			if (currentBook.author.toLowerCase().contains(author.toLowerCase())) {
				titlesList.add(currentBook.title);
			}
		}
		return titlesList;
	}
	public int findNumberOfBooksInYear(int year){
		int cont = 0;
		List<Book> bookList = dataTier.getAllBooks();
		for (Book currentBook : bookList) {
			if (currentBook.publicationYear == year) {
				cont++;
			}
		}
		return cont;
	}

}
