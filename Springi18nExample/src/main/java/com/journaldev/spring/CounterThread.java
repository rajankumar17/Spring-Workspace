package com.journaldev.spring;

public class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
       this.counter = counter;
    }

    public void run() {
   for(int i=0; i<40; i++){
          counter.add(i);
          counter.log2();
       }
   System.out.println(Thread.currentThread().getName());
    }
 }
