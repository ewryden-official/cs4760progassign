<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="site"/>
    <title>Book Store Authors</title>
</head>

<body>
<h1> AUTHORS </h1>
<ul>
    <g:each in="${authorList}">
        <li> ${it.name}</li>
        <g:each in="${it.books}">
            <li> &emsp; ${it.title}</li>
        </g:each>
    </g:each>
</ul>
</body>
</html>