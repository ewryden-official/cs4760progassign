<div class="fieldcontain ${hasErrors(bean: book, field: 'cover', 'error')} ">
    <label for="cover">
        <g:message code="book.cover.label" default="Cover" />
    </label>
    <input style="display:inline" type="file" name="cover" id="cover" accept="image/*" capture />
</div>