package cs4760progassign

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AuthorsController {

    AuthorsService authorsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond authorsService.list(params), model:[authorsCount: authorsService.count()]
    }

    def show(Long id) {
        respond authorsService.get(id)
    }

    def create() {
        respond new Authors(params)
    }

    def save(Authors authors) {
        if (authors == null) {
            notFound()
            return
        }

        try {
            authorsService.save(authors)
        } catch (ValidationException e) {
            respond authors.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'authors.label', default: 'Authors'), authors.id])
                redirect authors
            }
            '*' { respond authors, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond authorsService.get(id)
    }

    def update(Authors authors) {
        if (authors == null) {
            notFound()
            return
        }

        try {
            authorsService.save(authors)
        } catch (ValidationException e) {
            respond authors.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'authors.label', default: 'Authors'), authors.id])
                redirect authors
            }
            '*'{ respond authors, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        authorsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'authors.label', default: 'Authors'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'authors.label', default: 'Authors'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
