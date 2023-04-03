package Task2.com.fruitbase.customers;

import Task2.com.fruitbase.Cargo;
import Task2.com.fruitbase.fruits.Fruit;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class Customer {
    protected Fruit[] purchases;
    private String name;

    public Customer(String name) {
        purchases = new Fruit[]{};
        this.name = name;
    }

    public abstract void chooseFruit(Cargo cargo);

    public void printPurchases() {
        for (Fruit fruit : purchases) {
            System.out.println(fruit.getName());
        }
    }
    protected Fruit[] mergeArrays(Fruit[] fruit) {
        return Stream.concat(Arrays.stream(purchases), Arrays.stream(fruit))
                .toArray(Fruit[]::new);
    }
}