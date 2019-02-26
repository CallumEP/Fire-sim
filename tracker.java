import java.util.ArrayList;

// holds the x and y of all fire positions
public class tracker {
    private ArrayList<Integer> fireList;

    public tracker(){
        fireList = new ArrayList();

    }

    // Add x and y to fireList y's are positive position's
    public void add(int x, int y){
        fireList.add(x);
        fireList.add(y);
    }

    // Return an array of coordinates
    public int[][] getList(){

        int length = fireList.size() ;
        if(length <0){
            int l[][] = new int[1][1];
            l[0][0] = -1 ;
             return l;
        }
        else{
        int rList[][] = new int[2][length/2];
        for(int i =0 ; i < length/2;i = i+2){
            rList[0][i] = fireList.get(i);
            rList[1][i] = fireList.get(i+1);
        }
        return rList;}
    }
}
