package Lecture5_5.Task2.com.fruits;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
@JsonDeserialize(as = Apple.class)
public class Apple extends Fruit {

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Apple() {
        freshness = Freshness.FRESH;
        weight = 2.5;
        price = new BigDecimal(120);
        name = "Apple";
    }
}
