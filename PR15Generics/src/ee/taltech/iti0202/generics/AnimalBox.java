package ee.taltech.iti0202.generics;

import ee.taltech.iti0202.generics.foods.Food;
import java.util.Optional;


public class AnimalBox<T extends Animal> {
    private T animal;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void put(T animal) { }

    public void sound() {
        animal.sound();
    }

    public void feed(Food food) {
    }

    public Optional<T> getAnimal() {
        return Optional.ofNullable(animal);
    }
}
