<#macro login path isRegisterForm>

    <form action="${path}" method="post">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email:</label>
            <div class="col-sm-6">
                <#if !isRegisterForm>
                    <input type="email" name="username"
                           class="form-control"
                            <#--                       cледующая ошибка для мэйла если неправильно его заполняешь, то пустое возвращает форма-->
                            <#--                       value="<#if account??>${account.email}</#if>"-->
                           placeholder="some@some.com"/>
                </#if>

                <#if isRegisterForm>
                    <input type="email" name="email"
                            <#--                       cледующая ошибка для мэйла если неправильно его заполняешь, то пустое возвращает форма-->
                            <#--                       value="<#if account??>${account.email}</#if>"-->
                           class="form-control ${(emptyMail??)?string('is-invalid', '')}"
                           placeholder="some@some.com"/>
                    <#if emptyMail??>
                        <div class="invalid-feedback">
                            ${emptyMail}
                        </div>
                    </#if>
                </#if>

            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <#--                если passwordError есть, то создастся класс is-invalid, если без ошибки - пустая строка, значит валидно значение-->
                <input type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>

        <#if isRegisterForm>
            <div class="form-group row">
                <#--                2 колонки, в сетке всего 12 колонок на всю длинну-->
                <label class="col-sm-2 col-form-label">Repeat password:</label>
                <div class="col-sm-6">
                    <input type="password" name="password2"  class="form-control ${(password2Error??)?string('is-invalid', '')}"
                           placeholder="Repeat password"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">User Name :</label>
                <div class="col-sm-6">
                    <#-- value="<#if account??>${account.accountName}</#if>" - если аккаунт есть в контексте? - то выполнить условие     value="<#if account??>${account.accountName}</#if>"           t-->
                    <input type="text" name="accountName"
<#--                           value="<#if account??>${account.accountName}</#if>"-->
                           class="form-control ${(accountNameError??)?string('is-invalid', '')}"
                           placeholder="Account name"/>
                    <#if accountNameError??>
                        <div class="invalid-feedback">
                            ${accountNameError}
                        </div>
                    </#if>

                </div>
            </div>
        <#--            recaptcha here will be-->
        </#if>
        <#if newUserError??>
            <h2 style="color: red">${newUserError}</h2>
        </#if>
        <#if emptyEmail??>
            <h2 style="color: red">${emptyEmail}</h2>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if !isRegisterForm><a href="/registration">Add new account</a></#if>
        <button type="submit"
                class="btn btn-success"><#if isRegisterForm>Create new Account<#else>Sign In</#if></button>
    </form>

</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>