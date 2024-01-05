package menu

import grails.gorm.services.Service

@Service(Filter)
interface FilterService {

    Filter get(Serializable id)

    List<Filter> list(Map args)

    Long count()

    void delete(Serializable id)

    Filter save(Filter filter)

}