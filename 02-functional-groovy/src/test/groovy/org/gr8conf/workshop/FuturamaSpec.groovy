package org.gr8conf.workshop

import org.gr8conf.workshop.Futurama
import spock.lang.Specification
import spock.lang.Stepwise


@Stepwise
class FuturamaSpec extends Specification{

    void "Retrieve a list of firstnames sorted by the starts age"() {
        when:
        def names = Futurama.moviestars.sort{ it.age }*.firstNames

        then:
        names == ['Amy', 'Phillip J.', 'Turanga', 'Hermes', 'John A.', 'Hubert J.', 'Bender Bending']
    }

    void "Calculate the total number of letters in the firstnames of the moviestars in futorama"() {
        when:
        Integer totalLetters = Futurama.moviestars.collect{ it.firstNames.length() }.sum()

        then:
        totalLetters == 56
    }

    void "Lastnames of stars below the age of 50"() {
        when:
        def names = Futurama.moviestars.findAll{ it.age < 50 }*.lastName

        then:
        names == ['Wong', 'Fry', 'Leela']
    }

    void "Total age of moviestars with the word 'Planet' in the profession"() {
        when:
        def age = Futurama.moviestars.findAll{ it.profession.contains('Planet') }*.age.sum()

        then:
        age == 1398
    }

    void "List of all lastnames in spelled backwards"() {
        when:
        def names = Futurama.moviestars.collect{ it.lastName.reverse() }

        then:
        names == ['gnoW', 'yrF', 'aleeL', 'darnoC', 'grebdioZ', 'htrowsnraF', 'zeugírdoR']

    }

    void "Full name of the star with the longest profession description"() {
        when:
        Moviestar moviestar = Futurama.moviestars.sort{ it.profession.size() }.last()
        String name = "${moviestar.firstNames} ${moviestar.lastName}"

        then:
        name == 'Hubert J. Farnsworth'
    }


    void "Average age of Stars voiced by Billy West"() {
        when:
        List<Moviestar> moviestars = Futurama.moviestars.findAll{ it.voicedBy == 'Billy West' }
        BigDecimal averageAge = 1.0 * moviestars.sum{ it.age } / moviestars.size()

        then:
        averageAge == 110.6666666667
    }
}
