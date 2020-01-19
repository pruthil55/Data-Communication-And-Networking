package sender_lrc;

import java.io.*;
import java.util.*;

/**
 *
 * @author Pruthil Hirpara
 */
public class Sender_LRC {

    public static void main(String[] args) throws IOException {
        String fInName = "F:\\Academics\\CE253_DCN\\Parity\\Sender_LRC\\Input_LRC.txt"; // File Location
        System.out.print("Enter your choice: \n[1] Even Parity OR [2] Odd Parity: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String fOutName = "F:\\Academics\\CE253_DCN\\Parity\\Sender_LRC\\Output_LRC.txt"; // File Location
        FileWriter fw = new FileWriter(fOutName);
        BufferedReader br = new BufferedReader(new FileReader(fInName));
        String s;
        while ((s = br.readLine()) != null) {
            while ((s.length() % 8) != 0) {
                s = "0" + s;
            }
            System.out.println("\nInput Message:: " + s);
            int count = 0;
            int nBytes = s.length() / 8;
            String S[] = new String[nBytes];
            int k = 0;
            for (int j = 0; j < nBytes; j++) {
                S[j] = "";
                for (int i = k; i < k + 8; i++) {
                    S[j] = S[j] + s.charAt(i);
                }
                k += 8;
                //System.out.println(S[j]);
            }

            String adder = new String();
            adder = "";
            for (int j = 0; j < 8; j++) {
                count = 0;
                for (int i = 0; i < nBytes; i++) {
                    if (S[i].charAt(j) == '1') {
                        count++;
                    }
                }
                
                if(a==1){
                    if(count%2==0){
                        adder = adder + "0";
                }
                else{
                        adder=adder+"1"; 
                    }
                }

        
                else if(a==2){
                    if(count%2==0){
                        adder = adder+"1"; 
                }
                else{
                     adder = adder + "0";
                }
                }
            }  
            
            s=adder+s; 
            System.out.println("Output Message:: "+s+"\n");
            for(int i=0;i<s.length();i++)
                fw.write(s.charAt(i));
            
            fw.close(); 
        }                     
    }     
} 