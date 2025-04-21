package thiGK.ntu64130958.models;

public class Page {
	public String id;
    public String pageName;
    public String keyword;
    public String content;
    public String parentPageId;

    public Page(String id, String pageName, String keyword, String content, String parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }
}
