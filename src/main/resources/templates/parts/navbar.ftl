<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-dark sticky-top bg-primary" style="border-bottom: 1px solid white; ">
    <div class="container">
        <a class="navbar-brand" href="/">Notification</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_nav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="main_nav">
            <ul class="navbar-nav">
                <#if isAdmin>
                    <li class="nav-item ml-5"><a class="nav-link" href="/user">User list</a></li>
                    <li class="nav-item ml-3"><a class="nav-link" href="/file/template">Template</a></li>
                    <li class="nav-item dropdown ml-3">
                        <a class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown">More items</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/settings">Settings</a></li>
                            <li><a class="dropdown-item" href="/uploadOldTemplate">Old template</a></li>
                        </ul>
                    </li>
                </#if>
            </ul>
            <ul class="navbar-nav ml-auto">
                <#if !user?? || name=="unknown">
                    <li class="nav-item"><a class="nav-link" href="/login">Войти</a></li>
                    <li class="nav-item"><a class="nav-link" href="/registration">Зарегистрироваться</a></li>
                <#else>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">${name}</a>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li><a class="dropdown-item" href="/user/profile">Мой профиль</a></li>
                            <#-- href="/file/${user.username} и перенести этот мапинг из UserController
                             в FileController -->
                            <li><a class="dropdown-item" href="/file/${name}">Файлы</a></li>
                            <#if !isAdmin><li><a class="dropdown-item" href="/user/deleteUser">Удалить</a></li></#if>
                            <li><a class="dropdown-item" href="javascript:document.logoutForm.submit()">Выйти</a></li>
                        </ul>
                    </li>
                </#if>
                <@l.logout/>
            </ul>
        </div>
    </div>
</nav>
