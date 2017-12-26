package chat.metier;

import java.util.Collection;
import java.util.Map;

import chat.entites.Message;

public interface IMessageMetier extends IMetier<Message>{
	
	public Collection<Message> getUserMessages(int idSend ,int idR);//chat
	public Collection<Message> getMsgNotReaded(int id);
	public Collection<Message> getUserConsult(int idUser);
	

}
