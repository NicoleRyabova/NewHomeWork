//Добавьте в программу по фруктовой базе возможность импорта/экспорта каталога фруктов.
//   Добавьте в класс FruitBase следующие методы:
//   - общедоступный метод exportCatalogue
//     Сериализует внутренний объект FruitCatalogue в проект.
//     Выводится сообщение "каталог экспортирован"
//
//   - общедоступный метод importCatalogue
//     Десериализует из проекта объект FruitCatalogue и результатом заменяет текущий внутренний объект.
//     Выводится сообщение "каталог импортирован"
//
package Task2.com.fruitbase;

import Task2.com.fruits.Fruit;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//
public class FruitBase {
    FruitCatalogue fruitCatalogue;

    public FruitBase() {
        fruitCatalogue = new FruitCatalogue();
    }

    public Delivery takeOrder(String order) {
        List<Fruit> rightFruits = new ArrayList<>();
        Delivery cargo = new Cargo();

        for (String nameFruit : order.split(" ")) {
            Fruit fruit = fruitCatalogue.findFruit(nameFruit);

            if (fruit != null) {
                rightFruits.add(fruit);
            }
        }
        if (!rightFruits.isEmpty()) {
            rightFruits.forEach(fruit -> cargo.addFruit(fruit));
            return cargo;
        }
        return cargo;
    }

    public void exportCatalogue() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        objectMapper.writeValue(new File("src/main/resources/json.json" ), fruitCatalogue);
    }
    public void importCatalogue() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
       fruitCatalogue = objectMapper.readValue(new File("src/main/resources/json.json" ), FruitCatalogue.class);
    }
}