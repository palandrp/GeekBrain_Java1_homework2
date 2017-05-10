package ru.kimdo;

//  Java 1 homework 2
//  @author Петриковский Павел
//  Я не стал добавлять всевозможные проверки вводимых параметров,
//  чтобы не утяжелять код на этапе обучения. (Хотя руки чесались)

public class J1HW2 {

    public static void main(String[] args) {
//  Каждое задание выполнено в виде отдельного метода "покажиЗаданиеХ".
//  Так же, есть 2 вспомогательных метода, которые генерируют int[]
//  массив, и случайное число для сдвига в 8-м задании. Генерация
//  массива применяется как из метода main так и внутри самих заданий.
//  Так же я выделил showArray() в отдельный метод, так как этот код
//  повторяется почти в каждом задании.
        showTask1();
        showTask2();
        showTask3();
        showTask4();
        showTask5();
//        В 6-м задании нужно несколько раз позапускать, чтобы сгенерился
//        удачный массив, подходящий к условию, это даже немного похоже на
//        игру и азартно :)
        showTask6(generateIntArray(9, 10));
        showTask7(generateIntArray(10, 20), generateInt(5));

    }

//  Задание №1
//  Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
//  [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить
//  0 на 1, 1 на 0;
    private static void showTask1(){

        System.out.println("Здание №1");

        int[] array = {1, 0, 0, 1, 0, 0, 1, 0};

        System.out.println("Было:");
        showIntArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }
            else array[i] = 0;
        }

        System.out.println("Стало:");
        showIntArray(array);
    }

//  Задание №2
//  Задать пустой целочисленный массив размером 8. С помощью
//  цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    private static void showTask2(){

        System.out.println("Здание №2");

        int array[] = new int[8];

        int i, j;
        for (i = 0, j = 0; i < 8; i++, j = j+3) {
            array[i] = j;
        }
        System.out.println("Массив задания №2:");
        showIntArray(array);
    }

//  Задание №3
//  Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти
//  по нему циклом, и числа меньшие 6 умножить на 2;
    private static void showTask3(){

        System.out.println("Здание №3");

        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Было:");
        showIntArray(array);

        for (int i = 0; i < array.length; i++) {           //Объясните разницу при выводе for(int i : array) {
            if (array[i] < 6) array[i] = array[i] * 2;     // if (i < 6) i = i * 2; }
        }

        System.out.println("Стало:");
        showIntArray(array);
    }

