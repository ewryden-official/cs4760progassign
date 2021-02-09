<g:if test="${book?.author}">
    <li class="fieldcontain">
        <span id="author-label" class="property-label">
            <g:message code="book.author.label" default="Author" />
        </span>
        <span class="property-value">
            <g:link controller="author" action="show" id="${book?.author?.id}">
                ${book?.author?.encodeAsHTML()}
            </g:link>
        </span>
    </li>
</g:if>