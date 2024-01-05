package menu

class Option {
Filter filter
     String name
    String toString(){
        return this.name
    }
    static constraints = {
        name(unique:true)
    }
}
