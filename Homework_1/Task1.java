/*=================Задача 1. ======================
Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
(произведение чисел от 1 до n)
Вычислить n-ое треугольного число(сумма чисел от 1 до n).

Внутри класса Answer напишите метод countNTriangle, который принимает число n и возвращает его n-ое треугольное число.
Если число n < 1 (ненатуральное) метод должен вернуть -1.

Пример
n = 4 -> 10
n = 5 -> 15
 */

//==================Мое решение====================:

import java.util.Scanner;

public class Task1 {
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in, "ibm866");
    System.out.print("Enter n = "); 
    int n = scanner.nextInt();
    double tn = 0.5*n*(n+1);
    System.out.printf("n - ое треуголное число равно: %.1f \n", tn);
    double fn = factorial(n);
    System.out.printf("n! = %.1f \n", fn);
    scanner.close();
  }
  public static double factorial(int n) {
      if (n == 1) return 1;
      return n*factorial(n-1);
      
  }
} 


// // ================ Решение для АВТОТЕСТА ===============================
// public class Answer {
//   public int countNTriangle(int n){
//     // Введите свое решение ниже
//     int i = 0;
//     int countN_res = 0;
//     if (n < 1) {
//       System.out.println(-1);
//     } else {
//       while (i <= n){
//         countN_res += i;
//         i++;
//       }
//     }
//     return countN_res;
//   }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
// public class Task1 { // В автотестах данных класс называется Printer, 
//                     //но т.к. у меня файл называется Task1, 
//                     //то и класс с главным методом пришлось переименовать, 
//                     //иначе программа не запускалась.
//     public static void main(String[] args) { 
//       int n = 0;

//       if (args.length == 0) {
//         // При отправке кода на Выполнение, вы можете варьировать эти параметры
//         n = 4;
//       }
//       else{
//         n = Integer.parseInt(args[0]);
//       }     

//         // Вывод результата на экран
//       Answer ans = new Answer(); 
//       int itresume_res = ans.countNTriangle(n);     
//       System.out.println(itresume_res);
//     }
// }
