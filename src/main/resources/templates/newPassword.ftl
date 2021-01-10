<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.common>
    <div class="text-center my-4">
        <h4>Введите новый пароль</h4>
        <span class="star">${message!}</span>
    </div>

    <@l.login "/newPassword" false false false/>
</@c.common>