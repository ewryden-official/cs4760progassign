<g:if test="${book?.title}">
    <li class="fieldcontain">
        <span id="title-label" class="property-label">
            <g:message code="book.title.label" default="Title" />
        </span>
        <span class="property-value" aria-labelledby="title-label">
            <g:fieldValue bean="${book}" field="title"/>
        </span>
    </li>
</g:if>