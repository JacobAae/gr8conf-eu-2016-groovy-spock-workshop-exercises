package org.gr8conf.workshop

import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

@Stepwise
class PersonSpec extends Specification {

    void "BMI is calculated correctly"() {
        setup:
        Person person = new Person(heightInCm: heightInCm, weightInKg: weightInKg)

        expect:
        person.calculatedBMI == expectedBMI

        where:
        heightInCm      | weightInKg    || expectedBMI
        180             | 100           || 30.8641975309
        170             | 65            || 22.4913494810
    }

    void "calculatedBMI is robust for null input"() {
        when:
        new Person().calculatedBMI

        then:
        noExceptionThrown()
    }

    void "calculatedBMI throws exception for negative inputs"() {
        setup:
        Person person = new Person(heightInCm: heightInCm, weightInKg: weightInKg)

        when:
        person.calculatedBMI

        then:
        thrown(IllegalArgumentException)

        where:
        heightInCm      | weightInKg
        180             | -1
        -1              | 80
    }

    @Unroll
    void "Description should be correct - #comment"() {
        setup:
        Person person = new Person(heightInCm: heightInCm, weightInKg: weightInKg)

        expect:
        person.description == description

        where:
        heightInCm      | weightInKg    || description          | comment
        180             | 59            || 'Underweight'        | "bmi <= 18.5 is underweight"
        180             | 60            || 'Optimal weight'     | "18.5 < bmi <= 25 is Optimal weight"
        180             | 81            || 'Optimal weight'     | "18.5 < bmi <= 25 is Optimal weight"
        180             | 90            || 'Overweight'        | "25 < bmi <= 30 is Overweight"
        180             | 100           || 'Obese'              | "30 < bmi is Obese"
    }


}
