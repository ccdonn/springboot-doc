package donn.springboot_doc.error;

import org.springframework.http.HttpStatus;

public enum CusError {
	ERR_m1(-1, "Undefined.", HttpStatus.EXPECTATION_FAILED, "-1, Undefined"),
	ERR_m2(-2, "Undefined.",
			HttpStatus.EXPECTATION_FAILED, "-2, Undefined"),
	ERR_m000(0, "000", HttpStatus.EXPECTATION_FAILED, "000, init"),
	ERR_m001(1, "001", HttpStatus.EXPECTATION_FAILED, "001, init"),
	ERR_m002(2, "002", HttpStatus.EXPECTATION_FAILED, "002, init"),
	ERR_m003(3, "003", HttpStatus.EXPECTATION_FAILED, "003, init"),
	;

	public Integer getErrCode() {
		return errCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	private final Integer errCode;
	private final HttpStatus httpStatus;
	private final String logMessage;
	private final String errMessage;

	private CusError(Integer errCode, String msg, HttpStatus httpStatus, String logMessage) {
		this.errCode = errCode;
		this.httpStatus = httpStatus;
		this.logMessage = logMessage;
		this.errMessage = httpStatus.getReasonPhrase();
	}
}
