package fck

import grails.gorm.services.Service

@Service(Bus)
interface BusService {

    Bus get(Serializable id)

    List<Bus> list(Map args)

    Long count()

    void delete(Serializable id)

    Bus save(Bus bus)

}