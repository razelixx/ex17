package com.company;

//  Необходимо написать программу, которая будет записывать текстовые данные, введенные с экрана, в файл .txt.
//  Запись ввести в файл до тех пор, пока не будет введена команда стоп в консоли.
//  Пользователь при тестировании программы по правилу черного ящика должен понимать,
//  какой принцип остановки записи в файл он должен подать.

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Для остановки записи в файл введите 'стоп'");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        try(FileWriter strWrite = new FileWriter("file.txt", false)) {
            do {
                str = reader.readLine();
                if (str.equals("стоп")) break;
                strWrite.write(str);
                strWrite.append('\n');
            } while (!str.equals("стоп"));
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}