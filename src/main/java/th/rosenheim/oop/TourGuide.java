package th.rosenheim.oop;

/**
 * Represents the guide leading the tour.
 *
 * Responsibilities:
 * - Stores guide information like name and experience.
 * - May provide methods related to guiding activities.
 */

// This is a subclass of Person
public class TourGuide extends Person {

    // This Constructor passes name and age to the Person constructor
    public TourGuide(String name, int age) {
        super(name, age);
    }

    // This method overrides the abstract getRole() method in Person
    @Override
    public String getRole() {
        return "Tour Guide";
    }
}