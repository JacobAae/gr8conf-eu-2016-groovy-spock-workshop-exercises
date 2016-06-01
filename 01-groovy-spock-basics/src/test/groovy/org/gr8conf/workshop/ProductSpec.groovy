package org.gr8conf.workshop

import spock.lang.Specification
import spock.lang.Stepwise


@Stepwise
class ProductSpec extends Specification {

    void "product is only valid if percentages sum to at most 100"() {
        setup:
        Product product = new Product(fat: fat, carbohydrate: carbohydrate, protein: protein, alcohol: alcohol)

        expect:
        product.valid == valid

        where:
        fat     | carbohydrate  | protein   | alcohol   || valid
        10      | 10            | 10        | 10        || true
        25      | 25            | 25        | 25        || true
        26      | 25            | 25        | 25        || false
        0       | 100.00001     | 0         | 0         || false
    }

    void "null input should count as zero"() {
        setup:
        Product product = new Product(fat: fat, carbohydrate: carbohydrate, protein: protein, alcohol: alcohol)

        expect:
        product.sum == 30

        where:
        fat     | carbohydrate  | protein   | alcohol
        null    | 10            | 10        | 10
        10      | null          | 10        | 10
        10      | 10            | null      | 10
        10      | 10            | 10        | null
    }

    void "Water content is the remaining"() {
        setup:
        Product product = new Product(fat: 10, carbohydrate: 10, protein: 10, alcohol: 10)

        expect:
        product.waterContent == 60
    }

    void "Water content is null if the product is not valid"() {
        setup:
        Product product = new Product(fat: 25, carbohydrate: 25, protein: 25, alcohol: 26)

        expect:
        product.waterContent == null
    }

    void "ToString method shows a nice representation"() {
        setup:
        Product product = new Product(name: 'Food', fat: 25, carbohydrate: 25, protein: 25, alcohol: 25)

        expect:
        product.toString() == "Product(name:Food, fat:25, carbohydrate:25, protein:25, alcohol:25)"
    }

    void "Total energy must be calculated correctly"() {
        setup:
        Product product = new Product(fat: fat, carbohydrate: carbohydrate, protein: protein, alcohol: alcohol)

        expect:
        product.getTotalEnergy(100) == totalEnergy

        where:
        fat     | carbohydrate  | protein   | alcohol   | amount    || totalEnergy
        1       | 0             | 0         | 0         | 100       || 37
        0       | 1             | 0         | 0         | 100       || 17
        0       | 0             | 1         | 0         | 100       || 17
        0       | 0             | 0         | 1         | 100       || 30
        10      | 10            | 10        | 10        | 1000      || 1010
    }

    /*
    Calculate the energy in a BigMac
    https://www.mcdonalds.dk/content/dam/Denmark/Downloads/Filer/ernaeringsfolder_Jan_2016.pdf
     */
    void "BigMac is calculated correctly"() {
        when:
        Product bigMac = new Product(fat: 13.026, carbohydrate: 21.042, protein: 13.527, alcohol: null)

        then:
        bigMac.getTotalEnergy(200) == 2139.27
    }

}
