package menu

class Filter {
    Category category
  String name
    String toString(){
        if(this.category)
        return this.category.name+':'+this.name
    }
    static constraints = {
        name(unique:true)
    }
}
