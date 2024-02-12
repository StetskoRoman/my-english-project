<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
<#--   подчеркнуто потому как в контроллере мередавал только, но все работает, хз почему "wordList", listing.getWords()-->
    <h3>Words in "${listing.getListingName()}"</h3>

    <#if account??>

        <h4><a href="/${currentAccountId}/library/${listing.getId()}/createWord" class="link-underline-success">add
                word</a></h4>

        <#if errorMessage??>
            <h4 style="color: gray">${errorMessage}</h4>

        <#else>
            <#list wordList as word>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${word.getWordName()} <#if word.getTranscription()!="" ><span>[${word.getTranscription()}]</span> </#if>
                                     : &emsp; ${word.getExplanation()} </h5>
<#--                                <p class="card-text">${word.getExplanation()}</p>-->
                                <p class="card-text"></p>
                                <a href="/${currentAccountId}/library/${listing.getId()}/${word.getId()}" class="card-link">Examples</a>
                                <a href="/${currentAccountId}/library/${listing.getId()}/${word.getId()}/editWord" class="card-link">edit word</a>
                            </div>
                        </div>
                    </div>

                </div>
            </#list>
            <#if wordList?size == 0>
                <h4 class="text-muted">Empty wordlist</h4>
            </#if>


        </#if>
    </#if>
</@c.page>


<#--                    <div class="col-md-6">-->
<#--                        <div class="card">-->
<#--                            <div class="card-body">-->
<#--&lt;#&ndash;                                <h5 class="card-title">Examples</h5>&ndash;&gt;-->
<#--&lt;#&ndash;                                <hr>&ndash;&gt;-->
<#--                                <h5 class="card-text">${word.getExplanation()}</h5>-->
<#--&lt;#&ndash;                                <p class="card-text">${word.getExample()}</p>&ndash;&gt;-->

<#--                            </div>-->
<#--                        </div>-->
<#--                    </div>-->

<#--    <#list wordList as word>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">${word.getWordName()}</h5>
                        <p class="card-text">explanation ${word.getExplanation()}</p>
                        <p class="card-text">${word.getExample()}</p>
                        <p class="card-text">[${word.getTranscription()}]</p>
                        <a href="/" class="card-link">edit word</a>
                    </div>
                </div>
            </#list>
            <#if wordList?size == 0>
                <h4 class="text-muted">Empty wordlist</h4>
            </#if>-->

<#--<div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInputDisabled" placeholder="name@example.com" disabled>
                    <label for="floatingInputDisabled">${word.getWordName()}  </label>
                </div>-->

<#--        <form action="/${currentAccountId}/library/createListing" method="post">-->
<#--            Create new wordlist: <input type="text" name="listingName" required>-->
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--            <input type="submit" value="add new wordlist"/>-->
<#--        </form><br>-->