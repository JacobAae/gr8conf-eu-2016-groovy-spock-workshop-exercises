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
        if( !heightInCm || !weightInKg) {
            return null
        }
        if( heightInCm < 0 || weightInKg < 0) {
            throw new IllegalArgumentException()
        }
        def heightInMeters = heightInCm / 100
        weightInKg / (heightInMeters * heightInMeters )
    }

    /**
     *  a BMI from 18.5 up to 25 may indicate optimal weight, a BMI lower than 18.5 suggests the person is underweight,
     *  a number from 25 up to 30 may indicate the person is overweight, and a number from 30 upwards suggests the
     *  person is obese.
     * @return String representation
     */
    String getDescription() {
        def bmi = calculatedBMI

        if( bmi <= 18.5 ) {
            return 'Underweight'
        }
        if( bmi <= 25) {
            return 'Optimal weight'
        }
        if( bmi <= 30) {
            return 'Overweight'
        }
        return 'Obese'
    }
}
