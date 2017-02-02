package donn.springboot_doc.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class CusExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	@ResponseBody CusErrorResp defaultErrorHandler(HttpServletRequest req, Exception rex) {
		return new CusErrorResp(new CusErrorInfo(req.getRequestURL(), new CusException(CusError.ERR_m003)));
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CusException.class)
	@ResponseBody CusErrorResp cusErrorHandler(HttpServletRequest req, CusException ex) {
		return new CusErrorResp(new CusErrorInfo(req.getRequestURL(), ex));
	}
	
		
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody CusErrorResp numErrorHandler(HttpServletRequest req, IllegalArgumentException rex) {
		return new CusErrorResp(new CusErrorInfo(req.getRequestURL(), new CusException(CusError.ERR_m001)));
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody CusErrorResp nulErrorHandler(HttpServletRequest req, NullPointerException rex) {
		return new CusErrorResp(new CusErrorInfo(req.getRequestURL(), new CusException(CusError.ERR_m002)));
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody CusErrorResp defaultErrorHandler(HttpServletRequest req, CusException rex) {
		return new CusErrorResp(new CusErrorInfo(req.getRequestURL(), new CusException(CusError.ERR_m000)));
	}
	
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler(Exception.class)
//	@ResponseBody CusErrorResp defaultErrorHandler(HttpServletRequest req, Exception rex) {
//		return new CusErrorResp(new CusErrorInfo(req.getRequestURL(), new CusException(CusError.ERR_m003)));
//	}

}
