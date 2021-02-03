<!DOCTYPE html>
<!-- navbar wrapped with navbar-expand-? for controlling responsiveness -->
<nav class="navbar navbar-expand-md navbar-static-top navbar-dark">

    <!-- The navbar branding. Will appear on the right -->
    <a class="navbar-brand" href="/${grails.util.Metadata.current.getApplicationName()}">
        Book Store
    </a>

    <!-- Hamburger button for toggling. In this location will stay in the above and to the right -->
    <!-- data-target should have the id of the collapsing menu id. -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
        <!-- aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> Don't have to have! -->
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- The collapsing menu -->
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><g:link class="nav-link" controller="Books">Books</g:link></li>
            <li class="nav-item"><g:link class="nav-link" controller="Authors">Authors</g:link></li>
        </ul>
    </div>
    <sec:ifLoggedIn><li class="nav-item"><a class="nav-link" href="#"><sec:username/></a></li></sec:ifLoggedIn>
    <li class="nav-item">
        <sec:ifLoggedIn><g:link class="nav-link" controller="Logout">log out</g:link></sec:ifLoggedIn>
        <sec:ifNotLoggedIn><g:link class="nav-link" controller="login" action="auth">Login</g:link></sec:ifNotLoggedIn>
    </li>


</nav>