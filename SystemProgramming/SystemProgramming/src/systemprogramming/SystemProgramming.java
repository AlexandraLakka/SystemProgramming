/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemprogramming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it21525
 */
/*
public class SystemProgramming {


    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
 */
 /*
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        //String[] chr = new String[592610];
        String[] chr = new String[217265];
        
            try{
                 /*
                int lnCounter = 0;
                    
                while((ln = eisodos.readLine())!= null){
                lnCounter++;
                         
                }
                System.out.println(lnCounter);
                -- find how many lines the file has*/
 /*                
                FileReader arxeio = new FileReader("./dataFile/RC_2008-07");
                BufferedReader eisodos = new BufferedReader(arxeio);
               
                String ln;
                int charCount = 0;
                int i = 0;
                
                while((ln = eisodos.readLine())!= null){
                    
                    if(i < chr.length){
                        chr[i] = ln;
                        System.out.println(i);
                        i++;
                    }else{
                        break;
                    }
                         
                }
                    
                System.out.println("Array is filled.");
                
                long startTime = System.nanoTime();
                for(String readLn:chr){
                    for(int c = 0 ;c < readLn.length(); c++){
                          
                        readLn.charAt(c);
                        charCount++;
                            
                    }
                }
                    
                System.out.println("The number of characters counted " +
                        "in this file is: " + charCount);
                long estimatedTime = System.nanoTime() - startTime;
                System.out.println(estimatedTime);
         
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SystemProgramming.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SystemProgramming.class.getName()).log(Level.SEVERE, null, ex);
            } catch(StringIndexOutOfBoundsException e){
                System.out.println("StringIndexOutOfBoundsException!!");
            }
     
       
    }
    
}
*/
