package cs4760progassign

import grails.gorm.services.Service

@Service(Authors)
interface AuthorsService {

    Authors get(Serializable id)

    List<Authors> list(Map args)

    Long count()

    void delete(Serializable id)

    Authors save(Authors authors)

}