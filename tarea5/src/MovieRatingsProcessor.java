/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> alphabeticalMovies = new ArrayList<>();
	    try{
            if (movieRatings == null){
                return alphabeticalMovies;
            }
        } catch(NullPointerException e ){
            return alphabeticalMovies;
        }
		Set keys = movieRatings.keySet();

		for (Iterator i = keys.iterator(); i.hasNext();) {
			String key =  (String)i.next();
			alphabeticalMovies.add(key);
		}
		return alphabeticalMovies;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> alphabeticalMovies = new ArrayList<>();

        try{
            if (movieRatings == null){
                return alphabeticalMovies;
            }
        } catch(NullPointerException e ){
            return alphabeticalMovies;
        }

		Set keys = movieRatings.keySet();

		for (Iterator i = keys.iterator(); i.hasNext();) {
			String key =  (String)i.next();
			PriorityQueue<Integer> pq = movieRatings.get(key);
			int dsfgas = pq.peek();
			if (pq.peek() > rating) {
				alphabeticalMovies.add(key);
			}
		}
		return alphabeticalMovies;

	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		Set keys = movieRatings.keySet();
		TreeMap<String, Integer> map = new TreeMap<>();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			int cont = 0;
//			if(i.next() != null){
				String key =  (String)i.next();
				PriorityQueue<Integer> pq = movieRatings.get(key);

				Integer[] events = pq.toArray(new Integer[pq.size()]);
				Arrays.sort(events, pq.comparator());
				for (Integer e : events) {
					if (e < rating) {
						pq.remove(e);
						cont++;
						map.put(key, cont);
						if (pq.isEmpty()){
							i.remove();
						}
					}
				}
//			}

		}


		
		return map; // this line is here only so this code will compile if you don't modify it
	}
}
