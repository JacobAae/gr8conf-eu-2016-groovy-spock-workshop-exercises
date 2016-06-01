package org.gr8conf.workshop


class MetaclassFun {

    /**
     * Adds a toSnakeCase method to the String class
     */
    static void addSnakeCaseMethodToString() {
        println "Snake case"
        String.metaClass.toSnakeCase = { ->
            String value = delegate
            value.replaceAll(' ', '_')
        }
    }

    /**
     * Adds a toCamelCase method to the String class
     */
    static void addCamelCaseMethodToString() {
        String.metaClass.toCamelCase = { ->
            String value = delegate
            def parts = value.split(' ')
            parts.first() + parts.tail()?.collect{ it.capitalize() }.join('')
        }

    }


    // https://www.mathsisfun.com/roman-numerals.html
    /**
     * Adds a asRomanNumeral method to the Integer class that if the number is between 1 and 4000, it
     * returns a String representation in Roman numeral form.
     *
     * See https://www.mathsisfun.com/roman-numerals.html for details
     */
    static void addRomanNumeralMethodToInteger() {
        Integer.metaClass.asRomanNumeral = { ->
            Integer value = delegate
            return MetaclassFun.integerToRomanNumeral(delegate)
        }
    }

    static String integerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }




}
