<#import "parts/common.ftl" as c>

<@c.common>

<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="card border-primary mb-3" style="min-height: 50px;">
                <div class="card-header">
                    Редактирование настроек
                </div>
                <div class="card-body mt-4">
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">
                            <form method="post">
                                <div class="form-group row">
                                    <label class="col-sm-5">limitation_is_on:</label>
                                    <div class="col-sm-7">
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input" name="limitation"
                                                ${limitation?string("checked", "")}>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" value="${_csrf.token}" name="_csrf">
                                <button type="submit" class="btn btn-primary ">Save</button>
                            </form>
                            <hr>
                            <form method="get" action="/file/delete/common">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button class="btn btn-primary" type="submit">Очистить директорию common</button>
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
