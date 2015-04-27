package example

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import static groovyx.net.http.ContentType.JSON

@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader.class,classes = [Application.class])
@IntegrationTest("server.port:0")
class PersonRestSpec extends Specification {

    @Value("\${local.server.port}")
    int port;

    @Value("\${server.context-path}")
    String contextPath

    @Autowired
    PersonRepository personRepository

    @Unroll
    def "create new person via REST with different params: #params"(){
        setup: "people uri"
            RESTClient rest = new RESTClient("http://localhost:$port")
            def uri = "$contextPath/people"
        expect: "status ok"
            result == rest.post(requestContentType : JSON, path : uri, body : params).status
        where: "different params"
            result                      | params
            HttpStatus.CREATED.value()  | [firstName:"fatima",lastName:"casau"]
            HttpStatus.OK.value()       | [firstName:"fatima",lastName:"casau",age:29] // this fails
    }

    def "find a person via REST"(){
        given: "an existing person"
            RESTClient rest = new RESTClient("http://localhost:$port")
            def person = personRepository.findAll()[0]
        and: "people uri"
            def uri = "$contextPath/people/${person.id}"
        when:
            def result = rest.get(path: uri)
        then:
            result.status == HttpStatus.OK.value()
    }

}
