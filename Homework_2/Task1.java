/*
---------------------Задача 1-------------------------
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

//==================Мое решение====================:
import java.io.*;

public class Task1 {

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

    public static void main(String[] args) throws Exception {
        String[] list = ReadLineFromFile("dataForTask1.txt");
        // вывод данных с файла
        System.out.println("В файле имеется след информация:");
        System.out.println(list[0]);
        StringBuilder resultSelect = LineInList(list[0]);
        System.out.println(resultSelect);
    }

    public static StringBuilder LineInList(String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", ""); // \" - убираем ковычки
        System.out.println(line3);
        System.out.println("Полная строка запроса с частью WHERE:");
        StringBuilder result = new StringBuilder("select * from students where "); // "select * from students where " - начало запроса
        

        String[] arrayData = line3.split(", "); //отделить элементы массива запятой
        //Формирование части WHERE:
        // Из записи:        name:Ivanov, country:Russia, city:Moscow, age:null
        //Формируем запись:  name = Ivanov, country = Russia, city = Moscow - это будет концом запроса
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if (arrData[1].equals("null") == false) {
                if (i != 0) {
                    result.append(", ");
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                } else {
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                }
            }

        }
        return result;
    }
}

// // ================ Решение для АВТОТЕСТА ===============================
// class Answer {
// public static StringBuilder answer(String QUERY, String PARAMS){
// // Напишите свое решение ниже
// String paramsNew = PARAMS.replace('{',' ').replace('}', ' ');
// String[] params = paramsNew.split(",");
// StringBuilder stringBuilder = new StringBuilder(QUERY);

// for (int i = 0; i < params.length; i++){
// String[] elements = params[i].replace('"', ' ').split(":");
// if(!"null".equals(elements[1].trim())){
// stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
// if (i < params.length - 2) {stringBuilder.append(" and ");}
// }
// }
// return stringBuilder;
// }
// }

// // Не удаляйте этот класс - он нужен для вывода результатов на экран и
// проверки
// public class Task1{
// public static void main(String[] args) {
// String QUERY = "";
// String PARAMS = "";

// if (args.length == 0) {
// // При отправке кода на Выполнение, вы можете варьировать эти параметры
// QUERY = "select * from students where ";
// PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\",
// \"age\":\"null\"} ";
// }
// else{
// QUERY = args[0];
// PARAMS = args[1];
// }

// Answer ans = new Answer();
// System.out.println(ans.answer(QUERY, PARAMS));
// }
// }