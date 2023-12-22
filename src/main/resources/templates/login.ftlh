
<#import "parts/common.ftlh" as c>
<#import "parts/loginMacro.ftlh" as l>

<@c.page>
<#--    с активацией через mail добавить-->
<#--    <#if Session?? && SPRING_SECURITY_LAST_EXCEPTION??>-->
<#--        <div class="alert alert-danger" role="alert">-->
<#--            ${SPRING_SECURITY_LAST_EXCEPTION.message}-->
<#--        </div>-->
<#--    </#if>-->

    <h3>Welcome to the english for anyone</h3>
    <@l.login "/login" false/>

        <#if errorMessage??>
        <div class="invalid-feedback">
            ${errorMessage}
        </div>

    </#if>

</@c.page>

