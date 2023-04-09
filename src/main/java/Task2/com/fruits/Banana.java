package Task2.com.fruits;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
@JsonDeserialize(as = Banana.class)
public class Banana extends Fruit {

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

    public Banana() {
        freshness = Freshness.FRESH;
        weight = 3.5;
        price = new BigDecimal(140);
        name = "Banana";
    }
}
