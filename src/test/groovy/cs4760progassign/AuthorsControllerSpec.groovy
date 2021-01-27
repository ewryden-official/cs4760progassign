package cs4760progassign

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AuthorsControllerSpec extends Specification implements ControllerUnitTest<AuthorsController>, DataTest {
    void setupSpec(){
        mockDomains Author, Book
    }
    def 'Test the index method returns the correct model'(){
        given:
        new Author(name:"Author A")
                .addToBooks(new Book(title:"Title A1", publishYear:1978))
                .addToBooks(new Book(title:"Title A2", publishYear:1979))
                .save(flush: true, failOnError: true)
        new Author(name:"Author B")
                .addToBooks(new Book(title:"Title B1", publishYear:1876))
                .addToBooks(new Book(title:"Title B2", publishYear:1877))
                .save(flush: true, failOnError: true)

        when: 'The index action is executed'
        controller.index()

        then: 'The model is correct'
        model.authorList
        model.authorList.size == 2
        model.authorList == [
                [name: "Author A", books: ["Title A1", "Title A2"]],
                [name: "Author B", books: ["Title B1", "Title B2"]]
        ]
    } // End 'Test the index method returns the correct model'
}






