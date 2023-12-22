<#import "parts/common.ftlh" as c>
<#import "parts/loginMacro.ftlh" as l>

<@c.page>
    <h3> Create new account</h3>
    <@l.login "/registration" true />
</@c.page>