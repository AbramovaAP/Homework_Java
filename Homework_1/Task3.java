
/*================Задача 3====================
Реализуйте простой калькулятор

В методе calculate класса Calculator реализовать калькулятор, 
который будет выполнять математические операции (+, -, *, /) 
над двумя целыми числами и возвращать результат вещественного типа.

В классе Printer необходимо реализовать проверку переданного оператора, 
при некорректном операторе программа должна вывести сообщение об ошибке 
"Некорректный оператор: 'оператор'".

Аргументы, передаваемые в метод/функцию:
'3'
'+'
'7'

На выходе:
10.0
 */
//==================Мое решение====================:
import java.util.Scanner;

public class Task3 {
  public static void main(String[] args) {
    //Считываем данные, два числа и опепратор:
    Scanner iScanner = new Scanner(System.in);
    Scanner oScanner = new Scanner(System.in);
    System.out.println("Введите первое число: ");
    double x = iScanner.nextDouble();
    System.out.println("Введите второе число: ");
    double y = iScanner.nextDouble();
    System.out.println("Введите оперцию (+, -, *, /):");
    String operate = oScanner.nextLine();
    iScanner.close();
    oScanner.close();

    boolean corect = true;
    double res = 0;
    switch (operate) {
      case "+":
        res = x + y;
        break;
      case "-":
        res = x - y;
        break;
      case "*":
        res = x * y;
        break;
      case "/":
        if (y != 0)
          res = x / y;
        else {
          System.out.println("На ноль делить нельзя");
          corect = false;
        }
        break;
      default:
        System.out.println("Такой операции нет");
        break;
    }
    if (corect) {
      System.out.printf("%.2f %s %.2f = %.2f", x, operate, y, res);
    }
  }
}

// // ================ Решение для АВТОТЕСТА ===============================
// class Calculator {
// public double calculate(char op, double a, double b) {
// // Введите свое решение ниже
// double result = 0;
// if (op == '+'){
// result = a + b;
// }
// if (op == '-'){
// result = a - b;
// }
// if (op == '*'){
// result = a * b;
// }
// if (op == '/'){
// result = a / b;
// }
// return result;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task3{
// public static void main(String[] args) {
// double a = 0;
// char op = ' ';
// double b = 0;

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// a = 5;
// op = '*';
// b = 48.5;
// } else {
// a = Integer.parseInt(args[0]);
// op = args[1].charAt(0);
// b = Integer.parseInt(args[2]);
// }

// Calculator calculator = new Calculator();
// double result = calculator.calculate(op, a, b);
// System.out.println(result);
// }
// }