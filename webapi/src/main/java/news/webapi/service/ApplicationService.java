
package news.webapi.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.core.application.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Path("/api/applications")
@Produces(MediaType.APPLICATION_JSON)
public interface ApplicationService {
	@GET
	@Path("/{id}")
	Application getApplicationById(@PathParam("id") String id);
	
	@POST
	Application saveApplication(Application application);
	
	@PUT
	@Path("/{id}")
	Application updateApplication(Application application);
	
	@POST
	@Path("/{id}/secret")
	Application generateNewSecret(@PathParam("id") String id);
	
	@DELETE
	@Path("/{id}")
	void removeApplication(@PathParam("id") String id);
	
	@GET
	Page<Application> findApplicationByName(@QueryParam("q") @DefaultValue("") String name, Pageable pageable);
}
