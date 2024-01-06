package fck

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BusController {

    BusService busService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond busService.list(params), model:[busCount: busService.count()]
    }

    def show(Long id) {
        respond busService.get(id)
    }

    def create() {
        respond new Bus(params)
    }

    def save(Bus bus) {
        if (bus == null) {
            notFound()
            return
        }

        try {
            busService.save(bus)
        } catch (ValidationException e) {
            respond bus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bus.label', default: 'Bus'), bus.id])
                redirect bus
            }
            '*' { respond bus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond busService.get(id)
    }

    def update(Bus bus) {
        if (bus == null) {
            notFound()
            return
        }

        try {
            busService.save(bus)
        } catch (ValidationException e) {
            respond bus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'bus.label', default: 'Bus'), bus.id])
                redirect bus
            }
            '*'{ respond bus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        busService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'bus.label', default: 'Bus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bus.label', default: 'Bus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
