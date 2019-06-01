package ee.taltech.iti0202.generics;

import ee.taltech.iti0202.generics.cats.PersianCat;
import ee.taltech.iti0202.generics.foods.Food;
import java.util.Optional;


public class AnimalBox<T extends Animal> {
    private T animal;
    private PersianCat persianCat;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void put(T animal) { }

    public <T extends Animal> void sound() {
        animal.sound();
    }

    public void feed(Food food) { }

    public Optional<T> getAnimal() {
        return Optional.ofNullable(animal);
    }

}
