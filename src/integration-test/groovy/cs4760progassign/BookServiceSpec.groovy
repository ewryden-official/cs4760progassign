package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BookServiceSpec extends Specification {

    BookService bookService
    SessionFactory sessionFactory

    private Long setupData() {
        // Need to remove all data from tables just in case hibernate is already running.
        // https://stackoverflow.com/questions/8160296/grails-delete-all-data-from-table-domain-class-i-e-deleteall
        // Note even the deletes will be rolled backed.
        Book.executeUpdate('delete from Book')
        Author.executeUpdate('delete from Author')

        // Add to the tables
        Author testAuthor = new Author(name: "Test Author").save(flush: true, failOnError: true)
        Book book0 = new Book(title: "Test Book 0", publishYear: 1999, author: testAuthor).save(flush: true, failOnError: true)
        new Book(title: "Test Book 1", publishYear: 1999, author: testAuthor).save(flush: true, failOnError: true)
        new Book(title: "Test Book 2", publishYear: 1999, author: testAuthor).save(flush: true, failOnError: true)
        new Book(title: "Test Book 3", publishYear: 1999, author: testAuthor).save(flush: true, failOnError: true)
        new Book(title: "Test Book 4", publishYear: 1999, author: testAuthor).save(flush: true, failOnError: true)

        book0.id
    }

    void "test get"() {
        Long bookId = setupData()

        expect:
        bookService.get(bookId) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Book> bookList = bookService.list(max: 2, offset: 2)

        then:
        bookList.size() == 2
//        assert false, "TODO: Verify the correct instances are returned"
        bookList[0].title.contains("Test Book ")
        bookList[1].title.contains("Test Book ")
    }

    void "test count"() {
        setupData()

        expect:
        bookService.count() == 5
    }

    void "test delete"() {
        Long bookId = setupData()

        expect:
        bookService.count() == 5

        when:
        bookService.delete(bookId)
        sessionFactory.currentSession.flush()

        then:
        bookService.count() == 4
    }

    void "test save"() {
        when:
//        assert false, "TODO: Provide a valid instance to save"
        Author author = new Author(name: "Author").save(flush: true, failOnError: true)
        Book book = new Book(title: "Test Book", publishYear: 1990, author: author)
        bookService.save(book)

        then:
        book.id != null
    }
}
