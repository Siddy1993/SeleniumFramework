package rough;

public class Patterns {

    public static void main(String[] args) {

    	
    	
    	//right angled triangle
    	
//        for (int i = 1; i < 4; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print("*");  // stays on same line
//            }
//            System.out.println();  // moves to next line after row is done
//        }
        
        
       //right angled number triangle
        
//                                                                                        
//        for (int i = 1; i < 5; i++) {
//        	
//            for (int j = 1; j <=i; j++) {
//            	
//                System.out.print(j);  
//                
//            }           
//           
//            System.out.println();  
//        }
        
        
        //revers right angled number triangle
//        
//        for (int i = 4; i >= 1; i--) {
//        
//            for (int j =1 ; j <=i; j++) {
//            	
//                System.out.print(j);  
//                
//            }           
//           
//            System.out.println();  
//        }
        
        
        
        //star pyramid pattern
    	
//        for (int i=1;i<5;i++) {
//        	
//        	for (int j = 1; j <= 4 - i; j++) {
//                System.out.print(" ");
//            }
//
//            // Print stars
//            for (int k = 1; k <= (2 * i - 1); k++) {
//                System.out.print("*");
//            }
//
//            // Move to next line
//            System.out.println();
//        }
        
//        
//        // Flyd's triangle
//    	for (int i=1;i<5;i++) {
//    		
//    		for (int j=0+i;j<=1;j++) {
//    			
//    			System.out.println(j);
//    			
//    		}
//    		
//          System.out.println();  
//
//    	}
        
        
        // star right aligned trainagle
    	int rows=5;
    	
    	for (int i=1;i<=rows;i++) {
    		
    		for (int j=1;j<=rows-i;j++) {
    			 			  			
    	  System.out.println("*");
    	  
    		}
    		
    		
    		System.out.println();
    	}
    	
    	
        
        
        
        
        
        
        
        
        
    }
}
