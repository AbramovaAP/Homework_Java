/*
---------------------Задача 2-------------------------
Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации
запишите в лог-файл.
 */

//==================Мое решение====================:
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class Task2 {
    private static Logger logger = Logger.getLogger(Task2.class.getName());

    public static void main(String[] args) throws IOException {
        clearScreen();

        // Запись каждой итерации в лог-файл:
        FileHandler fh = new FileHandler("logTask2.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        
        //Узнаем размерность массива: 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Размерность массива: ");
        int sizeArray = scanner.nextInt();

        int[] numArray = new int[sizeArray]; //Новый массив чисел будет иметь размерность sizeArray
        //Заполняем массив случайными числами:
        Random random = new Random();
        // верхняя граница значений массива
        int MAX_NUMBER = 100;
        for (int i = 0; i < sizeArray; i++) {
            numArray[i] = random.nextInt(MAX_NUMBER);
        }

        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(numArray));

        numArray = bubbleSort(numArray); // перезаписываем в переменную numArray новые данные, которые получили при отсортировки исходного массива

        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(numArray));

        scanner.close();

    }

// Метод для сортировки исходного массива
    public static int[] bubbleSort(int[] array) {

        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    logger.info(Arrays.toString(array));
                }
            }
        }
        return array;
    }

// Метод для отчистки терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

// // ================ Решение для АВТОТЕСТА ===============================
// import java.io.File;
// import java.io.FileWriter;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.util.Arrays;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// class BubbleSort {
// private static File log;
// private static FileWriter fileWriter;

// public static String logger() {
// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
// String formattedDate = dateFormat.format(new Date());
// return formattedDate;
// }

// public static void sort(int[] mas) {
// try {
// log = new File("log.txt");
// fileWriter = new FileWriter(log);
// boolean swapped;
// for (int i = 0; i < mas.length; i++) {
// swapped = false;
// for (int j = 0; j < mas.length - 1 - i; j++) {
// if (mas[j] > mas[j + 1]) {
// int temp = mas[j];
// mas[j] = mas[j + 1];
// mas[j + 1] = temp;
// swapped = true;
// }
// }
// if (swapped == false)
// break;
// fileWriter.write(logger() + " " + Arrays.toString(mas));
// fileWriter.write(System.lineSeparator());

// }
// fileWriter.write(logger() + " " + Arrays.toString(mas));
// fileWriter.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task2{
// public static void main(String[] args) {
// int[] arr = {};

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// arr = new int[]{9, 4, 8, 3, 1};
// }
// else{
// arr = Arrays.stream(args[0].split(", "))
// .mapToInt(Integer::parseInt)
// .toArray();
// }

// BubbleSort ans = new BubbleSort();
// ans.sort(arr);

// try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
// String line;
// while ((line = br.readLine()) != null) {
// System.out.println(line);
// }
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }

// // Реализуйте алгоритм сортировки пузырьком числового массива, результат
// после каждой итерации запишите в лог-файл.
// import java.io.IOException;
// import java.util.logging.*;
// public class Task2 {
// public static void main(String[] args) throws IOException {
// Logger logger = Logger.getLogger(Task2.class.getName());
// FileHandler fh = new FileHandler("logTask2.xml");
// logger.addHandler(fh);
// XMLFormatter xml = new XMLFormatter();
// fh.setFormatter(xml);
// logger.info("Sort Array");
// int [] array = {2, 5, 1, -7, 3, 64, 0};
// lib.printArrayInt(array);
// int[] newArr = listSort(array);
// System.out.printf("\n Отсортированный массив: \n");
// lib.printArrayInt(newArr);
// }
// public static int[] listSort(int [] arr){
// for(int k = 0; k < arr.length-1; k++) {

// for (int i = 0; i < arr.length - k-1; i++){
// if (arr[i] > arr[i+1]) {
// int temp = arr[i];
// arr[i] = arr[i+1];
// arr[i+1] = temp;
// }
// }
// }
// return arr;
// }

// }