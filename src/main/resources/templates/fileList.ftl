<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-8">

            <div class="card border-primary mx-auto" style="min-height: 190px;">
                <div class="card-header">
                    Файлы
                </div>
                <div class="card-body">

                    <table class="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Файл</th>
                                <th></th>
                                <th>Дата загрузки</th>
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <#list list! as item>
                                <tr>
                                    <th>${item[0]?ifExists}</th>
                                    <td id="fileNameColumn">
                                        <a href="${item[1]?ifExists}" title="${item[2]?ifExists}">${item[2]?ifExists}</a>
                                    </td>
                                    <td>
                                        <#-- Вставка иконки карандаша со ссылкой для редактирования имени файла. -->
                                        <a href="${item[4]?ifExists}">
                                            <svg class="bi bi-pencil text-primary" alt="Редактировать" fill="currentColor" xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/></svg>
                                        </a>
                                    </td>
                                    <td>${item[5]?ifExists}</td>
                                    <td><a href="${item[6]?ifExists}">Конвертировать</a></td>
                                    <td><a href="${item[7]?ifExists}">Удалить</a></td>
                                    <td>
                                        <div title="${item[3]?ifExists}" alt="">
                                            <svg class="bi bi-chat-left-text text-primary" fill="currentColor" xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v11.586l2-2A2 2 0 0 1 4.414 11H14a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                <path fill-rule="evenodd" d="M3 3.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 6a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 6zm0 2.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                                            </svg>
                                        </div>
                                    </td>
                                </tr>
                            </#list>

                            </tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>

                            </tr>

                        </tbody>

                    </table>

                    <form method="post" enctype="multipart/form-data" action="/file/uploadFile">
                        <input type="hidden" name="dir" value="<#if user??>${name}</#if>" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <label class="btn btn-primary my-2">
                            <input <#if disabled>disabled</#if> type="file" accept=".xlsx" name="file" hidden onchange="submit()">Загрузить
                        </label>
                        <span style="float: right; line-height: 54px"> Можно загрузить не более 5 файлов.</span>
                    </form>
                </div>
            </div>

        </div>
        <div class="col-sm-2">
        </div>
    </div>
</div>

</@c.common>