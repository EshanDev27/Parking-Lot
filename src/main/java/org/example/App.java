package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws SQLException {
        operation op = new operation();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String owner_name, l_no;
        System.out.println("**************************************************************************");
        System.out.println("\t\t\tWelcome To The Parking Lot\t\t\t");
        System.out.println("**************************************************************************");
        System.out.println("How may I help you\n1. Do you want to enter the Parking Lot?\n2. Do you want to exit the Parking Lot?\n0. To exit the menu");
        choice = sc.nextInt();
        sc.nextLine();
        while (choice != 0){
            switch (choice){
                case 1:
                    System.out.println("Enter Owner's name");
                    owner_name = sc.nextLine();
                    System.out.println("Enter License Plate number");
                    l_no = sc.nextLine();
                    op.enter(owner_name, l_no);
                    break;
                case 2:
                    op.exit();
                    break;
                default:
                    System.out.println("Enter valid input");
                    break;
            }
            System.out.println("**************************************************************************");
            System.out.println("\t\t\tWelcome To The Parking Lot\t\t\t");
            System.out.println("**************************************************************************");
            System.out.println("How may I help you\n1. Do you want to enter the Parking Lot?\n2. Do you want to exit the Parking Lot?\n0. To exit the menu");
            choice = sc.nextInt();
            sc.nextLine();
        }
    }
}