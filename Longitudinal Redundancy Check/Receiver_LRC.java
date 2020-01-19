package receiver_lrc;
import java.io.*;
import java.util.*;

/**
 *
 * @author Pruthil Hirpara
 */
public class Receiver_LRC {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.print("Enter your choice: \n[1] Even Parity OR [2] Odd Parity: "); 
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(); 
        String fname="F:\\Academics\\CE253_DCN\\Parity\\Sender_LRC\\Output_LRC.txt"; // File Location 
        BufferedReader br = new BufferedReader(new FileReader(fname)); 
        String s; 
        while((s=br.readLine())!=null){ 
            System.out.println("\nMessage Received:: "+s); 
            String adder=""; 
             
            for(int i=0;i<8;i++){ 
                adder=adder+s.charAt(i);
            } 
            
            int n = (s.length()/8)-1;
            String s1[]=new String[n];      
            int k=8; 
            for(int j=0;j<n;j++){ 
                s1[j]=""; 
                for(int i=k;i<k+8;i++){
                    s1[j]+=s.charAt(i); 
                }                 
                k=k+8;
            }
          
            int count;
            boolean status=false; 
            for(int j=0,pointer=0;j<8;pointer++,j++){
                count=0;
                for(int i=0;i<n;i++){
                    if(s1[i].charAt(j)=='1'){
                        count++;
                        } 
                } 
                         
                if(a==1){
                    if(count%2==0){
                        status = adder.charAt(pointer)=='1'; 
                    } 
                    else if(count%2!=0){
                        status = adder.charAt(pointer) != '0';
                    } 
                }
 
                else if(a==2){
                    if(count%2==0){
                        status = adder.charAt(pointer)=='0'; 
                    } 
                    else if(count%2!=0){
                        status = adder.charAt(pointer)=='0';
                    } 
                }
            }        
            
            if(status==true){
                System.out.println("No Errors Detected. Message Recieved Sucessfully.");
                System.out.print("\nOriginal Message:: ");
                for(int i=8;i<s.length();i++)
                    System.out.print(""+s.charAt(i));
                System.out.println("\n");
                }
            else{
                System.out.println("Error in Message Detected!"); 
            } 
        } 
    }   
}
