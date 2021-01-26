package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuthorsServiceSpec extends Specification {

    AuthorsService authorsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Authors(...).save(flush: true, failOnError: true)
        //new Authors(...).save(flush: true, failOnError: true)
        //Authors authors = new Authors(...).save(flush: true, failOnError: true)
        //new Authors(...).save(flush: true, failOnError: true)
        //new Authors(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //authors.id
    }

    void "test get"() {
        setupData()

        expect:
        authorsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Authors> authorsList = authorsService.list(max: 2, offset: 2)

        then:
        authorsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        authorsService.count() == 5
    }

    void "test delete"() {
        Long authorsId = setupData()

        expect:
        authorsService.count() == 5

        when:
        authorsService.delete(authorsId)
        sessionFactory.currentSession.flush()

        then:
        authorsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Authors authors = new Authors()
        authorsService.save(authors)

        then:
        authors.id != null
    }
}
