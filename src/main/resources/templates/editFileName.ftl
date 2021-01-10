<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">

            <div class="card border-primary mb-3" style="min-height: 50px;">
                <div class="card-header">
                    Информация о файле
                    ${message?ifExists}
                </div>
                <div class="card-body mt-4">

                    <div class="row">

                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">
                            <form method="post">

                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Имя файла:</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="userFileName" class="form-control" value="${fileInf.userFileName!''}" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Комментарий:</label>
                                    <div class="col-sm-9">
                                        <textarea rows="10" name="commentary" class="form-control">${fileInf.commentary!''}</textarea>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Дата загрузки:</label>
                                    <div class="col-sm-9">
                                        <label class="col-form-label">${fileInf.dateOfUpload!''}</label>
                                    </div>
                                </div>

                                <input type="hidden" name="id" value="${fileInf.id!''}" />
                                <input type="hidden" name="directory" value="${directory}" />
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />

                                <button class="btn btn-primary my-2" type="submit">Сохранить</button>
                            </form>
                        </div>
                        <div class="col-sm-1"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>

</@c.common>