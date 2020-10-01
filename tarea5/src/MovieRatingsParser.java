/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();
		if (allUsersRatings != null && (!(allUsersRatings.isEmpty()))) {
			UserMovieRating objRev;
			UserMovieRating objToCompare;

			for (int i = 0; i < allUsersRatings.size(); i++) {

				objRev = allUsersRatings.get(i);
				if(objRev != null && !objRev.movie.equals("") && objRev.movie!= null && objRev.userRating > 0) {
					if (map.get(objRev.movie.toLowerCase()) == null){
						PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
						for (int j = 0; j < allUsersRatings.size(); j++) {
							allUsersRatings.get(i);
							objToCompare = allUsersRatings.get(j);
							if(objRev.movie.toLowerCase().equals(objToCompare.movie.toLowerCase())
									&& objToCompare.userRating > 0) {
								priorityQueue.add(objToCompare.userRating);
							}
						}
						map.put(objRev.movie.toLowerCase(), priorityQueue);
					}
				}
			}
		}

		return map; // this line is here only so this code will compile if you don't modify it
	}

}
