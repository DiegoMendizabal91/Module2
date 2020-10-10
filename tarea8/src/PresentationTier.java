/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

import java.util.List;
import java.util.Scanner;

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
		
		/* IMPLEMENT THIS METHOD */
	}

	public void showBookTitlesByAuthor() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter author name");
		String author = myObj.nextLine();  // Read user input
		List<String> titles = logicTier.findBookTitlesByAuthor(author);
		for (String currentTitle : titles) {
			System.out.println(currentTitle);
		}
	}

	public void showNumberOfBooksInYear() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter year");
		int year = Integer.parseInt(myObj.nextLine());  // Read user input
		int numberOfBooks = logicTier.findNumberOfBooksInYear(year);
		System.out.println(numberOfBooks);
	}
}
