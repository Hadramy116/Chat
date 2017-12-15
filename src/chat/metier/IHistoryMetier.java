package chat.metier;

import java.util.HashMap;
import java.util.Map;

import chat.entites.History;
import chat.entites.Message;

public interface IHistoryMetier {
	
	public boolean addToHistory(Message msg);
	public Map<Integer ,History> getUserHistoryS(int userId);

}
