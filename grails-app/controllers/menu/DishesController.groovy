package menu

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DishesController {

    DishesService dishesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def view(){
        Dishes d=Dishes.get(params.id)
        response.outputStream<<d.image
    }
    def buy(){
        Dishes d=Dishes.get(params.id)
        d.buyer++
        dishesService.save(d)
        redirect uri:'/?category='+d.category.id
    }
    def index(Integer max) {
        Category category
        if(params.category)
        category=Category.get(params.category)
        else
        category=Category.all.getAt(0)
        def dishes=Dishes.findAllByCategory(category)
        Filter.findAllByCategory(category).each{
            def options=new ArrayList()
           Option.findAllByFilter(it).eachWithIndex{o,index->
    //println "value " + it + " at index " +index
if(session.(o.id)){options.add(o)}
            }
            if(options.size()>0){
                def ds=new ArrayList<Dishes>(dishes)
            ds.eachWithIndex{d,i->
            options.eachWithIndex{o,index->
            if((!d.options)||!d.options.contains(o))dishes.remove(d)
                    }
                }
            }
        }
      //  params.max = Math.min(max ?: 10, 100)
        //respond dishesService.list(params), model:[dishesCount: dishesService.count()]
   render view:'/index',model:[dishes:dishes]
    }

    def show(Long id) {
        respond dishesService.get(id)
    }

    def create() {
        respond new Dishes(params)
    }

    def save(Dishes dishes) {
        dishes.category=Category.get(params.category)
        if (dishes == null) {
            notFound()
            return
        }
           Filter.findAllByCategory(dishes.category).each{
               Option o=Option.findByNameAndFilter(params.(it.name),it)
               if(o)
               dishes.addToOptions(o)
           }
        try {
            dishesService.save(dishes)
        } catch (ValidationException e) {
            respond dishes.errors, view:'create'
            return
        }

      redirect uri:'/?category='+dishes.category.id
    }

    def edit(Long id) {
        respond dishesService.get(id)
    }

    def update(Dishes dishes) {
        if (dishes == null) {
            notFound()
            return
        }

        try {
            dishesService.save(dishes)
        } catch (ValidationException e) {
            respond dishes.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dishes.label', default: 'Dishes'), dishes.id])
                redirect dishes
            }
            '*'{ respond dishes, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dishesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dishes.label', default: 'Dishes'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dishes.label', default: 'Dishes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
