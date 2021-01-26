package cs4760progassign

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class BooksControllerSpec extends Specification implements ControllerUnitTest<BooksController>, DomainUnitTest<Books> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.booksList
        model.booksCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.books!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/books/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * save(_ as Books)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def books = new Books(params)
        books.id = 1

        controller.save(books)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/books/show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * save(_ as Books) >> { Books books ->
                throw new ValidationException("Invalid instance", books.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def books = new Books()
        controller.save(books)

        then:"The create view is rendered again with the correct model"
        model.books != null
        view == 'create'
    }

    void "Test the show action with a null id"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the show action with a valid id"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * get(2) >> new Books()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        model.books instanceof Books
    }

    void "Test the edit action with a null id"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * get(2) >> new Books()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.books instanceof Books
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/books/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * save(_ as Books)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def books = new Books(params)
        books.id = 1

        controller.update(books)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/books/show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * save(_ as Books) >> { Books books ->
                throw new ValidationException("Invalid instance", books.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new Books())

        then:"The edit view is rendered again with the correct model"
        model.books != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/books/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.booksService = Mock(BooksService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/books/index'
        flash.message != null
    }
}






