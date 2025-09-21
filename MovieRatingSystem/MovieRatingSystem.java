import java.util.Scanner;

public class MovieRatingSystem{
    public static void main(String args[]){

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Input name
        System.out.print("Enter a name: ");
        String name = input.nextLine();

        // Arrays for movies and ratings
        final int ARRAY_LENGTH = 5;
        String[] movies = new String[ARRAY_LENGTH];
        int[] rating = new int[ARRAY_LENGTH];

        // Loop to input movie name and rating
        for(int i = 0; i < movies.length; ++i){
            // Enter movie name
            System.out.println("Movie name:");
            movies[i] = input.nextLine();

            // Enter movie rating
            int movieRating;

            while(true) {
                System.out.println("Movie rating (1 — 10):");
                
                // If the input is an int...
                if (input.hasNextInt()) {
                    movieRating = input.nextInt();
                    input.nextLine();

                    // Check if int is between 1 and 10
                    if(movieRating >= 1 && movieRating <= 10) {
                        break;
                    } else {
                        System.out.println("Invalid rating, enter a number between 1 and 10");
                    }
                } else {
                    System.out.println(("Invalid input. Please enter an integer"));
                    input.nextLine();
                }
            }
            rating[i] = movieRating;
        }

        // Calculate the average rating
        double averageRating = 0;
        for(int i = 0; i < rating.length; ++i){
            averageRating += rating[i];
        }
        // Display average rating
        averageRating /= rating.length;
        System.out.println("\nThe average rating of the movies is: " + averageRating);

        // Display taste in movies
        if (averageRating >= 9 && averageRating <= 10){
            System.out.println("An average of " + averageRating + " means you are a cinephile!");
        } else if (averageRating >= 7 && averageRating < 9){
            System.out.println("An average of " + averageRating + " means you enjoy movies quite a bit.");
        } else if (averageRating >= 5 && averageRating < 7){
            System.out.println("An average of " + averageRating + " means you have mixed feelings about movies.");
        } else if (averageRating >= 0 && averageRating < 5){
            System.out.println("An average of " + averageRating + " means you are a tough critic!");
        } else {
            System.out.println("Something went wrong calculating the average. It should be between 0 and 10.");
        }

        // Display movies & ratings, check for favorites
        System.out.println("\nYour movie ratings are:");
        for(int i = 0; i < movies.length; ++i){
            System.out.print("\nMovie: " + movies[i] + " | ");
            System.out.print("Rating: " + rating[i]);

            // Check if INDIVIDUAL movie rating is > 10 and also < 4
            if(rating[i] == 10){
                System.out.print("        Wow, you seemed to enjoy " + movies[i] + " a lot!");
            } else if (rating[i] >= 0 && rating[i] <= 4){
                System.out.print("      It seems like " + movies[i] + " didn't impress you much.");
            }
        }

        // Check for ALL ratings >= 7 or ANY < 3
        boolean allAboveSeven = true;
        boolean anyBelowThree = false;

        for (int i = 0; i < rating.length; ++i){
            if (rating[i] < 7) {
                allAboveSeven = false;
            }
            if (rating[i] < 3) {
                anyBelowThree = true;
            }
        }

        if (allAboveSeven) {
            System.out.println("\nYou seem to enjoy most movies.");
        } else if (anyBelowThree) {
            System.out.println("\nYou have strong opinions of movies!");
        }


        // Movie genre choices
        System.out.println("\nNow, enter your favorite movie genre:");
        String genre = input.nextLine();

        switch(genre){
            case "Action": System.out.println("You love excitement and thrills!"); break;
            case "Comedy": System.out.println("You enjoy a good laugh."); break;
            case "Horror": System.out.println("You have a taste for fear!"); break;
            case "Drama": System.out.println("You appreciate deep storytelling."); break;
            case "Sci-Fi": System.out.println("You love futuristic and imaginative worlds!"); break;
            default: System.out.println("Not a valid genre.");
        }

        // Conditional operator recommendation
        String recommendation = genre.equals("Drama") ? "You would like Silver Linings Playbook." : "Watch the Dark Knight!";
        System.out.println(recommendation);

    }
}
