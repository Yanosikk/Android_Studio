package com.example.lab7_1;

public class Item {
    String colour;
    String description;
    int image;

    public Item(String colour, String description, int image) {
        this.colour = colour;
        this.description = description;
        this.image = image;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

