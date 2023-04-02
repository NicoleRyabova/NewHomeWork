//   Для использования этих методов добавьте обработку специальных аргументов ("флагов") в классе Simulation.
//       в методе main после создания объекта FruitBase добавьте проверку аргументов:
//          - если передан флаг "-e" или "--export", то вызовите метод exportCatalogue у объекта FruitBase
//          - если передан флаг "-i" или "--import", то вызовите метод importCatalogue у объекта FruitBase
//Подготовьте необходимые классы к сериализации.
//
//   Для проверки экспортируйте каталог, зафиксируйте стоимость и цену полученного груза.
//   После экспорта каталога измените вес и цены у фруктов и зафиксируйте новые вес и стоимость.
//   Далее попробуйте имортировать каталог и обратите внимание, что стоимость и вес груза
//   расчитаны согласно экспортированному каталогу.
package Task2.com.fruitbase;

import Task2.com.fruitbase.customers.Customer;
import Task2.com.fruitbase.customers.FreshCustomer;
import Task2.com.fruitbase.customers.UniqueCustomer;

import java.io.IOException;
import java.util.List;

public class Simulation {

    public static void main(String[] args) throws IOException {
        FruitBase fruitBase = new FruitBase();
        List<String> listofArgs = List.of(args);
        if (listofArgs.contains("-e") || listofArgs.contains("--export")){
            fruitBase.exportCatalogue();
        }else if(listofArgs.contains("-i") || listofArgs.contains("--import")){
            fruitBase.importCatalogue();
            System.out.println("Каталог импортирован");
        }

        fruitBase.importCatalogue();
        Customer[] customers = new Customer[]{new FreshCustomer("Petr"), new UniqueCustomer("Vasya")};

        String line = "";

        if (args.length == 0) {
            System.exit(0);
        }
        for (int i = 0; i <= args.length - 1; i++) {
            line = line + args[i] + " ";
        }

        for (Customer customer : customers) {
            Cargo cargo = fruitBase.takeOrder(line);
            System.out.println(cargo);
            customer.chooseFruit(cargo);
            customer.printPurchases();
        }
    }
}
