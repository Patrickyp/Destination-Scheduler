
public class swda1test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		RoadMap me = new RoadMap("http://pearl.ics.hawaii.edu/~sugihara/courses/ics311s13/assign_p1_test_data/digraph01.txt");
		me.Print();
		}catch(Exception e){
			System.out.println(e);
		}
		
		int[] mee = new int[4];
		mee[3] = 4;
		for(int x = 0 ; x<mee.length;x++){
			System.out.print(mee[x] + " ");
		}

	}

}
