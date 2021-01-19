package cs4760progassign

class Book {

    String title
    Integer publishYear

    static belongsTo = [author: Author]

    static constraints = {
    }
}
