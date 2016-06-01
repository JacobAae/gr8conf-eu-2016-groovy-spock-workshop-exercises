package org.gr8conf.workshop

/**
 * Person class for BMI calculations
 */
class Person {

    Integer heightInCm
    Integer weightInKg

    /**
     * BMI is calculated as the weight in kg divided by the height in meters squared
     * @return
     */
    BigDecimal getCalculatedBMI() {
        // TODO - Implement me
        return null
    }

    /**
     *  a BMI from 18.5 up to 25 may indicate optimal weight, a BMI lower than 18.5 suggests the person is underweight,
     *  a number from 25 up to 30 may indicate the person is overweight, and a number from 30 upwards suggests the
     *  person is obese.
     * @return String representation
     */
    String getDescription() {
        // TODO - Implement me
        return null
    }
}
