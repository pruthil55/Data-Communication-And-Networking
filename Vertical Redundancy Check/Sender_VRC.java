package sender_vrc;

import java.io.*;
import java.util.*;

/**
 *
 * @author Pruthil Hirpara
 */
public class Sender_VRC {

    public static void main(String[] args) throws IOException {
        String Fname = "F:\\Academics\\CE253_DCN\\Parity\\Sender_VRC\\Input_VRC.txt"; // File Location
        System.out.print("Enter your choice: \n[1] Even Parity OR [2] Odd Parity: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String fName = "F:\\Academics\\CE253_DCN\\Parity\\Sender_VRC\\Output_VRC.txt"; // File Location
        FileWriter fw = new FileWriter(fName);
        BufferedReader br = new BufferedReader(new FileReader(Fname));
        String s;
        while ((s = br.readLine()) != null) {
            int length = s.length();
            System.out.println("\nInput Message:: " + s);
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

            if (a == 1) {
                if (count % 2 == 0) {
                    s = "0" + s;
                } else {
                    s = "1" + s;
                }
            }
            if (a == 2) {
                if (count % 2 == 0) {
                    s = "1" + s;
                } else {
                    s = "0" + s;
                }
            }
            System.out.println("Output Message:: " + s+"\n");
            for (int i = 0; i < s.length(); i++) {
                fw.write(s.charAt(i));
            }
        }
        fw.close();
    }
}
