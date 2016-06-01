package org.gr8conf.workshop

import groovy.transform.ToString

/**
 * Class representing a food product and the nutrition for
 */
@ToString(includeNames = true, includePackage = false)
class Product {

    /**
     * The name of the product
     */
    String name

    /**
     * The amount of fat pr 100 grams
     */
    BigDecimal fat

    /**
     * The amount of carbohydrate pr 100 grams
     */
    BigDecimal carbohydrate

    /**
     * The amount of protein pr 100 grams
     */
    BigDecimal protein

    /**
     * The amount of alcohol pr 100 gram.
     */
    BigDecimal alcohol

    /**
     * If sum of content is more than 100% it is not valid
     * @return if the product is clearly invalid, false is returned
     */
    boolean isValid() {
        // TODO - Implement me
        return null
    }

    /**
     * If the content sums to less than 100%, the rest must be water
     * @return
     */
    BigDecimal getWaterContent() {
        // TODO - Implement me
        return null
    }

    /**
     * Utility method that calculate the sum of fat, carbohydrate, protein and alcohol
     * @return
     */
    private getSum() {
        // TODO - Implement me
        return null
    }

    /**
     * Calculates the total energy in kilojoules for the amount of the product from the following formula
     * 1 gram of fat is 37 Kj
     * 1 gram of protein is 17Kj
     * 1 gram of carbohydrate is 17Kj
     * 1 gram of alcohol is 30Kj
     * @param totalWeightInGrams total weight in grams of the product
     * @return the total energy in the amount from the product
     */
    BigDecimal getTotalEnergy(BigDecimal totalWeightInGrams) {
        // TODO - Implement me
        return null
    }

}
