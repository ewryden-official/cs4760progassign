package cs4760progassign

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class BooksControllerSpec extends Specification implements ControllerUnitTest<BooksController>, DataTest {
    void setupSpec(){
        mockDomains Author, Book
    }
    def 'Test the index method returns the correct model'(){
        given:
        new Author(name:"Author A")
                .addToBooks(new Book(title:"Title A", publishYear:1978))
                .save(flush: true, failOnError: true)
        new Author(name:"Author B")
                .addToBooks(new Book(title:"Title B", publishYear:1876))
                .save(flush: true, failOnError: true)
        new Author(name:"Author C")
                .addToBooks(new Book(title:"Title C", publishYear:1876))
                .save(flush: true, failOnError: true)

        when: 'The index action is executed'
        controller.index()

        then: 'The model is correct'
        model.bkList
        model.bkList.size == 3
        model.bkList == [
                [title: "Title A", author: "Author A"],
                [title: "Title B", author: "Author B"],
                [title: "Title C", author: "Author C"]
        ]
    } // End 'Test the index method returns the correct model'
}






