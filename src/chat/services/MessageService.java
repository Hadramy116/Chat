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

import chat.entites.Message;
import chat.entites.Utilisateur;
import chat.metier.IMessageMetier;
import chat.metier.IMetier;

import chat.metier.MessageCtrl;
import chat.metier.UserCtrl;

@Path("msgs")
@Produces("application/json")
public class MessageService {
	
	private IMessageMetier ctrlM = new MessageCtrl();
	private IMetier<Utilisateur> ctrlU = new UserCtrl();
	
	@GET
	public Collection<Message> getMessages(){
		return  ctrlM.getItems();
	}
	
	@PUT
	@Path("addMsg")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatMsg(Message msg){
		if(ctrlU.getItemById(msg.getuRecaver()) == null || (msg.getuSender() == msg.getuRecaver() ))
			return Response.status(404).entity("User not found").build();
		else
			if(ctrlM.add(msg))
				return Response.status(204).entity(msg).build();
			else
				return Response.status(204).entity("Message n'est pas ajouter :(").build();
	}
	//uSender peut voir le messsage qui a envoiyer
	@GET
	@Path("chat")
	public Collection<Message> getUserMessages(@QueryParam("idUSend") int idUSend ,@QueryParam("idUR") int idUR){
		return ctrlM.getUserMessages(idUSend, idUR);
	}
	
	@DELETE
	@Path("deleteMsg")
	public Response deleteMsg(@QueryParam("id") int id) {
		if(ctrlM.delete(id))
			return Response.status(204).entity("le message dont l'id "+id+" a ete suprimer").build();
		else
			return Response.status(204).entity("Rein a ete suprimer :(").build();
	}
	
	@POST
	@Path("updateMsg")
	public Response updateMsg(Message item) {
		
		if(ctrlM.isExist(item.getId())) {
			if(ctrlM.update(item)){
				return Response.status(204).entity("le message dont l'id "+item.getId()+" a ete modifier").build();
			}else {
				return Response.status(204).entity("Rein a ete modifier :(").build();
			}
		}else 
			return Response.status(204).entity("Message n'exist pas ???!!").build();
	}
	
	
	@GET
	@Path("msgNonLu")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> getMsgNotReaded(@QueryParam("id") int id) {
		return ctrlM.getMsgNotReaded(id);
	}
	
	@GET
	@Path("userMsgConsult")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> consulterMsg(@QueryParam("id") int id) {
		return ctrlM.getUserConsult(id);
	}
	
	
}
