package ru.student.datatypes.g;

import java.util.Scanner;

public class DataTypesDemo {
    public static void main(String[] args) {
        // Задание 2: Демонстрация примитивных типов данных
        // Для каждого типа выводим значение, размер в байтах и диапазон (если применимо)

        byte b = 100;
        System.out.println("byte: значение = " + b + ", размер = " + Byte.BYTES + " байт, диапазон = " + Byte.MIN_VALUE + ".." + Byte.MAX_VALUE);

        short s = 1000;
        System.out.println("short: значение = " + s + ", размер = " + Short.BYTES + " байта, диапазон = " + Short.MIN_VALUE + ".." + Short.MAX_VALUE);

        int i = 100000;
        System.out.println("int: значение = " + i + ", размер = " + Integer.BYTES + " байта, диапазон = " + Integer.MIN_VALUE + ".." + Integer.MAX_VALUE);

        long l = 100000L; // суффикс L обязателен, иначе компилятор считает число int
        System.out.println("long: значение = " + l + ", размер = " + Long.BYTES + " байт");

        float f = 3.14f; // суффикс f обязателен, иначе компилятор считает число double
        System.out.println("float: значение = " + f + ", размер = " + Float.BYTES + " байта");

        double d = 3.14159;
        System.out.println("double: значение = " + d + ", размер = " + Double.BYTES + " байта");

        char c = 'A'; // символ хранится как число Unicode
        System.out.println("char: значение = " + c + ", код символа = " + (int) c + ", размер = " + Character.BYTES + " байта");

        boolean bool = true; // логический тип, принимает только true/false
        System.out.println("boolean: значение = " + bool);

        // Задание 3: Обёрточные классы (wrapper classes)
        // Каждый примитивный тип имеет соответствующий класс-обёртку

        Integer intObj = 128;       // autoboxing: int -> Integer
        Double doubleObj = 3.14;    // autoboxing: double -> Double
        Character charObj = 'B';    // autoboxing: char -> Character
        Boolean boolObj = true;     // autoboxing: boolean -> Boolean

        System.out.println("Integer object: " + intObj);

        // unboxing: автоматическое преобразование обёртки обратно в примитив
        int primitiveFromObj = intObj;
        System.out.println("Unboxed int: " + primitiveFromObj);

        // Кэш целых чисел: JVM кэширует объекты Integer от -128 до 127
        // Поэтому ссылки на одинаковые значения в этом диапазоне совпадают
        Integer a = 127;
        Integer bVal = 127;
        Integer cVal = 128;
        Integer dVal = 128;

        // true, потому что 127 попадает в кэш — это один и тот же объект
        System.out.println("127 == 127: " + (a == bVal));
        // false, потому что 128 вне кэша — создаются два разных объекта
        System.out.println("128 == 128: " + (cVal == dVal));
        // true, метод equals сравнивает значения, а не ссылки
        System.out.println("128 equals 128: " + cVal.equals(dVal));

        // Преобразование строки в число и обратно
        String strNum = "123";
        int parsedInt = Integer.parseInt(strNum); // парсинг строки в int
        System.out.println("String '123' to int: " + parsedInt);

        int numToStr = 456;
        String strFromNum = String.valueOf(numToStr); // преобразование int в строку
        System.out.println("Int 456 to String: " + strFromNum);

        // Задание 4: Преобразование типов
        // Восходящее преобразование (widening) — автоматическое, без потери данных

        byte byteVal = 10;
        short shortVal = byteVal;   // byte -> short
        int intVal = shortVal;      // short -> int
        long longVal = intVal;      // int -> long
        float floatVal = longVal;   // long -> float
        double doubleVal = floatVal; // float -> double
        System.out.println("Double from byte chain: " + doubleVal);

        // Нисходящее преобразование (narrowing) — требует явного приведения, возможна потеря данных
        double bigDouble = 99.99;
        int smallInt = (int) bigDouble; // дробная часть отбрасывается, результат 99
        System.out.println("Double 99.99 to int: " + smallInt);

        // Переполнение при сужении: 300 не помещается в byte (диапазон -128..127)
        // Результат: 300 % 256 = 44
        int bigIntForByte = 300;
        byte overflowByte = (byte) bigIntForByte;
        System.out.println("Int 300 to byte: " + overflowByte);

        // Задание 5: Отладчик
        // Цикл для тренировки работы с точками останова (breakpoints) в IDE
        for (int k = 0; k < 10; k++) {
            System.out.println("Debug loop step: " + k);
        }

        // Задание 6: Системы счисления
        // Java поддерживает запись чисел в разных системах: восьмеричной (0), шестнадцатеричной (0x), двоичной (0b)

        int dec = 100;       // десятичное
        int oct = 0144;      // восьмеричное (начинается с 0): 1*64 + 4*8 + 4 = 100
        int hex = 0x64;      // шестнадцатеричное (начинается с 0x): 6*16 + 4 = 100
        int bin = 0b1100100; // двоичное (начинается с 0b): 64+32+4 = 100

        System.out.println("Dec: " + dec);
        System.out.println("Oct: " + oct);
        System.out.println("Hex: " + hex);
        System.out.println("Bin: " + bin);
        // Все четыре записи представляют одно и то же число
        System.out.printf("Все равны 100: %b%n", dec == oct && oct == hex && hex == bin);

        // Задание 7: Char и Unicode
        // Символ 'A' имеет код 65 в таблице Unicode (и ASCII)

        char ch1 = 'A';         // символьный литерал
        char ch2 = (char) 65;   // явное приведение числа к символу
        char ch3 = '\u0041';    // Unicode-экранирование: 0041 в hex = 65 в decimal

        System.out.println("Code of 'A': " + (int) ch1);
        System.out.println("Char from 65: " + ch2);
        System.out.println("Unicode \\u0041: " + ch3);
        System.out.printf("Равны: %b%n", ch1 == ch2 && ch2 == ch3);

        // Вывод английского алфавита через цикл по char
        // char — это числовой тип, поэтому его можно инкрементировать
        System.out.print("Alphabet: ");
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            System.out.print(letter + " ");
        }
        System.out.println();

