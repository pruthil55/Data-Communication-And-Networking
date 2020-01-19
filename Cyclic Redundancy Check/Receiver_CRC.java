package receiver_crc;

import java.util.*;
import java.io.*;

/**
 *
 * @author Pruthil Hirpara
 */
public class Receiver_CRC {
static public String divisor;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your divisor bit: ");
        divisor = sc.next();
        String fName="F:\\Academics\\CE253_DCN\\Parity\\Sender_CRC\\Output_CRC.txt"; // File Location
        BufferedReader br = new BufferedReader(new FileReader(fName)); 
        String s,S=""; 
        while((s=br.readLine())!=null){
            S=s; 
            System.out.println("\nMessage Received:: "+s); 
            String s1=""; 
            for(int j=0;j<divisor.length();j++){
                s1=s1+s.charAt(j); 
            } 
             
            String s2=""; 
            for(int i=0;i<divisor.length();i++){
                s2= s2 + Integer.toString(Integer.parseInt(Character.toString(s1.charAt(i)))^Integer.parseInt(Character.toString(divisor.charAt(i)))); 
            }
              
           String s3=""; 
           for(int k=1;k<divisor.length();k++){
               s3=s3+s2.charAt(k); 
            } 
           
            
            for(int i=divisor.length();i<s.length();i++){
                s3+=s.charAt(i);
                s2="";
                if(s3.charAt(0)!='0'){
                    for(int j=0;j<divisor.length();j++){
                        s2=s2+Integer.toString(Integer.parseInt(Character.toString(s3.charAt(j)))^Integer.parseInt(Character.toString(divisor.charAt(j)))); 
                }
                }
                else{   
                   for(int j=0;j<divisor.length();j++){ 
                        s2=s2+Integer.toString(Integer.parseInt(Character.toString(s3.charAt(j)))^0); 
                   } 
                } 
                
                s3=""; 
                for(int k=1;k<divisor.length();k++){
                    s3=s3+s2.charAt(k); 
                }              
            }
            
            int cnt=0;
            for(int i =0;i<s3.length();i++){
                if(s3.charAt(i)!='0'){
                    cnt++;
                }
              
            }
            if(cnt==0){
                System.out.println("No Errors Detected. Message Received Successfully.");
            }
            else
                System.out.println("Error in Message Detected!!");
            
            String s4 = "";
            for(int i=0;i<(s.length()-divisor.length()+1);i++){
                s4 = s4 + s.charAt(i);
            }
            System.out.println("\nOriginal Message:: " + s4 + "\n");
        }        
        
}

}