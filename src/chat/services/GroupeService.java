package chat.services;

import java.util.Collection;

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

import chat.entites.Groupe;
import chat.entites.Message;
import chat.entites.Utilisateur;
import chat.metier.GroupeCtrl;
import chat.metier.IGroupe;
import chat.metier.IUser;
import chat.metier.UserCtrl;

@Path("grps")
@Produces("application/json")
public class GroupeService {
	
	private IGroupe grpCtrl = new GroupeCtrl();
	private IUser ctrlU = new UserCtrl();	
		
	
	@GET
	public Collection<Groupe> getGrps(){
		return grpCtrl.getItems();
	}
	
	@GET
	@Path("msgs")
	public Collection<Message> getMsgs(@QueryParam("idGrp") Integer idGrp){
		return grpCtrl.getGrpMsg(idGrp);
	}
	
	@GET
	@Path("users")
	public Collection<Utilisateur> getUsers(@QueryParam("idGrp") Integer idGrp){
		return grpCtrl.getGrpUser(idGrp);
	}
	
	@PUT
	@Path("addGrp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatGrp(Groupe grp){
		
		if(!grpCtrl.isExist(grp.getId())){
			grpCtrl.add(grp);
			return Response.status(204).entity(grp).build();
		}else{
			return Response.status(204).entity("groupe deja existe ??!").build();
		}
	}
	
	@PUT
	@Path("addUserToGrp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserToGrp(Utilisateur user , @QueryParam("idGrp") Integer idGrp){
		
		if(grpCtrl.isExist(idGrp) && ctrlU.isExist(user.getId())){
			if(grpCtrl.addToGroupe(user, idGrp))
					return Response.status(204).entity(user).build();
			else
				return Response.status(204).entity("groupe  n'existe pas ??!").build();
		}else{
			return Response.status(204).entity("groupe n'existe pas ??!").build();
		}
	}

	@PUT
	@Path("addMsgToGrp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserToGrp(Message msg , @QueryParam("idGrp") Integer idGrp){
		
		if(grpCtrl.isExist(idGrp)){
			if(grpCtrl.addMsgToGroupe(msg, idGrp) != null)
					return Response.status(204).entity(msg).build();
			else
				return Response.status(204).entity("groupe n'existe pas ??!").build();
		}else{
			return Response.status(204).entity("groupe n'existe pas ??!").build();
		}
	}
	
	
	@DELETE
	@Path("deleteGrp")
	public Response deleteGrp(@QueryParam("id") int id) {
		if(grpCtrl.delete(id))
			return Response.status(204).entity("le groupe dont l'id "+id+" a ete suprimer").build();
		else
			return Response.status(204).entity("Rein a ete suprimer :(").build();
	}
	
	@POST
	@Path("updateGrp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGrp(Groupe item) {
		
		if(grpCtrl.update(item))
			return Response.status(204).entity("le groupe dont l'id "+item.getId()+" a ete modifier").build();
		else
			return Response.status(204).entity("Rein a ete modifier :(").build();
	
	}
	
	@DELETE
	@Path("deleteUserFromGrp")
	public Response deleteUserFromGrp(@QueryParam("idUser") Integer idUser , @QueryParam("idGrp") Integer idGrp) {
		if(grpCtrl.deleteUserFromGrp(idUser, idGrp))
			return Response.status(204).entity("User a ete suprimer").build();
		else
			return Response.status(204).entity("Rein a ete suprimer :(").build();
	}

}
