package Homework_6;

import java.util.HashSet;
import java.util.Set;

public class Main_laptop_model {
        public static void main(String[] args) {

                // Создание объектов класса Laptop
                Laptop hp_pailion_g6 = new Laptop("hp_pailion_g6", 16, 500, "16", "Windows", "black");

                Laptop samsung_a52 = new Laptop("samsung_a52", 18, 300, "8", "Windows", "black");

                Laptop samsung_m31s = new Laptop("samsung_m31s", 16, 1000, "16", "Linux", "black");

                Laptop lenovo_gtx76 = new Laptop("lenovo_gtx76", 16, 700, "8", "Windows", "white");

                Laptop macbook_14pro = new Laptop("macbook_14pro", 17, 1000, "8", "ios", "white");

                Laptop asus_x515 = new Laptop("asus_x515", 17, 300, "4", "Windows", "black");

                Laptop acer_air5 = new Laptop("acer_air5", 19, 600, "8", "Windows", "black");

                // Создание множества
                Set<Laptop> laptop = new HashSet<>();
                laptop.add(hp_pailion_g6);
                laptop.add(samsung_a52);
                laptop.add(samsung_m31s);
                laptop.add(lenovo_gtx76);
                laptop.add(macbook_14pro);
                laptop.add(asus_x515);
                laptop.add(acer_air5);

                // создание нового объекта вызова методов
                Laptop FilterLaptop = new Laptop();

                // вызод метода фильтрации по заданным пользователем критериям
                System.out.println(FilterLaptop.newFilter(laptop));
        }
}
