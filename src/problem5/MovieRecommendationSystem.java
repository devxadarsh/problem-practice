package problem5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRecommendationSystem {

    public static void main(String[] args) {

        Movie movie;
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Sci-Fi", 8.8),
                new Movie("Titanic", "Romance", 7.8),
                new Movie("The Matrix", "Sci-Fi", 8.7),
                new Movie("The Notebook", "Romance", 7.9),
                new Movie("Interstellar", "Sci-Fi", 8.6)
        );

        recommendMovie( movies );
    }

    private static void recommendMovie(List<Movie> movies) {
        List<String> titles = movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase("Sci-Fi"))
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .limit(2)
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        if (titles.isEmpty()) {
            System.out.println("No Sci-Fi movies found");
        } else {
            System.out.println("Top Sci-Fi movies are: " +  titles);
        }
    }
}
