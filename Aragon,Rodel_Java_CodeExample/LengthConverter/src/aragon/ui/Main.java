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

import aragon.io.Conversion;
import aragon.io.ConversionIO;
import aragon.ui.ConversionsApp;
import java.util.ArrayList;

/**
 *
 * @author Rodel Aragon
 */
public class Main {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Length Converter.");
        
        ArrayList<Conversion> conversions = ConversionIO.getConversions();
        String continueProgram = "Y";
        while (continueProgram.equalsIgnoreCase("Y")) {
            ConversionsApp.displayMenu();
        
            int menuChoice = Console.getInt("Enter menu number: ");
            switch(menuChoice) {
                case 1:
                    if(!conversions.isEmpty()) {
                    ConversionsApp.displayConversions(conversions);
                    ConversionsApp.doConversion(conversions);
                    } else {
                        Console.displayLine("No conversions to display.");
                    }
                    break;
                case 2:
                    ConversionsApp.addConversion(conversions);
                    break;
                case 3:
                    ConversionsApp.deleteConversion(conversions);
                    break;
                case 4:
                    continueProgram = "N";
                    break;
                default:
                    Console.displayLine("Invalid menu option. Try again.");
                    break;
            }
        }
        Console.displayLine("Exiting program...");
    }
}
