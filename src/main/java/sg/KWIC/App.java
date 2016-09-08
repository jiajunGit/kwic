package sg.KWIC;

import CS3213.KWIC;

public class App {
	
    public static void main( String[] args ){
    	
    	long startTime = System.currentTimeMillis();
    	
    	KWIC kwic = new KWIC();
    	kwic.run();
    	
    	long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}
