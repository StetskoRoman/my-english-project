<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

    <#if account??>

            <h1>Word ${word.getWordName()}</h1>
            <form action="/${currentAccountId}/library/${listing.getId()}/${word.getId()}" method="post">

                <div class="form-group">
                    <label for="wordName">Word Name: ${word.wordName}</label>
                    <textarea type="text" name="wordName" id="wordName" class="form-control "> ${word.wordName}</textarea>
                </div>
                <div class="form-group">
                    <label for="explanation">Explanation:</label>
                    <textarea name="explanation" id="explanation" class="form-control"> ${word.explanation}</textarea>
                </div>
                <div class="form-group">
                    <label for="example">Example:</label>
                    <textarea name="example" id="example" class="form-control"> ${word.example}</textarea>
                </div>
                <div class="form-group">
                    <label for="transcription">Transcription:</label>
                    <textarea type="text" name="transcription" id="transcription" class="form-control"> ${word.transcription}</textarea>
                </div>
                <div class="form-group">
                    <label for="levelUsefulWord">How useful word is ${word.getLevelUsefulWord()}</label>
                    <select class="form-control" id="levelUsefulWord" name="levelUsefulWord">
                        <option value="VERY_LOW">Very Low</option>
                        <option value="LOW">Low</option>
                        <option value="MIDDLE">Middle</option>
                        <option value="HIGH">High</option>
                        <option value="MUST_HAVE">Must Have</option>
                        <option value="BASE_WORD">Base Word</option>
                    </select>
                </div>

                <!-- Add more fields as needed -->
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-primary">Save</button>
            </form>

    </#if>

</@c.page>

