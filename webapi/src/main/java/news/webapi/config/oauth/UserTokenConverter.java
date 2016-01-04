
package news.webapi.config.oauth;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.meruvian.yama.core.user.User;
import org.meruvian.yama.web.security.DefaultUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.util.StringUtils;

public class UserTokenConverter extends DefaultUserAuthenticationConverter {
	protected static final String USER_ID = "user_id";
	
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put(USERNAME, authentication.getName());
		
		if (authentication.getPrincipal() instanceof DefaultUserDetails) {
			DefaultUserDetails details = (DefaultUserDetails) authentication.getPrincipal();
			response.put(USER_ID, details.getId());
		}
		
		if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
			response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
		}
		
		return response;
	}

	public Authentication extractAuthentication(Map<String, ?> map) {
		if (map.containsKey(USERNAME) && map.containsKey(USER_ID)) {
			DefaultUserDetails details = new DefaultUserDetails((String) map.get(USERNAME),
					"N/A", getAuthorities(map));
			details.setId((String) map.get(USER_ID));
			
			User user = new User();
			user.setId(details.getId());
			user.setUsername(details.getUsername());
			details.setUser(user);
			
			return new UsernamePasswordAuthenticationToken(details, details.getPassword(),
					details.getAuthorities());
		}
		
		return null;
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
		Object authorities = map.get(AUTHORITIES);
		
		if (authorities instanceof String) {
			AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
		}
		
		if (authorities instanceof Collection) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
					.collectionToCommaDelimitedString((Collection<?>) authorities));
		}
		
		return AuthorityUtils.commaSeparatedStringToAuthorityList("");
	}
}
