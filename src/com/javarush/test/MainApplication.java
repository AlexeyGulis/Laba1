package com.javarush.test;

import java.util.Arrays;

public class MainApplication {
    final public static int MAX_BREAKFAST = 20;
    public static void main(String[] args){
        Food[] breakfast = new Food[MAX_BREAKFAST];
        int itemscount = 0;
        boolean sort1 = false;
        boolean cal1 = false;
        for (String arg : args) {
            String[] temp = arg.split("/");
            if (temp[0].equals("Пироженое")) {
                for (int i = 1; i < temp.length; i++) {
                    if (temp[i].equals("шоколадное") || temp[i].equals("сливочное") || temp[i].equals("с карамелью")) {
                        breakfast[itemscount] = new Cake(temp[i]);
                        itemscount++;
                    }
                }
            } else if (temp[0].equals("Кофе")) {
                for (int i = 1; i < temp.length; i++) {
                    if (temp[i].equals("насыщенный") || temp[i].equals("горький") || temp[i].equals("восточный")) {
                        breakfast[itemscount] = new Coffee(temp[i]);
                        itemscount++;
                    }
                }
            }
            String[] temp1 = arg.split("-");
            if(temp1.length == 2){
                if(temp1[1].equals("cal")){
                    cal1=true;
                }
                if(temp1[1].equals("sort")){
                    sort1=true;
                }
            }
        }
        int ip1 = 1;
        int ip2 = 1;
        if(sort1) Arrays.sort(breakfast,new FoodComparator());
        double callsum = 0.0;
        boolean checked[] = new boolean[MAX_BREAKFAST];
        for (int i = 0; i < MAX_BREAKFAST; i++) {
            checked[i]=false;
        }
        for (int i = 0; i < MAX_BREAKFAST; i++) {
            if(breakfast[i]!=null) {
                int i1 = 0;
                int i2 = 0;
                if(checked[i]) continue;
                breakfast[i].consumable();
                System.out.println(". ("+breakfast[i].calculateCalories()+") ");
                double cal12 = 0.0;
                for (int j = 0; j < MAX_BREAKFAST; j++){
                    if(breakfast[j]!=null){
                        if(breakfast[i].equals(breakfast[j]) && !checked[j]){
                            i1++;
                            checked[j]=true;
                            cal12+=breakfast[j].calculateCalories();
                        }
                    }
                }
                if(cal1){
                   System.out.println(" В количестве: " + i1 + ". Колличество каллорий: " + cal12);
                }else System.out.println(" В количестве: " + i1);
                callsum += cal12;
            }
        }

        if(cal1) System.out.println("Общее количество калорий: " + callsum);
    }
}
