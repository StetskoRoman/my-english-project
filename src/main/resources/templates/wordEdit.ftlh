<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

     <h3>Words in the ${listing.getListingName()}</h3>


    <#if account??>
    <form action="/${currentAccountId}/library/${listing.getId()}/createWord" method="post">
        word: <input type="text" name="wordName" required/>


        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="add new word"/>
    </form>
    </#if>
</@c.page>

<#--   @NotBlank
    private String wordName;
    private String explanation;
    private String example;

    private String transcription;
//    private boolean turnOnWord;

    private boolean shownWord;

    @Embedded
    private VisibleWord visibleWord;

    @ManyToOne
    private Library library;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "listing_id")
    private Listing listing;

    private LevelUsefulWord levelUsefulWord;-->