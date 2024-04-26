/*---------------------Задача 2-------------------------
Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

//==================Решение 1====================:

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        array = FillRandomArray(10);

        System.out.println("Исходный случайный массив: ");
        for (int element : array) {
            System.out.printf("%d ", element);
        }

        // ArrayList<Integer> arraySort = new ArrayList<>();
        DeleteEvenNumber(array);
        System.out.println();
        System.out.println("Массив без четных чисел: ");
        for (int element : array) {
            System.out.printf("%d ", element);
        }

    }

    // Метод для формирования рандомного массива чисел
    public static ArrayList<Integer> FillRandomArray(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add((int) (Math.random() * 100)); // числа будут в массиве в диапазоне от 0 до 100
        }
        return arr;
    }

    public static void DeleteEvenNumber(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0)
                list.remove(i);// удалить элемент
            else
                i++;
        }
    }
}

// // ================ Решение для АВТОТЕСТА ===============================
// import java.util.Arrays;
// import java.util.ArrayList;

// class Answer {
// public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
// // Введите свое решение ниже

// ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(arr));
// for (int i = 0; i < nums.size(); i++) {
// if (nums.get(i) % 2 == 0) {
// nums.remove(i);
// i--;
// }
// }
// return nums;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task2{
// public static void main(String[] args) {
// Integer[] arr = {};

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// arr = new Integer[]{2, 4, 6, 8};
// }
// else{
// arr = Arrays.stream(args[0].split(", "))
// .map(Integer::parseInt)
// .toArray(Integer[]::new);
// }

// Answer ans = new Answer();
// ArrayList<Integer> nums = ans.removeEvenNumbers(arr);
// System.out.println(nums);
// }
// }