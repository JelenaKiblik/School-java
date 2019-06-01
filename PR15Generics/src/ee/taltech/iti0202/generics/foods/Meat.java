package ee.taltech.iti0202.generics.foods;

import ee.taltech.iti0202.generics.Animal;

public abstract class Meat extends Food {

    private static  String name = "";
    private Animal animal;
    private Food food;

    public Meat() {
        super(name);
    }

    public abstract void feed();
}
