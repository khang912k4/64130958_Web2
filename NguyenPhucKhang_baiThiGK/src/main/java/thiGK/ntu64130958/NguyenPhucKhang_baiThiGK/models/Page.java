package thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models;
import lombok.Generated;
public class Page {
	String id,pageName,keyword,content,parentPageID;
	public Page(String id,String pageName, String keyword,String content,String parentPageID) {
		this.id=id;
		this.pageName=pageName;
		this.keyword=keyword;
		this.content=content;
		this.parentPageID = parentPageID;
	}
	@Generated
	public String getID() {
		return this.id;
	}
	@Generated
	public String getPageName() {
		return this.pageName;
	}
	@Generated
	public String getKeyword() {
		return this.keyword;
	}
	@Generated
	public String getContent() {
		return this.content;
	}
	@Generated
	public String getParentPageID() {
		return this.parentPageID;
	}
	@Generated
	public void setID(final String id) {
		this.id=id;
	}
	@Generated
	public void setPageName(final String pageName) {
		this.pageName=pageName;
	}
	@Generated
	public void setKeyword(final String keyword) {
		this.keyword=keyword;
	}
	@Generated
	public void setParentPageID(final String parentPageID) {
		this.parentPageID=parentPageID;
	}
	@Generated
	public Page(){
		
	}
}
