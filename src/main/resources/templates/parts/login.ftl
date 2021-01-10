<#macro login path isRegisterForm isLoginForm isResetPasswordForm>
    <div class="card mx-auto regForm">
        <div class="card-body">
            <form action="${path}" method="post"
                  <#if isRegisterForm>onsubmit="return registrationValidation()"
                  <#elseif !isRegisterForm && !isLoginForm && !isResetPasswordForm>onsubmit="return passwordResetValidation()"
                  </#if>>

                <#if isRegisterForm || isLoginForm>
                    <div class="form-group">
                        <label>Логин<#if !isRegisterForm> или email<#else><span class="text-danger"> *</span></#if></label>
                        <div>
                            <input type="text" name="username" class="form-control ${(usernameError??)?string('is-invalid', '')}"
                            value="<#if user?? && !isLoginForm>${user.username}</#if>"/>
                            <div class="invalid-feedback">
                                <#if usernameError??>
                                    ${usernameError}
                                </#if>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if isRegisterForm || isResetPasswordForm>
                    <div class="form-group">
                        <#if isRegisterForm>
                            <label>Email<span class="text-danger"> *</span></label>
                        <#else>
                            <label>Введите email, указанный при регистрации. На него будет выслана ссылка для восстановления пароля</label>
                        </#if>
                        <div>
                            <input type="text" name="email" class="form-control ${(emailError??)?string('is-invalid', '')}"
                            value="<#if user??>${user.email}</#if>"/>
                            <div class="invalid-feedback">
                                <#if emailError??>
                                    ${emailError}
                                </#if>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if isRegisterForm || isLoginForm || !isResetPasswordForm>
                    <div class="form-group">
                        <label>Пароль<#if isRegisterForm><span class="text-danger"> *</span></#if></label>
                        <div>
                            <input type="password" name="password"
                                   class="form-control ${(passwordError??)?then('is-invalid', '')} ${(blankPassword??)?then('is-invalid', '')}" />
                            <div class="invalid-feedback">
                                <#if passwordError??>
                                    ${passwordError}
                                </#if>
                                ${blankPassword!}
                            </div>
                        </div>
                    </div>
                </#if>
                <#if user?? && !isRegisterForm>
                    <input type="hidden" value="${user.id}" name="userId">
                </#if>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="sdf btn btn-primary mt-2" type="submit">
                    <#if isRegisterForm>Зарегистрироваться<#elseif isLoginForm>Войти<#elseif isResetPasswordForm>Отправить<#else>Сохранить</#if>
                </button>
                <#if isLoginForm>
                    <a class="col-form-label mt-2" href="/resetPassword" style="float: right;">Забыли пароль?</a>
                </#if>
            </form>
        </div>
    </div>
</#macro>
<#macro logout>
        <form action="/logout" method="post" name="logoutForm" hidden>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Out"/>
        </form>
</#macro>





















