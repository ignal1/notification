<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class="card border-primary mb-3" style="min-height: 250px;">
                <div class="card-header">
                    Редактирование пользователя
                </div>
                <div class="card-body mt-4">
                    <div class="row">
                        <div class="col-sm-1"></div>
                            <div class="col-sm-10">
                                <form action="/user" method="post">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Username:</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control ${(message??)?string('is-invalid', '')}"
                                                   name="username" value="${user.username}">
                                            <#if message??>
                                                <div class="invalid-feedback">
                                                    ${message}
                                                </div>
                                            </#if>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-3">Roles</div>
                                        <div class="col-sm-9">
                                            <div class="form-check">

                                                <#list roles as role>
                                                    <div>
                                                        <label class="form-check-label">
                                                            <input class="form-check-input" type="checkbox" name="${role}"
                                                                    ${user.roles?seq_contains(role)?string("checked", "")}>
                                                            ${role}
                                                        </label>
                                                    </div>
                                                </#list>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3">Active:</label>
                                        <div class="col-sm-9">
                                            <div class="form-check">
                                            <input type="checkbox" class="form-check-input" name="active"
                                                ${user.active?string("checked", "")}>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-3">Approved:</div>
                                        <div class="col-sm-9">
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input" name="approved"
                                                    ${user.approved?string("checked", "")}>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Expiration:</label>
                                        <div class="col-sm-9">
                                            <input type="date" class="form-control"
                                                   name="dateOfExpiration"
                                                   value="<#if user.expiryDateOfApproval??>${user.expiryDateOfApproval?string('yyyy-MM-dd')}</#if>">
                                        </div>
                                    </div>
                                    <input type="hidden" value="${user.id}" name="userId">
                                    <input type="hidden" value="${_csrf.token}" name="_csrf">

                                    <button type="submit" class="btn btn-primary my-3">Save</button>
                                </form>
                            </div>
                        <div class="col-sm-1"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>

</@c.common>
