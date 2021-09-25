import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Predicate;

public class NewArrayList<E> extends ArrayList<E>{
	private static final long serialVersionUID = 1L;
    
	
	@Override
	public E remove(int index) {
		return null;
	} 
	
	@Override
	public boolean remove(Object e) {
		return false;
	}
	@Override
	protected void removeRange(int fromIndex, int toIndex){};
	
	@Override
	public boolean removeAll(Collection<?> c) {
        return false;
    }
	
	@Override
	public boolean retainAll(Collection<?> c) {
        return false;
    }
	
	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		return false;
	}
	
	public void addAll(E...eee) {
		for (E i : eee) this.add(i);
	}
	public static  HashMap<Integer, Integer> repeats(NewArrayList<Integer> arraylist) {
		HashMap<Integer, Integer> repeats = new HashMap<Integer, Integer>();
		for (Integer i: arraylist) {
			if(repeats.containsKey(i)) repeats.replace(i, repeats.get(i) + 1);
			else repeats.put(i, 1);
		}
		return repeats;
	}
	
	public static void main(String[] args) {
		NewArrayList<Integer> arraylist = new NewArrayList<Integer>();
		arraylist.addAll(4,5,-6,4,5,3,4,2,4,5,7);
		
		for(Integer i: NewArrayList.repeats(arraylist).keySet()) {
			System.err.println(i + " - " + NewArrayList.repeats(arraylist).get(i));
		};
	}
	
}
