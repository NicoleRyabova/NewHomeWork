package Task2.com.fruitbase.fruits;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
@JsonDeserialize(as = Pineapple.class)
public class Pineapple extends Fruit {

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

    public Pineapple() {
        freshness = Freshness.FRESH;
        weight = 4.1;
        price = new BigDecimal(340);
        name = "Pineapple";
    }
}
