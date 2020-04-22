package br.net.nicoletti.ame.gateway.restful;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("gateway")
public class GatewayRESTFul {

	@GET
	@Path("/health")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdditional(@Context HttpServletRequest request) {
		String out = "It's working!";
		return Response.status(Response.Status.OK).entity(out).build();
	}
}
