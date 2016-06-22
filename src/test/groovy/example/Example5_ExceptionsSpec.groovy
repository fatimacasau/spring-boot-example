package example

import spock.lang.Specification

class Example5_ExceptionsSpec extends Specification{

    def 'Throw NullPointerException'() {

        given: 'a null object'
            Customer customer = null
        when: 'try to access to the object'
            customer.name
        then:'throw a nullpointerexception'
            thrown NullPointerException
//      This block fails
//      when: 'try to call toString method'
//            customer.toString()
//      then:'throw a nullpointerexception'
//            thrown NullPointerException
    }

}
