package rough;

public class Numbers {
	
	
	public static void checkOddEven(int num) {
		
		if(num%2==0) {
			
			System.out.println("number is even");
			
		}
		else {
			
			System.out.println("number is odd");

			
		}
		
	}
	
	
	
	public static void checkGreatestNumber(int num1,int num2,int num3) {
		
		if(num1>num2 && num1>num3) {
			
		System.out.println("num1 is greatest");
		
		}
		
		else if(num2>num3 && num2>num1) {
			
			
		System.out.println("num2 is greatest");

			
			
		}
		
		else
		
		System.out.println("num3 is greatest");

			
		
		
	}

	
	public static void reverseNumber(int num) { // 123
		
		int reversed =0;
		
		
		while(num!=0) {
		
			int digit = num%10; //get last digit 3 2 1
			reversed = reversed * 10 +digit; // build reversed number 3 32 321
			num=num/10; // remove last digit from num	12 1
			
		}
		
        System.out.println("Reversed number: " + reversed);

		
		
	}

	
	public static void sumOfDigits(int num) {
		
		int sum=0;
		
		while(num!=0) {
			
		int digit =num%10;
		sum = sum + digit;
		num = num/10;
		}
		
        System.out.println("Sum of digits: " + sum);
			
		}
		
		
	

	
	
	

	public static void main(String[] args) {
		
		
		sumOfDigits(246789);
		sumOfDigits(899075);
		sumOfDigits(99687610);

		
		
	}

}
