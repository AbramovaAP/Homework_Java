
/*---------------------Задача 3_ДОПОЛНИТЕЛЬНАЯ-------------------------
Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"
Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент
[фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
import java.io.*;

public class Task3_dop {

    // Метод №1 - для считывания данных с файла и сохранение данных во временый
    // буфер, для дальнейшего изъятия
    public static String[] ReadLineFromFile(String pathway) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(pathway));
        String str;
        int size = 0;
        while ((str = br.readLine()) != null) {
            size += 1;
        }
        br.close();
        String[] listData = new String[size];

        int i = 0;
        BufferedReader br1 = new BufferedReader(new FileReader(pathway));
        while ((str = br1.readLine()) != null) {
            listData[i] = str;
            i += 1;
        }
        br1.close();
        return listData;
    }

    // Метод №2 - для чтения конкретного файла и вывода
    public static void main(String[] args) throws Exception {
        String[] list = ReadLineFromFile("dataForTask3.txt"); // запускаем метод №1 -
                                        // для того, чтобы прочитать файл "dataForTask3.txt".

        // вывод данных с файла - для самопроверки, правильно ли указан файл и считаны данные:
        // System.out.println("В файле имеется след информация:");
        // System.out.println(list[0]);
        // System.out.println(list[1]);
        // System.out.println(list[2]);
        StringBuilder resultSelect_0 = PrintLine(list[0]);
        StringBuilder resultSelect_1 = resultSelect_0.append(PrintLine(list[1]));
        StringBuilder resultSelect_2 = resultSelect_1.append(PrintLine(list[2]));
        System.out.println(resultSelect_2);
    }

    // //Вместо методов №1 и №2 можно использовать файл lib.java, в котором имеется
    // метод для считывания строк с любых файлов:
    // public static void main(String[] args) throws Exception {
    // String[] arrayData = lib.ReadLineFromFile("dataForTask3.txt"); //Задаем
    // конкретный файл для чтения
    // for (int i = 0; i < arrayData.length; i++) {
    // System.out.println(PrintLine(arrayData[i]));
    // }

    // }

    public static StringBuilder PrintLine(String line) {
        // Удаляем ненужные символы из текста
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", ""); // удаляет ковычки
        String line4 = line3.replace("[", "");
        String line5 = line4.replace("]", "");

        StringBuilder result = new StringBuilder("");
        String[] arrayData = line5.split(",");
        String[] listName = { "Студент ", " получил ", " по предмету " };
        result.append('\n'); // УБРАТЬ!, если используется файл lib.java вместо методов №1 и №2
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            result.append(listName[i]);
            result.append(arrData[1]);
        }
        return result;
    }
}