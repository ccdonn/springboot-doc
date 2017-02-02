package donn.springboot_doc.error;

import java.util.Date;

public class CusErrorResp {
	private final String status = "_Failure";
	private final Date time = new Date();
	private CusErrorInfo result;
	
	public CusErrorResp() {
		
	}
	
	public CusErrorResp(CusErrorInfo errorInfo) {
		result = errorInfo;
	}
	
	
	public String getStatus() {
		return status;
	}
	public Date getTime() {
		return time;
	}
	public CusErrorInfo getResult() {
		return result;
	}
	public void setResult(CusErrorInfo result) {
		this.result = result;
	}
}
