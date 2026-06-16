package th.rosenheim.oop;

/**
 * Represents an item to be carried during the tour.
 *
 * Attributes:
 * - Name of the item.
 * - Weight of the item.
 */

// Represents an item a participant can carry
public class Item {
    private String name;
    private double weight;

    //this sets the item's name and weight
    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // Getter for item name
    public String getName() {
        return name;
    }

    // Getter for item weight
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " kg)";
    }
}