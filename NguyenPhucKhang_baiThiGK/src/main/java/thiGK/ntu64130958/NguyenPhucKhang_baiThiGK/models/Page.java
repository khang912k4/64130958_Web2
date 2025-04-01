package thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models;
public class Page {
	private String id,pageName,keyword,content,parentPageID;
	public Page(String id,String pageName, String keyword,String content,String parentPageID) {
		this.id=id;
		this.pageName=pageName;
		this.keyword=keyword;
		this.content=content;
		this.parentPageID = parentPageID;
	}
	public String getID() {
		return this.id;
	}
	 
	public String getPageName() {
		return this.pageName;
	}
	 
	public String getKeyword() {
		return this.keyword;
	}
	 
	public String getContent() {
		return this.content;
	}
	 
	public String getParentPageID() {
		return this.parentPageID;
	}
	 
	public void setID(final String id) {
		this.id=id;
	}
	 
	public void setPageName(final String pageName) {
		this.pageName=pageName;
	}
	 
	public void setKeyword(final String keyword) {
		this.keyword=keyword;
	}
	 
	public void setParentPageID(final String parentPageID) {
		this.parentPageID=parentPageID;
	}
	 
	public Page(){
		
	}
}
