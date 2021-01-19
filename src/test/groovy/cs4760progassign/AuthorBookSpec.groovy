package cs4760progassign

import grails.testing.gorm.DataTest
import spock.lang.Specification

class AuthorBookSpec extends Specification implements DataTest {
    void setupSpec(){
        mockDomains Author, Book
    }

    void "test basic Author Book persistence"(){
        setup:
        new Author(name:"Stephen King")
                .addToBooks(new Book(title:"The Stand", publishYear:1978))
                .addToBooks(new Book(title:"The Shining", publishYear:1977))
                .save(flush: true, failOnError: true)

        new Author(name:"Mark Twain")
                .addToBooks(new Book(title:"Tom Sawyer", publishYear:1876))
                .addToBooks(new Book(title:"Huckelberry Finn", publishYear:1884))
                .save(flush: true, failOnError: true)


        expect:
        Author.count == 2
        Book.count == 4

        Author.findByName("Stephen King").books.size() == 2
        Author.findByName("Mark Twain").books.size() == 2
    }

}
