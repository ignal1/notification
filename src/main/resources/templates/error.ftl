<#import "parts/common.ftl" as c>

<@c.common>
<div class="text-center my-4">
    <h4>Ошибка</h4>
    <#if message??>
        ${message}
    <#else>
        <span>В данный момент приложение не может обработать Ваш запрос.
        Попробуйте позже. Если эта ошибка будет возникать в дальнейшем,
        свяжитесь с администратором.</span>
    </#if>
</div>
</@c.common>