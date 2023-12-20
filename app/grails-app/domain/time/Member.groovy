package time

class Member {
     String name
     String toString(){
         return this.name
     }
    static constraints = {
        name(unique:true)
    }
}