        // Задание 8: Константы
        // Ключевое слово final делает переменную неизменяемой после инициализации

        final double PI = 3.14159;
        final int MAX_COUNT = 100;

        System.out.println("PI: " + PI);
        System.out.println("MAX_COUNT: " + MAX_COUNT);
        // Константы из отдельного класса Constants


        // Задание 9: Калькулятор
        // Считываем два числа и операцию, определяем тип (int/double) и вычисляем результат

        Scanner sc = new Scanner(System.in);
        System.out.print("Число 1: ");
        String s1 = sc.nextLine();
        System.out.print("Число 2: ");
        String s2 = sc.nextLine();
        System.out.print("Операция (+,-,*,/,%): ");
        String op = sc.nextLine();

        // Если хотя бы одно число содержит точку — работаем с double, иначе с int
        boolean isDbl = s1.contains(".") || s2.contains(".");
        if (isDbl) {
            double n1 = Double.parseDouble(s1);
            double n2 = Double.parseDouble(s2);
            // Проверка деления на ноль для операций / и %
            if ((op.equals("/") || op.equals("%")) && n2 == 0) {
                System.out.println("Ошибка: деление на 0!");
            } else {
                System.out.println("Результат (double): " + calc(n1, n2, op));
            }
        } else {
            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);
            if ((op.equals("/") || op.equals("%")) && n2 == 0) {
                System.out.println("Ошибка: деление на 0!");
            } else {
                System.out.println("Результат (int): " + calc(n1, n2, op));
            }
        }
        sc.close();
    }

    // Универсальный метод вычисления
    // Принимает два числа типа Number и строку с операцией
    // Возвращает Number (Integer или Double в зависимости от входных данных)
    static Number calc(Number a, Number b, String op) {
        // Проверяем тип первого аргумента: если Double — считаем в double, иначе в int
        if (a instanceof Double) {
            double x = a.doubleValue(), y = b.doubleValue();
            return switch (op) {
                case "+" -> x + y;
                case "-" -> x - y;
                case "*" -> x * y;
                case "/" -> x / y;
                case "%" -> x % y;
                default -> 0.0;
            };
        } else {
            int x = a.intValue(), y = b.intValue();
            return switch (op) {
                case "+" -> x + y;
                case "-" -> x - y;
                case "*" -> x * y;
                case "/" -> x / y;
                case "%" -> x % y;
                default -> 0;
            };
        }
    }
}