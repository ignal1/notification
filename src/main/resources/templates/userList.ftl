<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="card border-primary mx-auto" style="min-height: 50px;">
                <div class="card-header">
                    Список пользователей
                </div>
                <div class="card-body">

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Role</th>
                                <th>Active</th>
                                <th>Approved</th>
                                <th>Expiration</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list users?sort_by("username") as user>
                                <tr>
                                    <td>${user.username}</td>
                                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                                    <td><#if user.active>true<#else>false</#if></td>
                                    <td><#if user.approved>true<#else>false</#if></td>
                                    <td><#if user.expiryDateOfApproval??>${user.expiryDateOfApproval?string('dd.MM.yyyy')}</#if></td>

                                    <td><a href="/user/${user.id}">edit</a></td>
                                    <#if !user.roles?seq_contains(roleAdmin)>
                                        <td><a href="/user/${user.id}/delete">delete</a></td>
                                    </#if>
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

                </div>
            </div>

        </div>
        <div class="col-sm-2"></div>
    </div>
</div>

</@c.common>