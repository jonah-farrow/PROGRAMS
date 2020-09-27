import java.lang.Math;
import java.util.Scanner;
public class squareRootMachine{
public static void main (String args[]){
    Scanner scanner = new Scanner(System.in);
    double N = Double.parseDouble(scanner.next());
    N = Math.floor(N);
    double a = N / 2;
    
    while(Math.abs(a - N/a) >= 0.000000000001){
        a = ((a + (N/a)) /2);       
    }
    
    System.out.println((int) Math.floor(a)); 
    }
}
