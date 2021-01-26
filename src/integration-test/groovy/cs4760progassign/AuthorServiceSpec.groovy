package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuthorServiceSpec extends Specification {

    AuthorService authorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        Author author = new Author(name: "Test Author 0").save(flush: true, failOnError: true)
        new Author(name: "Test Author 1").save(flush: true, failOnError: true)
        new Author(name: "Test Author 2").save(flush: true, failOnError: true)
        new Author(name: "Test Author 3").save(flush: true, failOnError: true)
        new Author(name: "Test Author 4").save(flush: true, failOnError: true)
        // assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        author.id
    }

    void "test get"() {
        Long authorId = setupData()

        expect:
        authorService.get(authorId) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Author> authorList = authorService.list(max: 2, offset: 2)

        then:
        authorList.size() == 2
        // assert false, "TODO: Verify the correct instances are returned"
        authorList[0].name.contains("Test Author ")
        authorList[1].name.contains("Test Author ")
    }

    void "test count"() {
        setupData()

        expect:
        authorService.count() == 7
    }

    void "test delete"() {
        Long authorId = setupData()

        expect:
        authorService.count() == 7

        when:
        authorService.delete(authorId)
        sessionFactory.currentSession.flush()

        then:
        authorService.count() == 6
    }

    void "test save"() {
        when:
        // assert false, "TODO: Provide a valid instance to save"
        Author author = new Author(name: "Author").save(flush: true, failOnError: true)
        authorService.save(author)

        then:
        author.id != null
    }
}
