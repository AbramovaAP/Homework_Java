# Домашние работы по курсу - Java: знакомство и как пользоваться базовым API

<details>
<summary>Homework_1</summary>


+ <details>
    <summary>Task1</summary>

    Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
    (произведение чисел от 1 до n)
    Вычислить n-ое треугольного число(сумма чисел от 1 до n).

    Внутри класса Answer напишите метод countNTriangle, который принимает число n и возвращает его n-ое треугольное число.
    Если число n < 1 (ненатуральное) метод должен вернуть -1.

    Пример
    n = 4 -> 10
    n = 5 -> 15
    </details>

+ <details>
    <summary>Task2</summary>

    Вывести все простые числа от 1 до 1000
    Напишите функцию printPrimeNums, которая выведет на экран все простые числа 
    в промежутке от 1 до 1000, каждое на новой строке.

    Напишите свой код в методе printPrimeNums класса Answer.    
    Пример:    
    2    
    3    
    5    
    7    
    11    
    ...

    Простое число, это число, которое делится на 1 на само себя!  
    Простые числа: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 34, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97...
    </details>

+ <details>
    <summary>Task3</summary>

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

    На выходе: 10.0
    </details>

+ <details>
    <summary>Task4</summary>

    Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры
    могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется
    восстановить выражение до верного равенства. Предложить хотя бы
    одно решение или сообщить, что его нет.
</details>



<details>
<summary>Homework_2</summary>


+ <details>
    <summary>Task1</summary>

    Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    </details>

+ <details>
    <summary>Task2</summary>

    Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    </details>

+ <details>
    <summary>Task3</summary>

    Дана json строка (можно сохранить в файл и читать из файла)
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"
    Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

    Пример вывода:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
    </details>

+ <details>
    <summary>Task4</summary>

    К калькулятору из предыдущего дз добавить логирование.
    На вход поолучаем строку с простыой операцией,
    между цифровыми значениями и знаком операции должен быть пробел.
    Считаем введенные данные валидными, проверку верности данных и
    математическое соответствие не проводим

</details>



<details>
<summary>Homework_3</summary>


+ <details>
    <summary>Task1</summary>

    Реализовать алгоритм сортировки слиянием
    </details>

+ <details>
    <summary>Task2</summary>

    Пусть дан произвольный список целых чисел, удалить из него четные числа
    </details>

+ <details>
    <summary>Task3</summary>

    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

</details>



<details>
<summary>Homework_4</summary>


+ <details>
    <summary>Task1</summary>

    Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    </details>

+ <details>
    <summary>Task2</summary>

    Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
    </details>

+ <details>
    <summary>Task3</summary>

    В калькулятор добавьте возможность отменить последнюю операцию.

</details>



<details>
<summary>Homework_5</summary>

+ <details>
    <summary>Task1</summary>

    Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:

    add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
    Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
    Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

    find(String name): Поиск номеров телефона по имени в телефонной книге.
    Если запись с именем name существует, возвращает список номеров телефона для этой записи.
    Если запись с именем name не существует, возвращает пустой список.

    getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, 
    где ключи - это имена, а значения - списки номеров телефона.

    Пример.

        На входе:
    add("Alice", 123456);   
    add("Alice", 789012);   
    add("Bob", 789012);   

        На выходе:
    Команды:
    find("Alice")
    getPhoneBook()
    find("Me")

    Результат:
    [123456, 789012]. 
    {Bob=[789012], Alice=[123456, 789012]} 
    []
    </details>

+ <details>
    <summary>Task2</summary>

    Вы работаете с приложением для учета имен пользователей. 
    Ваша задача - разработать программу, 
    которая принимает на вход пять имен пользователей 
    (или использует имена по умолчанию, если аргументы не предоставлены) 
    и подсчитывает, сколько раз каждое имя встречается.
    Программа должна использовать HashMap для хранения имен и их количества вхождений.
    По завершении, программа выводит результат в виде пар "имя - количество".

        На входе:
    'Elena'
    'Elena'
    'Elena'
    'Ivan'
    'Ivan'

        На выходе:
    {Ivan=2, Elena=3}
    </details>

+ <details>
    <summary>Task3</summary>

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
    </details>

+ <details>
    <summary>Task4</summary>

    На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
    Рекурсивно найдем решения. Т.к. ферзи не должны бить друг друга - для хранения информации опозиции расстановки достаточно линейной структуры. Используем HashMap, в котором ключ - номер вертикали, значение - номер ряда доски. Нумерацию начнем с 0. При выводе позиции переведем в шахматный порядок

</details>



<details>
<summary>Homework_6</summary>


+ <details>
    <summary>Task</summary>
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
    методы. Реализовать в java.
    - Создать множество ноутбуков.
    - Написать метод, который будет запрашивать у пользователя критерий (или критерии)
    фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
    хранить в Map. Например:
    “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …

    - Далее нужно запросить минимальные значения для указанных критериев - сохранить
    параметры фильтрации можно также в Map.
    - Отфильтровать ноутбуки из первоначального множества и вывести проходящие по
    условиям.