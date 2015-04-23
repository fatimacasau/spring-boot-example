package example

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by fcasau on 4/23/15.
 */
@Repository
interface PersonRepository extends CrudRepository<Person,Long> {



}
