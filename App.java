
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	int testCases;
    	List<Map<Integer, int[]>> testData = new ArrayList<Map<Integer,int[]>>();
		Scanner sc= new Scanner(System.in);     
    	try{
    		// Get Inputs from command line
        	System.out.print("Enter number of test cases: ");  
        	testCases= sc.nextInt();  
        	System.out.println("Enter test inputs for each test case ");
        	System.out.println("=> N(number of persons), A[i](space sperated list of cost of each person)");
        	for(int i=0; i<testCases; i++){
        		System.out.print("N: "); 
        		int num= sc.nextInt();  
        		System.out.print("A[i]: "); 
        		int costArray[] = new int[num];
        		sc.nextLine(); 
        		String[] s1 = sc.nextLine().trim().split(" ");
        		for(int j=0;j<num;j++)
        			costArray[j]=Integer.parseInt(s1[j]);
        		
        		Map<Integer,int[]> dataEntry = new HashMap<Integer, int[]>();
        		dataEntry.put(num, costArray);
        		testData.add(dataEntry);
        		System.out.println("-----------------------------------");
        		
        	}
        	sc.close();
        	
        	//Print output for each test case
        	System.out.println("-----------------------------------");
        	System.out.println("Output : ");
        	System.out.println("Minimum cost for each test case");
        	for (Map<Integer, int[]> map : testData) {
    			for (Integer key : map.keySet()) 
    				System.out.println(findMinimumCost(map.get(key), key)); 
    		}
    	}
    	catch(Exception e){
    		System.err.println(e);
    	}
    }
    
    
  //Main Logic
    static int findMinimumCost(int cost[], int n) 
    { 
    	Arrays.sort(cost); 
        int total = 0; 
        // Calculate minimum price of n-2 most costly person 
        for (int i = n - 1; i > 1; i -= 2) 
        { 
            if (i == 2) 
            { 
                total += cost[2] + cost[0]; 
            } 
            else
            { 
                int cost_first = cost[i] + cost[0] + 2 * cost[1]; 
                int cost_second = cost[i] + cost[i - 1] + 2 * cost[0]; 
                total += Math.min(cost_first, cost_second); 
            } 
        } 
      
        //Calculate the minimum price of the two cheapest person 
        if (n == 1) 
        { 
            total += cost[0]; 
        } 
        else
        { 
            total += cost[1]; 
        } 
 
	return total; 
    } 
}
