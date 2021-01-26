package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BooksServiceSpec extends Specification {

    BooksService booksService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Books(...).save(flush: true, failOnError: true)
        //new Books(...).save(flush: true, failOnError: true)
        //Books books = new Books(...).save(flush: true, failOnError: true)
        //new Books(...).save(flush: true, failOnError: true)
        //new Books(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //books.id
    }

    void "test get"() {
        setupData()

        expect:
        booksService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Books> booksList = booksService.list(max: 2, offset: 2)

        then:
        booksList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        booksService.count() == 5
    }

    void "test delete"() {
        Long booksId = setupData()

        expect:
        booksService.count() == 5

        when:
        booksService.delete(booksId)
        sessionFactory.currentSession.flush()

        then:
        booksService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Books books = new Books()
        booksService.save(books)

        then:
        books.id != null
    }
}
