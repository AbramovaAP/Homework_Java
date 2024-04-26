
/*
---------------------Задача 3-------------------------
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из
этого списка.
 */
//==================Решение 1====================:
import java.util.ArrayList;

public class Task3 {
  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<>();
    array = FillRandomArray(10);

    System.out.println("Исходный случайный массив: ");
    for (int element : array) {
      System.out.printf("%d ", element);
    }
    System.out.println("\n");
    
    int maxElement = findMax(array);
    int minElement = findMin(array);
    Double avgElement = findAvg(array);
    System.out.printf("Максимальный элемент: %d \n", maxElement);
    System.out.printf("Минимальный элемент: %d \n", minElement);
    System.out.printf("Среднее арифметическое: %.1f \n", avgElement);

  }

  // метод для заполнения списка случайными целыми числами
  public static ArrayList<Integer> FillRandomArray(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add((int) (Math.random() * 100));
    }
    return list;
  }

  // метод для поиска максимального элемента
  public static int findMax(ArrayList<Integer> arr) {
    int max = arr.get(0);
    for (int element : arr) {
      if (element > max)
        max = element;
    }
    return max;
  }

  // метод для поиска минимального элемента
  public static int findMin(ArrayList<Integer> arr) {
    int min = arr.get(0);
    for (int element : arr) {
      if (element < min)
        min = element;
    }
    return min;
  }

  // метод для поиска ср.арифм. значения из всего списка элементов
  public static Double findAvg(ArrayList<Integer> arr) {
    int sum = 0;
    for (int element : arr) {
      sum += element;
    }
    Double avg = Double.valueOf(sum) / Double.valueOf(arr.size());
    return avg;
  }
}

// // ================ Решение для АВТОТЕСТА ===============================
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Collections;

// class Answer {
// public static void analyzeNumbers(Integer[] arr) {
// // Введите свое решение ниже
// ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(arr));
// Collections.sort(nums); // сортировка списка по возрастанию
// System.out.println(nums); // вывод списка на экран
// System.out.println("Minimum is " + nums.get(0)); // нахождение минимального
// значения в списке и вывод на экран
// System.out.println("Maximum is " + nums.get(nums.size()-1)); // нахождение
// максимального значения в списке и вывод на экран

// int sum = 0;
// for(int i : nums){ // вычисление суммы всех элементов списка
// sum += i;
// }
// System.out.println("Average is = " + (double) sum / nums.size()); //
// вычисление среднего арифметического значений списка и вывод на экран
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task3{
// public static void main(String[] args) {
// Integer[] arr = {};

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
// }
// else{
// arr = Arrays.stream(args[0].split(", "))
// .map(Integer::parseInt)
// .toArray(Integer[]::new);
// }

// Answer ans = new Answer();
// ans.analyzeNumbers(arr);
// }
// }