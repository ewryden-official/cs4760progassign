<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="site"/>
    <title>Book Store Books</title>
    <style>
        img {
            width: 250px;
            height: 250px;
        }
    </style>
</head>

<body>
<h1> BOOKS </h1>
<ul>
    <g:each in="${bkList}">
        <li> ${it.title} by ${it.author} </li>
        <img src="${createLink(controller:'book', action:'showCover', id:"${it.id}")}" class="img-thumbnail" alt="Missing Cover">
    </g:each>
</ul>
</body>
</html>