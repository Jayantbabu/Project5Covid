package prj5;

public class CovidCalculator {
    
    private SinglyLinkedList s;
    private SinglyLinkedList races;
	
	
	public CovidCalculator(SinglyLinkedList<State> state) {
	    s = state;
	}
	
	public SinglyLinkedList getState() {
	    return s;
	}
	
	public void sortAlphabetically() {
	    for (int i = 0; i < 6; i++) 
        {
            for (int j = i + 1; j < 6; j++) {
                races = ((State)s.get(i)).getRaces();
                String str = ((State)s.get(i)).getRaces().get(i).getRace();
                String str1 = ((State)s.get(j)).getRaces().get(j).getRace();
                if (str.compareTo(str1)>0) 
                {
                    
                }
            }
        }
	}
	
	public void sortRatio() {
	    for (int i = 0; i < 6; i++)  {
	        ((State)s.get(i)).getRaces().get(i).getCFR().insertionSort();
	    }
	}
}
