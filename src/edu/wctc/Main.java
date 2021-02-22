package edu.wctc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator;

    public static void main(String[] args) {
        paintCalculator = new PaintCalculator();
        int selection = 0;

        do {
            printMenu();
            System.out.print("Enter selection: ");
            selection = Integer.parseInt(keyboard.nextLine());

            switch (selection){
                case 1:
                    createRoom();
                    break;
                case 2:
                    System.out.println(paintCalculator);
                    break;
                case 3:
                    readFile();
                    break;
                case 4:
                    writeFile();
                    break;
            }
        } while(selection != 5);

    }

    private static void printMenu(){
        System.out.println("1. Add room");
        System.out.println("2. View rooms");
        System.out.println("3. Read rooms from file");
        System.out.println("4. Write rooms to file");
        System.out.println("5. Exit program");
    }

    private static double promptForDimension(String dimensionName){
        System.out.print("Enter the room's" + " " + dimensionName);
        double length = Double.parseDouble(keyboard.nextLine());
        return length;
    }

    private static void createRoom(){
        double length = promptForDimension("length: ");
        double width = promptForDimension("width: ");
        double height = promptForDimension("height: ");
        paintCalculator.addRoom(length, width, height);
    }

    private static void readFile(){
        try (
                FileInputStream fis = new FileInputStream("paintCalculator.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
             ) {
            paintCalculator = (PaintCalculator) ois.readObject();
            System.out.println("You read the file!");
        } catch (IOException | ClassNotFoundException e) {
           // e.printStackTrace();
            System.out.println("File cannot be read.");
        }
    }

    private static void writeFile(){
        try (
                FileOutputStream fos = new FileOutputStream("paintCalculator.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
            System.out.println("You wrote into file!");

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("File cannot be written.");
        }
    }
}
