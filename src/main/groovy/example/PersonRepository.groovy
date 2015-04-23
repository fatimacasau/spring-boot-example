package example

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * Created by fcasau on 4/23/15.
 */
@Repository
interface PersonRepository extends CrudRepository<Person,Long> {

    List<Person> findByLastName(String name)

    @Query("select p from Person p where p.firstName like %?1")
    List<Person> findByFirstNameEndsWith(String firstname)

    @Query(value = "SELECT * FROM PERSON WHERE AGE BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Person> findByAgeBetween(Integer from, Integer to)

    @Query("select p from Person p where p.firstName = :firstname or p.lastName = :lastname")
    List<Person> findByLastnameOrFirstname(@Param("lastname") String lastname,
                                     @Param("firstname") String firstname)

}
