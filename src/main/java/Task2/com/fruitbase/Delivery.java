package Task2.com.fruitbase;

import Task2.com.fruits.Fruit;

import java.math.BigDecimal;

////В проект фруктовой базы, в пакет fruitbase, добавьте интерфейс Delivery.
////Содержит следующие абстрактные методы
////   double getWeight();
////   BigDecimal getPrice();
////   void addFruit(Fruit fruit);
////   Fruit[] getFruits();
////   void removeFruit(Fruit fruit);
////Укажите, что класс Cargo реализует интерфейс Delivery.
////Замените в методах проекта типы возвращаемых объектов и типы передаваемых аргументов с Cargo на Delivery.
public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit);
    Fruit[] getFruits();
    void removeFruit(Fruit fruit);

    void setFruits(Fruit[] toArray);
}
