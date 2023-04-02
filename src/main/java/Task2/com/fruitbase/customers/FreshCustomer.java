package Task2.com.fruitbase.customers;

import Task2.com.fruitbase.Cargo;
import Task2.com.fruitbase.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FreshCustomer extends Customer {

    public FreshCustomer(String name) {
        super(name);
    }

    @Override
    public void chooseFruit(Cargo cargo) {
        Fruit[] fruitArray = cargo.getFruits();
        List<Fruit> fruitArrayWithFreshFruits = new ArrayList<>();

        for (Fruit fruit : fruitArray) {
            if (fruit.isFresh()) {
                fruitArrayWithFreshFruits.add(fruit);
            }
        }
        purchases = Stream.concat(Arrays.stream(purchases),
                Arrays.stream(fruitArrayWithFreshFruits.toArray(Fruit[]::new))).toArray(Fruit[]::new);

        List<Fruit> newListofFruit = new ArrayList<>(List.of(fruitArray));
        newListofFruit.removeAll(fruitArrayWithFreshFruits);
        cargo.setFruits(newListofFruit.toArray(Fruit[]::new));

    }

}
