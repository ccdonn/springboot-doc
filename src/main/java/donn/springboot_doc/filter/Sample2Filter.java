package donn.springboot_doc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Sample2Filter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(Sample2Filter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader("token");
		
		logger.info("token:"+token);
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setHeader("X-xMessage", "Donn-Was-Here");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
