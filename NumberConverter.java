
import java.util.*;

public class NumberConverter {
    public static int uBinaryToDecimal(String[] bin_num) {
        // This method converts unsigned binary to decimal
        int result = 0;
        int x = 1;
        
        for (int i = bin_num.length-1; i >= 0; i--){
            result += Integer.valueOf(bin_num[i]) * x;
            x = x * 2;
        }
        
        // Prints result
        System.out.print(result);
        return result;
    }
    
      public static void decimalToSBinary(String decimal) {
        // This method converts decimals to signed binary
        int dec = Integer.valueOf(decimal);
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // While the decimal is not devisible by 2...
        while (dec/2 != 0) {
            //  If the remainder is 0, we add a 0
            if (dec%2 == 0) {
                dec = dec/2;
                result.add(0);
            }
            // If the remainder is not 0, we add a 1
            else {
                dec = dec/2;
                result.add(1);
            }
        }
        
        // We need to do this once more to add the final digit
        if (dec%2 == 0) {
            result.add(0);
        }
        else {
            result.add(1);
        }
        
        // If the size of the whole number is not at least 8, we add 0s
        while (result.size()%8 != 0) {
            result.add(0);
        }
        
        // Calls the reverse function to reverse the array!
        result = reverse(result);
        
        // Prints out the array in order if its positive
        if (!decimal.contains("-")) {
            for (int i = 0; i < result.size(); i++) {
                if ((i+1)%4 == 0) {
                    System.out.print(result.get(i) + " ");
                }
                else {
                    System.out.print(result.get(i) + "");
                }     
            }
            System.out.print("\n");
        }
        
        // If the array is negative...
        else {

            int x = result.size()-1;
            
            // Adds the 0001 to the number
            while(true){
                if(result.get(x) == 1){
                    result.set(x, 0);
                    x = x-1;
                }
                else{
                    result.set(x,1);
                    break;
                }
            }
            
            
            // Makes a temp list for adding the 1 at the front
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1); 
            
            // Adds remainder of last list to the new one
            for (int i = 0; i <result.size(); i++) {
                temp.add(result.get(i));
            }
            
            // Sets the old list back to this temp one and adds 3 0s to make it divisible by 4
            result = temp;
            result.add(0);
            result.add(0);
            result.add(0);
            
            // If the size of the whole number is not at least 8, we add 0s
            while (result.size()%8 != 0) {
                result.add(0);
            }
            
            // Inverts the values in the array
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) == 0) {
                    result.set(i, 1);
                }
                else {
                    result.set(i,0);
                }
            }
            
            // Prints the result
            for (int i = 0; i < result.size(); i++) {
                if ((i+1)%4 == 0) {
                    System.out.print(result.get(i) + " ");
                }
                else {
                    System.out.print(result.get(i) + "");
                }    
            }
        }
     }
     
    public static void decimalToUBinary(String decimal) {
        // This method converts decimals to unsigned binary
        int dec = Integer.valueOf(decimal);
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // If decimal is not divisible by 2...
        while (dec/2 != 0) {
            // If the remainder is 0, we add a 0
            if (dec%2 == 0) {
                dec = dec/2;
                result.add(0);
            }
            // If the remainder is not 0, we add a 1
            else {
                dec = dec/2;
                result.add(1);
            }
        }
        
        // We do this once more for the last number
        if (dec%2 == 0) {
            result.add(0);
        }
        else {
            result.add(1);
        }
        
        // Add 0s until the length is at least 8
        while (result.size()%8 != 0) {
            result.add(0);
        }
        
        // Reverse the list!
        result = reverse(result);
        
        // Prints out the result
        for (int i = 0; i < result.size(); i++) {
            if ((i+1)%4 == 0) {
                System.out.print(result.get(i) + " ");
            }
            else {
                System.out.print(result.get(i) + "");
            }     
        }
        System.out.print("\n");
    }
    
    public static void binaryToDecimal(String bin_num[]) {
        // if first num is 0 then continue as normal (positive)
        if (Integer.valueOf(bin_num[0]) == 0) {
            int result = 0;
            int x = 1;
            for (int i = bin_num.length - 1; i >= 0; i--) {
                result += Integer.valueOf(bin_num[i]) * x;
                x = x * 2;
            }
            System.out.print(result);
        }
        // if first num is 1 (negative) then follow steps
        else {
            // calculate inverse (flip 0s and 1s)
            for (int i = 0; i < bin_num.length; i++) {
                if (Integer.valueOf(bin_num[i]) == 0) {
                    bin_num[i] = "1";
                }
                else {
                    bin_num[i] = "0";
                }
            }
            
            // add 1 to value
            String one = "0001";
            String input = "";
            for (int i = 0; i < bin_num.length; i++) {
                input = input + bin_num[i];
            }

            int sum = Integer.parseInt(one, 2) + Integer.parseInt(input, 2);

            System.out.println("-" + sum);
        }
    }

    public static void decimalToHex(String decimal1) { 
        // A method for converting decimal to hexadecimal
        String result = "";   
        int decimal = Integer.valueOf(decimal1);
        // An array of all hex characters
        char hexArray[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        
        while(decimal > 0) {  
            
           int i = decimal%16;   
           result = hexArray[i] + result;   
           decimal = decimal/16;  
        }  
        
        System.out.print(result + "\n");
    }
    
    public static void uBinaryToHex(String binary) {
        // A method that converts unsigned binary to hex
        String result = "";
        
        // Splits the binary into groups of 4
        if(binary.length()%4 !=0){
            int count = 0;
            int bit = binary.length() % 4;           
            while(count < (4 - bit)){
                binary = "0" + binary;
                count++;
            }
        }
        
        // Initiating values that we will use in the further method
        int start = 0;
        int cur = 0;
        int sum = 0;
        
        // Goes through the binary and converts it to hex via segments
        while(start < binary.length()){
            // For each segment
            while(cur < 4){
               sum = (int) (sum + Integer.parseInt("" + binary.charAt(binary.length()- start -1)) * Math.pow(2, cur)) ;
               cur++;
               start++;
            }
            // Checks if the sum is under or over 10
            if(sum < 10) {
                result = Integer.toString(sum) + result;
            }
            else {
                result = (char) (sum + 55) + result;
            }
            // Resets positions
            cur = 0;
            sum = 0;
       }
        // Prints the output
       System.out.println(result);
    }
    
    public static int hexToDecimal(String hex) {
        // A method which converts hex to decimal
        String digitArray = "0123456789ABCDEF";  
        
        hex = hex.toUpperCase();  
        int result = 0; 
        
        for (int i = 0; i < hex.length(); i++) {  
            char c = hex.charAt(i);  
            int x = digitArray.indexOf(c);  
            result = 16*result + x;  
        }  
        
        return result;
    }
    
    public static ArrayList<Integer> reverse(ArrayList<Integer> alist) {
        // A method for reversing a list
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        for (int i = alist.size() - 1; i >= 0; i--) {
            temp.add(alist.get(i));
        }
        
        return temp;
    }
    
    public static void main(String[] args) {
        // Variables needed for program
	String[] inputLine; // used to save the command read from input file
	Scanner in = new Scanner(System.in);

	while (true) {
                // Prints the menu choices
                System.out.print("\n1: Convert decimal to unsigned binary\n" +
                                "2: Convert decimal to signed binary\n" +
                                "3: Convert decimal to hexadecimal\n" +
                                "4: Convert unsigned binary to decimal\n" +
                                "5: Convert signed binary to decimal\n" +
                                "6: Convert unsigned binary to hexadecimal\n" +
                                "7: Convert hexadecimal to unsigned binary\n" +
                                "8: Convert hexadecimal to decimal\n" +
                                "0: Exit \n");
                
                System.out.print("Select From 0-8: ");
		inputLine = in.nextLine().split(" ");

                // Convert decimal to unsigned binary
		if (inputLine[0].equals("1") == true) {  
                    System.out.print("Insert Your Decimal: ");
                    String decimal = in.nextLine();
                    
                    decimalToUBinary(decimal);
		}
                
                // Convert decimal to signed binary
                else if (inputLine[0].equals("2") == true) {
                    System.out.print("Insert Your Decimal: ");
                    String decimal = in.nextLine();
                    
                    decimalToSBinary(decimal);
		}
                
                // Convert decimal to hexadecimal
                else if (inputLine[0].equals("3") == true) { 
                    System.out.print("Insert Your Decimal: ");
                    String decimal = in.nextLine();
                    
                    decimalToHex(decimal);
		}
                
                // Convert unsigned binary to decimal
                else if (inputLine[0].equals("4") == true) {   
                    System.out.print("Insert Your Binary: ");
                    String binary = in.nextLine();
                    String[] bin = binary.split("");
                    
                    uBinaryToDecimal(bin);
		}
                
                // Convert signed binary to decimal
                else if (inputLine[0].equals("5") == true) { 
                    System.out.print("Insert Your Binary: ");
                    String binary = in.nextLine();
                    String[] bin = binary.split("");
                    
                    binaryToDecimal(bin);
		}
                
                // Convert unsigned binary to hexadecimal
                else if (inputLine[0].equals("6") == true) { 
                    System.out.print("Insert Your Binary: ");
                    String binary = in.nextLine();
                    
                    uBinaryToHex(binary);
		}
                // Convert hexadecimal to unsigned binary
                else if (inputLine[0].equals("7") == true) {     
                    System.out.print("Insert Your Hexadecimal: ");
                    String hex = in.nextLine();
                    decimalToUBinary(String.valueOf(hexToDecimal(hex)));
		}
                
                // Convert hexadecimal to decimal
                else if (inputLine[0].equals("8") == true) {   
                    System.out.print("Insert Your Hexadecimal: ");
                    String hex = in.nextLine();
                    
                    System.out.print(hexToDecimal(hex) + "\n");
		}
                
                // Quits the program
		else if (inputLine[0].equals("0") == true) {
                    break;
		}
                
		// Invalid Command --- this will NEVER occur if you coded things correctly
		else {
                    System.out.println("Invalid Command: input invalid.");
		}
            } // END while loop
	} // END main() method   
}
