<#import "parts/common.ftl" as c>

<@c.common>

<div class="container mt-4">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">

            <div class="card border-primary mb-3" style="min-height: 50px;">
                <div class="card-header">
                    Удаление аккаунта
                </div>
                <div class="card-body mt-2">

                    <div class="row">

                        <div class="col-sm-1"></div>
                        <div class="col-sm-10">

                            <div>
                                Удаление аккаунта не может быть отменено. Пожалуйста, подтвердите удаление.
                            </div>
                            <form method="post">

                                <input type="hidden" value="${_csrf.token}" name="_csrf">

                                <button type="submit" class="btn btn-primary my-4">Удалить аккаунт</button>
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
