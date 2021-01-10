<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.common>
    <div class="text-center my-4">
        <h4>Вход в аккаутн</h4>
    </div>
    <div class="alert <#if message?? && (message == "codeIsMissing" || message == "cannotResetPassword")>
        alert-danger<#else>alert-success</#if>" id="popup">

        <#if message?hasContent && message == "emailSent">
            <span class="vertical-text-align">На указанный email была отправлена ссылка для подтверждения регистрации.</span>
        <#elseIf message?hasContent && message == "successRegistration">
            <span class="vertical-text-align">Регистрация прошла успешно. Для входа в аккаунт<br>введите логин и пароль.</span>
        <#elseIf message?hasContent && message == "codeIsMissing">
            <span class="vertical-text-align">Код для активации не найден.</span>
        <#elseIf message?hasContent && message == "passwordHasBeenChanged">
            <span class="vertical-text-align">Пароль был изменен.</span>
        <#elseIf message?hasContent && message == "cannotResetPassword">
            <span class="vertical-text-align">Невозможно восстановить пароль по данной ссылке.</span>
        </#if>

    </div>

    <div>
        <input hidden id="registration-message" value="${message!}"
    </div>

   <@l.login "/login" false true false/>
</@c.common>