<#macro upload>
    <form hidden method="post" enctype="multipart/form-data" action="/file/convert/common">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <label class="btn btn-primary my-2" id="fileUploadControl">
            <input type="file" accept=".xlsx" name="file" hidden onchange="submit(); this.value=null">Загрузить
        </label>
    </form>
</#macro>