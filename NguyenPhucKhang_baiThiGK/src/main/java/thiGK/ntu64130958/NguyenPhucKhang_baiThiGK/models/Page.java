package thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models;

public class Page {
	String id,pageName,keyword,content,parentPageID;
	public Page(String id,String pageName, String keyword,String content,String parentPageID) {
		this.id=id;
		this.pageName=pageName;
		this.keyword=keyword;
		this.content=content;
		this.parentPageID = parentPageID;
	}
	public Page() {
		this.id="";
		this.pageName="";
		this.keyword="";
		this.content="";
		this.parentPageID="";
	}
}
