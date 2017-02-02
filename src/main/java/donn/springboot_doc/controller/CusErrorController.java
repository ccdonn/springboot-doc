package donn.springboot_doc.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import donn.springboot_doc.error.CusError;
import donn.springboot_doc.error.CusException;

@RestController
public class CusErrorController implements ErrorController {
	private final String PATH = "/error";

	@RequestMapping(PATH)
	public String error() {
		throw new CusException(CusError.ERR_m003);
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(PATH + "/m1")
	public String error_M1() {
		throw new CusException(CusError.ERR_m1);
	}

	@RequestMapping(PATH + "/m2")
	public String error_M2() {
		throw new CusException(CusError.ERR_m2);
	}

	@RequestMapping(PATH + "/defaultRuntime")
	public String error_Runtime() {
		throw new RuntimeException();
	}

	@RequestMapping(PATH + "/null")
	public String error_Null() {
		String str = null;
		return "Length=" + str.length();
	}

	@RequestMapping(PATH + "/parseint")
	public String error_ParseInt() {
		String number = "number";
		return "Number=" + Integer.parseInt(number);
	}

}
