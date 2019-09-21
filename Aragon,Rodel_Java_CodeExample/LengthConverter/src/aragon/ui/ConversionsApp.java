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
import java.util.ArrayList;
/**
 *
 * @author Rodel Aragon
 */
public class ConversionsApp {
    
    /**
     * Displays the menu.
     */
    public static void displayMenu() {
        System.out.println("\n1 - Convert a length\n"
                + "2 - Add a type of conversion\n"
                + "3 - Delete a type of conversion\n"
                + "4 - Exit\n");
    }
    
    /**
     * Display the conversions in menu form.
     * @param conversions The <code>ArrayList</code> containing
     *      the conversion data.
     */
    public static void displayConversions(ArrayList<Conversion> conversions) {
        int menuItem = 1;
        Console.displayLine();
        for (Conversion conversion : conversions) {
            Console.displayLine(menuItem + " - "
                    + conversion.getFromUnit() + " to " + conversion.getToUnit()
                    + ": " + conversion.getConverionRatio());
            
            menuItem++;
        }
    }
    
    /**
     * Asks for conversion information and performs the conversion.
     * @param conversions The <code>ArrayList</code> containing
     *      the conversion data.
     */
    public static void doConversion(ArrayList<Conversion> conversions) {
        int conversionIndex = 
                        Console.getInt("\nEnter conversion number: ");
        if (conversionIndex < 1 || conversionIndex > conversions.size()) {
            Console.displayLine("Invalid number. Try again.");
        } else {
            //Gets toUnit string value
            double fromValue = Console.getDouble("\nEnter " + 
                    conversions.get(conversionIndex - 1).getFromUnit() + ": ");
            conversions.get(conversionIndex - 1).performConversion(fromValue);
        }
    }
    
    /**
     * Adds new conversion data to the file.
     * @param conversions The <code>ArrayList</code> containing
     *      the conversion data.
     */
    public static void addConversion(ArrayList<Conversion> conversions) {
        while (true) {
            String fromUnit = Console.getString("\nEnter 'From' unit: ");
            String toUnit = Console.getString("Enter 'To' unit: ");
            double conversionRatio = Console.getDouble(
                    "Enter the conversion ratio: ");
        
            for (Conversion c : conversions) {
                if (c.getFromUnit() == fromUnit &&
                        c.getToUnit() == toUnit &&
                        c.getConverionRatio() == conversionRatio) {
                    Console.displayLine("Conversion is already on the list.");
                    continue;
                }
            }
            Conversion newConversion = new Conversion(
                fromUnit, toUnit, conversionRatio);
            conversions.add(newConversion);
            break;
        }
        if (ConversionIO.saveConversions(conversions)) {
            System.out.println("\nThis entry has been saved.");
        } else {// save not successful
            System.out.println("\nSave was unsuccessful.");
        }
    }
    
    /**
     * Deletes conversion data from the file.
     * @param conversions The <code>ArrayList</code> containing
     *      the conversion data.
     */
    public static void deleteConversion(ArrayList<Conversion> conversions) {
        displayConversions(conversions);
        int indexToDelete = Console.getInt(
                "\nEnter a conversion number to delete: ");
        if (indexToDelete < 1 || indexToDelete > conversions.size()) {
            Console.displayLine("Invalid number. Try again.");
        } else {
        conversions.remove(indexToDelete - 1);
            if (ConversionIO.saveConversions(conversions)) {
                System.out.println("\nThis entry has been deleted.");
            } else {// save not successful
                System.out.println("Delete was unsuccessful.");
            }
        }
    }
}
