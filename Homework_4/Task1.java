/*=================Задача 1======================
Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет
“перевернутый” список.
*/

//==================Решение====================:
package Homework_4;

import java.util.LinkedList;

public class Task1 {

  //Заполняем список элементами вручную
  public static LinkedList<Object> fillList() {
    LinkedList<Object> list = new LinkedList<>();
    list.add("Start");
    list.add(":");
    list.add("one");
    list.add(2);
    list.add("three");
    list.add(4);
    list.add("five");
    list.add(6);
    list.add("End");
    list.add("!");
    return list;
  }

  //общий метод для печати любого списка
  public static void printList(LinkedList<Object> list) {
    for (Object el : list) {
      System.out.printf(el + " ");
    }
  }

  //метод для преобразования списка
  public static void replaceList(LinkedList<Object> list) {
    int n = list.size() / 2;
    int m = list.size();
    
    for (int i = 0; i < n; i++) {
      Object temp = list.get(i);
      list.set(i, list.get(m - i - 1));
      list.set(m - i - 1, temp);
    }
  }

  public static void main(String[] args) {
    LinkedList<Object> listFirst = fillList();
    System.out.println("Исходный связанный список:");
    printList(listFirst); //запуск метода для печати исходного списка
    replaceList(listFirst); //запуск метода для переворачивания исходного списка
    System.out.println("\n");
    System.out.println("Перевернутый список:");
    printList(listFirst);//запуск метода для печати перевернутого списка
  }
}

// // ================ Решение для АВТОТЕСТА ===============================
// package Homework_4;

// import java.util.LinkedList;

// class LLTasks {
// public static void revertLL(LinkedList<Object> ll) {
// // Напишите свое решение ниже
// int size = ll.size();
// for (int i = 0; i < size / 2; i++) {
// Object temp = ll.get(i);
// ll.set(i, ll.get(size - i - 1));
// ll.set(size - i - 1, temp);
// }
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task1{
// public static void main(String[] args) {
// LinkedList<Object> ll = new LinkedList<>();

// if (args.length == 0 || args.length != 4) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// ll.add(1);
// ll.add("One");
// ll.add(2);
// ll.add("Two");
// } else {
// ll.add(Integer.parseInt(args[0]));
// ll.add(args[1]);
// ll.add(Integer.parseInt(args[2]));
// ll.add(args[3]);
// }
// LLTasks answer = new LLTasks();
// System.out.println(ll);
// answer.revertLL(ll);
// System.out.println(ll);
// }
// }
