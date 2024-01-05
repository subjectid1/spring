package menu

import grails.gorm.services.Service

@Service(Dishes)
interface DishesService {

    Dishes get(Serializable id)

    List<Dishes> list(Map args)

    Long count()

    void delete(Serializable id)

    Dishes save(Dishes dishes)

}