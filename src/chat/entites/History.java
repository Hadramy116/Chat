package chat.entites;

import java.util.List;

public class History {
	
	private Integer id;
	private List<Message> messages;
	
	public History() {
		
	}
	
	public History(Integer id, List<Message> messages) {
		super();
		this.id = id;
		this.messages = messages;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}
