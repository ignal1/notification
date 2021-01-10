<#import "parts/common.ftl" as c>

<@c.common>
<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">

            <div class="card border-primary mb-3" style="min-height: 550px;">
                <div class="card-header">
                    <strong>${username}</strong>
                    ${message?ifExists}
                </div>
                <div class="card-body mt-4">

                    <div class="row">

                        <div class="col-sm-1"></div>
                            <div class="col-sm-10">
                                <form id="profile-form" method="post" onsubmit="return profileEditValidation()">

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Имя:</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="first_name" class="form-control valid-length" value="${firstName!''}" />
                                            <div class="invalid-feedback">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Фамилия:</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="last_name" class="form-control valid-length" value="${lastName!''}" />
                                            <div class="invalid-feedback">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Компания:</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="company" class="form-control" value="${company!''}" />
                                            <div class="invalid-feedback">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Email:</label>
                                        <div class="col-sm-9">
                                            <input type="text" name="email" class="form-control pro" value="${email!''}" />
                                            <div class="invalid-feedback">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="mt-5">
                                        <p>
                                            Пароль будет изменен только в случае корректного ввода старого пароля.
                                        </p>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Старый пароль:</label>
                                        <div class="col-sm-9">
                                            <input type="password" name="password1" class="form-control valid-length" />
                                            <div class="invalid-feedback">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Новый пароль:</label>
                                        <div class="col-sm-9">
                                            <input type="password" name="password2" class="form-control valid-length" />
                                            <div class="invalid-feedback">
                                            </div>
                                        </div>
                                    </div>

                                     <input type="hidden" name="_csrf" value="${_csrf.token}" />

                                    <button id="profile-form-btn" class="btn btn-primary my-2" type="submit">Сохранить</button>
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