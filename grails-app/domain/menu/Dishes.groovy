package menu

class Dishes {
     Category category
     byte[] image
     int price
     int buyer=0
     String name
    static hasMany = [options: Option]
    static constraints = {
        image(maxSize:128000)
        buyer(display:false)
        options(display:false)
        category(display:false)
    }
}
