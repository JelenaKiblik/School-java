package ee.taltech.iti0202.geometry;

import ee.taltech.iti0202.geometry.shape.Triangle;

public class Main {

    public static void main(String[] args) {
        Triangle tr = new Triangle("k", 3, Triangle.Color.Blue, 40);
        System.out.println(tr);
    }
}
