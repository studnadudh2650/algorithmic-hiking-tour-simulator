package th.rosenheim.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an individual participating in a tour.
 *
 * Responsibilities:
 * - Stores personal information like name and age.
 * - Maintains a list of items assigned to the participant (backpack).
 * - Calculates total weight carried.
 * - Determines maximum carrying capacity based on age.
 */
public class Participant extends Person implements Carrier {

    private List<Item> backpack;

    public Participant(String name, int age) {
        super(name, age);
        this.backpack = new ArrayList<>(); //
    }

    @Override
    public void addItem(Item item) {
        backpack.add(item);
    }

    @Override
    public double getTotalWeight() {
        return backpack.stream()
                .mapToDouble(Item::getWeight)
                .sum();
    }

    @Override
    public void clearBackpack() {
        backpack.clear();
    }

    public List<Item> getBackpack() {
        return backpack;
    }

    @Override
    public String getRole() {
        return "Participant";
    }
}