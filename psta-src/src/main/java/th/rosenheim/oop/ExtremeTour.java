package th.rosenheim.oop;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents an adventure-oriented tour.
 *
 * Inherits from:
 * - Tour (abstract class)
 *
 * Specific Behavior:
 * - Implements redistributeLuggage() using a greedy algorithm:
 *   - Sorts items by weight in descending order.
 *   - Assigns each item to the participant with the most available capacity.
 */

// A tour with no carrying restrictions
public class ExtremeTour extends Tour {

    // this is the Constructor
    public ExtremeTour(String name, LocalDate date, List<Participant> participants,
                       TourGuide tourGuide, List<Item> itemToDistribute) {
        super(name, date, participants, tourGuide, itemToDistribute);
    }

    // This Redistribute items without restrictions
    @Override
    public void redistributeLuggage() {
        System.out.println("Starting redistribution for extreme tour...");

        // Step 1: Clear all backpacks
        for (Participant p : getParticipants()) {
            p.clearBackpack();
        }

        // Step 2: Sort items (heavy first)
        List<Item> items = new ArrayList<>(getItemToDistribute());
        items.sort((a, b) -> Double.compare(b.getWeight(), a.getWeight()));

        // Step 3: Sort participants (strongest capacity first)
        List<Participant> participants = new ArrayList<>(getParticipants());
        participants.sort((a, b) -> {
            double capacityA = getCapacity(a.getAge());
            double capacityB = getCapacity(b.getAge());
            return Double.compare(capacityB, capacityA); // descending
        });

        // Step 4: Assign items
        for (Item item : items) {
            Participant bestFit = null;
            double lightestLoad = Double.MAX_VALUE;

            for (Participant p : participants) {
                double capacity = getCapacity(p.getAge());
                double load = p.getTotalWeight();

                if (load + item.getWeight() <= capacity && load < lightestLoad) {
                    bestFit = p;
                    lightestLoad = load;
                }
            }

            if (bestFit != null) {
                bestFit.addItem(item);
                System.out.println(bestFit.getName() + " takes " + item.getName() + " (" + item.getWeight() + " kg)");
            }
        }
    }

    // Utility method
    private double getCapacity(int age) {
        if (age < 5) return 0.0;
        if (age <= 14) return 5.0;
        return Double.MAX_VALUE;
    }

    // This is the Summary of the tour
    @Override
    public void printOverview() {
        System.out.println("⛰️ Extreme Tour: " + name);
        System.out.println("📅 Date: " + date);
        System.out.println("🧑‍✈️ Tour Guide: " + tourGuide.getName());
        System.out.println("👨‍👩‍👧 Participants: " + participants.size());
    }

    // This is the Detailed participant list
    @Override
    public void printDetails() {
        System.out.println("===== Extreme Tour Details =====");
        for (Participant p : participants) {
            System.out.println("👤 " + p.getName() + " (age: " + p.getAge() + ")");
            System.out.println("🎒 Carries:");
            for (Item item : p.getBackpack()) {
                System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
            }
            System.out.println();
        }
    }
}