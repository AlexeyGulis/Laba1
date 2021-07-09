package com.javarush.test;

public class Food implements Consumable,Nutritious {

    String name = null;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object arg0) {
        if (arg0 != null && arg0 instanceof Food) {
            return name.equals(((Food) arg0).getName());
        } else return false;
    }

    public void consumable() {
        System.out.print(this.name + " " + "съедено");
    }

    public double calculateCalories() {
        return 0.0;
    }
}
