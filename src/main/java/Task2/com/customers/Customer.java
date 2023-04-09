package Task2.com.customers;

import Task2.com.fruitbase.Delivery;
import Task2.com.fruits.Fruit;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class Customer {
    protected Fruit[] purchases;
    String name;

    public Customer(String name) {
        purchases = new Fruit[]{};
        this.name = name;
    }

    public abstract void chooseFruit(Delivery cargo);

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