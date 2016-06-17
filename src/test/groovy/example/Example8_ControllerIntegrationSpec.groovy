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
class Example8_ControllerIntegrationSpec extends Specification{

    @Value("\${local.server.port}")
    int port;

    @Value("\${server.context-path}")
    String contextPath

    @Autowired
    CustomerRepository customerRepository

    @Unroll
    def "create new customer via REST with different params: #params"(){
        setup: "get customer uri"
            RESTClient rest = new RESTClient("http://localhost:$port")
            def uri = "$contextPath/customer"
        when: "call post request to create new customer"
            def response = rest.post(requestContentType : JSON, path : uri, body : params)
        then: "return response status..."
            result == response.status
        where: "with different params"
            result                      | params
            HttpStatus.CREATED.value()  | [name:"fatima", lastName:"casau"]
            //HttpStatus.OK.value()       | [name:"pepito",lastName:"perez"] // this fails
    }

    def "find a person via REST"(){
        given: "an existing person"
            RESTClient rest = new RESTClient("http://localhost:$port")
            def person = customerRepository.findAll()[0]
        and: "people uri"
            def uri = "$contextPath/customer/${person.id}"
        when:
            def result = rest.get(path: uri)
        then:
            result.status == HttpStatus.OK.value()
    }

}
