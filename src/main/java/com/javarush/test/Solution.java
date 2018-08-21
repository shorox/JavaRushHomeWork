package com.javarush.test;

public class Solution {

    /*public static void main(String[] args) {
        int size = 8;
        int max = size * size;
        int[][] matrix = new int[size][size];
        int left = 0, top = 0, right = size, bottom = size;
        int x = left, y = top;
        Position pos = Position.START;
        for (int i = 1; i <= max; i++) {
            switch (pos) {
                case START:
                    pos = Position.RIGHT;
                    break;
                case RIGHT:
                    if(x + 1 < right) x++;
                    else {
                        pos = Position.BOTTOM;
                        right--;
                        y++;
                    }
                    break;
                case BOTTOM:
                    if(y + 1 < bottom) y++;
                    else {
                        pos = Position.LEFT;
                        bottom--;
                        x--;
                    }
                    break;
                case LEFT:
                    if(x - 1 >= left) x--;
                    else {
                        pos = Position.TOP;
                        left++;
                        y--;
                    }
                    break;
                case TOP:
                    if(y - 1 > top) y--;
                    else {
                        pos = Position.RIGHT;
                        top++;
                        x++;
                    }
                    break;
            }
            matrix[x][y] = i;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) System.out.format("%4d", matrix[j][i]);
            System.out.println();
        }
    }

    enum Position{
        START,
        RIGHT,
        BOTTOM,
        LEFT,
        TOP
    }*/

    /*public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a * b);
    }*/

    /*public static void main(String[] args) throws Exception
    {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static void printSomething()
    {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }*/

    /*public static void main(String[] args) {
        PrintStream out = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        System.setIn(System.in);
        System.out.println(5);
        System.out.println("+");
        System.out.println(5);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //baos.write();
        byte[] b = new byte[8 * 1024];
        int count;

        //stream.write(b);
        String[] str = new String[1];
        int sum = 0;
        Integer x = null;
        for (String s : str) {
            try{
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                switch (s.charAt(0)){
                    case '+' :
                        sum += (x == null ? 0 : x);
                        x = null;
                        break;
                    case '-' :
                        sum -= (x == null ? 0 : x);
                        x = null;
                        break;
                    case '*' :
                        sum *= (x == null ? 1 : x);
                        x = null;
                        break;
                    case '/':
                        sum /= (x == null ? 1 : x);
                        x = null;
                        break;
                }
            }

        }
        System.setOut(out);
        System.out.println(sum);
    }*/

    public static void main(String[] args) {
        int n = 5;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}