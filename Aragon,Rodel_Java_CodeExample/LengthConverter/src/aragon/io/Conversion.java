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

import aragon.ui.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Rodel Aragon
 */
public class Conversion {
    
    private String fromUnit;
    private double fromValue;
    private String toUnit;
    private double toValue;
    private double conversionRatio;
    
    Conversion() {
        this.fromUnit = "";
        this.fromValue = 0;
        this.toUnit = "";
        this.toValue = 0;
        this.conversionRatio = 0;
    }
    
    /**
     * Constructor with parameters
     * @param fromUnit The <code>String</code> to set fromUnit
     * @param toUnit The <code>String</code> to set toUnit
     * @param conversionRatio The <code>double</code> value for conversionRatio
     */
    public Conversion (String fromUnit, String toUnit, double conversionRatio) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.conversionRatio = conversionRatio;
    }
    
    /**
     * Sets the unit <code>fromUnit</code> to the passed parameter
     * @param fromUnit The parameter to set <code>fromUnit</code>
     */
    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }
    
    /**
     * Sets the unit <code>toUnit</code> to the passed parameter
     * @param toUnit The parameter to set <code>toUnit</code>
     */
    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }
    
    /**
     * Sets the unit <code>conversionRatio</code> to the passed parameter
     * @param conversionRatio The parameter to set <code>conversionRatio</code>
     */
    public void setConverionRatio(double conversionRatio) {
        this.conversionRatio = conversionRatio;
    }
    
    /**
     * Function to return the <code>fromUnit</code> <code>String</code>
     * @return Returns a string contained in <code>fromUnit</code>
     */
    public String getFromUnit() {
        return this.fromUnit;
    }
    
    /**
     * Function to return the <code>fromUnit</code> <code>String</code>
     * @return Returns a <code>String</code> contained in <code>toUnit</code>
     */
    public String getToUnit() {
        return this.toUnit;
    }
    
    /**
     * Function to return the <code>conversionRatio</code>
     * @return Returns a <code>double</code> value
     *      contained in <code>toUnit</code>
     */
    public Double getConverionRatio() {
        return this.conversionRatio;
    }
    
    /**
     * Performs the conversion according to the <code>fromValue</code> that 
     *      is passed as a parameter and displays the conversion.
     * @param <code>fromValue<code> The value to be converted into the
     *      <code>toValue</code>
     */
    public void performConversion(double fromValue) {
        this.fromValue = fromValue;
        this.toValue = fromValue * conversionRatio;
        BigDecimal roundedValue = 
                new BigDecimal(this.toValue).setScale(4, RoundingMode.HALF_UP);
        this.toValue = roundedValue.doubleValue();
        Console.displayLine(toString());
    }
    
    /**
     * Generates a <code>String</code> stating the units
     *      and values after conversion.
     * @return A <code>String</code> containing the units
     *      and values after conversion
     */
    public String toString() {
        return fromValue + " " + fromUnit + " = " + toValue + " " + toUnit;
    }
}
