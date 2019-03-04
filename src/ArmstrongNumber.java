import java.util.Scanner;

public class ArmstrongNumber {
    public static void checkArmstrongNumber(){
        String numberString = getNumber();
        int numberInteger = Integer.parseInt(numberString);
        String numberStringArray[] = splitString(numberString);
        int intArray[] = convertToIntegerArray(numberStringArray);
        int result = Algorithm(intArray);
        if(result == numberInteger){
            System.out.println("The number is the Armstrong Number!");
        }
        else {
            System.out.println("The number isn't the Armstrong Number!");
        }
    }

    public static String getNumber(){
        String number;
        Scanner reading = new Scanner(System.in);
        number = reading.nextLine();
        return number;
    }

    public static String[] splitString(String string){
        String[] splitedArray;
        splitedArray = string.split("");
        return splitedArray;
    }

    public static int[] convertToIntegerArray(String string[]){
        int[] intArray = new int[string.length];
        for(int i=0; i<string.length;i++){
            intArray[i] = Integer.parseInt(string[i]);
        }
        return intArray;
    }

    public static int Algorithm(int intArray[]){
        int sum = 0;
        for(int i=0; i<intArray.length;i++){
            sum += Math.pow(intArray[i], intArray.length);
        }
        return sum;
    }

}
