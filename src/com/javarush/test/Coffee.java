package com.javarush.test;

public class Coffee extends Food {
    String aroma = null;
    double cal = 0.0;

    public Coffee(String aroma) {
        super("Кофе");
        this.aroma = aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getAroma() {
        return aroma;
    }

    public void consumable() {
        System.out.print(getName() + " " + getAroma() + " " + "выпит");
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if(arg0 instanceof Coffee){
            return aroma.equals(((Coffee) arg0).getAroma());
            }else return false;
        } else return false;
    }

    public double calculateCalories() {
        switch (aroma){
            case "насыщенный": return 310;
            case "горький": return 400;
            case "восточный": return 340;
            default : return 0.0;
        }
    }
}
