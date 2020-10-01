import java.util.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Find Node test:");
        TreeMap<String, PriorityQueue<Integer>> map;
        List<UserMovieRating> allUsersRatings = new ArrayList<>();
        UserMovieRating movie1 = new UserMovieRating("Titanic", 8);
        UserMovieRating movie2 = new UserMovieRating("star wArs", 9);
        UserMovieRating movie3 = new UserMovieRating("LA VIDA ES BELLA", 10);
        UserMovieRating movie4 = new UserMovieRating("TiTaNic", 3);
        UserMovieRating movie5 = new UserMovieRating("", 8);
        UserMovieRating movie6 = new UserMovieRating("Rocky", 7);
        UserMovieRating movie7 = new UserMovieRating("titanic", 5);
        UserMovieRating movie8 = new UserMovieRating("star WARS", 6);
        UserMovieRating movie9 = new UserMovieRating("titanic", 4);
        UserMovieRating movie10 = new UserMovieRating("titanic", -15);
        UserMovieRating movie11 = new UserMovieRating("amanda", 5);
        UserMovieRating movie12 = new UserMovieRating("mario", 8);
        UserMovieRating movie13 = new UserMovieRating("dexter", 4);
        UserMovieRating movie14 = new UserMovieRating("amanda", 4);
        UserMovieRating movie15 = new UserMovieRating("amanda", 3);

        allUsersRatings.add(movie1);
        allUsersRatings.add(movie2);
        allUsersRatings.add(movie3);
        allUsersRatings.add(movie4);
        allUsersRatings.add(movie5);
        allUsersRatings.add(movie6);
        allUsersRatings.add(movie7);
        allUsersRatings.add(movie8);
        allUsersRatings.add(movie9);
        allUsersRatings.add(movie10);
        allUsersRatings.add(movie11);
        allUsersRatings.add(movie12);
        allUsersRatings.add(movie13);
        allUsersRatings.add(movie14);
        allUsersRatings.add(movie15);


        System.out.println("***********Convert list to map:************");

        map = MovieRatingsParser.parseMovieRatings(allUsersRatings);

        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        System.out.println("***********alphabeticalMovies:************");

        List<String> alphabeticalMovies = MovieRatingsProcessor.getAlphabeticalMovies(map);

        for(String movie : alphabeticalMovies) {
            System.out.println(movie);
        }

        System.out.println("***********getAlphabeticalMoviesAboveRating 5:************");

        List<String> alphabeticalMovies1 = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(map, 5);

        for(String movie : alphabeticalMovies1) {
            System.out.println(movie);
        }

        System.out.println("***********removeAllRatingsBelow 5:************");

        TreeMap<String, Integer> map1 = MovieRatingsProcessor.removeAllRatingsBelow(map, 5);

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        System.out.println("***********Map after removing:************");

        for (Map.Entry<String, PriorityQueue<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

    }
}

