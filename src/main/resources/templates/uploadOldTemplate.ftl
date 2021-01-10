<#import "parts/common.ftl" as c>

<@c.common>

<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="card border-primary mb-3" style="min-height: 250px;">
                <div class="card-header">
                    Загрузка старых шаблонов
                </div>
                <div class="card-body mt-4">
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">
                            <table class="table" style="margin: 0">
                                <thead>
                                    <tr>
                                        <th>Файл</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <#list list! as item>
                                    <tr>
                                        <td>${item?ifExists}</td>
                                    </tr>
                                </#list>
                                </tr>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                            <table style="width: 100%">
                                <tr>
                                    <td>
                                        <form method="post" enctype="multipart/form-data" action="/file/uploadFile">
                                            <input type="hidden" name="dir" value="template_old" />
                                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                            <label class="btn btn-primary my-2">
                                                <input type="file" accept=".xlsx" name="file" hidden onchange="submit()">Загрузить
                                            </label>
                                        </form>
                                    </td>
                                    <td style="text-align: right">
                                        <form method="get" action="/file/delete/template_old">
                                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                            <button class="btn btn-primary" type="submit">Очистить директорию template_old</button>
                                        </form>
                                    </td>
                                </tr>
                            </table>
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
