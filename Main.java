/*
Домашняя работа №1
1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

2. Посмотрите на код, и подумайте сколько разных типов исключений
вы тут сможете получить ?

3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен разности элементов двух
входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
оповестить пользователя.

4. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен частному элементов двух
входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
оповестить пользователя.

Важно:
При выполнении метода единственное исключение,
которое пользователь может увидеть - RuntimeException, т.е. ваше.
*/

public class Main {
    public static void main(String[] args) {

        //1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения:

        //№1
        //System.out.println(metodOneV1(10, 1));
        //однако при dividingNumber = 0 получаем следующее
        // иcключение: ArithmeticException:
        //System.out.println(metodOneV1(10, 0));
        //или еще более примитивно:
        //metodOneV2(10);

        //№2
        //Исключение ArrayIndexOutOfBoundsException:
        //int[] arrayForTwo = new int[] {1,2,3};
        //System.out.println(metodTwo(arrayForTwo));

        //№3
        //Исключение NullPointerException:
        //Integer[] arrayForThree = null;
        //metodThreeV1(arrayForThree);
        //или совсем примитивно:
        //metodThreeV2();

        //#4
        //System.out.println( metodForV1("1"));
        //Исключение NumberFormatException:
        //System.out.println(metodForV1("1a"));
        //или совсем примитивно:
        //metodForV2();

        //Integer[] arrayOne = new Integer[] {3,2,1};
        //Integer[] arrayTwo = new Integer[] {1,2,3};
        //Integer[] arrayTwo = new Integer[] {1,2};
        //Integer[] arrayTwo = new Integer[] {};
        //Integer[] arrayTwo = null;

        //outputToScreen(differenceElementArray1d(arrayOne, arrayTwo));

        Integer[] arrayOne = new Integer[] {3,2,1};
        //Integer[] arrayTwo = new Integer[] {1,2,3};
        Integer[] arrayTwo = new Integer[] {1,2,0};
        //Integer[] arrayTwo = new Integer[] {1,2};
        //Integer[] arrayTwo = new Integer[] {};
        //Integer[] arrayTwo = null;

        outputToScreen(privateElementArray1d(arrayOne, arrayTwo));

        /*
        P.S.: В принципе можно поработать и с 2х-мерными массивами,
        но не это вроде тема нашего ДЗ.
        */
    }

    //1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения:
    public static int metodOneV1(int divisibleNumber, int dividingNumber) {
        return divisibleNumber/dividingNumber;
    }

    public static int metodOneV2(int divisibleNumber) {
        return divisibleNumber/0;
    }

    public static int metodTwo(int[] array) {
        return array[array.length];
    }

    public static int metodThreeV1(Integer[] array) {
        return array.length;
    }

    public static int metodThreeV2() {
        Integer [] array = null;
        //int [] array = null;
        return array.length;
    }

    public static Integer metodForV1(String namberParsInteger) {
        return Integer.parseInt(namberParsInteger);
    }

    public static Integer metodForV2() {
        return Integer.parseInt("1a");
    }

    /*
    Реализовано 4-ре метода.
    */

    //2. Посмотрите на код, и подумайте сколько разных типов
    // исключений вы тут сможете получить ?
    //Код на который нужно посмотреть:
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    /*
    Вижу следующие исключения в порядке "очевидности" для меня:
    1. ArrayIndexOutOfBoundsException из-за for (int j = 0; j < 5; j++) {
    2. NullPointerException если String[][] arr = null;
    3.1 NumberFormatException если
    входной массив {{"1a","1","1","1","1"},{"1","1","1","1","1"}};
    3.2 NumberFormatException если
    входной массив {{null,"1","1","1","1"},{"1","1","1","1","1"}};
    3.3 incompatible types: int cannot be converted to java.lang.String если
    входной массив {{1,"1","1","1","1"},{"1","1","1","1","1"}};
    */

    /*
    3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    и возвращающий новый массив, каждый элемент которого равен разности элементов двух
    входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
    оповестить пользователя.
    */

    /*
     Допущение:
     1. Входящие массивы одномерные
     2. Разность между элементами первого и второго массива
    */

    public static Integer[] differenceElementArray1d(Integer[] arrayOne, Integer[] arrayTwo) {

        if (arrayOne == null) {
            throw new RuntimeException(String.format("arrayOne пуст (arrayOne == null)"));
        }

        if (arrayTwo == null) {
            throw new RuntimeException(String.format("arrayTwo пуст (arrayTwo == null)"));
        }

        if (arrayOne.length == 0) {
            throw new RuntimeException(String.format("Длинна массива arrayOne равна нулю"));
        }

        if (arrayTwo.length == 0) {
            throw new RuntimeException(String.format("Длинна массива arrayTwo равна нулю"));
        }

        if (arrayOne.length != arrayTwo.length) {
            throw new RuntimeException(String.format("Количество элементов в массиве arrayOne не равно количеству элементов в массиве arrayTwo" +
                    "Количество элементов в массиве arrayOne: %d " +
                    "Количество элементов в массиве arrayTwo: %d",
                    arrayOne.length, arrayTwo.length));
        }

        Integer[] resalt = new Integer[arrayOne.length];

        for (int i = 0; i < resalt.length; i++) {

            resalt[i] = arrayOne[i] - arrayTwo[i];

        }

        return resalt;
    }

    /*
    4. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    и возвращающий новый массив, каждый элемент которого равен частному элементов двух
    входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
    оповестить пользователя.
    */

    /*
     Допущение:
     1. Входящие массивы одномерные
     2. Деление (частное) элементов первого массива на элементы второго массива
    */

    public static Integer[] privateElementArray1d(Integer[] arrayOne, Integer[] arrayTwo) {

        if (arrayOne == null) {
            throw new RuntimeException(String.format("arrayOne пуст (arrayOne == null)"));
        }

        if (arrayTwo == null) {
            throw new RuntimeException(String.format("arrayTwo пуст (arrayTwo == null)"));
        }

        if (arrayOne.length == 0) {
            throw new RuntimeException(String.format("Длинна массива arrayOne равна нулю"));
        }

        if (arrayTwo.length == 0) {
            throw new RuntimeException(String.format("Длинна массива arrayTwo равна нулю"));
        }

        if (arrayOne.length != arrayTwo.length) {
            throw new RuntimeException(String.format("Количество элементов в массиве arrayOne не равно количеству элементов в массиве arrayTwo" +
                            "Количество элементов в массиве arrayOne: %d " +
                            "Количество элементов в массиве arrayTwo: %d",
                    arrayOne.length, arrayTwo.length));
        }

        Integer[] resalt = new Integer[arrayOne.length];

        for (int i = 0; i < resalt.length; i++) {

            /*
            Данную проверку можно "расположить" в отдельном цикле перед этим циклом,
            что правда не рационально на мой взгляд.
            */
            if (arrayTwo[i] == 0) {
                throw new RuntimeException(
                        String.format("Данная операция не возможна " +
                                "так как %d элемент массива arrayTwo равен нулю", i));
            }

            resalt[i] = arrayOne[i] / arrayTwo[i];

        }

        return resalt;
    }

    //служебная функция для вывода на экран элементов массива:
    public static void outputToScreen(Integer[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}