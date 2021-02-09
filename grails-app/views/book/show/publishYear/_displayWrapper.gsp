<g:if test="${book?.publishYear}">
    <li class="fieldcontain">
        <span id="publishYear-label" class="property-label">
            <g:message code="book.publishYear.label" default="Publication Year" />
        </span>
        <span class="property-value" aria-labelledby="title-label">
            <g:fieldValue bean="${book}" field="publishYear"/>
        </span>
    </li>
</g:if>