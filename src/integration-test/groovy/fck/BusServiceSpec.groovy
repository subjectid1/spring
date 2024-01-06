package fck

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BusServiceSpec extends Specification {

    BusService busService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Bus(...).save(flush: true, failOnError: true)
        //new Bus(...).save(flush: true, failOnError: true)
        //Bus bus = new Bus(...).save(flush: true, failOnError: true)
        //new Bus(...).save(flush: true, failOnError: true)
        //new Bus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //bus.id
    }

    void "test get"() {
        setupData()

        expect:
        busService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Bus> busList = busService.list(max: 2, offset: 2)

        then:
        busList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        busService.count() == 5
    }

    void "test delete"() {
        Long busId = setupData()

        expect:
        busService.count() == 5

        when:
        busService.delete(busId)
        sessionFactory.currentSession.flush()

        then:
        busService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Bus bus = new Bus()
        busService.save(bus)

        then:
        bus.id != null
    }
}
