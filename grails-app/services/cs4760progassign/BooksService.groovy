package cs4760progassign

import grails.gorm.services.Service

@Service(Books)
interface BooksService {

    Books get(Serializable id)

    List<Books> list(Map args)

    Long count()

    void delete(Serializable id)

    Books save(Books books)

}