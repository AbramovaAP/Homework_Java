/*=================Задача 1. ======================
Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:

add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

find(String name): Поиск номеров телефона по имени в телефонной книге.
Если запись с именем name существует, возвращает список номеров телефона для этой записи.
Если запись с именем name не существует, возвращает пустой список.

getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, 
где ключи - это имена, а значения - списки номеров телефона.

Пример.

    На входе:
add("Alice", 123456);   
add("Alice", 789012);   
add("Bob", 789012);   

    На выходе:
Команды:
find("Alice")
getPhoneBook()
find("Me")

Результат:
[123456, 789012]. 
{Bob=[789012], Alice=[123456, 789012]} 
[]
*/
package Homework_5;
// //==================Решение 1====================:

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;

// public class Task1 {

//   // Метод, который добавляет номера в книгу
//   public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) {
//     if (map.containsKey(key)) {
//       map.get(key).add(value);
//     } else {
//       ArrayList<Integer> list = new ArrayList<>();
//       list.add(value);
//       map.put(key, list);
//     }

//   }

//   // Метод, который печатает список контактов
//   public static void printBook(Map<String, ArrayList<Integer>> map) {
//     for (var item : map.entrySet()) {
//       String phones = "";
//       for (int el : item.getValue()) {
//         phones = phones + el + ", ";
//       }
//       System.out.printf("%s: %s \n", item.getKey(), phones);
//     }
//   }

//   public static void main(String[] args) {
//     Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
//     addNumber("Ivanov", 123, bookPhone);
//     addNumber("Ivanov", 1234, bookPhone);
//     addNumber("Petrov", 546585, bookPhone);
//     addNumber("Sidorov", 8956477, bookPhone);
//     addNumber("Ivanov", 12356233, bookPhone);
//     addNumber("Petrov", 787897, bookPhone);
//     printBook(bookPhone);
//   }
// }

//==================Решение 2, не мое, но очень крутое!====================:
import java.util.*;
import java.util.logging.Logger;

/*телефонный справочник организуем по принципу записной Книжки, где основой
 * поиска служит ФИО
 * дубли телефонов не вносим
 */

public class Task1 {
    private static Map<String, List<String>> phoneNote = new HashMap<>();

    public static void main(String[] args) {
        int menuOption = 1;

        String fio = "";
        String phone = "";
        while (menuOption > 0) {
            menuOption = menu();

            switch (menuOption) {
                case 1:
                    fio = readStrConsole("ФИО: ");
                    phone = readStrConsole("Номер: ");
                    setPhone(fio, phone);
                    break;
                case 2:
                    fio = readStrConsole("ФИО: ");
                    List<String> phones = getPhones(fio);
                    if (phones.size() == 0) {
                        printLog("Абонент не найден!");
                    } else {
                        printLog(phones.toString());
                    }
                    break;
            }
        }

    }

    // получить телефонные номера для абонента fio, если абонент отсутствует -
    // вернет пустой список
    public static List<String> getPhones(String fio) {
        return phoneNote.getOrDefault(fio, new ArrayList<>());
    }

    // добавить телефон в справочник, если абонент fio уже существует - добавит еще
    // один номер
    // (дубликаты номеров не добавляются)
    // если абонента в справочнике нет - создаст
    public static void setPhone(String fio, String phoneNumber) {
        if (phoneNote.containsKey(fio)) {
            if (!phoneNote.get(fio).contains(phoneNumber)) {
                phoneNote.get(fio).add(phoneNumber);
            }
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            phoneNote.put(fio, phoneList);
        }
    }

    // логированный вывод
    public static void printLog(String message) {
        Logger logger = Logger.getAnonymousLogger();
        logger.info(message);
    }

    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // получение целочисленного значения с консоли
    public static int readIntConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    // получение строкового значения с консоли
    public static String readStrConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    }

    // меню программы
    public static int menu() {
        System.out.println("1 - добавить запись");
        System.out.println("2 - найти телефон");
        System.out.println("0 - выход");
        return readIntConsole(">");
    }

}

// // ================ Решение для АВТОТЕСТА ===============================
// package Homework_5;

// import java.util.ArrayList;
// import java.util.HashMap;

// class PhoneBook {
// private static HashMap<String, ArrayList<Integer>> phoneBook = new
// HashMap<>();

// public void add(String name, Integer phoneNum) {
// if (phoneBook.containsKey(name)) {
// phoneBook.get(name).add(phoneNum);
// } else {
// ArrayList<Integer> values = new ArrayList<>();
// values.add(phoneNum);
// phoneBook.put(name, values);
// }
// }

// public ArrayList<Integer> find(String name) {
// if (phoneBook.containsKey(name)) {
// return phoneBook.get(name);
// }
// return new ArrayList<Integer>();
// }

// public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
// return phoneBook;
// }
// }

// public class Task1 {
// public static void main(String[] args) {
// String name1;
// String name2;
// int phone1;
// int phone2;

// if (args.length == 0) {
// name1 = "Ivanov";
// name2 = "Petrov";
// phone1 = 123456;
// phone2 = 654321;
// } else {
// name1 = args[0];
// name2 = args[1];
// phone1 = Integer.parseInt(args[2]);
// phone2 = Integer.parseInt(args[3]);
// }

// PhoneBook myPhoneBook = new PhoneBook();
// myPhoneBook.add(name1, phone1);
// myPhoneBook.add(name1, phone2);
// myPhoneBook.add(name2, phone2);
// System.out.println(myPhoneBook.find(name1));
// System.out.println(PhoneBook.getPhoneBook());
// System.out.println(myPhoneBook.find("Me"));
// }
// }
