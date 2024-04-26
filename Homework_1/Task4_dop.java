
/**================Задача 4====================
* Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры
могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется
восстановить выражение до верного равенства. Предложить хотя бы
одно решение или сообщить, что его нет. 
*/
import java.util.Scanner;

public class Task4_dop {
    public static void main(String[] args) {
        // 1. Задаем переменные, которые будут хранить значения левой и правой части
        // уравнения и результат соответственно:
        int q = -1, w = -1, e = -1;

        // 2. Считать входные данные с помощью класса Scanner, разбив строку на три
        // части(чтобы получилось 3 строки) используя метод split
        Scanner scanner = new Scanner(System.in, "ibm866");
        System.out.println("Введите уравнение вида q + w = e: ");
        String equation = scanner.nextLine();
        String[] parts = equation.split("\s*[+=]\s*");// разделяем строку 1 -> до +; 2 -> от + до =; 3 -> после =. И
                                                      // записываем в строковый массив из 3-х элементов
        scanner.close();

        // 3. Для каждой из трех строк нужно пройти цикл от 0 до 9 и проверять, какое
        // значение соответствует знаку вопроса.
        // В случае нахождения соответствия знаку вопроса на нужной позиции, присвоить
        // соответствующую цифру.
        // Значение нуля тоже считаем допустимым.
        for (int i = 0; i < 10; i++) { // перебираем все числа от 0 до 9
            if (q == -1 && !parts[0].contains("?")) {
                q = Integer.parseInt(parts[0]);
            }
            if (w == -1 && !parts[1].contains("?")) {
                w = Integer.parseInt(parts[1]);
            }
            if (e == -1 && !parts[2].contains("?")) {
                e = Integer.parseInt(parts[2]);
            }
            // если нашли знак ? на нужной позиции
            if (parts[0].charAt(i) == '?') {
                q = i;
            }
            if (parts[1].charAt(i) == '?') {
                w = i;
            }
            if (parts[2].charAt(i) == '?') {
                e = i;
            }
        }

        // 4. После выполнения второго шага, проверяем равенство левой и правой частей
        // уравнения для найденных значений q, w, e.
        // Если равенство выполняется, выводим полученное значение на экран (либо
        // сохраняем в файл, если это требуется).

        if (q + w == e && q != -1 && w != -1 && e != -1) {
            System.out.printf("%d + %d = %d", q, w, e);
        } else {// Если уравнение не имеет решения, (н-р, "2? + ?5 = 70"), то будет выведено
                // сообщение "Решений нет"
            System.out.println("Решений нет!");
        }
        // 5. после запуск программы и вывода уравнения: "2? + ?5 = 69" получим "24 + 45
        // = 69".
    }
}

// //Решение другого человека
// import java.util.Scanner;

// public class Task4_dop {
// public static void main(String[] args) {

// clearScreen();

// String q = readStrConsole("Введите q?: ");
// String w = readStrConsole("Введите ?w: ");
// String e = readStrConsole("Введите e: ");

// String result = "";

// // Проверить длину введенных значениий.
// // Например, если среди слагаемых есть трехзначное число, а результат -
// // двузначное,
// // имеем неверное выражение
// if (q.length() > e.length() || w.length() > e.length()) {
// result = "Неверное выражение";
// } else {
// // разложение чисел на разряды
// // + дополнительный разряд, на случай переполнения при расчетах
// int[] qr = digToArray(q, e.length() + 1);
// int[] wr = digToArray(w, e.length() + 1);
// int[] er = digToArray(e, e.length() + 1);

// // поиск неизвестных
// for (int i = er.length - 1; i > 0; i--) {
// int d = qr[i] < 0 ? wr[i] : qr[i];
// if (er[i] >= d) {
// if (qr[i] < 0)
// qr[i] = er[i] - d;
// if (wr[i] < 0)
// wr[i] = er[i] - d;
// } else {
// er[i - 1]--;
// er[i] += 10;

// if (qr[i] < 0)
// qr[i] = er[i] - d;
// if (wr[i] < 0)
// wr[i] = er[i] - d;
// }
// }

// // собираем ответ проверяем решение
// int Q = arrayToDig(qr);
// int W = arrayToDig(wr);
// int E = Integer.parseInt(e);

// if ((Q + W) == E) {
// StringBuffer sb = new StringBuffer();
// sb.append(Q);
// sb.append(" + ");
// sb.append(W);
// sb.append(" = ");
// sb.append(E);

// result = sb.toString();
// } else {
// result = "решение не найдено";
// }

// }

// System.out.println(result);
// }

// public static int arrayToDig(int[] arr) {
// int result = 0;
// int mult = 1;

// for (int i = arr.length - 1; i >= 0; i--) {
// result += arr[i] * mult;
// mult *= 10;
// }
// return result;
// }

// // получение поразрядного представления числа
// // (? заменяем на -1, т.к. в выражение ищем только для положительных чисел)
// public static int[] digToArray(String dig, int lenArr) {
// int[] arr = new int[lenArr];
// char[] strk = dig.toCharArray();

// int posStr = strk.length - 1;
// int posArr = lenArr - 1;

// while (posStr >= 0) {
// if (Character.isDigit(strk[posStr])) {
// arr[posArr] = Integer.parseInt(String.valueOf(strk[posStr]));
// } else {
// arr[posArr] = -1;
// }
// posArr--;
// posStr--;
// }

// return arr;
// }

// // очистка терминала
// public static void clearScreen() {
// System.out.print("\033[H\033[2J");
// System.out.flush();
// }

// // получение строкового значения с консоли
// public static String readStrConsole(String message) {
// System.out.print(message);
// Scanner scanner = new Scanner(System.in);
// String result = scanner.nextLine();
// scanner.close();
// return result;
// }
// }