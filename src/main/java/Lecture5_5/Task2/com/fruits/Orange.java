package Lecture5_5.Task2.com.fruits;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
@JsonDeserialize(as = Orange.class)
public class Orange extends Fruit {

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

    public Orange() {
        freshness = Freshness.FRESH;
        weight = 2.1;
        price = new BigDecimal(110);
        name = "Orange";
    }
}
