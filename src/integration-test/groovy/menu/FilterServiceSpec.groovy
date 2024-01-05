package menu

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FilterServiceSpec extends Specification {

    FilterService filterService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Filter(...).save(flush: true, failOnError: true)
        //new Filter(...).save(flush: true, failOnError: true)
        //Filter filter = new Filter(...).save(flush: true, failOnError: true)
        //new Filter(...).save(flush: true, failOnError: true)
        //new Filter(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //filter.id
    }

    void "test get"() {
        setupData()

        expect:
        filterService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Filter> filterList = filterService.list(max: 2, offset: 2)

        then:
        filterList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        filterService.count() == 5
    }

    void "test delete"() {
        Long filterId = setupData()

        expect:
        filterService.count() == 5

        when:
        filterService.delete(filterId)
        sessionFactory.currentSession.flush()

        then:
        filterService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Filter filter = new Filter()
        filterService.save(filter)

        then:
        filter.id != null
    }
}
