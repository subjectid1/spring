package time

class Task {
    String title
       String toString(){
         return this.title
     }
    static constraints = {
        title(unique:true)
    }
}
