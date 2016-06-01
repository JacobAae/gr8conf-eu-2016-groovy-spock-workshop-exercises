package org.gr8conf.workshop

import org.gr8conf.workshop.Futurama
import spock.lang.Specification
import spock.lang.Stepwise


@Stepwise
class FuturamaSpec extends Specification{

    void "Retrieve a list of firstnames sorted by the starts age"() {
        when:
        def names = Futurama.moviestars // TODO

        then:
        names == ['Amy', 'Phillip J.', 'Turanga', 'Hermes', 'John A.', 'Hubert J.', 'Bender Bending']
    }

    void "Calculate the total number of letters in the firstnames of the moviestars in futorama"() {
        when:
        def totalLetters = Futurama.moviestars // TODO

        then:
        totalLetters == 56
    }

    void "Lastnames of stars below the age of 50"() {
        when:
        def names = Futurama.moviestars // TODO

        then:
        names == ['Wong', 'Fry', 'Leela']
    }

    void "Total age of moviestars with the word 'Planet' in the profession"() {
        when:
        def age = Futurama.moviestars // TODO

        then:
        age == 1398
    }

    void "List of all lastnames in spelled backwards"() {
        when:
        def names = Futurama.moviestars // TODO

        then:
        names == ['gnoW', 'yrF', 'aleeL', 'darnoC', 'grebdioZ', 'htrowsnraF', 'zeugírdoR']

    }

    void "Full name of the star with the longest profession description"() {
        when:

        String name = ""  // TODO

        then:
        name == 'Hubert J. Farnsworth'
    }


    void "Average age of Stars voiced by Billy West"() {
        when:
        def averageAge = 1.0  // TODO

        then:
        averageAge == 110.6666666667
    }
}
