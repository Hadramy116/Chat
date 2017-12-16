package chat.metier;

import java.util.HashMap;
import java.util.Map;

import chat.entites.Message;

public class MessageCtrl implements IMessageMetier {

	private Map<Integer, Message> messages = new HashMap<Integer, Message>();

	@Override
	public boolean createMsg(Message msg) {

		if (msg != null) {
			messages.put(msg.getId(), msg);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteMessage(int id) {

		if (messages.remove(id) != null) {
			return true;
		} else
			return false;
	}

	@Override
	public Map<Integer, Message> getUserMessages(int idSend ,int idR) {
		Map<Integer, Message> userMsgs = new HashMap<Integer, Message>();

		for (Message msg : messages.values()) {
			
			if (msg.getuSender().getId() == idSend && msg.getuRecaver().getId() == idR){
				userMsgs.put(idSend, msg);
			}
				

		}
		return userMsgs;

	}

	

	public Map<Integer, Message> getMessages() {

		return messages;

	}

	@Override
	public Message getLastMsg(int idUser) {
		
		return null;
	}

}
