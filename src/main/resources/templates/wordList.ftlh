<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h3>Words in ${listing.getListingName()}</h3>


    <#if account??>

    <#--        <form action="/${currentAccountId}/library/createListing" method="post">-->
    <#--            Create new wordlist: <input type="text" name="listingName" required>-->
    <#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
    <#--            <input type="submit" value="add new wordlist"/>-->
    <#--        </form><br>-->
        <p><a href="/${currentAccountId}/library/${listing.getId()}/createWord" class="link-underline-success">add
                word</a></p>

        <#if errorMessage??>
            <h4 style="color: gray">${errorMessage}</h4>
        <#else>
            <#list wordList as word>
                <p><b>${word.getWordName()} ${word.getExplanation()}</b> <a href="/">edit word</a></p>
            <#else>
                <h4>Empty wordlist</h4>
            </#list>
        </#if>
    </#if>
</@c.page>

<#--<div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInputDisabled" placeholder="name@example.com" disabled>
                    <label for="floatingInputDisabled">${word.getWordName()}  </label>
                </div>-->