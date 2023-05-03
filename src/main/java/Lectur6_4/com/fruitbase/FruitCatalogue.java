package Lectur6_4.com.fruitbase;


import Lectur6_4.com.fruits.*;

import java.math.BigDecimal;

public class FruitCatalogue {
    Fruit[] fruits;
    Fruit kiwi = new Fruit(0.2, BigDecimal.valueOf(380), "Kiwi", Freshness.FRESH){
        @Override
        public double getWeight() {
            return kiwi.weight;
        }

        @Override
        public BigDecimal getPrice() {
            return kiwi.price;
        }

        @Override
        public String getName() {
            return kiwi.name;
        }
    };

    Fruit mango = new Fruit(0.8, BigDecimal.valueOf(400), "Mango", Freshness.FRESH){
        @Override
        public double getWeight() {
            return mango.weight;
        }

        @Override
        public BigDecimal getPrice() {
            return mango.price;
        }

        @Override
        public String getName() {
            return mango.name;
        }
    };

    public FruitCatalogue() {
        fruits = new Fruit[]{new Apple(), new Banana(), new Orange(), new Pineapple(),kiwi,mango };
    }

    public Fruit findFruit(String fruit) {
        for (int i = 0; i < fruits.length; i++) {
            if (fruit.equalsIgnoreCase(fruits[i].getName())) {
                return fruits[i];
            }
        }
        return null;
    }
}