package sender_crc;
import java.io.*;
import java.util.*;

/**
 *
 * @author Pruthil Hirpara
 */
public class Sender_CRC {
static public String divisor;

     public void crc(String fInName,String fOutName) throws Exception { 
        FileWriter fw=new FileWriter(fOutName); 
        BufferedReader br = new BufferedReader(new FileReader(fInName)); 
        String s,S=""; 
        while((s=br.readLine())!=null){
            S=s; 
                for(int i=0;i<(divisor.length()-1);i++){
                    s=s+"0"; 
                } 
             
            System.out.println("\nInput Message:: "+s); 
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
            
            S=S+s3; 
            System.out.println("Output Message:: "+S+"\n"); 
        } 
 
        for(int i=0;i<S.length();i++)            
            fw.write(S.charAt(i)); 
        fw.close();     
    } 



    public static void main(String[] args) throws Exception {
        Sender_CRC c=new Sender_CRC(); 
        String fInName="F:\\Academics\\CE253_DCN\\Parity\\Sender_CRC\\Input_CRC.txt"; // File Location
        System.out.print("Enter your divisor bit: ");
        Scanner sc=new Scanner(System.in);
        c.divisor=sc.next();
        String fOutName="F:\\Academics\\CE253_DCN\\Parity\\Sender_CRC\\Output_CRC.txt"; // File Location
        c.crc(fInName,fOutName); 

    }
    
}
