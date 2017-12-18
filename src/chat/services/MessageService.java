package chat.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import chat.entites.Message;
import chat.metier.IMessageMetier;
import chat.metier.IUserMetier;
import chat.metier.MessageCtrl;
import chat.metier.UserCtrl;

@Path("msgs")
@Produces("application/json")
public class MessageService {
	
	private IMessageMetier ctrlM = new MessageCtrl();
	private IUserMetier ctrlU = new UserCtrl();
	
	@GET
	public Collection<Message> getMessages(){
		return  ctrlM.getMessages().values();
	}
	
	@PUT
	@Path("addMsg")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatMsg(Message msg){
		if(ctrlU.getUserById(msg.getuRecaver()) == null)
			return Response.status(204).entity("User not found").build();
		else
			if(ctrlM.createMsg(msg))
				return Response.status(204).entity(msg).build();
			else
				return Response.status(204).entity("Message n'est pas ajouter :(").build();
	}
	
	@GET
	@Path("chat")
	public Map<Integer, Message> getUserMessages(@QueryParam("idUSend") int idUSend ,@QueryParam("idUR") int idUR){
		return ctrlM.getUserMessages(idUSend, idUR);
	}
	
	@DELETE
	@Path("deleteMsg")
	public Response deleteMsg(@QueryParam("id") int id) {
		if(ctrlM.deleteMessage(id))
			return Response.status(204).entity("le message dont l'id "+id+" a ete suprimer").build();
		else
			return Response.status(204).entity("Rein a ete suprimer :(").build();
	}
	@GET
	@Path("msgNonLu")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> getMsgNotReaded(@QueryParam("id") int id) {
		return ctrlM.getMsgNotReaded(id).values();
	}
	
	@GET
	@Path("userMsgConsult")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Message> consulterMsg(@QueryParam("id") int id) {
		return ctrlM.getUserConsult(id);
	}
	
	
}
