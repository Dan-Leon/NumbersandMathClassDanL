package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // This is a small program that is a bill generator for a business that involves tips. (was suppose to be a
        // tip calculator)
        double tax = 0.025;
        double subtotal = 0.00;


        // I was going to use an empty array and append to it, however I was making this harder than it needed to be
        // so I changed it to just a while loop that kept a running total of entries.

        double userInput = getAmount("Please enter the dollar amount: $");  // gets user input calling method
        while (userInput != 0){
            subtotal  += userInput;
            userInput = getAmount("Please enter the dollar amount: $");
        }
        double billTax = subtotal * tax;
        double recTip = subtotal * 0.175;

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        String recTipOut = nf.format(recTip);

        System.out.println("Your subtotal is:\t\t$" + subtotal);
        System.out.println("The recommended tip is:\t$" + recTipOut);
        System.out.println("\n");
        double userTip = getAmount("Please enter the amount you wish to tip: $");
        System.out.println("\n");

        double total = subtotal + billTax + userTip;

        String totalOut = nf.format(total);
        String billTaxOut = nf.format(billTax);
        String subtotalOut = nf.format(subtotal);
        String userTipOut = nf.format(userTip);

        System.out.println("Your bill breakdown:");
        System.out.println("-------------------------------------");
        System.out.println("| Subtotal: \t\t\t\t$" + subtotalOut + "\t|");
        System.out.println("| Tax: \t\t\t\t\t\t$" + billTaxOut + "\t|");
        System.out.println("| Tip: \t\t\t\t\t\t$" + userTipOut +"\t|");
        System.out.println("| Total: \t\t\t\t\t$" + totalOut + "\t|");
        System.out.println("|\t\t\t\t\t\t\t\t\t|");
        System.out.println("-------------------------------------");

    }

    private static double getAmount(String sLabel){
        double dItem;
        Scanner sc = new Scanner(System.in);
        System.out.print(sLabel);
        dItem = sc.nextDouble();
        return dItem;
    }



}
