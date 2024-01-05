package menu

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OptionController {

    OptionService optionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond optionService.list(params), model:[optionCount: optionService.count()]
    }

    def show(Long id) {
        respond optionService.get(id)
    }

    def create() {
        respond new Option(params)
    }

    def save(Option option) {
        if (option == null) {
            notFound()
            return
        }

        try {
            optionService.save(option)
        } catch (ValidationException e) {
            respond option.errors, view:'create'
            return
        }

      redirect uri:'/?category='+option.filter.category.id
    }
    def check(){
        session.(params.id)=!session.(params.id)
     Option o=Option.get(params.id)
        redirect uri:'/?category='+o.filter.category.id
    }

    def edit(Long id) {
        respond optionService.get(id)
    }

    def update(Option option) {
        if (option == null) {
            notFound()
            return
        }

        try {
            optionService.save(option)
        } catch (ValidationException e) {
            respond option.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'option.label', default: 'Option'), option.id])
                redirect option
            }
            '*'{ respond option, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        optionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'option.label', default: 'Option'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'option.label', default: 'Option'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
