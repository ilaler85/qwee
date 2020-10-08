package com.company;

import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
       System.out.println("Введите размер буфера");
       int n = scanner.nextInt();
        RingBufer<String> buf = new RingBufer<String>(n);
        Boolean Ok = true;
        while (Ok)
        {
            System.out.println("1 - введите элемент");
            System.out.println("2 - выделить самый первый элемент");
            System.out.println("3 - вывести первый элемент");
            System.out.println("4 - размер буфера");
            System.out.println("0 - выход");
            n = scanner.nextInt();
            switch (n){
                case 1:
                    System.out.println("Введите элемент");
                    String tmp = scanner.next();
                    buf.add(tmp);
                    break;
                case 2:
                    System.out.println("Первый элемент "+buf.poll());
                    break;
                case 3:
                    System.out.println("Первый элемент "+buf.peek());
                    break;
                case 4:
                    System.out.println("Размер буфера "+buf.getSize());
                    break;
                case 0:
                    Ok = false;
                    break;
            }
            System.out.println(buf.toString());

        }
    }
}
