package Appota.gui;

import Appota.controller.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static int showMenu() {
        System.out.println("1. Print all tittle of poem");
        System.out.println("2. Search a poem content by tittle");
        System.out.println("3. Print number 42 with sum of digit is 42");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int userInput = 0;
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                userInput = Integer.parseInt(in.nextLine());
                if (userInput > 4 || userInput < 1) {
                    throw new Exception("Must Enter 1 to 3\nEnter another choice:");
                }
                return userInput;
            } catch (Exception e) {
                System.out.println("Must Enter 1 to 3\n");
                System.out.print("Enter another choice: ");
            }

        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "UTF-8");
        int choice = -1;
        Controller con = new Controller();
        String data = "";
        try {
            data = con.openFile("book1.txt");
            while(choice!=4){
            choice = showMenu();
                if(choice == 1) {
                    System.out.println(con.getTittle(data));
                    System.in.read();
                }
                if(choice == 2) {
                    System.out.print("Enter tittle of poem: ");
                    String tittle = in.nextLine();
                 
                    String content = con.getContent(tittle);
                    if(content == null || content.isEmpty()) {
                        System.out.println("Can't found any poem with tittle is: " + tittle);
                    }else {
                        System.out.println(content);
                    }
                    System.in.read();
                }
                if(choice == 3) {
                    List<Integer> ArrLst = new ArrayList<>();
                    int i = 69999;
                    while(ArrLst.size() < 42) {
                        if(con.sumOfDigit(i)==42) {
                            ArrLst.add(i);
                        }
                        i++;
                    }
                    System.out.println(ArrLst.get(41));
                    System.in.read();
                }
            }
        } catch (Exception ex) {
            System.out.println("Read file error: "+ex);
        }
        
    }
}