//  Задание №4
//  Создать квадратный двумерный целочисленный массив (количество
//  строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его
//  диагональные элементы единицами;
    private static void showTask4(){

        System.out.println("Здание №4");
//      Здесь я захардкодил размер массива и количество итераций цикла,
//      по идее их бы тоже генерировать или принимать с ввода, но это
//      в другой раз, это в задаче не стояло.
        char table[][] = new char[8][8];

        System.out.println("Результат:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == j) table[i][j] = '1';
//              Решил, чтобы было видно чистую диагональ, остальные
//              элементы заполнить пробелами, это не противоречит
//              заданию.
                else table[i][j] = ' ';
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        System.out.print('\n');
    }

//  Задание №5
//  Задать одномерный массив и найти в нем минимальный и
//  максимальный элементы (без помощи интернета);
    private static void showTask5() {

        System.out.println("Здание №5");

        int array[] = generateIntArray(20, 1000);

        System.out.println("Массив:");
        showIntArray(array);

        int x = array[0];
        int y = array[0];
        for(int i = 1; i < array.length; i++){
            if (array[i] > x) x = array[i];
            if (array[i] < y) y = array[i];
        }

        System.out.printf("Максимальное значение: %d.\nМинимальное значение: %d.\n", x, y);
    }

//  Задание №6
//  Написать метод, в который передается не пустой одномерный целочисленный
//  массив, метод должен вернуть true если в массиве есть место, в котором
//  сумма левой и правой части массива равны. Примеры:
//  checkBalance([1, 1, 1, || 2, 1]) → true,
//  checkBalance ([2, 1, 1, 2, 1]) → false,
//  checkBalance ([10, || 10]) → true, граница показана
//  символами ||, эти символы в массив не входят.
    private static boolean checkBalance(int[] array){

        int x = array[0];
        int y = 0;
        boolean isTrue = false;

        for (int i = 1; i < array.length; i++){
            for (int j = i; j < array.length; j++) {
                y += array[j];
            }
            if (x == y) {
                System.out.println("Обработка:");
                for (int k = 0; k < i; k++) {
                    System.out.print(array[k] + " ");
                }
                System.out.print("|| ");
                for (int n = i; n < array.length; n++) {
                    System.out.print(array[n] + " ");
                }
                System.out.printf("\n%d || %d", x, y);
                System.out.print('\n');
                isTrue = true;
            }
            x += array[i];
            y = 0;
        }
        return isTrue;
    }

    private static void showTask6(int[] array) {

        System.out.println("Здание №6");

        System.out.println("Массив:");
        showIntArray(array);
        if (checkBalance(array))
            System.out.println("Метод вернул true");
        else System.out.println("Метод вернул false");
    }

//  Задание №7
//  Написать метод, которому на вход подается одномерный массив и
//  число n (может быть положительным, или отрицательным), при этом
//  метод должен сместить все элементымассива на n позиций. Для
//  усложнения задачи нельзя пользоваться вспомогательными массивами.
    private static int[] moveElements(int[] array, int n){
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int lastElement = array[array.length - 1];
                int tempStorage2 = array[0];
                int tempStorage1 = 0;
                int k = 1;
                for (int j = 1; j <= array.length - 1; j++) {
                    if (j <= array.length - 2){
                        switch (k) {
                            case 1:
                                tempStorage1 = array[j];
                                array[j] = tempStorage2;
                                k = 2;
                                break;
                            case 2:
                                tempStorage2 = array[j];
                                array[j] = tempStorage1;
                                k = 1;
                                break;
                        }
                    }
                    else {
                        if (array.length % 2 == 1) {
                            array[array.length - 1] = tempStorage1;
                            array[0] = lastElement;
                        }
                        else {
                            array[array.length - 1] = tempStorage2;
                            array[0] = lastElement;
                        }
                    }
                }
            }
            return array;
        }
        else if (n < 0) {
            for (int i = 0; i > n; i--) {
                int firstElement = array[0];
                int tempStorage2 = array[array.length - 1];
                int tempStorage1 = 0;
                int k = 1;
                for (int j = array.length - 2; j >= 0; j--) {
                    if (j >= 1){
                        switch (k) {
                            case 1:
                                tempStorage1 = array[j];
                                array[j] = tempStorage2;
                                k = 2;
                                break;
                            case 2:
                                tempStorage2 = array[j];
                                array[j] = tempStorage1;
                                k = 1;
                                break;
                        }
                    }
                    else {
                        if (array.length % 2 == 1) {
                            array[0] = tempStorage1;
                            array[array.length - 1] = firstElement;
                        }
                        else {
                            array[0] = tempStorage2;
                            array[array.length - 1] = firstElement;
                        }
                    }
                }
            }
            return array;
        }
        else return array;
    }
//  Я с удовольствием познакомлюсь с более элегантным решением этой задачки...

    private static void showTask7(int[] array, int n){

        System.out.println("Здание №7");

        System.out.println("Массив:");
        showIntArray(array);
        System.out.printf("Показатель сдвига: %d\n", n);

        System.out.println("Результат сдвига:");
        showIntArray(moveElements(array, n));
    }

//  Вспомогательные методы
    private static int[] generateIntArray(int pool, int weight){
        int[] array = new int[pool];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (weight * Math.random());
        }
        return array;
    }

    private static void showIntArray(int[] array){
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
    }

    private static int generateInt(int range){
        int z;
        int x = (int) (2 * Math.random());
        if (x == 0)
            z = (int) (-range * Math.random());
        else
            z = (int) (range * Math.random());
        return z;
    }
}




















