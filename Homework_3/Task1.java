/*---------------------Задача 1-------------------------
Реализовать алгоритм сортировки слиянием
*/
//==================Решение 1====================:
public class Task1 {
  public static void main(String[] args) {
    int[] array = new int[10];
    array = FillRandomArray(10);

    System.out.println("Исходный случайный массив: ");
    for (int element : array) {
      System.out.printf("%d ", element);
    }

    mergeSort(array, 10);
    System.out.println();
    System.out.println("Отсортированный массив: ");
    for (int element : array) {
      System.out.printf("%d ", element);
    }

  }

  // Метод для формирования рандомного массива чисел типа int
  public static int[] FillRandomArray(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = ((int) (Math.random() * 20));
    }
    return arr;
  }

  public static void mergeSort(int[] arr, int n) {
    if (n < 2)
      return;
    int mid = n / 2;
    int[] leftArr = new int[mid];
    int[] rightArr = new int[n - mid];
    System.arraycopy(arr, 0, leftArr, 0, mid);
    System.arraycopy(arr, mid, rightArr, 0, n - mid);
    mergeSort(leftArr, mid);
    mergeSort(rightArr, n - mid);
    merge(arr, leftArr, rightArr, mid, n - mid);
  }

  public static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftLength, int rightLength) {
    int k = 0, i = 0, j = 0;
    while (i < leftLength && j < rightLength) {
      if (leftArr[i] <= rightArr[j])
        arr[k++] = leftArr[i++];
      else
        arr[k++] = rightArr[j++];
    }
    while (i < leftLength) {
      arr[k++] = leftArr[i++];
    }
    while (j < rightLength) {
      arr[k++] = rightArr[j++];
    }
  }
}

// //==================Решение 2, не мое====================:
// /* Основная идея — разделение неотсортированного массива на две части и
// сортировка
// отдельных половинок по рекурсивному принципу.

// Исходный массив заздадим при помощи генерации, количесво элементов
// запрашиваем у пользователя.
// */
// import java.util.ArrayList;
// import java.util.Random;
// import java.util.Scanner;
// import java.util.logging.Logger;

// public class Task1 {
// // максимальная граница генерируемых значений
// private static final int MAX_NUM = 100;
// private static int arraySize;

// public static void main(String[] args) {
// clearScreen();

// arraySize = readIntConsole("Размерность массива: ");
// ArrayList<Integer> array = new ArrayList<>(arraySize);
// Random random = new Random();

// // формирование массива
// for (int i = 0; i < arraySize; i++) {
// array.add(random.nextInt(MAX_NUM));
// }

// Logger logger = Logger.getAnonymousLogger();
// logger.info(array.toString());
// logger.info(mergeSort(array).toString());
// }

// // алгоритм сортировки
// public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
// int partArraySize = arraySize / 2 - 1;
// sortPart(array, 0, partArraySize);
// sortPart(array, partArraySize + 1, array.size() - 1);

// unionParts(array, 0, array.size() - 1, partArraySize);
// return array;
// }

// public static ArrayList<Integer> sortPart(ArrayList<Integer> arrayList, int
// start, int end) {
// int sizePart = end - start;

// if (sizePart > 1) { // полученная часть массива - делим дальше
// int halfSize = (end - start) / 2;
// int halfPos = start + halfSize;

// // todo: Здесь можно сделать проверку на величину полученной части массива
// // для исключения вызова сортировки из одного элемента.
// // Есть ? эффективности, проверка будет в каждом вызове рекурсии,
// // вызов для единичного элемента только в определенных случаях.
// sortPart(arrayList, start, halfPos);
// sortPart(arrayList, halfPos + 1, end);

// unionParts(arrayList, start, end, halfPos);

// } else if (sizePart == 1) { // можем сравнить (имееем два элемента), если
// передан один - он уже отсортирован
// if (arrayList.get(start) > arrayList.get(end)) {
// swapArr(arrayList, start, end);
// }
// }
// return arrayList;
// }

// //
// private static ArrayList<Integer> unionParts(ArrayList<Integer> array, int
// start, int end, int half) {
// int i = start;
// int j = half + 1;

// ArrayList<Integer> tmp = new ArrayList<>();
// // объединение отсортированных частей
// while (i <= half && j <= end) {
// if (array.get(i) < array.get(j)) {
// tmp.add(array.get(i));
// i++;
// } else {
// tmp.add(array.get(j));
// j++;
// }
// }
// // дописывание "остатков", если есть - сработает только 1 из циклов
// while (i <= half) {
// tmp.add(array.get(i));
// i++;
// }
// while (j <= end) {
// tmp.add(array.get(j));
// j++;
// }
// // замена на сортированный кусок
// for (int k = 0; k < tmp.size(); k++) {
// array.set(start + k, tmp.get(k));
// }

// return array;
// }

// // обмен элементов массива
// private static ArrayList<Integer> swapArr(ArrayList<Integer> array, int
// firstPos, int secondPos) {
// int tmp = array.get(firstPos);
// array.set(firstPos, array.get(secondPos));
// array.set(secondPos, tmp);

// return array;
// }

// // очистка терминала
// public static void clearScreen() {
// System.out.print("\033[H\033[2J");
// System.out.flush();
// }

// // получение целочисленного значения с консоли
// public static int readIntConsole(String message) {
// System.out.print(message);
// Scanner scanner = new Scanner(System.in);

// return scanner.nextInt();
// }
// }

// // ================ Решение для АВТОТЕСТА ===============================
// import java.util.Arrays;

// class MergeSort {
// public static int[] mergeSort(int[] a) {
// // Напишите свое решение ниже
// int n = a.length;
// if (n < 2) {
// return a;
// }
// int mid = n / 2;
// int[] l = new int[mid];
// int[] r = new int[n - mid];

// for (int i = 0; i < mid; i++) {
// l[i] = a[i];
// }
// for (int i = mid; i < n; i++) {
// r[i - mid] = a[i];
// }
// l = mergeSort(l);
// r = mergeSort(r);

// return merge(l, r);
// }
// public static int[] merge(int[] l, int[] r) {
// int left = l.length;
// int right = r.length;
// int[] a = new int[left + right];
// int i = 0, j = 0, k = 0;

// while (i < left && j < right) {
// if (l[i] <= r[j]) {
// a[k++] = l[i++];
// }
// else {
// a[k++] = r[j++];
// }
// }
// while (i < left) {
// a[k++] = l[i++];
// }
// while (j < right) {
// a[k++] = r[j++];
// }

// return a;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task1{
// public static void main(String[] args) {
// int[] a;

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// a = new int[]{5, 1, 6, 2, 3, 4};
// } else {
// a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
// }

// MergeSort answer = new MergeSort();
// String itresume_res = Arrays.toString(answer.mergeSort(a));
// System.out.println(itresume_res);
// }
// }