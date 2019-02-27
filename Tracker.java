import java.util.ArrayList;

// holds the x and y of all Fire positions
public class Tracker {
    private ArrayList<Fire> fireList;

    public Tracker(){
        fireList = new ArrayList();

    }

    // Add x and y to fireList y's are positive position's
    public void add(Fire f){
        fireList.add(f);
    }

    // Return an array of coordinates
    public ArrayList getList(){
        return fireList;
    }
}
