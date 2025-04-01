package thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models;

public class Post {
	private String id,title,content,categoryID;
	public Post(String id,String title,String content,String categoryID) {
		this.id=id;
		this.title=title;
		this.content=content;
		this.categoryID=categoryID;
	}
	public Post() {
		this.id="";
		this.title="";
		this.content="";
		this.categoryID="";
	}
	public String getID() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getContent() {
		return this.content;
	}
	public String getCategoryID() {
		return this.categoryID;
	}
}
