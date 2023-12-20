package time

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MemberController {

    MemberService memberService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond memberService.list(params), model:[memberCount: memberService.count()]
    }

    def show(Long id) {
        respond memberService.get(id)
    }

    def create() {
        respond new Member(params)
    }

    def save(Member member) {
        if (member == null) {
            notFound()
            return
        }

        try {
            memberService.save(member)
        } catch (ValidationException e) {
            respond member.errors, view:'create'
            return
        }
     flash.message='member added'
      redirect uri:'/'
    }

    def edit(Long id) {
        respond memberService.get(id)
    }

    def update(Member member) {
        if (member == null) {
            notFound()
            return
        }

        try {
            memberService.save(member)
        } catch (ValidationException e) {
            respond member.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'member.label', default: 'Member'), member.id])
                redirect member
            }
            '*'{ respond member, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        memberService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'member.label', default: 'Member'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'member.label', default: 'Member'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
