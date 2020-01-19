package receiver_vrc;
import java.io.*;
import java.util.*;

/**
 *
 * @author Pruthil Hirpara
 */
public class Receiver_VRC {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fname="F:\\Academics\\CE253_DCN\\Parity\\Sender_VRC\\Output_VRC.txt"; // File Location
        String S;         
        char parity; 
        System.out.print("Enter your choice : \n[1] Even Parity OR [2] Odd Parity: "); 
        Scanner sc=new Scanner(System.in); 
        int a=sc.nextInt(); 
        BufferedReader br = new BufferedReader(new FileReader(fname));
        while ((S = br.readLine()) != null) {
            int count = 0;
            System.out.println("\nMessage Received:: " + S);
            parity = S.charAt(0); 
            //even_algo 
            if(a==1){
                for(int i=0;i<S.length();i++){
                    if(S.charAt(i)=='1')
                        count++;
                } 
                
                if(count%2==0){ 
                    System.out.println("No Errors Detected. Message Recieved Sucessfully.");
                    System.out.print("\nOriginal Message:: "); 
                    for(int i=1;i<S.length();i++){
                        System.out.print(""+S.charAt(i)); 
                    }
                    System.out.println("\n");
                }
                else 
                    System.out.println("Error in Message Detected!!"); 
            } 
             
            else if(a==2){
                for(int i=0;i<S.length();i++){
                    if(S.charAt(i)=='1')
                        count++;       
                } 
                System.out.println(count);
                if(count%2!=0){ 
                    System.out.println("No Errors Detected. Message Recieved Sucessfully.");
                    System.out.print("\nOriginal Message:: "); 
                    for(int i=1;i<S.length();i++){
                        System.out.print(""+S.charAt(i)); 
                    }
                    System.out.println("\n");
                }
                else 
                    System.out.println("Error in Message Detected!!"); 
            }
            else 
                System.out.println("Invalid Input..."); 
        } 
     

    }
    
}
