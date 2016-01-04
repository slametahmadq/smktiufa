
package news.webapi.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.meruvian.yama.core.user.User;

@Path("/api/signup")
public interface SignUpService {
	@POST
	User signUp(User user);
	
	@GET
	User isUserExist(@QueryParam("u") String username);
}
