package cs4760progassign

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BooksController {

    BooksService booksService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond booksService.list(params), model:[booksCount: booksService.count()]
    }

    def show(Long id) {
        respond booksService.get(id)
    }

    def create() {
        respond new Books(params)
    }

    def save(Books books) {
        if (books == null) {
            notFound()
            return
        }

        try {
            booksService.save(books)
        } catch (ValidationException e) {
            respond books.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'books.label', default: 'Books'), books.id])
                redirect books
            }
            '*' { respond books, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond booksService.get(id)
    }

    def update(Books books) {
        if (books == null) {
            notFound()
            return
        }

        try {
            booksService.save(books)
        } catch (ValidationException e) {
            respond books.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'books.label', default: 'Books'), books.id])
                redirect books
            }
            '*'{ respond books, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        booksService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'books.label', default: 'Books'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'books.label', default: 'Books'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
