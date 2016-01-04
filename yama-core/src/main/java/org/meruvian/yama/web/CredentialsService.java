
package org.meruvian.yama.web;

import javax.servlet.http.HttpServletRequest;

public interface CredentialsService {
	void registerAuthentication(String userId);
	
	void registerAuthentication(String userId, HttpServletRequest request);
}
