/*=================Задача 3======================
Сортировка массива с использованием кучи
Необходимо разработать программу для сортировки массива 
целых чисел с использованием сортировки кучей (Heap Sort). 
Программа должна работать следующим образом:

1. Принимать на вход массив целых чисел для сортировки. 
Если массив не предоставлен, программа использует массив по умолчанию.

2. Сначала выводить исходный массив на экран.

3. Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива 
в порядке возрастания.

4. Выводить отсортированный массив на экран.

Ваше решение должно содержать два основных метода: 
buildTree, который строит сортирующее дерево на основе массива, 
и heapSort, который выполняет собственно сортировку кучей.

Программа должна быть способной сортировать массив, 
даже если он состоит из отрицательных чисел и имеет дубликаты.

        На входе:
'5 8 12 3 6 9'

        На выходе:
Initial array:
[5, 8, 12, 3, 6, 9]
Sorted array:
[3, 5, 6, 8, 9, 12]
*/
package Homework_5;

//==================Решение====================:
public class Task3 {

  public static int LEFT(int i) {
    return (2 * i + 1);
  }

  public static int RIGHT(int i) {
    return (2 * i + 2);
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void heapify(int[] arr, int i, int size) {
    int left = LEFT(i);
    int right = RIGHT(i);

    int largest = i;

    if (left < size && arr[left] > arr[i]) {
      largest = left;
    }

    if (right < size && arr[right] > arr[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, largest, size);
    }
  }

  public static int pop(int[] arr, int size) {
    if (size <= 0) {
      return -1;
    }
    int top = arr[0];
    arr[0] = arr[size - 1];
    heapify(arr, 0, size - 1);

    return top;
  }

  public static void heapsort(int[] arr) {
    int n = arr.length;
    int i = (n - 2) / 2;
    while (i >= 0) {
      heapify(arr, i--, n);
    }

    while (n > 0) {
      arr[n - 1] = pop(arr, n);
      n--;
    }
  }

  public static void main(String[] args) {
    int[] listNum = new int[] { 5, 2, 3, 8, 10, 5, -1 };
    
    System.out.println("Исходный массив: ");
    for (int ish : listNum)
      System.out.printf("%d ", ish);
    System.out.println();

    System.out.println("Отсортированный массив: ");
    heapsort(listNum);
    for (int el : listNum)
      System.out.printf("%d ", el);
  }
}

// // ================ Решение для АВТОТЕСТА ===============================
// package Homework_5;

// import java.util.Arrays;

// class HeapSort {
// public static void buildTree(int[] tree, int sortLength) {
// // Для всех вершин дерева начиная с середины сортируемой части массива
// // (движемся влево до нулевого индекса)
// for (int i = sortLength / 2 - 1; i >= 0; i--) {
// int maxIndex;
// // Если у вершины два листа, выбираем больший
// if (i * 2 + 2 <= sortLength - 1) {
// if (tree[i * 2 + 2] > tree[i * 2 + 1]) maxIndex = i * 2 + 2;
// else maxIndex = i * 2 + 1;
// // Иначе один лист
// } else maxIndex = i * 2 + 1;
// // Сравниваем лист с максимальным значением с вершиной, при большем значении
// //дочернего элемента меняем его местами с вершиной
// if (tree[i] < tree[maxIndex]) {
// int temp = tree[i];
// tree[i] = tree[maxIndex];
// tree[maxIndex] = temp;
// }
// }
// }

// public static void heapSort(int[] sortArray, int sortLength) {
// // Выход из рекурсии: длина сортируемой части равна 0
// if (sortLength == 0) return;
// // Выстраивание элементов части массива в виде сортирующего дерева
// buildTree(sortArray, sortLength);
// // Замена местами первого и последнего элемента в сортируемой части
// int temp = sortArray[0];
// sortArray[0] = sortArray[sortLength - 1];
// sortArray[sortLength - 1] = temp;
// // Рекурсивно построение дерева и замена элементов для n - 1 элементов
// массива
// heapSort(sortArray, sortLength - 1);
// }
// }

// public class Task3 {
// public static void main(String[] args) {
// int[] initArray;

// if (args.length == 0) {
// initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
// } else {
// initArray = Arrays.stream(args[0].split("
// ")).mapToInt(Integer::parseInt).toArray();
// }

// System.out.println("Initial array:");
// System.out.println(Arrays.toString(initArray));
// HeapSort.heapSort(initArray, initArray.length);
// System.out.println("Sorted array:");
// System.out.println(Arrays.toString(initArray));
// }
// }
