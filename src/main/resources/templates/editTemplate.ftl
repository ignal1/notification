<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-8">
            <div class="card border-primary mb-3 mx-auto" style="min-height: 100px;">
                <div class="card-header">
                    Шаблон
                </div>
                <div class="card-body">

                    <table class="table">
                        <thead>
                        <tr>
                            <th>Файл</th>
                            <th>Дата загрузки</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>

                        <#list list! as item>
                            <tr>
                                <td><a href="${item[1]?ifExists}">Шаблон</a></td>
                                <td>${item[5]?ifExists}</td>
                                <td><a href="${item[7]?ifExists}">Удалить</a></td>
                            </tr>
                        </#list>

                        </tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                        </tbody>
                    </table>

                    <form method="post" enctype="multipart/form-data" action="/file/uploadFile">
                        <input type="hidden" name="dir" value="template" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <label class="btn btn-primary my-2">
                            <input <#if disabled>disabled</#if> type="file" accept=".xlsx" name="file" hidden onchange="submit()">Загрузить
                        </label>
                    </form>

                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-2">
        </div>
    </div>
</div>


<div class="alert alert-danger" id="popup">
    <#if message?hasContent && message == "shouldHaveNameTemplate">
        <span class="vertical-text-align">Файл шаблона должен называться "template.xlsx"</span>
    </#if>
</div>

<div>
    <input hidden id="registration-message" value="${message!}"
</div>

</@c.common>