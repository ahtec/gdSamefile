/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdsamefile;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author gerard
 */
public class vergelijk
{
    static private int searchDepht = 3000;
 
    
    boolean filesAreEqual(File fa, File fb)  throws java.io.IOException {
        boolean out = false;
        FileInputStream fisa = new FileInputStream(fa);
        FileInputStream fisb = new FileInputStream(fb);
        int c;
        byte[] byteA;
        byte[] byteB;
//        byte[] byteT;
        byteA = new byte[searchDepht];
        byteB = new byte[searchDepht];
//        byteT = new byte[1048];
        fisa.read(byteA);
        fisb.read(byteB);
        System.out.print("byteA.length");
        System.out.print(byteA.length);
        System.out.print(" inhoud");
        System.out.print(byteA);
        System.out.println(" byteB.length");
        System.out.print(byteB.length);
        System.out.print(" inhoud");
        System.out.print(byteB);

        if (java.util.Arrays.equals(byteA,byteB)) {
            out = true;
        }
        fisa.close();
        fisb.close();
        return out;
    }
    
}
