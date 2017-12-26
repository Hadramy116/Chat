package chat.metier;

import java.util.Collection;


public interface IMetier<T> {
	
	public boolean add(T item);
	public boolean update(T item);
	public Collection<T> getItems();
	public T getItemById(Integer id);
	public boolean delete(Integer id);

}
