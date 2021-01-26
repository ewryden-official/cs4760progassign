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
            <li class="nav-item"><a class="nav-link" href="#">Books</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Authors</a></li>
        </ul>
    </div>


</nav>