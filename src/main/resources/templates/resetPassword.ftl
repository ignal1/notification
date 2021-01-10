<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.common>
    <div class="text-center my-4">
        <h4>Восстановление пароля</h4>
    </div>
    <div class="alert ${(message!)?contains("emailSent")?then('alert-success', 'alert-danger')}" id="popup">
        <#if message?hasContent && message == "emailSent">
            <span class="vertical-text-align">На указанный email была отправлена ссылка для восстановления пароля.</span>
        <#elseIf message?hasContent && message == "doubleRequestToResetPassword">
            <span class="vertical-text-align">Недопустимое действие (повторный запрос на восстановление пароля).</span>
        <#elseIf message?hasContent && message == "userDoesNotExist">
            <span class="vertical-text-align">Пользователь не существует.</span>
        <#elseIf message?hasContent && message == "cannotSendEmail">
            <span class="vertical-text-align">Невозможно отправить письмо на указанный email.</span>
        </#if>
    </div>
    <div>
        <input hidden id="registration-message" value="${message!}"
    </div>
    <@l.login "/resetPassword" false false true/>
</@c.common>