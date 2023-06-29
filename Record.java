package application;

public class Record {
	
	int UrlID;
	String PageUrl, PageStatus, ResponseCode;
	
	public Record(int UrlID, String PageUrl, String PageStatus, String ResponseCode) {
		this.UrlID = UrlID;
		this.PageUrl = PageUrl;
		this.PageStatus = PageStatus;
		this.ResponseCode = ResponseCode;
	}
	public int getUrlID() {
		return UrlID;
	}
	public void setUrlID(int UrlID) {
		this.UrlID = UrlID;
	}
	public String getPageUrl() {
		return PageUrl;
	}
	public void setPageUrl(String PageUrl) {
		this.PageUrl = PageUrl;
	}
	public String getPageStatus() {
		return PageStatus;
	}
	public void setPageStatus(String PageStatus) {
		this.PageStatus = PageStatus;
	}
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String ResponseCode) {
		this.ResponseCode = ResponseCode;
	}
}
