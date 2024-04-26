/*=================Задача 3. ======================
В калькулятор добавьте возможность отменить последнюю операцию.
 */
package Homework_4;

import java.util.ArrayDeque;
import java.util.Deque;

class Calculator {
  public Deque<Double> resultsStack = new ArrayDeque<>();
  public double prevResult;

//Модуль для отмены крайней операции, если вводим знак '<'
  public double calculate(char op, int a, int b) {
    if (op == '<') {
      if (resultsStack.size() >= 2) {
        resultsStack.pop();
        prevResult = resultsStack.peek();
      }
      return prevResult;
    } else {
      double result = performOperation(op, a, b);
      resultsStack.push(result);
      prevResult = result;
      return result;
    }
  }
  
  private double performOperation(char op, int a, int b) {
    double result = 0;
    switch (op) {
      case '+':
        result = add(a, b);
        break;
      case '-':
        result = minus(a, b);
        break;
      case '*':
        result = mult(a, b);
        break;
      case '/':
        result = divide(a, b);
        break;
    }
    return result;
  }
  
  private double divide(int a, int b) {
    if (b != 0)
      return (double) a / b;
    return -1;
  }
  
  private int mult(int a, int b) {
    return a * b;
  }
  private int minus(int a, int b) {
    return a - b;
  }
  
  private int add(int a, int b) {
    return a + b;
  }
}

public class Task3 {
  public static void main(String[] args) {
    int a, b, c, d;
    char op, op2, undo;
    
    if (args.length == 0) {
      a = 3;
      op = '+';
      b = 7;
      c = 4;
      op2 = '+';
      d = 7;
      undo = '<';
    } else {
      a = Integer.parseInt(args[0]);
      op = args[1].charAt(0);
      b = Integer.parseInt(args[2]);
      c = Integer.parseInt(args[3]);
      op2 = args[4].charAt(0);
      d = Integer.parseInt(args[5]);
      undo = args[6].charAt(0);
    }
    
    // Ниже добавить проверку оператора на корректность
    if (op != '+' && op != '-' && op != '*' && op != '/') {
      System.out.println("Некорректный оператор: " + op);
      return;
    }
    
    Calculator calculator = new Calculator();
    double result = calculator.calculate(op, a, b);
    System.out.println(result);
    double result2 = calculator.calculate(op2, c, d);
    System.out.println(result2);
    double prevResult = calculator.calculate(undo, 0, 0);
    System.out.println(prevResult);
  }
}
