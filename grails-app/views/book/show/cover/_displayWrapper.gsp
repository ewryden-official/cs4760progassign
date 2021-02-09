<g:if test="${book?.cover}">
    <li class="fieldcontain">
        <span id="cover-label" class="property-label">
            <g:message code="book.cover.label" default="Cover: " />
        </span>
        <img class="property-value" alt="Missing Cover" src="${createLink(controller:'book', action:'showCover', id:"${book.id}")}">
    </li>
</g:if>