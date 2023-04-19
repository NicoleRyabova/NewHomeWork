package Lecture5_5.Task2.com.fruitbase;


import Lecture5_5.Task2.com.fruits.Fruit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class Cargo implements Delivery {
    public void setFruits(Fruit[] fruits) {
        this.fruits = fruits;
    }

    private Fruit[] fruits;

    public Fruit[] getFruits() {
        return fruits;
    }

    @Override
    public void removeFruit(Fruit fruit) {

    }

    public Cargo() {
        this.fruits = new Fruit[]{};
    }

    public double getWeight() {
        return Arrays.stream(fruits)
                .mapToDouble(fruit -> fruit.getWeight())
                .sum();
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(Arrays.stream(fruits)
                .mapToInt(fruit -> fruit.getPrice().intValue())
                .sum());
    }

    public void addFruit(Fruit fruit) {
        fruits = mergeArrays(fruit);

    }

    private Fruit[] mergeArrays(Fruit fruit) {
        return Stream.concat(Arrays.stream(fruits), Arrays.stream(new Fruit[]{fruit}))
                .toArray(Fruit[]::new);
    }

    @Override
    public String toString() {
        return "общая цена: " + getPrice() + " Общий вес: " + getWeight();
    }

}