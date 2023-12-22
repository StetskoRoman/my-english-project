<#assign
known = SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    account = SPRING_SECURITY_CONTEXT.authentication.principal
    email = account.getEmail()
    currentAccountId = account.getId()
    isAdmin = account.isAdmin()
    >

<#else>
    <#assign
    email = "unknown"
    isAdmin = false
    currentAccountId = -1
    >
</#if>


<#--        тут описывается юзер только если он авторизован (тот принципал что вставляется в методы из контекста)-->
<#--    cлучай для неавторизованного   currentUserId = -1 ни одному пользователю не соответствует-->