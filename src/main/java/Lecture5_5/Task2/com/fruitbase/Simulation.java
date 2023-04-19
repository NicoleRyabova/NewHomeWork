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

//2. В проект фруктовой базы добавьте возможность через аргументы указать файл,
//   в который экспортировать или импортировать каталог.
//   Если после флага '-e' или '-i' следует '=', то каталог записывать или, соответственно,
//   считывается из файла по указанному пути.
//   Исключения обрабатываются в классе Simulation. При исключениях программа завершается со следующими сообщениями:
//   - если файл не найден (FileNotFoundException), то выводится сообщение: "Не найден файл "
//   - если происходит исключение при экспорте или импорте (IOException), то , например для экспорта -
//   "Ошибка при экспорте каталога в "
//   - если происходит чтение неподходящей версии файла, то сообщение
//   "Невозможно импортировать каталог из файла : неподдерживаемая версия" - Не доделано
//   - в остальных случаях сообщения для импорта и экспорта
//   "Непредведенная ошибка при импорте каталога из файла "
//   "Непредведенная ошибка при экспорте каталога из файла "
package Lecture5_5.Task2.com.fruitbase;

import Lecture5_5.Task2.com.customers.Customer;
import Lecture5_5.Task2.com.customers.FreshCustomer;
import Lecture5_5.Task2.com.customers.UniqueCustomer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.List;

public class Simulation {

    public static void main(String[] args) throws IOException {
        FruitBase fruitBase = new FruitBase();
        List<String> listofArgs = List.of(args);
        if (listofArgs.toString().contains("-e") || listofArgs.contains("--export")) {
            if (listofArgs.toString().contains("-e=")) {
                String argument = listofArgs.stream().filter(e -> e.contains("-e=")).findFirst().get();
                try {
                    fruitBase.exportCatalogue(argument.replaceAll("-e=", ""));
                } catch (FileNotFoundException exception) {
                    System.out.println("Не найден файл");
                } catch (IOException exception) {
                    System.out.println("Ошибка при экспорте каталога в " + argument);
                    exception.printStackTrace();
                } catch (Throwable e) {
                    System.out.println("Непредведенная ошибка при экспорте каталога из файла " + argument);
                }
            } else {
                fruitBase.exportCatalogue();
            }
        } else if (listofArgs.toString().contains("-i") || listofArgs.contains("--import")) {
            if (listofArgs.toString().contains("-i=")) {
                String argument = listofArgs.stream().filter(e -> e.contains("-i=")).findFirst().get();
                try {
                    fruitBase.importCatalogue(argument.replaceAll("-i=", ""));
                } catch (FileNotFoundException exception) {
                    System.out.println("Не найден файл");
                } catch (InvalidClassException exception) {
                    System.out.println("Невозможно импортировать каталог из файла : неподдерживаемая версия");
                } catch (IOException exception) {
                    System.out.println("Ошибка при импорте каталога в " + argument);
                } catch (Throwable e) {
                    System.out.println("Непредведенная ошибка при импорте каталога из файла " + argument);
                }

            } else {
                fruitBase.importCatalogue();
                System.out.println("Каталог импортирован");
            }
        }
        Customer[] customers = new Customer[]{new FreshCustomer("Petr"), new UniqueCustomer("Vasya")};

        String line = "";

        if (args.length == 0) {
            System.exit(0);
        }
        for (int i = 0; i <= args.length - 1; i++) {
            line = line + args[i] + " ";
        }

        for (Customer customer : customers) {
            Delivery cargo = fruitBase.takeOrder(line);
            System.out.println(cargo);
            customer.chooseFruit(cargo);
            customer.printPurchases();
        }
    }
}

/*public static void main(String[] args) throws IOException {
        FruitBase fruitBase = new FruitBase();
        List<String> listofArgs = List.of(args);
        if (listofArgs.toString().contains("-e") || listofArgs.contains("--export")) {
            if (listofArgs.toString().contains("-e=")) {
                String argument = listofArgs.stream().filter(e -> e.contains("-e=")).findFirst().get();//почитать
                try {
                    fruitBase.exportCatalogue(argument.replaceAll("-e=", ""));
                } catch (FileNotFoundException exception) {
                    System.out.println("Не найден файл");
                } catch (IOException exception) {
                    System.out.println("Ошибка при экспорте каталога в " + argument);
                    exception.printStackTrace();
                } catch (Throwable e) {
                    System.out.println("Непредведенная ошибка при экспорте каталога из файла " + argument);
                }
            } else {
                fruitBase.exportCatalogue();
            }
        } else if (listofArgs.toString().contains("-i") || listofArgs.contains("--import")) {
            if (listofArgs.toString().contains("-i=")) {
                String argument = listofArgs.stream().filter(e -> e.contains("-i=")).findFirst().get();

                try {
                    fruitBase.importCatalogue(argument.replaceAll("-i=", ""));
                } catch (FileNotFoundException exception) {
                    System.out.println("Не найден файл");
                } catch (InvalidClassException exception) {
                    System.out.println("Невозможно импортировать каталог из файла : неподдерживаемая версия");
                } catch (IOException exception) {
                    System.out.println("Ошибка при импорте каталога в " + argument);
                } catch (Throwable e) {
                    System.out.println("Непредведенная ошибка при импорте каталога из файла " + argument);
                }

            } else {
                fruitBase.importCatalogue();
                System.out.println("Каталог импортирован");
            }
        }
        Customer[] customers = new Customer[]{new FreshCustomer("Petr"), new UniqueCustomer("Vasya")};

        String line = "";

        if (args.length == 0) {
            System.exit(0);
        }
        for (int i = 0; i <= args.length - 1; i++) {
            line = line + args[i] + " ";
        }

        for (Customer customer : customers) {
            Delivery cargo = fruitBase.takeOrder(line);
            System.out.println(cargo);
            customer.chooseFruit(cargo);
            customer.printPurchases();
        }
    }
}*/