package Lectur6_4.com.customers;

import Lectur6_4.com.fruitbase.Delivery;
import Lectur6_4.com.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UniqueCustomer extends Customer {

    public UniqueCustomer(String name) {
        super(name);
    }

    @Override
    public void chooseFruit(Delivery cargo) {
        Fruit[] fruitArray = cargo.getFruits();
        List<Fruit> fruitArrayWithUniqueFruits = new ArrayList<>();
        List<Fruit> innerArray = List.of(purchases);

        for (Fruit fruit : fruitArray) {
            if (!fruitArrayWithUniqueFruits.contains(fruit)) {
                if (!innerArray.contains(fruit)) {
                    fruitArrayWithUniqueFruits.add(fruit);
                }
            }
        }

        purchases = Stream.concat(Arrays.stream(purchases),
                Arrays.stream(fruitArrayWithUniqueFruits.toArray(Fruit[]::new))).toArray(Fruit[]::new);
        List<Fruit> newListofFruit = new ArrayList<>(List.of(fruitArray));
        newListofFruit.removeAll(fruitArrayWithUniqueFruits);
        cargo.setFruits(newListofFruit.toArray(Fruit[]::new));
    }

}