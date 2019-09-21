/***********************************************************
*                                                          *
*  Author:        Rodel Aragon                             *
*  Course:        CS2420 Advanced Java Programming         *
*  Assignment:    Module 2, Exercise 17-2                  *
*  Program:       LengthConverter                          *
*  Description:   Application that allows a user to        *
*                 perform various conversions.             *
*  Input:         User-input values for conversion values. *
*  Output:        Displays the conversion and creates a    *
*                 file with the conversion data if none    *
*                 existed. Otherwise, reads and            *
*                 overwrites data.                         *
*  Created:       3/22/2018                                *
*                                                          *
***********************************************************/

package aragon.ui;

import java.util.Scanner;

/**
 *
 * @author Rodel Aragon
 */
public class Console {
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Outputs a single line.
     */
    public static void displayLine() {
        System.out.println();
    }
    
    /**
     * Outputs a <code>String<code> followed by a newline character
     * @param s the <code>String<code> to be displayed.
     */
    public static void displayLine(String s) {
        System.out.println(s);
    }
    
    /**
     * Outputs a <code>String<code> followed by a newline character
     * @param prompt The <code>String<code> to be displayed.
     * @return A <code>String</code> value from the user.
     */
    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }
    
    /**
     * Outputs a <code>String<code> followed by a newline character
     * @param prompt The <code>String<code> to be displayed.
     * @return A <code>int</code> value from the user.
     */
    public static int getInt(String prompt) {
        int i = 0;
        while (true) {
            System.out.print(prompt);
            try {
                i = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer. Try again");
            }
        }
        return i;
    }
    
    /**
     * Outputs a <code>String<code> followed by a newline character
     * @param prompt The <code>String<code> to be displayed.
     * @return A <code>double</code> value from the user.
     */
    public static double getDouble(String prompt) {
        double d = 0;
        while (true) {
            System.out.print(prompt);
            try {
                d = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal. Try again.");
            }
        }
        return d;
    }
}
