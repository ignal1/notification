<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="card border-primary mb-3 mx-auto" style="min-height: 550px;">
                <div class="card-header">
                    <strong>${username}</strong>
                    <a class="edit-block" href="/user/update" style="float: right;">Редактировать</a>
                </div>
                <div class="card-body">

                    <table class="table mb-5" >
                        <tbody>
                            <tr>
                                <th>Имя</th>
                                <td id="profileDataColumn">${firstName!''}</td>
                            </tr>
                                <th>Фамилия</td>
                                <td id="profileDataColumn">${lastName!''}</td>
                            </tr>
                                <th>Компания</td>
                                <div>
                                    <td id="profileDataColumn">${company!''}</td>
                                </div>
                            </tr>
                                <th>Email</td>
                                <td id="profileDataColumn">${email!''}</td>
                            </tr>
                            </tr>
                                <th>Статус аккаунта</td>
                                <td>
                                    <#if approved>
                                        <div class="text-success">Активирован</div>
                                    <#else>
                                        <div class="text-danger">Не активирован</div>
                                    </#if>
                                </td>
                            </tr>
                            </tr>
                                <td></td>
                                <td></td>
                            </tr>
                            </tbody>
                    </table>
                    <div class="text-justify mb-4">
                        Статус аккаунта <span class="text-danger">Не активирован</span> означает,
                        что пользователю доступна ограниченная функциональность. Установлено ограничение
                        на максимальное количество строк в таблице subjects шаблона (не более 5 строк).
                        Для снятия данного ограничения необходимо отправить запрос администратору сайта.
                    </div>
                    <form action="/user/approvalRequest" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary my-2">Отправить запрос</button>
                    </form>
                </div>
            </div>

        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
<div class="alert alert-success" id="popup">

    <#if message?hasContent && message == "requestHasBeenSent">
        <span class="vertical-text-align">Ваш запрос отправлен!</span>
    <#elseIf message?hasContent && message == "requestIsBeingProcessed">
        <span class="vertical-text-align">Ваш запрос обрабатывается!</span>
    <#elseIf message?hasContent && message == "yourAccountIsApproved">
        <span class="vertical-text-align">Ваш аккаунт одобрен!</span>
    </#if>

</div>
<div>
    <input hidden id="registration-message" value="${message!}"
</div>

</@c.common>