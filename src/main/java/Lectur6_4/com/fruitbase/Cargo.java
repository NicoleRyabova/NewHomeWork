package Lectur6_4.com.fruitbase;


import Lectur6_4.com.fruits.Fruit;

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
/* public void setFruits(Fruit[] fruits) {
        this.fruits = List.of(fruits);
    }

    private List<Fruit> fruits;

    public Fruit[] getFruits() {
       return fruits.toArray(new Fruit[0]);
    }

    public Fruit removeFruit(Fruit fruit){
        if(fruits.contains(fruit)) {
            fruits.remove(fruit);
            return fruit;
        }
        return null;
    }

    public Cargo() {
        this.fruits = new ArrayList<>();
    }

    public double getWeight() {
        return Arrays.stream(new List[]{fruits})
                .mapToDouble(Fruit fruit -> fruit.getWeight())
                .sum();
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(Arrays.stream(fruits)
                .mapToInt(fruit -> fruit.getPrice().intValue())
                .sum());
    }

    public void addFruit(Fruit fruit) {
        fruits = List.of(mergeArrays(fruit));

    }

    private Fruit[] mergeArrays(Fruit fruit) {
        return Stream.concat(Arrays.stream(fruits), Arrays.stream(new Fruit[]{fruit}))
                .toArray(Fruit[]::new);
    }*/