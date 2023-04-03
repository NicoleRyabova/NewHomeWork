package Task2.com.fruitbase;


import Task2.com.fruitbase.fruits.*;

public class FruitCatalogue {
    Fruit[] fruits;

    public FruitCatalogue() {
        fruits = new Fruit[]{new Apple(), new Banana(), new Orange(), new Pineapple()};
    }

    Fruit findFruit(String fruit) {
        for (int i = 0; i < fruits.length; i++) {
            if (fruit.equalsIgnoreCase(fruits[i].getName())) {
                return fruits[i];
            }
        }
        return null;
    }
}