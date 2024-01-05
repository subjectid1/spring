package menu

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DishesServiceSpec extends Specification {

    DishesService dishesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dishes(...).save(flush: true, failOnError: true)
        //new Dishes(...).save(flush: true, failOnError: true)
        //Dishes dishes = new Dishes(...).save(flush: true, failOnError: true)
        //new Dishes(...).save(flush: true, failOnError: true)
        //new Dishes(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dishes.id
    }

    void "test get"() {
        setupData()

        expect:
        dishesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dishes> dishesList = dishesService.list(max: 2, offset: 2)

        then:
        dishesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dishesService.count() == 5
    }

    void "test delete"() {
        Long dishesId = setupData()

        expect:
        dishesService.count() == 5

        when:
        dishesService.delete(dishesId)
        sessionFactory.currentSession.flush()

        then:
        dishesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dishes dishes = new Dishes()
        dishesService.save(dishes)

        then:
        dishes.id != null
    }
}
