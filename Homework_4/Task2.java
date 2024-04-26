/*=================Задача 2======================
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент
из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
 */
//==================Решение 1====================:
package Homework_4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {

    // Заполняем список элементами вручную
    public static Deque<Object> fillList() {
        Deque<Object> list = new LinkedList<>();
        list.add("Start");
        list.add(":");
        list.add("one");
        list.add(2);
        list.add("End");
        return list;
    }

    // общий метод для печати любого списка, чтобы не повторять этот блок постоянно
    public static void printList(Deque<Object> list) {
        for (Object el : list) {
            System.out.printf(el + " ");
        }
        System.out.println();
    }

    // метод, который добавляет элемент в конец списка
    public static void enqueue(Deque<Object> list) {
        System.out.println("Введите элемент, который надо добавить: ");
        Scanner sc1 = new Scanner(System.in);
        Object element = sc1.nextLine();
        list.addLast(element);
        // sc1.close(); // если закроем, то не сможем добвлять новые элементы в список
    }

    // метод для удаления первого элемента в списке
    public static Object dequeue(Deque<Object> list) {
        Object item = list.pollFirst();
        return item;
    }

    // метод, который вернет первый элемент списка
    public static Object first(Deque<Object> list) {
        return list.peekFirst();
    }

    // метод для вывода списка возможный операций
    public static void listNumber(String[] args) {
        System.out.println(
                "Введите номер операции: \n1 - поместить элемент в конец очереди; \n2 - вернуть первый элемент из очереди и удалить его; \n3 - вернуть первый элемент из очереди, не удаляя; \n4 - завершение работы");
    }

    // Метод для запуска встроенных методов по соответствующей команде
    public static void main(String[] args) {
        Deque<Object> que = new LinkedList<>();
        que = fillList();
        System.out.println("Исходный список: ");
        printList(que);
        System.out.println();
        listNumber(args);

        while (true) {
            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) { // команда 1 - поместить элемент в конец очереди;
                enqueue(que);
                System.out.println("Измененный список: ");
                printList(que);
                System.out.println();
                listNumber(args); // повторно выводим список всех операций, для наглядности
                continue;
            }
            if (cmd == 2) { // команда 2 - вернуть первый элемент из очереди и удалить его;
                System.out.println("Первый элемент: " + dequeue(que));
                System.out.println("Измененный список, без первого элемента: ");
                printList(que); // печать списка без первого элемента
                System.out.println();
                listNumber(args); // повторно выводим список всех операций, для наглядности
                continue;
            }
            if (cmd == 3) { // команда 3 - вернуть первый элемент из очереди, НЕ удаляя;
                System.out.println("Первым элементом был: " + first(que));
                System.out.println("Список остался без изменений: ");
                printList(que);
                System.out.println();
                listNumber(args); // повторно выводим список всех операций, для наглядности
                continue;
            }
            if (cmd == 4) // команда 4 - завершение работы
                break;
            else {
                System.out.println("Для выхода из программы введите 4");
            }
            sc.close(); // закрываем считывание операций
        }

    }

}

// // ================ Решение для АВТОТЕСТА ===============================
// package Homework_4;

// import java.util.LinkedList;

// class MyQueueInt {
// // Напишите свое решение ниже
// private LinkedList<Integer> elements = new LinkedList<>();

// public void enqueue(int element){
// // Напишите свое решение ниже
// elements.add(element);
// }

// public int dequeue(){
// // Напишите свое решение ниже
// return elements.removeFirst();
// }

// public int first(){
// // Напишите свое решение ниже
// return elements.getFirst();
// }

// public LinkedList<Integer> getElements() {
// // Напишите свое решение ниже
// return elements;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task2 {
// public static void main(String[] args) {
// MyQueueInt queue;
// queue = new MyQueueInt();

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// queue.enqueue(1);
// queue.enqueue(10);
// queue.enqueue(15);
// queue.enqueue(5);
// } else {
// queue.enqueue(Integer.parseInt(args[0]));
// queue.enqueue(Integer.parseInt(args[1]));
// queue.enqueue(Integer.parseInt(args[2]));
// queue.enqueue(Integer.parseInt(args[3]));
// }

// System.out.println(queue.getElements());

// queue.dequeue();
// queue.dequeue();
// System.out.println(queue.getElements());

// System.out.println(queue.first());
// }
// }
