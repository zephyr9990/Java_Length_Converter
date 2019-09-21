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

package aragon.io;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

/**
 *
 * @author Rodel Aragon
 */
public class ConversionIO {
    
    private static final Path conversionPath = Paths.get(
                                                "conversion_types.txt");
    private static final File conversionFile = conversionPath.toFile();
    private static ArrayList<Conversion> conversions = new ArrayList<>();
    private static final String FIELD_SEP = "\t";
    
    /**
     * Gets the conversion information from a file
     * @return An <code>ArrayList</code> containing a list of
     *      <code>Conversion</code> objects with the data from the file.
     */
    public static ArrayList<Conversion> getConversions() {
        if (Files.notExists(conversionPath)) {
            try {
                Files.createFile(conversionPath);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else {// file does exist
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(conversionFile))) {
            //read all conversions stored in the file into array list  
                String line = in.readLine();
                while(line != null) {
                    String[] fields = line.split(FIELD_SEP);
                    Conversion conversion = new Conversion();
                    conversion.setFromUnit(fields[0]);
                    conversion.setToUnit(fields[1]);
                    conversion.setConverionRatio(
                            Double.parseDouble(fields[2]));
                    conversions.add(conversion);
                
                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        }
        return conversions;
    }
    
    /**
     * Function to save the conversion information saved
     *      in <code>conversions</code> to a file.
     * @param conversions The <code>ArrayList</code> containing
     *      the conversion data.
     * @return <code>true</code> if successful, <code>false</code> if not. 
     */
    public static boolean saveConversions(ArrayList<Conversion> conversions)
    {
        try (PrintWriter out = new PrintWriter(
                           new BufferedWriter(
                           new FileWriter(conversionFile)))) {
            // write all conversions stored in the array list to the file
            for (Conversion conversion : conversions) {
                out.print(conversion.getFromUnit() + "\t");
                out.print(conversion.getToUnit() + "\t");
                out.println(conversion.getConverionRatio());                
            } 
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}