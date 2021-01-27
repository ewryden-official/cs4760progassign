package cs4760progassign

class AuthorsController {
    static final boolean debugIndex = true
    def index() {

        // Author.list() gets all Author instances from the database and puts them in a list.
        def authors = Author.listOrderByName()

        // println outputs to console
        if(debugIndex){
            println ""
            authors.each{
                println it.name+"\n"+it.books.each{println "\t"+it.title}
            }
        }

        // Make a list of all books title and authors
        def authorList = []
        for(int i=0; i<authors.size; i++){
            def authorBooks = [:]
            authorBooks.put('name', authors[i].name)
            authorBooks.put('books', authors[i].books)
            authorList << authorBooks
        }
        if(debugIndex){
            println " "
            println authorList
        }

        // So that the unit test can access the model, we need
        // to explicitly use the render method and specify the model.
        // We also have to explicitly specify the view, or
        // text will be rendered and not the view.
        render view: "index", model: [authorList: authorList]

        // If we did not have to access the model in the view
        // then we could use the default behavior and return
    }
}
