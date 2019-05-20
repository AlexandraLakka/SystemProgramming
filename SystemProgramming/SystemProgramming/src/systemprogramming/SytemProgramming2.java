package systemprogramming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SytemProgramming2 {

    static class controlCounter {

        private volatile int sumCount = 0;

        public synchronized void increment(int counter) {

            this.sumCount += counter;

        }

        public synchronized int value() {
            return sumCount;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
        /*
        ExecutorService e = Executors.newFixedThreadPool(100);
        ArrayList<Future<String>> futures = new ArrayList<>();
        //String[] chr = new String[592610];
        String[] chr = new String[217265];
        
            futures.add((Future<String>) e.submit(new Runnable(){
               @Override
                public void run(){
                    try{
                        FileReader arxeio = new FileReader("./dataFile/RC_2008-07");
                        BufferedReader eisodos = new BufferedReader(arxeio); 
                        String ln;
                        int charCount = 0;
                        int l = 0;
                        while((ln = eisodos.readLine()) != null){
                            
                            if(l < chr.length){
                                chr[l] = ln;
                                System.out.println(l);
                                l++;
                            }else{
                                break;
                            }
                            Thread.sleep((long) 0.5);
                            
                        }
                        e.shutdown();
                        System.out.println("Array is filled.");
                        
                        while(!e.isShutdown()){
                            for(Future<String> result:futures){
                                 try{
                                    System.out.println(result.get());
                                } catch (ExecutionException ex) {
                                    Logger.getLogger(SytemProgramming2.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 
                                /*
                                try{
                                    System.out.println(result.get());
                                } catch (ExecutionException ex) {
                                    Logger.getLogger(SytemProgramming2.class.getName()).log(Level.SEVERE, null, ex);
                                }*/
 /*            
                            }
                        }
                       
                       System.out.println("The number of characters counted " +
                        "in this file is: " + charCount);

                       
                     } catch (FileNotFoundException ex) {
                        Logger.getLogger(SytemProgramming2.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                       Logger.getLogger(SytemProgramming2.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(SytemProgramming2.class.getName()).log(Level.SEVERE, null, ex);
                   }
                } 
            }));
         */

        //String[] chr = new String[592610];
        //String[] chr = new String[217265];
        String[] chr = new String[100051];
        Thread[] newThread = new Thread[5];
        controlCounter cnl = new controlCounter();

        try {
            FileReader arxeio = new FileReader("./dataFile/RC_2008-07");
            BufferedReader eisodos = new BufferedReader(arxeio);
            String ln;

            int l = 0;
            
            while ((ln = eisodos.readLine()) != null) {

                if (l  < chr.length) {
                    chr[l] = ln;
                    System.out.println(l);
                    l++;
                    //System.out.println(cnl.value());
                } else {
                    break;
                }

                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SystemProgramming.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SytemProgramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Array is filled.");
        System.gc();
        int start = 0;
    
        long startTime = System.nanoTime();
        for (int i = 0; i < newThread.length; i++) {
            
          
            String[] chr2 = new String[chr.length/newThread.length];
            System.arraycopy(chr, start, chr2, 0, chr.length/newThread.length);
            start += chr.length/newThread.length;
            newThread[i] = new Thread(new Runnable() {

                @Override
                public synchronized void run() {
                    try {
                        int charCount = 0;
                        
                        

                        for (String readLn : chr2) {
                            for (int c = 0; c < readLn.length(); c++) {
                                readLn.charAt(c);
                                charCount++;
                            }
                        }
                        cnl.increment(charCount);
                        
                        
                        System.out.println("The number of characters counted"
                                + "in thread is: " + cnl.value());
                    }catch (StringIndexOutOfBoundsException e) {
                            System.out.println("StringIndexOutOfBoundsException!!");
                        }
                    }
                }
                );
                newThread[i].start();
            }
        Thread.sleep(1000);
        System.out.println("Total number of characters counted "
                                + "in this file is: " + cnl.value());
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
        

        }

    }
