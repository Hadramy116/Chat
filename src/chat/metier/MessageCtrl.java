package chat.metier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import chat.entites.Message;

public class MessageCtrl implements IMessageMetier {

	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();
	private static Map<Integer, Message>  userMsgs;
	
	public boolean isExist(Integer id){
		
		if(messages.get(id) != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean add(Message msg) {

		if (msg != null) {
			messages.put(msg.getId(), msg);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {

		if (messages.remove(id) != null) {
			return true;
		} else
			return false;
	}

	@Override
	public Collection<Message> getUserMessages(int idSend, int idR) {
	    userMsgs = new HashMap<Integer, Message>();

		for (Message msg : messages.values()) {
			if (msg.getuSender() == idSend && msg.getuRecaver() == idR) {
				System.out.println("entre"+msg.getId());
				userMsgs.put(msg.getId(), msg);
			}
			if(msg.getuSender() == idR && msg.getuRecaver() == idSend){
				System.out.println("entre"+msg.getId());
				userMsgs.put(msg.getId(), msg);
			}
		}
		return userMsgs.values();

	}

	public Collection<Message> getItems() {

		return messages.values();
	}

	@Override
	public Collection<Message> getMsgNotReaded(int id) {

		Map<Integer, Message> userMsgs = new HashMap<Integer, Message>();

		for (Message msg : messages.values()) {

			if (!msg.isVues() && msg.getuRecaver() == id) {
				userMsgs.put(msg.getId(), msg);
			}
		}
		return userMsgs.values();
	}

	@Override
	public Collection<Message> getUserConsult(int idUser) {

		Map<Integer, Message> userMsgs = new HashMap<Integer, Message>();

		for (Message msg : messages.values()) {

			if (msg.getuRecaver() == idUser) {
				userMsgs.put(msg.getId(), msg);
			}else if (msg.getuSender() == idUser){
				userMsgs.put(msg.getId(), msg);
			}
		}
		return userMsgs.values();

	}

	@Override
	public boolean update(Message item) {
		if (messages.replace(item.getId(), item) != null ) {
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Message getItemById(Integer id) {
		return messages.get(id);
	}

}
