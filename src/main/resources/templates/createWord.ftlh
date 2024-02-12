<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

    <h3>Words in the ${listing.getListingName()}</h3>

    <#if account??>
        <form action="/${currentAccountId}/library/${listing.getId()}/createWord" method="post">

            <#--do it more fashn-->
            <div class="form-group">
                <label for="wordName">Word:</label>
                <input type="text" name="wordName" id="wordName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="explanation">Explanation:</label>
                <input type="text" name="explanation" id="explanation" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="example">Example (advisable):</label>
                <textarea name="example" id="example" class="form-control"></textarea>
            </div>

            <div class="form-group">
                <label for="transcription">Pronunciation (doesn't required if it's not necessary):</label>
                <input type="text" name="transcription" id="transcription" class="form-control">
            </div>

            <div class="form-group">
                <label for="levelUsefulWord">How useful word is</label>
                <select class="form-control" id="levelUsefulWord" name="levelUsefulWord">
                    <option value="VERY_LOW">Very Low</option>
                    <option value="LOW">Low</option>
                    <option value="MIDDLE">Middle</option>
                    <option value="HIGH">High</option>
                    <option value="MUST_HAVE">Must Have</option>
                    <option value="BASE_WORD">Base Word</option>
                </select>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="add new word"/>
        </form>
    </#if>
</@c.page>

<#--BOT-->
<#-- old version-->
<#--word: <input type="text" name="wordName" required/> <br>-->
<#--explanation: <input type="text" name="explanation" required/>  <br>-->
<#--example: <input type="text" name="example"> <br>-->
<#--pronunciation: <input type="text" name="transcription">-->
<#--<form action="/${currentAccountId}/library/${listing.getId()}/createWord" method="post" class="form">-->
<#--    <div class="form-group">-->
<#--        <label for="wordName">Word:</label>-->
<#--        <input type="text" name="wordName" id="wordName" class="form-control" required>-->
<#--    </div>-->
<#--    <div class="form-group">-->
<#--        <label for="explanation">Explanation:</label>-->
<#--        <input type="text" name="explanation" id="explanation" class="form-control" required>-->
<#--    </div>-->
<#--    <div class="form-group">-->
<#--        <label for="example">Example:</label>-->
<#--        <input type="text" name="example" id="example" class="form-control">-->
<#--    </div>-->
<#--    <div class="form-group">-->
<#--        <label for="transcription">Pronunciation:</label>-->
<#--        <input type="text" name="transcription" id="transcription" class="form-control">-->
<#--    </div>-->
<#--    <!---->
<#--    <div class="form-group">-->
<#--        <label for="levelUsefulWord">How useful word is</label>-->
<#--        <select class="form-control" id="levelUsefulWord" name="levelUsefulWord">-->
<#--            <option value="VERY_LOW">Very Low</option>-->
<#--            <option value="LOW">Low</option>-->
<#--            <option value="MIDDLE">Middle</option>-->
<#--            <option value="HIGH">High</option>-->
<#--            <option value="MUST_HAVE">Must Have</option>-->
<#--            <option value="BASE_WORD">Base Word</option>-->
<#--        </select>-->
<#--    </div>-->
<#--    &ndash;&gt;-->
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--    <input type="submit" value="Add New Word" class="btn btn-primary">-->
<#--</form>-->

