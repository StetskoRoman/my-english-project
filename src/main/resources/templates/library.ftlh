<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h3>Here is your library, containing all your words</h3>
    <#if account??>

        <form action="/${currentAccountId}/library/createListing" method="post">
            Create new wordlist: <input type="text" name="listingName" required>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="add new wordlist"/>
        </form><br>

        <#if errorMessage??>
            <h4 style="color: gray">${errorMessage}</h4>
        <#else>
            <#list listingList as listing>
                <div>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <#--                            <p class="col-sm-3 fw-bold">${listing.listingName}</p>-->
                            <li class="breadcrumb-item active " aria-current="page">${listing.listingName}</li>
                            <li class="breadcrumb-item active" aria-current="page">amount of
                                words: ${listing.totalAmountWords}</li>
                            <li class="breadcrumb-item"><a href="/${currentAccountId}/library/${listing.id}">enter to
                                    list</a></li>
                        </ol>
                    </nav>

                </div>
            <#else>
                <h4 class="text-muted">Empty library</h4>
            </#list>
        </#if>
    </#if>

</@c.page>


<#--                    <b>${listing.listingName}</b> <a href="/${currentAccountId}/library/${listing.id}">enter to list</a>-->

<#--        <form action="/${currentAccountId}/library/createListing" method="post">-->

<#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--            <input type="submit" value="add new wordlist"/>-->
<#--        </form>-->

<#--<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"-->
<#--   aria-controls="collapseExample">-->
<#--    Add new wordlist-->
<#--</a>-->
<#--<div class="collapse <#if message??>show</#if>" id="collapseExample">-->
<#--    <div class="form-group mt-3">-->
<#--        <form action="/${currentAccountId}/library/createListing" method="post">-->
<#--            <div class="form-group">-->
<#--                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"-->
<#--                       value="<#if message??>${message.text}</#if>" name="wordList"-->
<#--                       placeholder="name for your wordlist"/>-->
<#--                <#if textError??>-->
<#--                    <div class="invalid-feedback">-->
<#--                        ${textError}-->
<#--                    </div>-->
<#--                </#if>-->
<#--            </div>-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--            <input type="hidden" name="id" value="<#if message??>${message.id}</#if>"/>-->
<#--            <div class="form-group">-->
<#--                <button type="submit" class="btn btn-primary">Save wordlist</button>-->
<#--            </div>-->
<#--        </form>-->
<#--    </div>-->
<#--</div>-->