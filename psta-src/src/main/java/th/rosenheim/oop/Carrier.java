package th.rosenheim.oop;


/**
 * Carrier interface defining the contract for entities capable of carrying items.
 *
 * <p>This interface is implemented by classes that represent entities with the ability
 * to carry items, such as participants or tour guides. It specifies the methods required
 * to manage the items being carried.</p>
 *
 * <p>Implementing classes must provide concrete implementations for all methods declared
 */

public interface Carrier {
    void addItem(Item item);
    double getTotalWeight();
    void clearBackpack();
}

