<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.common>
    <div class="text-center my-4">
        <h4>Регистрация</h4>
    </div>
    <div class="alert alert-danger" id="popup">
        <#if message?? && message == "userExists">
            <span class="vertical-text-align">Пользователь существует!</span>
        <#elseIf message?? && message == "cannotSendEmail">
            <span class="vertical-text-align">Невозможно отправить письмо на указанный email.</span>
        </#if>
    </div>
    <div>
        <input hidden id="registration-message" value="${message!}"
    </div>
<@l.login "/registration" true false false/>
</@c.common>