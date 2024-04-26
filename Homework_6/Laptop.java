/*---------------------Задача 1-------------------------
* Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
- Создать множество ноутбуков.
- Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …

- Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
- Отфильтровать ноутбуки из первоначального множества и вывести проходящие по
условиям.
*/

package Homework_6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Laptop {
    // Создание полей
    private String model;
    private float diagonal;
    private int hardDisk;
    private String operativeMemory;
    private String operatingSystem;
    private String color;

    // Создание пустого конструктора для работы с методами
    public Laptop() {
    }

    // Создание конструктора для создания экземпляров класса
    public Laptop(String model, float diagonal, int hardDisk, String operativeMemory, String operatingSystem, String color) {
        this.model = model;
        this.diagonal = diagonal;
        this.hardDisk = hardDisk;
        this.operativeMemory = operativeMemory;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Создание методов get\set Для работы с private полями
    public String getModel() {
        return model;
    }

    public float getDiagonal() {
        return diagonal;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getOperativeMemory() {
        return operativeMemory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    // создание метода фильтрации ноутбуков по выборочной критериям
    public Set<Laptop> newFilter(Set<Laptop> laptop) {
        Scanner scan = new Scanner(System.in);
        Set<Laptop> listLaptop = new HashSet<>(laptop);

        System.out.println( "Укажите номер или номера (через запятую) критериев фильрации ноутбуков:" +
                            "\n1. Размер жесткого диска"+
                            "\n2. Размер оперативной памяти"+
                            "\n3. ОС"+
                            "\n4. Цвет");
        String userRequest = scan.nextLine();

        for (int i = 0; i < userRequest.length(); i++) {
            if (1 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println( "Укажите размер жёсткого диска в гб"+
                                    "\nВ наличии: 300,500,600,700,1000");
                String enterHardDisk = scan.nextLine();
                int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
                for (Laptop tempLaptop : laptop) {
                    if (intParseEnterHardDisk != tempLaptop.hardDisk) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if (2 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println( "Укажите количество оперативной памяти в Гб"+
                                    "\nВ наличии: 4, 8, 16 ");
                String enterOperativeMemory = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperativeMemory.equals(tempLaptop.operativeMemory)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if (3 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println("Укажите операционную систему\nВналичии : Linux, ios, Windows");
                String enterOperatingSystem = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperatingSystem.equals(tempLaptop.operatingSystem) == false)) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if (4 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println("Укажите цвет ноутбука\nВналичии : black, white");
                String enterColor = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterColor.equals(tempLaptop.color)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        }
        scan.close();
        return listLaptop;
    }

    // метод toString, выводит на экран данные объекта
    public String toString() {
        return "\nLaptop  ->  " + model + ",\ndiagonal = " + diagonal + ",\nhardDisk = " + hardDisk + ",\noperativeMemory = " + operativeMemory
                + ",\noperatingSystem = " + operatingSystem + ",\ncolor = " + color + "\n";
    }
}
