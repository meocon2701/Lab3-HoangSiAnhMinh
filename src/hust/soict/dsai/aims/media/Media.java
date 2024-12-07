package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.store.Store;

import java.util.Comparator;
import java.util.Scanner;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        // Check if obj is null or not an instance of Media
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }
        // Cast to Media and compare titles
        Media other = (Media) obj;
        return this.title.equalsIgnoreCase(other.title); // Case-insensitive comparison
    }

    @Override
    public String toString() {
        return "Media - " + title + " - " + category + " - Cost: " + cost;
    }


    public void displayInfo() {
        System.out.println("Media Information:");
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: " + getCost() + " $");
    }

    public void Playable() {
    }
}

