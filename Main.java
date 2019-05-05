import java.util.*;

public class Main {

	public static void main(String[] args) {		
        Scanner s = new Scanner(System.in);
        Set<String> firstblock = new HashSet<>();
        Set<String> secondblock = new HashSet<>();
        Set<String> filenames = new HashSet<>();
        
        ArrayList<String> firstfilenamestosort = new ArrayList<String>();
        ArrayList<String> filenamestosort = new ArrayList<String>();
        
		
        while(true){
        	String thestring = s.nextLine();  

        	if(thestring.equals("")) {
        		break;
        	}
        	
        	firstblock.add(thestring);
        }
		
        while(s.hasNextLine()){
        	String thestring = s.nextLine();
        	
        	secondblock.add(thestring);
        	
        	int getsecondlastunderscore = thestring.lastIndexOf("_", thestring.lastIndexOf("_")-1);
        	
        	String newstring = thestring.substring(0, getsecondlastunderscore);
        	
        	if(!filenames.contains(newstring)) {
        		filenames.add(newstring);
        	}
        	
        }

        
        for(String compare : secondblock) {
        	int getsecondlastunderscore = compare.lastIndexOf("_", compare.lastIndexOf("_")-1);
        	
        	String newstring = compare.substring(0, getsecondlastunderscore);
        	
        	if(firstblock.contains(newstring)) {
        		continue;
        	}
        	else {
        		firstfilenamestosort.add(compare);
        	}
        	
        }
        
        for(String compare : firstblock) {
        	if(filenames.contains(compare)) {
        		continue;
        	}
        	else {
        		filenamestosort.add(compare);
        	}
        }
        
        if(firstfilenamestosort.size()!=0 || filenamestosort.size()!=0) {
        	Collections.sort(firstfilenamestosort);
            Collections.sort(filenamestosort);
            
            for(int i=0; i<firstfilenamestosort.size(); i++) {
            	System.out.println("F "+firstfilenamestosort.get(i));
            }
            for(int i=0; i<filenamestosort.size(); i++) {
            	System.out.println("I "+filenamestosort.get(i));
            }
        }
        
        else {
        	System.out.println("No mismatches.");
        }
        
	}
	
}
