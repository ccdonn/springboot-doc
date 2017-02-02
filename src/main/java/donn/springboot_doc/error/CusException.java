package donn.springboot_doc.error;

import org.springframework.http.HttpStatus;

public class CusException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6586933618883373301L;

	private final String status = "_failure";
	private HttpStatus httpStatus;
	private Integer errorCode;
	private String message;


	public CusException(CusError cx) {
		this.httpStatus = cx.getHttpStatus();
		this.errorCode = cx.getErrCode();
		this.message = cx.getLogMessage();
	}


	public String getStatus() {
		return status;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
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
