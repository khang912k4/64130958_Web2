package thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models;

public class Post {
	String id,title,content,categoryID;
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
}
