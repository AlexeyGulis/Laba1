package com.javarush.test;

public class Cake extends Food {
    String icing;
    double cal;

    public Cake(String icing) {
        super("Пироженое");
        this.icing = icing;
    }
    public String getIcing(){
        return icing;
    }

    public void consumable() {
        System.out.print(getName() + " " + this.icing + " " + "съедено");
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if(arg0 instanceof Cake){
                return icing.equals(((Cake) arg0).getIcing());
            }else return false;
        } else return false;
    }
    public double calculateCalories() {
        switch (icing){
            case "с карамелью": return 1120;
            case "сливочное": return 1800;
            case "шоколадное": return 1340;
            default : return 0.0;
        }
    }
}
