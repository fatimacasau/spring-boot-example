package example

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

/**
 * Created by fatimacasau on 25/04/15.
 */
@RepositoryRestResource(exported = false)
interface AddressRepository extends CrudRepository<Address,Long> {
}
