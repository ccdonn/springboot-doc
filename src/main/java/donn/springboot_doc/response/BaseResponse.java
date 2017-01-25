package donn.springboot_doc.response;

import java.util.Date;

public class BaseResponse {
	private final Date time = new Date();
	private final String status = "success";

	public Date getTime() {
		return time;
	}

	public String getStatus() {
		return status;
	}
}
