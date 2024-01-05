package menu

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FilterController {

    FilterService filterService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond filterService.list(params), model:[filterCount: filterService.count()]
    }

    def show(Long id) {
        respond filterService.get(id)
    }

    def create() {
        respond new Filter(params)
    }

    def save(Filter filter) {
        if (filter == null) {
            notFound()
            return
        }

        try {
            filterService.save(filter)
        } catch (ValidationException e) {
            respond filter.errors, view:'create'
            return
        }

        redirect uri:'/?category='+filter.category.id
    }

    def edit(Long id) {
        respond filterService.get(id)
    }

    def update(Filter filter) {
        if (filter == null) {
            notFound()
            return
        }

        try {
            filterService.save(filter)
        } catch (ValidationException e) {
            respond filter.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'filter.label', default: 'Filter'), filter.id])
                redirect filter
            }
            '*'{ respond filter, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        filterService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'filter.label', default: 'Filter'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'filter.label', default: 'Filter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
