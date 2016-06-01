package org.gr8conf.workshop

import spock.lang.Specification

class MetaclassFunSpec extends Specification {

    void "String have snake case method"() {
        setup:
        MetaclassFun.addSnakeCaseMethodToString()

        expect:
        input.toSnakeCase() == output

        where:
        input                           | output
        "normal string with spaces"     | "normal_string_with_spaces"
        "no-spaces"                     | "no-spaces"
        "under_line"                    | "under_line"
    }

    void "String have camel case method"() {
        setup:
        MetaclassFun.addCamelCaseMethodToString()

        expect:
        input.toCamelCase() == output

        where:
        input                           | output
        "normal string with spaces"     | "normalStringWithSpaces"
        "no-spaces"                     | "no-spaces"
        "under_line"                    | "under_line"
    }


    void "roman numeral method on integer"() {
        setup:
        MetaclassFun.addRomanNumeralMethodToInteger()

        when:
        Integer i = number

        then:
        i.asRomanNumeral() == romanNumeral

        where:
        number      | romanNumeral
        1           | "I"
        2           | "II"
        3           | "III"
        4           | "IV"
        5           | "V"
        6           | "VI"
        7           | "VII"
        8           | "VIII"
        9           | "IX"
        10          | "X"
        20          | "XX"
        40          | "XL"
        49          | "XLIX"
        3999        | "MMMCMXCIX"
    }

    void "if the integer is negative or greater than or equal to 4000 'Invalid Roman Number Value' is returned"() {
        setup:
        MetaclassFun.addRomanNumeralMethodToInteger()

        when:
        Integer i = number

        then:
        i.asRomanNumeral() == 'Invalid Roman Number Value'

        where:
        number << [-1, 400]

    }
}
