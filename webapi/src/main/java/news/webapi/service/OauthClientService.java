
package news.webapi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.core.application.Application;

@Path("/api/oauth/clients")
@Produces(MediaType.APPLICATION_JSON)
public interface OauthClientService {
	@GET
	@Path("/{id}")
	Application findClientDetailsById(@PathParam("id") String id);
}
