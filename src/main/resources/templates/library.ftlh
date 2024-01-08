<#import "parts/common.ftlh" as c>
    <#include "parts/security.ftlh">

<@c.page>
    <h3>Here is your library, containing all your words</h3>
    <#if account??>
        <a href="/${currentAccountId}/createListing">Add new wordlist</a>
<#--        <form action="/${currentAccountId}/createListing" method="post">-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--            <input type="submit" value="add new wordlist"/>-->
<#--        </form>-->
    </#if>
</@c.page>