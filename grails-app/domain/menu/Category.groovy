package menu

class Category {
    String name
    String toString(){
        return this.name
    }
    static constraints = {
        name(unique:true)
    }
}
