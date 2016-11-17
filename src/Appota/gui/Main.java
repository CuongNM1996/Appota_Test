package Appota.gui;

import Appota.controller.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static int showMenu() {
        System.out.println("1. Print all tittle of poem");
        System.out.println("2. Search a poem content by tittle");
        System.out.println("3. Print number n with sum of digit is 42");
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
                    int num = 0;
                    int k = 0;
                    while(k!=1) {
                        try {
                            System.out.print("Enter a number n: ");
                            num = Integer.parseInt(in.nextLine());
                            if(num <= 0) {
                                throw new Exception("number only");
                            }
                            k = 1;
                        } catch (Exception e) {
                            System.out.println("n > 0, and number only");
                        }
                    }
                    List<Integer> ArrLst = new ArrayList<>();
                    //this block code will find the first number
                    int NumberOf9 = 0;
                    String frsNum = ""+(42%9);               
                    for(int i = 0; i < (42/9);i++) {          
                        frsNum+="9";
                    }
                    int i = Integer.parseInt(frsNum);//the first number
                    
                    while(ArrLst.size() < num) {
                        //check if that number have sum of digit = 42
                        if(con.sumOfDigit(i)==42) {
                            ArrLst.add(i); //then add to array list
                        }
                        i++;
                    }
                    System.out.println();
                    System.out.println(ArrLst.get(num-1)); //print that number
                    System.in.read();
                }
            }
        } catch (Exception ex) {
            System.out.println("Read file error: "+ex);
        }
        
    }
}
