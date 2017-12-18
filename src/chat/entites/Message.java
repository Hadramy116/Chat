package chat.entites;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int uSender;
	private int uRecaver;
	private String dateSend;
	private String msgContenu;
	private boolean vues;
	
	
	public Message() {
		
	}

	public Message(Integer id, String content, int uSender, int uRecaver, boolean vues ) {
		this.id = id;
		this.msgContenu = content;
		this.uSender = uSender;
		this.uRecaver = uRecaver;
		this.dateSend = new Date().toString();
		this.vues = vues;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsgContenu() {
		return msgContenu;
	}

	public void setMsgContenu(String content) {
		msgContenu = content;
	}

	public int getuSender() {
		return uSender;
	}

	public void setuSender(int uSender) {
		this.uSender = uSender;
	}

	public int getuRecaver() {
		return uRecaver;
	}

	public void setuRecaver(int uRecaver) {
		this.uRecaver = uRecaver;
	}

	public String getDateSend() {
		return dateSend;
	}

	public void setDateSend(String dateSend) {
		this.dateSend = dateSend;
	}

	public boolean isVues() {
		return vues;
	}

	public void setVues(boolean vues) {
		this.vues = vues;
	}

	
	
}
