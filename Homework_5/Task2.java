/*=================Задача 2======================
Вы работаете с приложением для учета имен пользователей. 
Ваша задача - разработать программу, 
которая принимает на вход пять имен пользователей 
(или использует имена по умолчанию, если аргументы не предоставлены) 
и подсчитывает, сколько раз каждое имя встречается.
Программа должна использовать HashMap для хранения имен и их количества вхождений.
По завершении, программа выводит результат в виде пар "имя - количество".

    На входе:
'Elena'
'Elena'
'Elena'
'Ivan'
'Ivan'

    На выходе:
{Ivan=2, Elena=3}
*/
package Homework_5;

// //==================Решение 1====================:
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;

// public class Task2 {

//     public static ArrayList<String> getName(String[] list) {
//         ArrayList<String> listName = new ArrayList<>();
//         for (String el : list) {
//             String[] elList = el.split(" ");
//             listName.add(elList[0]);
//         }
//         return listName;
//     }

//     public static Map<String, Integer> getMap(ArrayList<String> name) {
//         Map<String, Integer> mapName = new HashMap<>();
//         for (int i = 0; i < name.size(); i++) {
//             int count = 1;
//             for (int j = i + 1; j < name.size(); j++) {
//                 if (name.get(i).equals(name.get(j)))
//                     count += 1;
//             }
//             if (mapName.containsKey(name.get(i)) == false)
//                 mapName.put(name.get(i), count);
//         }
//         return mapName;
//     }

//     public static void nameRepeat(Map<String, Integer> map) {
//         for (var item : map.entrySet()) {
//             if (item.getValue() > 1)
//                 System.out.printf("%s: %d \n", item.getKey(), item.getValue());
//         }
//     }

//     public static void sortName(Map<String, Integer> map) {
//         Map<Integer, ArrayList<String>> sortMap = new HashMap<>();
//         ArrayList<Integer> listCount = new ArrayList<>();
//         for (var item : map.entrySet()) {
//             if (listCount.contains(item.getValue()) == false)
//                 listCount.add(item.getValue());
//         }
//         listCount.sort(null);
//         for (int i = listCount.size() - 1; i > -1; i--) {
//             for (var item : map.entrySet()) {
//                 if (listCount.get(i) == item.getValue())
//                     System.out.printf("%s : %d \n", item.getKey(), item.getValue());
//             }
//         }
//     }

//     public static void main(String[] args) {
//         String[] emploees = new String[] {  "Иван Иванов", "Иван Петров", "Сергей Козлов", "Евгений Петров",
//                                             "Сергей Васильев", "Иван Смирнов", "Андрей Петров" };
//         ArrayList<String> emploeesName = getName(emploees);
//         Map<String, Integer> mapName = getMap(emploeesName);
//         System.out.println("Повторяющиеся имена: ");
//         nameRepeat(mapName);
//         System.out.println("Имена, отсортированные по убыванию популярности: ");
//         sortName(mapName);
//     }

// }

//==================Решение 2====================:
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    private static List<String> employeer = new ArrayList<>();
    private static Map<String, Integer> names = new TreeMap<>();

    public static void main(String[] args) {
        // инициализация списка
        employeer.add("Иван Иванов");
        employeer.add("Светлана Светина");
        employeer.add("Анна Анина");
        employeer.add("Анна Иванова");
        employeer.add("Юрий Юрин");
        employeer.add("Иван Ивашкин");
        employeer.add("Петр Петин");
        employeer.add("Петр Юрин");

        // подсчет повторений только по имени
        for (String s : employeer) {
            String[] fio = s.split(" ");
            if (names.containsKey(fio[0])) {
                names.put(fio[0], names.get(fio[0]) + 1);
            } else {
                names.put(fio[0], 1);
            }
        }

        // сортировка, получениеи списка
        List<String> listNames = names.entrySet().stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .map(e -> e.getKey() + "=" + e.getValue().toString())
                .collect(Collectors.toList());

        // вывод через logger, т.е. с датой
        //Logger logger = Logger.getAnonymousLogger();
        //for (String s : listNames) {
            //logger.info(s);
        //}
        //без даты
        for (String s : listNames) {
            System.out.println(s);
        }
    }
}

// // ================ Решение для АВТОТЕСТА ===============================
// package Homework_5;
// import java.util.HashMap;

// class NamesCounter {
// private HashMap<String, Integer> names = new HashMap<>();

// // Метод для добавления имени в HashMap
// public void addName(String name) {
// if (names.containsKey(name)) {
// names.put(name, names.get(name) + 1);
// } else {
// names.put(name, 1);
// }
// }

// // Метод для вывода содержимого HashMap
// public void showNamesOccurrences() {
// System.out.println(names);
// }
// }

// public class Task2 {
// public static void main(String[] args) {
// String name1;
// String name2;
// String name3;
// String name4;
// String name5;

// if (args.length == 0) {
// name1 = "Elena";
// name2 = "Elena";
// name3 = "Elena";
// name4 = "Elena";
// name5 = "Ivan";
// } else {
// name1 = args[0];
// name2 = args[1];
// name3 = args[2];
// name4 = args[3];
// name5 = args[4];
// }
// NamesCounter namesCounter = new NamesCounter();

// namesCounter.addName(name1);
// namesCounter.addName(name2);
// namesCounter.addName(name3);
// namesCounter.addName(name4);

// namesCounter.addName(name5);

// namesCounter.showNamesOccurrences();
// }
// }
