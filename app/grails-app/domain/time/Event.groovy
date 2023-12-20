package time

class Event {
    Member member
    Task task
    Date date
    int start
    int end
    static constraints = {
      
        start(min:0,max:24)
         end(min:0,max:24)
    }
}
