package example

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

class Example3_DataDrivenTestingSpec extends Specification{


    def "maximum of two numbers (without data table)"() {
        expect:
            Math.max(1, 3) == 3
            Math.max(7, 4) == 7
            Math.max(0, 0) == 0
    }

    def 'maximum of two numbers (with data table)'() {
        expect:
            Math.max(x, y) == result
        where:
            x  | y  | result
            1  | 3  | 3
            7  | 4  | 7
            0  | 1  | 1
    }

    def 'minimum of two numbers (with data table) - syntactic variation'() {
        expect:
            Math.min(x, y) == result
        where:
            x  | y  || result
            2  | 5  || 2
            -1 | -3 || -3
            1  | 0  || 0
    }

    // Force to fail
    @Unroll
    def 'minimum of two numbers (with data table) using @unroll'() {
        expect:
            Math.min(x, y) == result
        where:
            x  | y  || result
            // 2  | 5  || 5 // This fails
            -1 | -3 || -3
            1  | 0  || 0
    }

    // Force to fail
    @Unroll
    def """maximum of two numbers (with data table) using @unroll with variables:
            The minimun between x:#x and y:#y is #result"""() {
        expect:
            Math.max(x, y) == result
        where:
            x  | y  || result
            1  | 3  || 3
            7  | 4  || 7
            0  | 1  || 1
    }

    def "maximum of two numbers (without data pipes)"() {
        expect:
            Math.max(x, y) == result
        where:
            x << [3, 7, 0]
            y << [5, 0, 0]
            result << [5, 7, 0]
    }

    def 'pair numbers [with pipe lines]'() {
        expect:
            number % 2 == 0

        where:
            number << [2, 4, 6, 20, 84]
    }

    def 'pair numbers [with data table]'() {
        expect:
            number % 2 == 0

        where:
            number  | _
            2       | _
            4       | _
            6       | _
            20      | _
            84      | _
    }

}
