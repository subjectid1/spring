package menu

import grails.gorm.services.Service

@Service(Option)
interface OptionService {

    Option get(Serializable id)

    List<Option> list(Map args)

    Long count()

    void delete(Serializable id)

    Option save(Option option)

}