package StreamsAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Movie {
    String title;
    List<String> actors;
    double rating;

    public Movie(String title, List<String> actors, double rating) {
        this.title = title;
        this.actors = actors;
        this.rating = rating;
    }
    public List<String> getActors() { return actors; }
    public double getRating() { return rating; }
    public String getTitle() { return title; }


//    Create a list of all unique actors across all movies.
    public static List<String> getListOfAllUniqueActors(List<Movie> movies) {
        List<String> moviesList = movies.stream().map(Movie::getActors).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        List<String> moviesList1 = movies.stream().flatMap(movie -> movie.getActors().stream()).distinct().collect(Collectors.toList());
        System.out.println("13. ------------------");
        System.out.println(moviesList);
        System.out.println(moviesList1);
        System.out.println("------------------");
        return moviesList;
    }

//    Count how many movies "Leo" has acted in.
    public static Long countMoviesActorActedIn(List<Movie> movies, String actor) {
        Long collect = movies.stream().filter(movie -> movie.getActors().contains(actor)).collect(Collectors.counting());
        System.out.println("14. ------------------");
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

    static class ActorMoviePair {
        String actor;
        String movie;
        ActorMoviePair(String actor, String movie) {
            this.actor = actor;
            this.movie = movie;
        }
    }

//    Create a Map: Actor Name -> List of Movies they are in.
    public static Map<String, List<String>> mapOfActorMovieList(List<Movie> movies) {
        Map<String, List<String>> collect = movies.stream().flatMap(movie -> movie.getActors().stream()
                        .map(actor -> new ActorMoviePair(actor, movie.getTitle())))
                .collect(Collectors.groupingBy(
                        actorMoviePair -> actorMoviePair.actor,
                        Collectors.mapping(movie -> {
                            return movie.movie;
                        }, Collectors.toList())
                ));

        System.out.println("15. ------------------");
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

//    Find the total number of actors in the database (including duplicates).
    public static Long totalNoOfActors(List<Movie> movies){
        System.out.println("15. ------------------");
        long count = movies.stream().flatMap(movie -> movie.getActors().stream()).count();
        System.out.println(count);
        System.out.println("------------------");
        return count;
    }
//    Find the movie with the highest rating (return the Title string).
    public static String movieWithHighestRating(List<Movie> movies){
        System.out.println("15. ------------------");
        String collect = movies.stream().sorted(Comparator.comparing(Movie::getRating).reversed()).map(Movie::getTitle).findFirst().get();
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

//    Convert the Movie list to a Map<String, Double> (Title -> Rating)
    public static Map<String, Double> mapMovieWithRating(List<Movie> movies){
        System.out.println("16. ------------------");
        Map<String, Double> collect = movies.stream().collect(Collectors.toMap(Movie::getTitle, Movie::getRating));
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }
//    Create a single String of all movie titles separated by commas.
    public static String getAllMovieTitles(List<Movie> movies){
        System.out.println("17. ------------------");
        String collect = movies.stream().map(Movie::getTitle).collect(Collectors.joining(","));
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }
}

