package com.journaldev.spring;

public class Counter{
    
    long count = 0;
   
    public synchronized void add(long value){
      this.count += value;
      System.out.println(count);
    }
    
    public void log2(){
        synchronized(this){
            for(int i=0;i<40;i++){
           System.out.println(Thread.currentThread().getName()+" Inside log2 ");
            }
        }
     }
 }
