package menu

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OptionServiceSpec extends Specification {

    OptionService optionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Option(...).save(flush: true, failOnError: true)
        //new Option(...).save(flush: true, failOnError: true)
        //Option option = new Option(...).save(flush: true, failOnError: true)
        //new Option(...).save(flush: true, failOnError: true)
        //new Option(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //option.id
    }

    void "test get"() {
        setupData()

        expect:
        optionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Option> optionList = optionService.list(max: 2, offset: 2)

        then:
        optionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        optionService.count() == 5
    }

    void "test delete"() {
        Long optionId = setupData()

        expect:
        optionService.count() == 5

        when:
        optionService.delete(optionId)
        sessionFactory.currentSession.flush()

        then:
        optionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Option option = new Option()
        optionService.save(option)

        then:
        option.id != null
    }
}
