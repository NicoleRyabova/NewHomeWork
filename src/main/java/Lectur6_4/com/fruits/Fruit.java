package Lectur6_4.com.fruits;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Apple.class, name = "Apple"),
        @JsonSubTypes.Type(value = Banana.class, name = "Banana"),
        @JsonSubTypes.Type(value = Orange.class, name = "Orange"),
        @JsonSubTypes.Type(value = Pineapple.class, name = "Pineapple")
})
public abstract class Fruit {
    public double weight;
    public BigDecimal price;
    public String name;

    protected Freshness freshness;

    protected Fruit() {
    }

    @JsonIgnore
    public boolean isFresh() {
        return freshness.equals(Freshness.FRESH);
    }

    public abstract double getWeight();

    public abstract BigDecimal getPrice();

    public Fruit(double weight, BigDecimal price, String name, Freshness freshness) {
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.freshness = freshness;
    }

    public abstract String getName();
}