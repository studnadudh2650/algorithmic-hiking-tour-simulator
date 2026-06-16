package th.rosenheim.oop;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents a family-oriented tour.
 *
 * Inherits from:
 * - Tour (abstract class)
 *
 * Specific Behavior:
 * - Implements redistributeLuggage() with age-based rules:
 *   - Children under 5 carry nothing.
 *   - Children aged 5–14 have a maximum carrying capacity of 5 kg.
 *   - Adults can carry unlimited weight.
 */

//represents thefamily hiking tour
public class FamilyTour extends Tour {

    // Constructor: passes everything to parent Tour class
    public FamilyTour(String name, LocalDate date, List<Participant> participants,
                      TourGuide tourGuide, List<Item> itemToDistribute) {
        super(name, date, participants, tourGuide, itemToDistribute);
    }

    // Redistribute luggage based on participant age
    @Override
    public void redistributeLuggage() {
        System.out.println("Starting redistribution...");

        for (Participant p : getParticipants()) {
            p.clearBackpack(); // clear backpacks first
        }

        List<Item> items = new ArrayList<>(getItemToDistribute());
        items.sort((a, b) -> Double.compare(b.getWeight(), a.getWeight())); // heavy first

        List<Participant> children = new ArrayList<>(getParticipants());
        children.sort(Comparator.comparingInt(Participant::getAge)); // young first

        for (Item item : items) {
            for (Participant child : children) {
                int age = child.getAge();
                double currentWeight = child.getTotalWeight();
                double maxWeight;

                if (age < 5) {
                    maxWeight = 0;
                } else if (age <= 14) {
                    maxWeight = 5;
                } else {
                    maxWeight = Double.MAX_VALUE;
                }

                if (currentWeight + item.getWeight() <= maxWeight) {
                    child.addItem(item);
                    System.out.println(child.getName() + " takes " + item.getName() + " (" + item.getWeight() + " kg)");
                    break;
                }
            }
        }
    }

    // Print tour summary
    @Override
    public void printOverview() {
        System.out.println("📋 Family Tour: " + name);
        System.out.println("📅 Date: " + date);
        System.out.println("🧑‍✈️ Tour Guide: " + tourGuide.getName());
        System.out.println("👨‍👩‍👧 Participants: " + participants.size());
    }

    // Print participant details
    @Override
    public void printDetails() {
        System.out.println("===== Tour Details =====");
        for (Participant p : participants) {
            System.out.println("👤 " + p.getName() + " (age: " + p.getAge() + ")");
            System.out.println("🎒 Carries:");

            if (p.getBackpack().isEmpty()) {
                System.out.println("   ⚠️ Carries nothing!");
            } else {
                for (Item item : p.getBackpack()) {
                    System.out.println("   - " + item.getName() + " (" + item.getWeight() + " kg)");
                }
            }

            System.out.println();
        }
    }
}
