package com.citycollege.sdmd.recyclerviewdemos;

public class Item {

    private String name;
    private int quantity;
    private int color;

    public Item(String name, int quantity, int color) {
        this.name = name;
        this.quantity = quantity;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getColor() {
        return color;
    }
}
