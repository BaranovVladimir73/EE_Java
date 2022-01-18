package ru.gb;

public class Product {

    private int id;
    private String item;
    private double cost;

    public Product(int id, String item, double cost) {
        this.id = id;
        this.item = item;
        this.cost = cost;
    }

    public String toString() {
        return this.id + " " + this.item + " " + this.cost;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getCost() {
        return cost;
    }
}
