
package news.webapi.service;

import javax.inject.Inject;

import org.meruvian.yama.core.application.Application;
import org.meruvian.yama.core.application.ApplicationRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

@Service
public class RestOauthClientService implements OauthClientService {
	@Inject
	private ClientDetailsService clientDetailsService;
	
	@Inject
	private ApplicationRepository applicationRepository;
	
	@Override
	public Application findClientDetailsById(String id) {
		ClientDetails clientDetails =  clientDetailsService.loadClientByClientId(id);
		
		if (clientDetails == null) {
			return null;
		}
		
		Application application = applicationRepository.findById(clientDetails.getClientId());
		application.setScopes(clientDetails.getScope());
		application.setAuthorizedGrantTypes(clientDetails.getAuthorizedGrantTypes());
		
		return application;
	}
}
