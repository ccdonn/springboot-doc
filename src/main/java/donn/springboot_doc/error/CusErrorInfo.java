package donn.springboot_doc.error;

public class CusErrorInfo {
	public String url;
    public String ex;
	private Integer errorCode;
	private String message;

	public CusErrorInfo() {
		
	}
	
	public CusErrorInfo(CharSequence url, CusException cx) {
		this.url = url.toString();
        if (cx != null) {
        	this.errorCode = cx.getErrorCode();
        	this.message = cx.getMessage();
        }
	}
	
	public CusErrorInfo(CharSequence url, Exception ex) {
        this.url = url.toString();
        if (ex != null) {
        	this.ex = ex.getLocalizedMessage();
        }
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
