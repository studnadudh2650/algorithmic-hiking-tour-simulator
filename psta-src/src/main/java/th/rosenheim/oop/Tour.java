package th.rosenheim.oop;

import java.time.LocalDate;
import java.util.List;

/**
 * Abstract base class representing a generic tour.
 *
 * Characteristics:
 * - Cannot be instantiated directly.
 * - Defines common attributes like name, date, participants, and items.
 * - Declares the abstract method redistributeLuggage() to be implemented by subclasses.
 */

// This ia the Abstract class for all kinds of tours
public abstract class Tour {

    protected String name;
    protected LocalDate date;
    protected List<Participant> participants;
    protected TourGuide tourGuide;
    protected List<Item> itemToDistribute;

    // this constructur initializes all fields
    public Tour(String name, LocalDate date, List<Participant> participants,
                TourGuide tourGuide, List<Item> itemToDistribute) {
        this.name = name;
        this.date = date;
        this.participants = participants;
        this.tourGuide = tourGuide;
        this.itemToDistribute = itemToDistribute;
    }

    // Abstract method: subclasses must implement how luggage is distributed
    public abstract void redistributeLuggage();


    // This prints summary of the tour
    public abstract void printOverview();

    // This print all details of the tour
    public abstract void printDetails();

    // Getter for tour name
    public String getName() {
        return name;
    }

    // Getter for tour date
    public LocalDate getDate() {
        return date;
    }

    // Getter for participants list
    public List<Participant> getParticipants() {
        return participants;
    }

    // Getter for tour guide
    public TourGuide getTourGuide() {
        return tourGuide;
    }

    // Getter for distributable items
    public List<Item> getItemToDistribute() {
        return itemToDistribute;
    }
}