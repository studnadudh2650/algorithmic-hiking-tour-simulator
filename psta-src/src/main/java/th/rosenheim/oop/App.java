package th.rosenheim.oop;

import java.time.LocalDate;
import java.util.List;

/**
 * Entry point of the application.
 *
 * Responsibilities:
 * - Initializes tours, participants, and items.
 * - Executes luggage redistribution logic.
 * - Generates outputs in console and Markdown formats.
 */

public class App {

    public static void main(String[] args) {
        init();
    }

    public static void init() {

        // Kampenwand – FamilyTour
        Tour kampenwand = new FamilyTour(
                "Kampenwand",
                LocalDate.of(2025, 8, 15),
                List.of(
                        new Participant("Peter", 27),
                        new Participant("Max", 14),
                        new Participant("Sabine", 10),
                        new Participant("Gerda", 26),
                        new Participant("Otto", 4)
                ),
                new TourGuide("Lukas", 40),
                List.of(
                        new Item("Water", 1.5),
                        new Item("Water", 1.5),
                        new Item("Sausage sandwiches", 0.5),
                        new Item("Jacket", 1.5),

                        new Item("Cheese sandwiches", 0.7),
                        new Item("Chocolate", 0.3),
                        new Item("Water", 1.5),
                        new Item("Water", 1.5),
                        new Item("Climbing equipment", 7.5),
                        new Item("Jacket", 1),

                        new Item("Water", 1.5),
                        new Item("Water", 1.5),
                        new Item("Apples", 0.5),
                        new Item("Blanket", 2),
                        new Item("Tent", 6.8),
                        new Item("Jacket", 1),

                        new Item("Bananas", 0.5),
                        new Item("Frisbee", 0.2),
                        new Item("Apple spritzer", 1.5),
                        new Item("Picnic basket", 3.5),
                        new Item("Water", 1.5),
                        new Item("Water", 1.5),
                        new Item("Jacket", 0.7)
                )
        );

        // Simsee – ExtremeTour
        Tour simsee = new ExtremeTour(
                "Simsee",
                LocalDate.of(2025, 5, 30),
                List.of(
                        new Participant("Franz", 19)
                ),
                new TourGuide("Lukas", 40),
                List.of(
                        new Item("Gatorade", 1.5),
                        new Item("Gatorade", 1.5),
                        new Item("Gatorade", 1.5),
                        new Item("Power bars", 1),
                        new Item("Jacket", 1.5)
                )
        );

        // Königssee – FamilyTour
        Tour koenigssee = new FamilyTour(
                "Königssee",
                LocalDate.of(2025, 10, 1),
                List.of(
                        new Participant("Lena", 9),
                        new Participant("Mila", 34),
                        new Participant("Ben", 6),
                        new Participant("Tobias", 12),
                        new Participant("Ella", 5)
                ),
                new TourGuide("Maxi", 41),
                List.of(
                        new Item("Protein bar", 0.4),
                        new Item("Water", 1.5),
                        new Item("Hiking jacket", 1),
                        new Item("Rain poncho", 0.5),

                        new Item("Thermos flask with tea", 1.2),
                        new Item("Sandwiches", 0.7),
                        new Item("Fruit box", 1.1),
                        new Item("Hiking guide", 0.2),

                        new Item("Water bottle", 0.75),
                        new Item("Water bottle", 0.75),
                        new Item("Oreos", 0.3),
                        new Item("Chips", 0.2),

                        new Item("First aid kit", 1),
                        new Item("Camera", 0.9),
                        new Item("Water bottle", 1.5),
                        new Item("Water bottle", 1.5),
                        new Item("Fruit", 0.5),
                        new Item("Jacket", 1.5),

                        new Item("Teddy bear", 0.3)
                )
        );

        // Run and print each tour
        List<Tour> allTours = List.of(kampenwand, simsee, koenigssee);

        for (Tour tour : allTours) {
            System.out.println("\n=============================");
            System.out.println("🏔️ " + tour.getName() + " TOUR");
            System.out.println("=============================");
            tour.redistributeLuggage();
            tour.printOverview();
            tour.printDetails();
            MarkdownWriter.writeTourDetails(tour);
        }

        MarkdownWriter.writeTourOverview(allTours);
    }
}