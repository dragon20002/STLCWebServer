package kr.ac.hansung.cse.model;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class CsrfRequestMatcher implements RequestMatcher {
	private Pattern defaultAllowPattern = Pattern.compile("^(GET|TRACE|HEAD|OPTIONS)$");
	private RegexRequestMatcher csrfDisabledMatcher = new RegexRequestMatcher("/RegisterKey", null);

	@Override
	public boolean matches(HttpServletRequest request) {
		if (defaultAllowPattern.matcher(request.getMethod()).matches())
			return false;
		return !csrfDisabledMatcher.matches(request);
	}

}
