package example

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.config.RepositoryConfiguration
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.config.RepositoryRestConfiguration

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
interface PersonRepository extends CrudRepository<Person,Long> {

    List<Person> findByLastName(@Param("lastname") String lastname)

    @Query("select p from Person p where p.firstName like %?1")
    List<Person> findByFirstNameEndsWith(@Param("firstname") String firstname)

    @Query(value = "SELECT * FROM PERSON WHERE AGE BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Person> findByAgeBetween(@Param("from") Integer from, @Param("to") Integer to)

    @Query("select p from Person p where p.firstName = :firstname or p.lastName = :lastname")
    List<Person> findByLastnameOrFirstname(@Param("lastname") String lastname,
                                     @Param("firstname") String firstname)

}
