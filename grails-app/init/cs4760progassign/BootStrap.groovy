package cs4760progassign

class BootStrap {

    def init = { servletContext ->
        new Author(name:"Stephen King")
                .addToBooks(new Book(title:"The Stand", publishYear:1978))
                .addToBooks(new Book(title:"The Shining", publishYear:1977))
                .save()

        new Author(name:"Mark Twain")
                .addToBooks(new Book(title:"Tom Sawyer", publishYear:1876))
                .addToBooks(new Book(title:"Huckelberry Finn", publishYear:1884))
                .save()

    }
    def destroy = {
    }
}
