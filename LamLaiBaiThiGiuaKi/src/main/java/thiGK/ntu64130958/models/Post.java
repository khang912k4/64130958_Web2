package thiGK.ntu64130958.models;

public class Post {
	public String id;
    public String title;
    public String content;
    public String categoryId;

    public Post(String id, String title, String content, String categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }
}
