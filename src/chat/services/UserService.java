package chat.services;

import java.util.Collection;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import chat.entites.Utilisateur;
import chat.metier.IUserMetier;
import chat.metier.UserCtrl;

@Path("users")
@Produces("application/json")
public class UserService {
	
	private IUserMetier ctrl = new UserCtrl();
	
	
	@GET
	public Collection<Utilisateur> getUsers(){
		return ctrl.getUsers().values();
	}
	
	@PUT
	@Path("addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(Utilisateur user){
		if(ctrl.addUser(user)){
			return Response.status(204).entity(user).build();
		}else{
			return Response.status(204).entity("N'est pas ajouter !!").build();}
		
		
	}
	
	@POST
	@Path("updateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(Utilisateur user){
		if(ctrl.updateUser(user)){
			return Response.status(204).entity(user).build();
		}else{
			return Response.status(204).entity("N'est pas modifier !!").build();}
		
	}
	@DELETE
	@Path("deleteUser")
	public Response deleteUser(@QueryParam("id") int id){
		if(ctrl.deleteUser(id)){
			return Response.status(204).entity("Utilisateur dont l'id "+id+" a ete suprimer").build();
		}else{
			return Response.status(204).entity("Aucun element a ete suprimer !!").build();}
		
	}
	
}
