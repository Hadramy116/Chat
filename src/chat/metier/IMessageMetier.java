package chat.metier;

import java.util.Map;

import chat.entites.Message;

public interface IMessageMetier {
	
	public boolean createMsg(Message msg);
	public boolean deleteMessage(int id);

	public Map<Integer, Message> getMessages();
	public Map<Integer, Message> getUserMessages(int idSend ,int idR);
	

}
