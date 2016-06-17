package example

import spock.lang.IgnoreIf
import spock.lang.Requires

// spock imports
import spock.lang.Shared
import spock.lang.Specification
import spock.util.environment.OperatingSystem

import static Example1_IntroSpec.isFriendsCharacter

class Example1_IntroSpec extends Specification {

    def fieldCount = 0

    @Shared sharedCount = 0

    // Fixture methods

    def setupSpec() {
        println "setupSpec: run before the first feature method. \n"
    }

    def setup() {
        println "setup: run before every feature method. sharedCount = $sharedCount, fieldCount = $fieldCount"
    }

    def cleanup() {
        println "cleanup: run after every feature method. sharedCount $sharedCount, fieldCount = $fieldCount"
    }

    def cleanupSpec() {
        println "cleanSpec: run after the last feature method."
    }

    // Feature Methods

    def "Change shareable and instance field first time"(){
        setup:
            sharedCount++
            fieldCount++
        expect:
            println "first time"
            sharedCount == 1
            fieldCount == 1
    }

    def "Change shareable and instance field second time"(){
        setup:
            sharedCount++
            fieldCount++
        expect:
            println "second time"
            sharedCount == 2
            fieldCount == 1

    }

    // Some extensiones

    @Requires({ OperatingSystem.current.macOs })
    void 'only run on MacOS'() {
        expect:
            println 'MacOS'
            true
    }

    @IgnoreIf({ isFriendsCharacter("Rachel") })
    void 'run if is a friend character'() {
        expect:
            true
    }

    static boolean isFriendsCharacter(String name) {
        name in ['Rachel', 'Monica', 'Phoebe', 'Joey', 'Chandler', 'Ross']
    }

}
